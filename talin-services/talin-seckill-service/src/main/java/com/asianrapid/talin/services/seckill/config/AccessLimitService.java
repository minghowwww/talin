package com.asianrapid.talin.services.seckill.config;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

@Component
public class AccessLimitService {

    /**
     * 每秒只发出5个令牌 ，超过permits会被阻塞
     * 类似于JDK的信号量Semphore，用来限制对资源并发访问的线程数
     */
    private final RateLimiter rateLimiter = RateLimiter.create(5.0);

    /**
     * 尝试获取令牌
     *
     * @return
     */
    public boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }
}