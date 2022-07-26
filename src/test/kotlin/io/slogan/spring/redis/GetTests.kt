package io.slogan.spring.redis

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.slogan.spring.redis.repository.MetricRedisRepository
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    classes = [SpringDataRedisApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
internal class GetTests(
    val metricRedisRepository: MetricRedisRepository
) : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
    }
}
