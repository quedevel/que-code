package com.example.queredis.redis;

import com.example.queredis.dto.MemberDto;
import com.example.queredis.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RedisTests {

    @Autowired
    MemberService memberRedisService;

    @Test
    void saveTest(){
        //given
        String uuid = UUID.randomUUID().toString();
        MemberDto dto = MemberDto.builder().uuid(uuid).name("김동호").build();

        //when
        memberRedisService.saveMember(uuid, dto);
        MemberDto findMember = memberRedisService.getMember(uuid);

        //then
        assertThat(findMember.getUuid()).isEqualTo(uuid);
        assertThat(findMember.getName()).isEqualTo("김동호");
    }

    @Test
    void cacheTest(){
        //given
        String uuid = UUID.randomUUID().toString();
        MemberDto dto = MemberDto.builder().uuid(uuid).name("김동호").build();
        int redisHit = 10;

        //when
        memberRedisService.saveMember(uuid, dto);

        for (int i = 0; i < 10; i++) {
            memberRedisService.getMember(uuid);
        }

        //then
        assertThat(redisHit).isNotEqualTo(memberRedisService.getMethodHitCount);
    }
}
