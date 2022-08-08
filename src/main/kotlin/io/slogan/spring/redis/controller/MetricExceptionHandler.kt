package io.slogan.spring.redis.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import reactor.core.publisher.Mono

@RestControllerAdvice
class MetricExceptionHandler {

    @ExceptionHandler(value = [NoSuchElementException::class])
    fun handleNoSuchElementException() =
        Mono.justOrEmpty(
            ResponseEntity.badRequest().body(mapOf<String, Any>("message" to "No Such Element", "code" to 400))
        )
}