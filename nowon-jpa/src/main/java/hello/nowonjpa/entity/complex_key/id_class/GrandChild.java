package hello.nowonjpa.entity.complex_key.id_class;

import hello.nowonjpa.entity.complex_key.id_class.primary_key.GrandChildId;

import javax.persistence.*;

@Entity
@IdClass(GrandChildId.class)
public class GrandChild {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private ChildV3 childV3;

    @Id
    @Column(name = "GRANDCHILD_ID")
    private String id;

    private String name;
}
