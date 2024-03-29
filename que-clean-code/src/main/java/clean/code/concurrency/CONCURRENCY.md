## 동시성.

> 객체는 처리의 추상화다. 스레드는 일정의 추상화다. <br>
>  - 제임스 O.코플리엔 <br>

<br>

동시성과 깔끔한 코드는 양립하기 어렵다. 스레드를 하나만 실행하는 코드는 짜기가 쉽다. 

<br>

#### 동시성이 필요한 이유?

동시성은 결합을 없애는 전략이다. 즉, 무엇과 언제를 분리하는 전략이다. <br>
스레드가 하나인 프로그램은 무엇과 언제가 서로 밀접하다. <br>

무엇과 언제를 분리하면 애플리케이션 구조와 효율이 극적으로 나아진다. <br>
구조적인 관점에서 프로그램은 거대한 루프 하나가 아니라 작은 협력 프로그램 여럿으로 보인다. <br>
따라서 시스템을 이해하기가 쉽고 문제를 분리하기도 쉽다. <br>

<br>

#### 미신과 오해 <br>

* 동시성은 항상 성능을 높여준다. <br>

동시성은 때로 성능을 높여준다. 대기 시간이 아주 길어 여러 스레드가 프로세서를 공유할 수 있거나, <br>
여러 프로세서가 동시에 처리할 독립적인 계산이 충분히 많은 경우에만 성능이 높아진다. <br>
어느 쪽도 일상적으로 발생하는 상황은 아니다. <br>

* 동시성을 구현해도 설계는 변하지 않는다. <br>

단일 스레드 시스템과 다중 스레드 시스템은 설계가 판이하게 다르다. <br>
일반적으로 무엇과 언제를 분리하면 시스템 구조가 크게 달라진다. <br>

* 웹 또는 EJB 컨테이너를 사용하면 동시성을 이해할 필요가 없다. <br>

실제로는 컨테이너가 어떻게 동작하는지, 어떻게 동시 수정, 데드락 등과 같은 문제를 피할 수 있는지를 알아야만 한다. <br>

<br>

#### 동시성과 관련된 타당한 생각 몇 가지

* 동시성은 다소 부하를 유발한다. <br>

성능 측면에서 부하가 걸리며, 코드도 더 짜야 한다. <br>

* 동시성은 복잡하다. <br>

간단한 문제라도 동시성은 복잡하다. <br>

* 일반적으로 동시성 버그는 제현하기 어렵다. <br>

그래서 진짜 결함으로 간주되지 않고 일회성 문제로 여겨 무시하기 쉽다. <br>

* 동시성을 구현하려면 흔히 근복적인 설계 전략을 재고해야 한다. <br>

<br>

#### 동시성 방어 원칙

* 단일 책임 원칙 <br>

SRP는 주어진 메서드/클래스/컴포넌트를 변경할 이유가 하나여야 한다는 원칙으로 <br>
동시성은 복잡성 하나만으로도 따로 분리할 이유가 충분하다. 즉, 동시성 관련 코드는 다른 코드와 분리해야 한다. <br>

* 따름 정리: 자료 범위를 제한하라 <br>

객체 하나를 공유한 후 동일 필드를 수정하던 두 스레드가 서로 간섭하므로 예상치 못한 결과를 내놓는다. <br>
이런 문제를 해결하는 방안으로 공유 객체를 사용하는 코드 내 임계영역을 synchronized 키워드로 보호하라. <br>

* 따름 정리: 자료 사본을 사용하라 <br>

공유 자료를 줄이려면 처음부터 공유하지 않는 방법이 제일 좋다. <br>
어떤 경우에는 객체를 복사해 읽기 전용으로 사용하는 방법이 가능하다. <br>
어떤 경우에는 각 스레드가 객체를 복사해 사용한 후 한 스레드가 해당 사본에서 결과를 가져오는 방법도 가능하다. <br>

* 따름 정리: 스레드는 가능한 독립적으로 구현하라 <br>

자신만의 세상에 존재하는 스레드를 구현한다. 즉, 다른 스레드와 자료를 공유하지 않는다. <br>
각 스레드는 클라이언트 요청 하나를 처리한다. 모든 정보는 비공유 출처에서 가져오며 로컬 변수에 저장한다. <br>
그러면 각 스레드는 세상에 자신만 있는 듯이 돌아갈 수 있다. <br>

<br>

#### 동기화하는 메서드 사이에 존재하는 의존성을 이해하라

동기화하는 메서드 사이에 의존성이 존재하면 동시성 코드에 찾아내기 어려운 버그가 생긴다. <br>
자바 언어는 개별 메서드를 보호하는 synchronized 라는 개념을 지원하다. <br>
하지만 공유 클래스 하나에 동기화된 메서드가 여럿이라면 구현이 올바른지 다시 한 번 확인해야 한다. <br>

<br>

#### 스레드 코드 테스트하기

코드가 올바르다고 증명하기는 현실적으로 불가능하다. 테스트가 정확성을 보장하지는 않는다. <br>
그럼에도 충분한 테스트는 위험을 낮춘다. 스레드가 하나인 프로그램은 지금까지 한 말이 모두 옳다 <br>
그런데 같은 코드와 같은 자원을 사용하는 스레드가 둘 이상으로 늘어나면 상황은 급격하게 복잡해진다. <br>

<br>

> Robert C. Martin, 『Clean Code』, 박재호 * 이해영 옮김, 인사이트(2013), p226-244.