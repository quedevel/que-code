package com.example.queredis.service;

import com.example.queredis.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final RedisTemplate<String, Object> redisTemplate;

    public static int getMethodHitCount = 0;

    public void saveMember(String uuid, MemberDto value) {
        redisTemplate.opsForValue().set(uuid, value);
    }

    @Cacheable(value = "Member", key = "#uuid", cacheManager = "cacheManager")
    public MemberDto getMember(String uuid) {
        getMethodHitCount++;
        return (MemberDto) redisTemplate.opsForValue().get(uuid);
    }

    @CacheEvict(value = "Member", key = "#uuid", cacheManager = "cacheManager")
    public void deleteMember(String uuid) {
        redisTemplate.delete(uuid);
    }
}

