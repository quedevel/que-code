package com.quecode.chapter2;

/**
 * Description
 * 8. finalizer와 cleaner 사용을 피하라
 *
 * 핵심 정리
 *
 * Object.java 에 구현되어 있는 finalizer의 주석 참고
 *
 * @deprecated The finalization mechanism is inherently problematic.
 * Finalization can lead to performance issues, deadlocks, and hangs.
 * Errors in finalizers can lead to resource leaks
 *
 * @deprecated finalizer 메커니즘은 본질적으로 문제가 있다.
 * finalizer은 성능 문제, 교착 상태 및 중단으로 이어질 수 있습니다.
 * finalizer의 오류는 리소스 누수로 이어질 수 있습니다.
 *
 * cleaner 또한 성능에 문제를 줄 수 있으니 사용을 피하자!
 */
public class Item8 {
}
