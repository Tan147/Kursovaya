package com.tatiana.exam.kurs01;

import java.time.LocalDate;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        Holder holder01 = new Holder("Ivan", "Petrov", 1990);
        Holder holder02 = new Holder("22", "ghjghv", 1990);
        Holder holder03 = new Holder("33", "vm", 1990);
        Holder holder04 = new Holder("44an", "Pvbmvmov", 1990);
        Holder holder05 = new Holder("55an", "Pfjfjov", 1990);
        Holder holder06 = new Holder("66an", "Pyjcxov", 1990);

        Membership membership01 = new Membership(1, LocalDate.of(2024, 12, 31), holder01, Type.ONETIME);
        Membership membership02 = new Membership(2, LocalDate.of(2024, 10, 31), holder04, Type.FULL);

        Fitness fitness01 = new Fitness();
        Fitness fitness02 = new Fitness();
        Membership[] gyms = new Membership[20];
        Membership[] pools = new Membership[20];
        Membership[] groupClasses = new Membership[20];
        gyms[0] = membership02;

        fitness01.add(Zone.POOL, membership01);
        fitness02.add(Zone.GYM, membership02);

        /*
        for (int i = 0; i < 19; i++){
            System.out.println(gyms[i]);
        }
        */

        fitness01.info();






    }
}
