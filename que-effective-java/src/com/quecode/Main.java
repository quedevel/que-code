package com.quecode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Byte> list = new ArrayList<>();
        list.add((byte) 'a');
        list.add((byte) 'b');
        list.add((byte) 'c');

    }
    private static void extracted(byte b) throws IOException {
        System.out.write(b);
    }
}
