package com.xlc.config;

import com.xlc.Feign.EchoClient;
import com.xlc.Feign.EchoClientFallback;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    @Bean
    public EchoClient echoClientFallback() {
        return new EchoClientFallback();
    }

}