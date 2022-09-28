package com.jay.filter;


import com.alibaba.nacos.common.model.RestResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * Copyright(c),2018-2021,合肥市鼎足空间技术有限公司
 *
 * @author jing.fang
 * @date 2022/9/28 9:44
 * @description 全局过滤器
 * history
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Component
public class HeaderEnhanceFilter implements GlobalFilter, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderEnhanceFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String uri = request.getURI().getPath();
        String method = Objects.requireNonNull(request.getMethod()).name();
        LOGGER.info("进入全局过滤方法,{},{}", uri, method);
        if (uri.contains("love")) {
            ServerHttpResponse response = exchange.getResponse();
            DataBufferFactory bufferFactory = response.bufferFactory();
            ObjectMapper objectMapper = new ObjectMapper();
            DataBuffer wrap = null;
            try {
                wrap = bufferFactory.wrap(objectMapper.writeValueAsBytes(new RestResult<>(500, "访问频繁，请稍后再试")));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new RuntimeException("写入异常");
            }
            DataBuffer finalWrap = wrap;
            return response.writeWith(Mono.fromSupplier(() -> finalWrap));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -10;
    }
}
