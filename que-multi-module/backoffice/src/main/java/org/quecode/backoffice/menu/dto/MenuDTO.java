package org.quecode.backoffice.menu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.quecode.backoffice.menu.entity.Menu;

@ToString
@Data
@Builder
public class MenuDTO {

    private Long id;
    private Long parentId;
    private String menuNm;
    private String menuUrl;
    private Integer depth;
    private String menuOpt1;
    private String menuOpt2;
    private String menuOpt3;

    public Menu toEntity(){
        return Menu.builder()
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
