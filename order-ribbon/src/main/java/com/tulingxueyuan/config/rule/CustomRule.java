package com.tulingxueyuan.config.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CustomRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        //获得当前请求的服务实例
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        List<Server> allServers = loadBalancer.getAllServers();
        int random = ThreadLocalRandom.current().nextInt(allServers.size());
        Server server = allServers.get(random);
        if (server.isAlive()){
            return null;
        }
        return server;
    }
}
