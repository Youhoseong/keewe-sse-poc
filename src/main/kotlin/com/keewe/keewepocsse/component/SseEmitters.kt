package com.keewe.keewepocsse.component

import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@Component
class SseEmitters(
    private var emitters: MutableList<SseEmitter> = mutableListOf()
) {

    fun addEmitter(emitter: SseEmitter) {
        configureInitialEmitter(emitter)
        emitters.add(emitter)
    }

    private fun configureInitialEmitter(emitter: SseEmitter) {
        emitter.onCompletion {
            emitters.remove(emitter)
        }

        emitter.onTimeout {
            emitter.complete()
        }
    }
}