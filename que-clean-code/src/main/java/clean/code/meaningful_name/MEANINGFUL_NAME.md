## 깨끗한 코드.

<br>

### 의도를 분명히 밝혀라.

* 아무 의미도 드러나지 않는 변수
```java
int d; // 경과 시간(단위 : 날짜)
```

* 의도가 드러나는 이름을 사용한 변수
```java
int elapsedTimeInDays;
int daysSinceCreation;
int daysSinceModification;
int fileAgeInDays;
```

<br>

### 그릇된 정보를 피하라.

프로그래머는 코드에 그릇된 단서를 남겨서는 안 된다. 그릇된 단서는 코드 의미를 흐린다.

<br>


### 의미 있게 구분하라.

* before
```java
public static void copyChars(char a1[], char a2[]){
    for (int i = 0; i < a1.length; i++) {
        a2[i] = a1[i];
    }
}
```

* after
```java
public static void copyChars(char[] source, char[] destination){
    for (int i = 0; i < source.length; i++) {
        destination[i] = source[i];
    }
}
```

<br>


### 발음하기 쉬운 이름을 사용하라.

* before
```java
private Date genymdhms;
private Date modymdhms;
private final String pszqint = "102";
```

* after
```java
private Date generationTimestamp;
private Date modificationTimestamp;
private final String recordId = "102";
```

<br>


### 검색하기 쉬운 이름을 사용하라.

**이름 길이는 범위 크기에 비례해야 한다.** 변수나 상수를 코드 여러 곳에서 사용한다면 검색하기 쉬운 이름이 바람직하다.

<br>

### 자신의 기억력을 자랑하지 마라.

독자가 코드를 읽으면서 변수 이름을 자신이 아는 이름으로 변환해야 한다면 그 변수 이름은 바람직하지 못하다. 이는 일반적으로 <br>
문제 영역이나 해법 영역에서 사용하지 않는 이름을 선택했기 때문에 생기는 문제다. <br>
똑똑한 프로그래머와 전문가 프로그래머 사이에서 나타나는 차이점 하나만 들자면, 전문가 프로그래머는 **명료함이 최고**라는 사실을 이해한다. 

<br>

### 한 개념에 한 단어를 사용하라.

추상적인 개념 하나에 단어 하나를 선택해 이를 고수한다. 예를 들어, 똑같은 메서드를 클래스마다 fetch, retrieve, get으로 제각각 <br>
부르면 혼란스럽다. 어느 클래스에서 어느 이름을 썻는지 기억하기도 어렵다. <br>

<br>


### 말장난을 하지 마라.

프로그래머는 코드를 최대한 이해하기 쉽게 짜야 한다. 집중적인 탐구가 필요한 코드가 아니라 대충 훑어봐도 이해할 코드 작성이 목표다. <br>
의미를 해독할 책임이 독자에게 있는 논문 모델이 아니라 의도를 밝힐 책임이 저자에게 있는 잡지 모델이 바람직하다. <br>

<br>

### 의미 있는 맥락을 추가하라.

* before
```java
private void printGuessStatistics(char candidate, int count){
    String number;
    String verb;
    String pluralModifier;
    if (count == 0) {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    } else if (count == 1) {
        number = "1";
        verb = "is";
        pluralModifier = "";
    } else {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s";
    }
    String guessMessage = String.format(
        "There %s %s %s%s", verb, number, candidate, pluralModifier
    );
    print(guessMessage);
}
```

* after
```java
private String number;
private String verb;
private String pluralModifier;

private void make(char candidate, int count){
    createPluralDependentMessageParts(count);
    String guessMessage = String.format(
        "There %s %s %s%s", verb, number, candidate, pluralModifier
    );
    print(guessMessage);
}

private void createPluralDependentMessageParts(int count) {
    if (count == 0) {
        thereAreNoLetters();
    } else if (count == 1) {
        thereIsOneLetter();
    } else {
        thereAreManyLetters(count);
    }
}

private void thereAreNoLetters() {
    number = "no";
    verb = "are";
    pluralModifier = "s";
}

private void thereIsOneLetter() {
    number = "1";
    verb = "is";
    pluralModifier = "";
}

private void thereAreManyLetters(int count) {
    number = Integer.toString(count);
    verb = "are";
    pluralModifier = "s";
}
```

<br>

> Robert C. Martin, 『Clean Code』, 박재호 * 이해영 옮김, 인사이트(2013), p22-38.