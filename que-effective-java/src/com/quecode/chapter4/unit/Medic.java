package com.quecode.chapter4.unit;

public class Medic implements GroundHealingUnit{
    @Override
    public void walk() {
        System.out.println("Medic.walk");
    }

    @Override
    public void cure() {
        System.out.println("Medic.cure");
    }
}
