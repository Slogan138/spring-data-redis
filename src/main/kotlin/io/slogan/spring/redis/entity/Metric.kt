package io.slogan.spring.redis.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.time.Instant
import java.util.UUID

// Warning!! : 생성자에 default 값 지정해 주지 않으면 kotlin.jvm.DefaultConstructorMarker Property 주입으로 인해 MappingException 발생
@RedisHash("metric")
data class Metric(
    @Id val id: String = UUID.randomUUID().toString(),
    val time: Instant = Instant.now(),
    val first: Long = 0L,
    val second: Long = 0L,

    @TimeToLive val timeout: Long = 60L // Second
)