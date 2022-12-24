package com.keewe.keewepocsse.api


import com.keewe.keewepocsse.service.DummyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@RestController
class ConnectionController(
    private var dummyService: DummyService
) {

        @GetMapping("/{userId}")
        fun createNewConnection(@PathVariable userId: String): SseEmitter {
            return dummyService.makeConnection(userId)
        }

}