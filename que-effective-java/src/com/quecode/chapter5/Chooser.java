package com.quecode.chapter5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {

    private final List<T> choiceArray;

    public Chooser(Collection<T> choiceArray) {
        this.choiceArray = new ArrayList<>(choiceArray);
    }

    public T choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceArray.get(rnd.nextInt(choiceArray.size()));
    }
}
