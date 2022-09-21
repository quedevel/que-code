package hello.nowonjpa.entity.complex_key.id_class;

import hello.nowonjpa.entity.complex_key.id_class.primary_key.ChildIdV3;

import javax.persistence.*;

@Entity
@IdClass(ChildIdV3.class)
public class ChildV3 {

    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public ParentV3 parentV3;

    @Id
    @Column(name = "CHILD_ID")
    private String childId;

    private String name;
}
