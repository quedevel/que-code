package com.quecode.chapter2;

import java.util.function.Supplier;

/**
 * Description
 * 5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
 *
 * 핵심 정리
 * 유연하게 사용하기 위해 필요한 자원 넘겨 주입 받자.
 */
public class Item5 {

    static abstract class Lexicon {}
    static class EnglishLexicon extends Lexicon {}
    static class KoreanLexicon extends Lexicon {}
    static class SpellChecker {
        private Lexicon dictionary;
        public SpellChecker(Supplier<? extends Lexicon> supplier){
            this.dictionary = supplier.get();
        }
        public boolean isValid(String word){return false;}
    }

}
