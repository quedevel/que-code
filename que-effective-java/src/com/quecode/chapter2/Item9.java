package com.quecode.chapter2;

import java.io.*;

/**
 * Description
 * 9. try-finally보다는 try-with-resources를 사용하라.
 *
 * 핵심 정리
 * 반드시 자원을 회수해야 하는 자원을 다룰때는
 * try-finally를 이용해 close 함수를 사용하지 말고
 * try-with-resources문을 활용해 정확성과 가독성을 높여서 자원을 회수하자
 */
public class Item9 {

    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new FileReader("try-with-resources"))){

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
