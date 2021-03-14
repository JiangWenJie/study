package com.jwj.server.spring.boot.start;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * TODO
 *
 * @author jiangwenjie
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(ServerProperties.class)
public class ServerAutoConfiguration {
    private Logger logger= LoggerFactory.getLogger(ServerAutoConfiguration.class);

    public HttpServer httpServer(ServerProperties serverProperties) throws IOException {
        HttpServer server=HttpServer.create(new InetSocketAddress(serverProperties.getPort()),0);
        server.start();
        logger.info("[httpServer][启动服务器成功,端口为:{}]",serverProperties.getPort());
        return server;
    }
}
