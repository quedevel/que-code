package hello.nowonjpa.entity.complex_key.embedded_id.primary_key;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class GrandChildIdV2 implements Serializable {
    private ChildIdV4 childId;

    @Column(name = "GRANDCHILD_ID")
    private String id;
}
