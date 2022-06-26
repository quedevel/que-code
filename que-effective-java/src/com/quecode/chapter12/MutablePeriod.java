package com.quecode.chapter12;

import com.quecode.chapter8.Period;

import java.io.*;
import java.util.Date;

public class MutablePeriod {
    public final Period period;
    public final Date start;
    public final Date end;

    public MutablePeriod() {
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);

            out.writeObject(new Period(new Date(), new Date()));

            byte[] ref = {0x71, 0, 0x7e, 0, 5};
            bos.write(ref);
            ref[4] = 4;
            bos.write(ref);

            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            this.period = (Period) in.readObject();
            this.start = (Date) in.readObject();
            this.end = (Date) in.readObject();
        } catch (IOException | ClassNotFoundException e){
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        Date pEnd = mp.end;

        pEnd.setYear(78);
        System.out.println("p = " + p);

        pEnd.setTime(69);
        System.out.println("p = " + p);
    }
}
