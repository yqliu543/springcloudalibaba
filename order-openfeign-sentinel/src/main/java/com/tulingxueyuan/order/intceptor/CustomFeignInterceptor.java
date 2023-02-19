package com.tulingxueyuan.order.intceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: 刘
 * @date: 2023年02月15日 下午 1:36
 */
public class CustomFeignInterceptor implements RequestInterceptor {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //requestTemplate.header("xxx","xxx");
        logger.info("feign拦截器！");
    }
}
