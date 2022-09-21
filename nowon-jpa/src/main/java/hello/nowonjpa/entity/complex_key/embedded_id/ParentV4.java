package hello.nowonjpa.entity.complex_key.embedded_id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParentV4 {

    @Id @Column(name = "PARENT_ID")
    private String id;

    private String name;
}
