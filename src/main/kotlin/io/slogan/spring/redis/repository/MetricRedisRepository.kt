package io.slogan.spring.redis.repository

import io.slogan.spring.redis.entity.Metric
import org.springframework.data.repository.CrudRepository

interface MetricRedisRepository : CrudRepository<Metric, String> {
}