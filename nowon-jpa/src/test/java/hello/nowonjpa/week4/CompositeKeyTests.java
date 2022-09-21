package hello.nowonjpa.week4;

import hello.nowonjpa.entity.embedded_id.primary_key.ParentIdV2;
import hello.nowonjpa.entity.embedded_id.ParentV2;
import hello.nowonjpa.entity.id_class.Parent;
import hello.nowonjpa.entity.id_class.primary_key.ParentId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@Commit
@Transactional
@SpringBootTest
public class CompositeKeyTests {

    @PersistenceContext
    private EntityManager em;

    @Test
    void idClassTest(){
        // given
        Parent parent = new Parent();
        parent.setId1("id1");
        parent.setId2("id2");
        parent.setName("parentName");
        em.persist(parent);

        // when
        ParentId parentId = new ParentId("id1", "id2");
        Parent findParent = em.find(Parent.class, parentId);

        // then
        assertThat(parent).isEqualTo(findParent);
    }

    @Test
    void embeddedIdTest(){
        // given
        ParentV2 parentV2 = new ParentV2();
        ParentIdV2 idV2 = new ParentIdV2("id1", "id2");
        parentV2.setId(idV2);
        parentV2.setName("parentV2Name");
        em.persist(parentV2);

        // when
        ParentIdV2 parentId = new ParentIdV2("id1", "id2");
        ParentV2 findParentV2 = em.find(ParentV2.class, parentId);

        // then
        assertThat(parentV2).isEqualTo(findParentV2);
    }
}
