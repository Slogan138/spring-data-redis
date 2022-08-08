package io.slogan.spring.redis.controller

import io.slogan.spring.redis.repository.MetricRedisRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class MetricController(
    val metricRedisRepository: MetricRedisRepository
) {

    @GetMapping("/metric/{id}")
    suspend fun get(@PathVariable id: String) = Mono.just(ResponseEntity.ok(withContext(Dispatchers.IO) {
        metricRedisRepository.findById(id)
    }.orElseThrow()))
}
