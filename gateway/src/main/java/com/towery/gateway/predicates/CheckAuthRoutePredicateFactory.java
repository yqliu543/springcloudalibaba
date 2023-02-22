package com.towery.gateway.predicates;

import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.cloud.gateway.handler.predicate.QueryRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Description:
 * @author: 刘
 * @date: 2023年02月22日 下午 4:03
 */
@Component
public class CheckAuthRoutePredicateFactory  extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {
    public static final String PARAM_KEY = "param";
    public static final String REGEXP_KEY = "regexp";

    public CheckAuthRoutePredicateFactory() {
        super(CheckAuthRoutePredicateFactory.Config.class);
    }

    public List<String> shortcutFieldOrder() {
        return Arrays.asList("param", "regexp");
    }

    public Predicate<ServerWebExchange> apply(CheckAuthRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            public boolean test(ServerWebExchange exchange) {
                if (config.getParam().equals("zhangsan")){
                    return true;
                }
                return false;
            }
        };
    }

    @Validated
    public static class Config {
        private String param;

        public String getParam() {
            return this.param;
        }

        public void setParam(String param) {
            this.param = param;
        }
    }
}
