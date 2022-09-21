package hello.nowonjpa.entity.complex_key.embedded_id.primary_key;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ChildIdV4 implements Serializable {

    private String parentId;

    @Column(name = "CHILD_ID")
    private String id;
}
