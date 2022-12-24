package com.keewe.keewepocsse.service

import com.keewe.keewepocsse.component.SseEmitters
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Service
class DummyService(
    private var sseEmitters: SseEmitters
){
    fun makeConnection(eventName: String): SseEmitter {
        val sseEmitter = SseEmitter()
        sseEmitters.addEmitter(sseEmitter);
        sseEmitter.send(SseEmitter.event().name(eventName).data("I'm alive !!"))
        return sseEmitter
    }
}