package hello.nowonjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {

    @Id
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

}
