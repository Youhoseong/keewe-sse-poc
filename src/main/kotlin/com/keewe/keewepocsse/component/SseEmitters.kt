package com.keewe.keewepocsse.component

import org.springframework.stereotype.Component
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.ConcurrentHashMap

@Component
class SseEmitters(
    private var userConnectionMap: ConcurrentHashMap<String, SseEmitter>
) {

        fun addEmitter(userId: String, emitter: SseEmitter) {
            configureInitialEmitter(userId, emitter)
            userConnectionMap.put(userId, emitter)
        }

        private fun configureInitialEmitter(userId: String, emitter: SseEmitter) {
            emitter.onCompletion {
                userConnectionMap.remove(userId)
            }

            emitter.onTimeout {
                emitter.complete()
            }
        }
}