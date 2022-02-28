package com.github.solairerove.amzscouttesttask.limit.service

import com.github.solairerove.amzscouttesttask.limit.domain.LimitationRequest
import com.github.solairerove.amzscouttesttask.limit.exception.LimitationException
import com.github.solairerove.amzscouttesttask.limit.properties.ApplicationProperties
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.Collections.synchronizedMap

// hostname to list of instant time
val cache: MutableMap<String, MutableList<Instant>> = synchronizedMap(mutableMapOf<String, MutableList<Instant>>())

@Service
class DefaultLimitationService(
    private val applicationProperties: ApplicationProperties
) : LimitationService {

    // не учитываю пограничный случай, когда ограничение запросов меньше 1
    // заполнять пока есть место и только потом вычищать будет решением лучше
    override fun limit(req: LimitationRequest) {
        val (startTime, hostname) = req
        if (cache.containsKey(hostname)) {
            evictCache(hostname, startTime)
            val times = cache[hostname]!!

            if (applicationProperties.limitCount > times.size) {
                times.add(startTime)
                return
            } else {
                throw LimitationException("limit exceeded for $hostname. already have $req request")
            }
        } else {
            cache[hostname] = mutableListOf(startTime)
        }
    }

    private fun evictCache(hostname: String, startTime: Instant) {
        val times = cache[hostname]!!
        val filteredTimes = times
            .filter { startTime.isBefore(it.plus(applicationProperties.timeout.limitTime)) }
            .toMutableList()
        cache[hostname] = filteredTimes
    }
}
