package com.towery.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.towery.sentinel.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")

public class HelloController {

    private static final String RESOURCE_NAME="hello";
    private static final String USER_RESOURCE_NAME="user";
    private static final String DEGRADE_RESOURCE_NAME="=degrade";



    @RequestMapping("/hello")
    public String hello(){
        Entry entry=null;
        try {
            entry=SphU.entry(RESOURCE_NAME);
            String str="Hello World";
            return str;
        } catch (BlockException e) {
//            e.printStackTrace();
            return "被流控了";
        }catch (Exception e){
            Tracer.traceEntry(e,entry);
        }finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return null;
    }

    /*
    spring的初始化方法
     */
    @PostConstruct
    private static void initFlowRules(){
        //流控规则
        List<FlowRule> rules = new ArrayList<FlowRule>();
        //流控
        FlowRule flowRule = new FlowRule();
        //为那个资源进行流量控制
        flowRule.setResource(RESOURCE_NAME);
        //设置流控规则 QPS
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源的阈值
        flowRule.setCount(1);
        rules.add(flowRule);

        FlowRule rule2 = new FlowRule();
        rule2.setResource(USER_RESOURCE_NAME);
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //设置受保护的资源的阈值
        rule2.setCount(1);
        rules.add(rule2);

        FlowRuleManager.loadRules(rules);
    }
    @PostConstruct
    public void initDegradeRule(){
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource(DEGRADE_RESOURCE_NAME);
        //设置规则为异常数
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        //设置异常数
        rule.setCount(2);
        //触发熔断最少请求数
        rule.setMinRequestAmount(2);
        //统计时长
        rule.setStatIntervalMs(60*1000);
        //熔断时长，秒
        rule.setTimeWindow(10);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }

    @RequestMapping("/user")
    @SentinelResource(value = USER_RESOURCE_NAME,blockHandler ="blockHandlerForGetUser" )
    public User getuser(String id){
            return new User("zhangsan");
    }
    public User blockHandlerForGetUser(String id){
        return new User("流控");
    }

    @RequestMapping("degrade")
    @SentinelResource(value = DEGRADE_RESOURCE_NAME,entryType = EntryType.IN,blockHandler = "blockHandlerForFb")
    public User degrade(){
        throw new RuntimeException("异常");
    }
    public User blockHandlerForFb(String id,BlockException e){
        return new User("熔断降级");
    }


}
