# 🔥 [ Chapter3 ] 모든 객체의 공통 메서드
_<span style='font-weight: bold;'>Object</span>는 객체를 만들 수 잇는 구체 클래스지만 기본적으로는 상속해서 사용하도록 설계되었다.<br>_
_<span style='font-weight: bold;'>Object</span>에서 final이 아닌 메서드는 모두 재정의를 염두에 두고 설계된 것이라 재정의 시 지켜야 하는<br>_
_일반 규약이 명확히 정의되어 있다._

## 🎯  아이템 10. equals는 일반 규약을 지켜 재정의하라.
+ **Object 명세에 적힌 규약 ❗**
> 1️⃣ 반사성 : null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true다.<br>
> 2️⃣ 대칭성 : null이 아닌 모든 참조 값 x,y에 대해, x.equals(y)가 true면 y.equals(x)도 true다.<br>
> 3️⃣ 추이성 : null이 아닌 모든 참조 값 x,y,z에 대해, x.equals(y)가 true이고 y.equals(z)도 true면 x.equals(z)도 true다.<br>
> 4️⃣ 일관성 : null이 아닌 모든 참조 값 x,y에 대해, x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.<br>
> 5️⃣ null-아님 : null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false다.<br>
 
 <br>

+ **잘못된 코드 - 대칭성 위배 ❗** 
```java
public final class CaseInsensitiveString {
    private final String s;
    
    public CaseInsensitiveString(String s){
        this.s = Object.requireNonNull(s);
    }
    
    // 대칭성 위배 !!
    @Override
    public boolean equals(Object o){
        if(o instanceof CaseInsensitiveString) return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        if(o instanceof String) return s.equalsIgnoreCase(((String) o));
        return false;
    }
    ... 
}
```
⚠️`CaseInsensitiveString`의 equals는 일반`String`을 알고있지만 `String`의 equals는 `CaseInsensitiveString`의 존재를 모른다는데 있다.<br>
⚠️ equals 규약을 어기면 그 객체를 사용하는 다른 객체들이 어떻게 반응할지 알 수 없다.<br>
⚠️ 구체 클래스를 확장해 새로운 값을 추가하면서 equals 규약을 만족시킬 방법은 존재하지 않는다.<br><br><br>

+ **양질의 equals 메서드 구현 방법을 단계별로 정리 ❗**
> 1️⃣ == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.<br>
> 2️⃣ instanceof 연산자로 입력이 올바른 타입인지 확인한다.<br>
> 3️⃣ 입력을 올바른 타입으로 형변환한다.<br>
> 4️⃣ 입력 객체와 자기 자신의 대응되는 '핵심'필드들이 모두 일치하는지 하나씩 검사한다.<br>


## 🎯  아이템 11. equals를 재정의하려거든 hashCode도 재정의하라.
+ **Object 명세에 적힌 규약 ❗**
> 1️⃣ equals 비교에 사용되는 정보가 변경되지 않았다면, 애플리케이션이 실행되는 동안 그 객체의 hashCode 메서드는 <br>&nbsp; &nbsp; &nbsp; 몇 번을 호출해도 일관되게 항상 같은 값을 반환해야 한다.<br>
> 2️⃣ equals(Object)가 두 객체를 같다고 판단했다면, 두 객체의 hashCode는 똑같은 값을 반환해야 한다.<br>
> 3️⃣ equals(Object)가 두 객체를 다르다고 판단했더라도, 두 객체의 hashCode가 서로 다른 값을 반환할 필요는 없다.<br>

**⚠️hashCode 재정의를 잘못했을 때 크게 문제가 되는 조항은 두 번재다. 즉, 논리적으로 같은 객체는 같은 해시코드를 반환해야 한다.**


## 🎯  아이템 12. toString을 항상 재정의하라.
```java
@Override
public String toString() {
    return "User{" +
            "userId='" + userId + '\'' +
            ", userPw='" + userPw + '\'' +
            ", userNm='" + userNm + '\'' +
            '}';
}
```
+ toString은 그 객체가 가진 주요 정보 모두를 반환하는게 좋다.
+ toString이 반환한 값에 포함된 정보를 얻어올 수 있는 API를 제공하자.

## 🎯  아이템 13. clone 재정의는 주의해서 진행하라.

## 🎯  아이템 14. Comparable을 구혈할지 고려하라.


## ⭐ 결론
