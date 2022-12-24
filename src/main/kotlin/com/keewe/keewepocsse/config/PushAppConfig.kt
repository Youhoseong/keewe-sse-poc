package com.keewe.keewepocsse.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.ConcurrentHashMap

@Configuration
class PushAppConfig {
    @Bean
    fun userConnectionMap(): ConcurrentHashMap<String, SseEmitter> = ConcurrentHashMap<String, SseEmitter>();
}