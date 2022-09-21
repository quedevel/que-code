package hello.nowonjpa.entity.complex_key.embedded_id;

import hello.nowonjpa.entity.complex_key.embedded_id.primary_key.ChildIdV4;

import javax.persistence.*;

@Entity
public class ChildV4 {

    @EmbeddedId
    private ChildIdV4 id;

    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public ParentV4 parentV4;
}
