package hello.nowonjpa.entity.complex_key.embedded_id;

import hello.nowonjpa.entity.complex_key.embedded_id.primary_key.GrandChildIdV2;

import javax.persistence.*;

@Entity
public class GrandChildV2 {

    @EmbeddedId
    private GrandChildIdV2 id;

    @MapsId("childId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private ChildV4 childId;

    private String name;
}
