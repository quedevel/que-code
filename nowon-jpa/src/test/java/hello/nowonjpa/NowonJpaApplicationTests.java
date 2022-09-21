package hello.nowonjpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Commit
class NowonJpaApplicationTests {

    @PersistenceContext
    private EntityManager em;

    @Test
    void entityManagerTest(){

    }

    @Test
    void contextLoads() {
    }

}
