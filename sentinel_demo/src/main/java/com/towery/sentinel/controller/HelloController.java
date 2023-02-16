package com.towery.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
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
        FlowRuleManager.loadRules(rules);
    }


    @RequestMapping("/user")
    public User getuser(String id){
            return new User("zhangsan");
    }
}
