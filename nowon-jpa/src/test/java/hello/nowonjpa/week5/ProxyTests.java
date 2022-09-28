package hello.nowonjpa.week5;

import hello.nowonjpa.entity.Member;
import hello.nowonjpa.entity.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;

@Transactional
@SpringBootTest
public class ProxyTests {

    @PersistenceContext
    EntityManager em;

    @BeforeEach
    void insertMemberWithTeam(){
        Team team = new Team();
        team.setName("team1");
        team.setDescription("1번 팀");

        em.persist(team);

        Member member = new Member();
        member.setUsername("member1");
        member.setTeam(team);

        em.persist(member);
        em.flush();
        em.clear();
    }

    @Test
    @DisplayName("회원과 팀 정보를 출력하는 비즈니스 로직")
    void printUserAndTeam(){
        System.out.println("ProxyTests.printUserAndTeam");
        Member findMember = em.find(Member.class, "member1");
        Team team = findMember.getTeam();
        System.out.println("findMember = " + findMember.getUsername());
        System.out.println("team.getName() = " + team.getName());
    }
    
    @Test
    @DisplayName("회원과 팀 정보를 출력하는 비즈니스 로직")
    void printUser(){
        Member member1 = em.find(Member.class, "member1");
        System.out.println("member1.getUsername() = " + member1.getUsername());
    }

    @Test
    void getReference(){
        Member findMember = em.getReference(Member.class, "member1");
        PersistenceUnitUtil pu = em.getEntityManagerFactory().getPersistenceUnitUtil();
        boolean isLoaded = pu.isLoaded(findMember);
        System.out.println("isLoaded = " + isLoaded);
    }

    @Test
    @DisplayName("지연 로딩 테스트")
    void lazyLoadingTest(){
        Member findMember = em.find(Member.class, "member1");
        System.out.println("findMember.getUsername() = " + findMember.getUsername());
        Team team = findMember.getTeam();
        System.out.println("team.getDescription() = " + team.getDescription());
    }

}
