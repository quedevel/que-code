package hello.nowonjpa.entity.complex_key.id_class;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ParentV3 {

    @Id
    @Column(name = "PARENT_ID")
    private String id;
    private String name;
}
