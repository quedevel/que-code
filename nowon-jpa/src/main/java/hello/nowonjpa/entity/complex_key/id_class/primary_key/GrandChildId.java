package hello.nowonjpa.entity.complex_key.id_class.primary_key;

import hello.nowonjpa.entity.complex_key.id_class.ChildV3;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class GrandChildId implements Serializable {

    private ChildV3 childV3;
    private String id;
}
