package hello.nowonjpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Locker {

    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


}
