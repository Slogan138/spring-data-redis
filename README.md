# Spring Data Redis 사용하여 Redis Cache 사용하기

## Redis 란?
***Re***mote ***Di***ctionary ***S***erver 의 줄임말로 `Dictionary`, 즉 Key-Value 쌍 구조의 데이터 저장소이다.   
In-Memory 에 데이터가 저장되어 R/W 속도가 매우 빠른것이 특징이다. 주로 Caching, Session 관리 Pub/Sub 기능을 위해 사용한다.

### 지원하는 자료구조

- String
- List
- Set
- Hash
- SortedSet
- Bitmap
- HyperLogLog
- Stream
- Geospatial Index

## Spring Data Redis 는 그럼?

> Spring Data Redis, part of the larger Spring Data family, provides easy configuration and access to Redis from Spring applications.   
> It offers both low-level and high-level abstractions for interacting with the store, freeing the user from infrastructural concerns.

Spring 공식 홈페이지에 설명을 그대로 해석하자면 아래와 같다.(영어 실력이 뛰어나지 않아 오역이 있을 수 있습니다.)

> `Spring Data Redis` 는 커다란 `Spring Data` 의 가족 중 하나로 Spring 애플리케이션에서 손쉽게 설정하고 Redis 에 접속 할 수 있게 합니다.      
> 저장소와의 상호작용을 위한 `low-level` 과 `high-level` 추상화를 모두 제공해 사용자에게 인프라적인 고려사항에서 자유롭게 합니다.

저수준의 추상화와 고수준의 추상화 모두 지원하기 때문에 여타 다른 Spring Data 프로젝트, 예를 들자면 Spring Data JPA, Spring Data JDBC 와 유사하게 사용할 수 있다.

## How to Use.

`RedisTemplate` 를 설정하고 주입받아 사용하거나 `opsForX()` Instance 를 활용할 수 있지만 `Repository` 방식으로 사용하는 방법으로 소개한다.

### Entity 선언

```kotlin
@RedisHash("metric")
data class Metric(
    @Id val id: String = UUID.randomUUID().toString(),
    val time: Instant = Instant.now(),
    val first: Long = 0L,
    val second: Long = 0L,

    @TimeToLive val timeout: Long = 60L // Second
)
```

#### Warning!!

Primary Constructor 에 Default 값 없이 `val id: String` 과 같이 선언한다면 `kotlin.jvm.DefaultConstructorMarker` Property 가 주입되어 `MappingException` 이 발생한다.

### Reference.

- https://spring.io/projects/spring-data-redis
- https://www.baeldung.com/spring-data-redis-tutorial