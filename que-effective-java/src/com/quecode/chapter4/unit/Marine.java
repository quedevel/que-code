package com.quecode.chapter4.unit;

public class Marine implements GroundAttackUnit, Comparable<Marine> {
    private String name;
    private int health;

    @Override
    public void walk() {
        System.out.println("Marine.walk");
    }

    @Override
    public void attack() {
        System.out.println("Marine.attack");
    }

    @Override
    public int compareTo(Marine o) {
        return health - o.getHealth() >= 0? health - o.getHealth() == 0? 0 : 1: -1;
    }

    /* getter, setter */
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getHealth() {return health;}
    public void setHealth(int health) {this.health = health;}
}
