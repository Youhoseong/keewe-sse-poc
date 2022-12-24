package com.keewe.keewepocsse.component

import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.ConcurrentHashMap

@Component
class SseEmitters(
    private var emittersMap: ConcurrentHashMap<String, SseEmitter> = ConcurrentHashMap()
) {

        fun addEmitter(userId: String, emitter: SseEmitter) {
            configureInitialEmitter(userId, emitter)
            emittersMap.put(userId, emitter)
        }

        private fun configureInitialEmitter(userId: String, emitter: SseEmitter) {
            emitter.onCompletion {
                emittersMap.remove(userId)
            }

            emitter.onTimeout {
                emitter.complete()
            }
        }
}