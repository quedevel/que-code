package hello.nowonjpa.entity.complex_key.id_class.primary_key;

import hello.nowonjpa.entity.complex_key.id_class.ParentV3;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChildIdV3 implements Serializable {
    private ParentV3 parentV3;
    private String childId;
}
