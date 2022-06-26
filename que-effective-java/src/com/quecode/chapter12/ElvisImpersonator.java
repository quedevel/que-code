package com.quecode.chapter12;

import java.io.*;

public class ElvisImpersonator {
    private static final byte[] serializedForm = {
        -84, -19, 0, 5, 115, 114, 0, 27, 99, 111, 109, 46,
        113, 117, 101, 99, 111, 100, 101, 46, 99, 104, 97,
        112, 116, 101, 114, 49, 50, 46, 69, 108, 118, 105,
        115, -12, 65, 67, 5, -113, -25, -60, -79, 2, 0, 1,
        91, 0, 13, 102, 97, 118, 111, 114, 105, 116, 101,
        83, 111, 110, 103, 115, 116, 0, 19, 91, 76, 106, 97,
        118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105,
        110, 103, 59, 120, 112, 117, 114, 0, 19, 91, 76,
        106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116,
        114, 105, 110, 103, 59, -83, -46, 86, -25, -23, 29,
        123, 71, 2, 0, 0, 120, 112, 0, 0, 0, 2, 116, 0, 11,
        71, 105, 109, 109, 101, 32, 71, 105, 109, 109, 101,
        116, 0, 3, 66, 97, 100
    };

    public static void main(String[] args) {
        Elvis elvis = (Elvis) deserialize(serializedForm);
        Elvis impersonator = ElvisStealer.impersonator;
        elvis.print();
        impersonator.print();
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
