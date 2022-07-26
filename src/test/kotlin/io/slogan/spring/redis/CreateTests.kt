package io.slogan.spring.redis

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.slogan.spring.redis.entity.Metric
import io.slogan.spring.redis.repository.MetricRedisRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import java.time.Instant
import java.util.UUID

@SpringBootTest(
    classes = [SpringDataRedisApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
internal class CreateTests(
    val metricRedisRepository: MetricRedisRepository
) : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    private final val log: Logger = LoggerFactory.getLogger(javaClass)

    init {
        this.describe("Create Metric Data and Save to Redis") {
            val metric = Metric(UUID.randomUUID().toString(), Instant.now(), 200.toULong(), 100.toULong())
            metricRedisRepository.save(metric) shouldBe metric
        }
    }
}