package com.jwj.server.spring.boot.start;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TODO
 *
 * @author jiangwenjie
 * @since 1.0
 */
@ConfigurationProperties(prefix = "jwj.server")
public class ServerProperties {
    private static final Integer DEFAULT_PORT=8000;
    private Integer port=DEFAULT_PORT;
    public static Integer getDefaultPort(){
        return DEFAULT_PORT;
    }
    public Integer getPort(){
        return port;
    }
    public ServerProperties setPort(Integer port){
        this.port=port;
        return this;
    }
}
