package org.quecode.backoffice.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.quecode.backoffice.member.dto.MemberDTO;
import org.quecode.backoffice.menu.dto.MenuDTO;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "M_MENU")
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long parentId;
    private String menuNm;
    private String menuUrl;
    private Integer depth;
    private String menuOpt1;
    private String menuOpt2;
    private String menuOpt3;

    public MenuDTO toDTO(){
        return MenuDTO.builder()
                .id(id)
                .parentId(parentId)
                .menuNm(menuNm)
                .menuUrl(menuUrl)
                .depth(depth)
                .menuOpt1(menuOpt1)
                .menuOpt2(menuOpt2)
                .menuOpt3(menuOpt3)
                .build();
    }
}
