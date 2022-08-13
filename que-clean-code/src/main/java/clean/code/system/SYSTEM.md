## 시스템.

<br>

#### 도시를 세운다면?

온갖 세세한 사항을 혼자서 직접 관리할 수 있을까? 아마도 불가능하다. <br>
이미 세워진 도시라도 한 사람의 힘으로는 무리다. <br>

<br>

#### 시스템 제작과 시스템 사용을 분리하라.

소프트웨어 시스템은 (애플리케이션 객체를 제작하고 의존성을 서로 '연결'하는) <br>
준비 과정과 (준비 과정 이후에 이어지는) 런타임 로직을 분리해야 한다. <br>
시작 단계는 모든 애플리케이션이 풀어야 할 **관심사**(concern)다. <br>
**관심사 분리**는 우리 분야에서 가장 오래되고 가장 중요한 설계 기법 중 하나다. <br>

<br>

#### 확장

'처음부터 올바르게' 시스템을 만들 수 있다는 믿음은 미신이다. 대신에 우리는 오늘 주어진 사용자 스토리에 맞춰 시스템을 구현해야 한다. <br>
내일은 새로운 스토리에 맞춰 시스템을 조정하고 확장하면 된다. 이것이 반복적이고 점진적인 애자일 방식의 핵심이다. <br>
테스트 주도 개발,리팩터링, 깨끗한 코드는 코드 수준에서 시스템을 조정하고 확장하기 쉽게 만든다. <br>

> 소프트웨어 시스템은 물리적인 시스템과 다르다. <br>
> 관심사를 적절히 분리해 관리한다면 소프트웨어 아키텍처는 점진적으로 발전할 수 있다. <br>

<br>

#### 테스트 주도 시스템 아키텍처 구축

관점으로 관심사를 분리하는 방식은 그 위력이 막강하다. 애플리케이션 도메인 논리를 POJO로 작성할 수 있다면, <br>
즉 코드 수준에서 아키텍처 관심사를 분리할 수 있다면, 진정한 테스트 주도 아키텍처 구축이 가능해진다. <br>

> 최선의 시스템 구조는 각기 POJO 객체로 구현되는 모듈화된 관심사 영역으로 구성된다. <br>
> 이렇게 서로 다른 영역은 해당 영역 코드에 최소한의 영향을 미치는 관점이나 유사한 도구를 사용해 통합한다. <br>
> 이런 구조 역시 코드와 마찬가지로 테스트 주도 기법을 적용할 수 있다. <br>

<br>

#### 의사 결정을 최적화하라.

> 관심사를 모듈로 분리한 POJO 시스템은 기민함을 제공한다. 이런 기만함 덕택에 최신 정보에 기반해 <br>
> 최선의 시점에 최적의 결정을 내리기가 쉬워진다. 또한 결정의 복잡성도 줄어든다. <br>

<br>

#### 명백한 가치가 있을 때 표준을 현명하게 사용하라

> 표준을 사용하면 아이디어와 컴포넌트를 재사용하기 쉽고, 적절한 경험을 가진 사람을 구하기 쉬우며, <br>
> 좋은 아이디어를 캡슐화하기 쉽고, 컴포넌트를 엮기 쉽다. 하지만 때로는 표준을 만드는 시간이 너무 오래 <br>
> 걸려 업계가 기다리지 못한다. 어떤 표준은 원래 표준을 제정한 목적을 잊어버리기도 한다. <br>

<br>

#### 결론

시스템 역기 깨끗해야 한다. .깨끗하지 못한 아키텍처는 도메인 논리를 흐리며 기민성을 떨어뜨린다. <br>
도메인 논리가 흐려지면 제품 품질이 떨어진다. 버그가 숨어들기 쉬워지고, 스토리를 구현하기 어려워지는 탓이다. <br>
기민성이 떨어지면 생성성이 낮아져 TDD가 제공하는 장점이 사라진다. <br>

모든 추상화 단계에서 의도는 명확히 표현해야 한다. 그러려면 POJO 를 작성하고 관점 혹인 관점과 유사한 매커니즘을 <br>
사용해 각 구현 관심사를 분리해야 한다. <br.

시스템을 설계하든 개별 모듈을 설계하든, 실제로 **_돌아가는 가장 단순한 수단_**을 사용해야 한다는 사실을 명심하자. <br>

<br>

> Robert C. Martin, 『Clean Code』, 박재호 * 이해영 옮김, 인사이트(2013), p194-214.