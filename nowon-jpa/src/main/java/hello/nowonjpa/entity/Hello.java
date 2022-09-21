package hello.nowonjpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hello {

    @Id
    private String id1;

    @Id
    private String id2;
}
