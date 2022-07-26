package io.slogan.spring.redis.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.time.Instant

@RedisHash("metric")
data class Metric(
    @Id
    val id: String,
    val time: Instant,
    val first: ULong,
    val second: ULong
)