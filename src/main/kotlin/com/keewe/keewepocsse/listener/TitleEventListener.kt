package com.keewe.keewepocsse.listener

import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.ConcurrentHashMap


@Component
class TitleEventListener(
    private var userConnectionMap: ConcurrentHashMap<String, SseEmitter>
) {


    @RabbitListener
    fun pushTitleAcquireToUser(message: Message) {
        val userId: String? = "KW00000000001"
        val sseEmitter = userConnectionMap[userId] ?: return

        println("Connection exist with ${userId}")
        sseEmitter.send("You got title")
    }
}