package hello.nowonjpa.entity.embedded_id;

import hello.nowonjpa.entity.embedded_id.primary_key.ParentIdV2;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class ParentV2 {

    @EmbeddedId
    private ParentIdV2 id;

    private String name;

}
