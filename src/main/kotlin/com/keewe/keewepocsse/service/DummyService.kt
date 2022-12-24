package com.keewe.keewepocsse.service

import com.keewe.keewepocsse.component.SseEmitters
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Service
class DummyService(
    private var sseEmitters: SseEmitters
){
        fun makeConnection(userId: String): SseEmitter {
            val sseEmitter = SseEmitter()
            sseEmitters.addEmitter(userId, sseEmitter)
            sseEmitter.send(SseEmitter.event().name(userId).data("I'm alive !!"))
            return sseEmitter
        }
}