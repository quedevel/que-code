package hello.nowonjpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Hello implements Serializable {

    @Id
    private String id1;

    @Id
    private String id2;
}
