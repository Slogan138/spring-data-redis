package io.slogan.spring.redis

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.slogan.spring.redis.entity.Metric
import io.slogan.spring.redis.repository.MetricRedisRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID

@SpringBootTest(
    classes = [SpringDataRedisApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
internal class GetTests(
    val metricRedisRepository: MetricRedisRepository
) : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    val log: Logger = LoggerFactory.getLogger(javaClass)

    init {
        this.describe("Get Created Metric by randomly generated uuid") {
            val id = UUID.randomUUID().toString()
            val metric = Metric(id = id, first = 200L, second = 100L)
            val createMetric = metricRedisRepository.save(metric)
            createMetric shouldBe metric
            log.info("$createMetric")
            val getValue = metricRedisRepository.findById(id).orElse(Metric())
            getValue shouldBe createMetric
        }
    }
}
