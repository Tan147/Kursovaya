package com.tatiana.exam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Fitness {
    private Membership[] gims;
    private Membership[] pools;
    private Membership[] groupClasses;
    private int index;
    private LocalTime startTime =  LocalTime.of(8, 0);
    private LocalTime endTime =  LocalTime.of(22, 0);
    private LocalTime endDayTime =  LocalTime.of(16, 0);


    public Fitness() {
        Membership[] gims = new Membership[20];
        Membership[] pools = new Membership[20];
        Membership[] groupClasses = new Membership[20];
    }

    /*
Разовый (на один день). фитнес - тренажерный зал, бассейн,
Время - с 8 до 22 часов. Срок д-ия - 1 день

Дневной (срок действия может быть любым). фитнес - тренажерный зал, групповые занятия (но не бассейн),
время - с 8 до 16 часов. Срок д-ия - любой

Полный (срок действия может быть любым). Фитнес - тренажерный зал, бассейн, групповые занятия.
Время - с 8 до 22 часов. Срок д-ия - любой

1. Метод принимает на вход желаемую зону (тренажерный зал или бассейн, или групповые занятия) и абонемент.
2. Перед добавлением абонемента в соответствующий массив необходимо проверить:
-можно ли по данному абонементу пройти в желаемую зону и есть ли в ней свободные места
-не просрочен ли абонемент
-не зарегистрирован ли абонемент в одной из зон
3. Если абонемент проходит проверку п.2, то он добавляется в выбранную зону, в противном случае
в консоль необходимо вывести причину отказа
     */



    public void add (Zone zone, Membership membership){
        if (LocalDate.now().isAfter(membership.getEndDate())) {
            throw new IllegalArgumentException("Срок действия абонемента истек")
        } else {
            switch (membership.getType()){
                case Type.ONETIME -> {
                    if (zone == Zone.GROUP_CLASSES) {
                        throw new IllegalArgumentException("Абонемент не предназначен для групповых занятий");
                    } else if ((LocalTime.now().isAfter(endDayTime))) {
                        throw new IllegalArgumentException("Время посещения для дневного абонемента на сегодня закончено");
                    } else if (membership){

                    }
                }
                case Type.DAYTIME -> {
                    if (zone == Zone.POOL) {
                        throw new IllegalArgumentException("Абонемент не предназначен для посещения бассейна");
                    } else {
                        
                    }
                }
                case Type.FULL ->
            
            }
        }
    }


}
/*
if (membership.getType() == Type.ONETIME && zone == Zone.GROUP_CLASSES)
            throw new IllegalArgumentException("Абонемент не предназначен для групповых занятий");

                && (zone == Zone.GYM || zone == Zone.POOL)) &&
                (LocalDate.now() <= Membership.getEndDate()) && ){


 Фитнес содержит информацию об абонементах, которые:

1. зарегистрированы в тренажерном зале (массив абонементов);
2. зарегистрированы в бассейне (массив абонементов);
3. зарегистрированы на групповых занятиях (массив абонементов).
 В каждой зоне (бассейн, тренажерный зал, групповые занятия) одновременно может быть зарегистрировано 20 абонементов.

 У Фитнеса должен быть реализован функционал по заполнению массивов абонементов дефолтными значениями.

 У Фитнеса должен быть реализован функционал добавления абонемента в одну из зон:

1. Метод принимает на вход желаемую зону (тренажерный зал или бассейн, или групповые занятия) и абонемент.
2. Перед добавлением абонемента в соответствующий массив необходимо проверить:
-можно ли по данному абонементу пройти в желаемую зону и есть ли в ней свободные места
-не просрочен ли абонемент
-не зарегистрирован ли абонемент в одной из зон
3. Если абонемент проходит проверку п.2, то он добавляется в выбранную зону, в противном случае
в консоль необходимо вывести причину отказа


 Реализовать возможность вывода информации о текущих абонементах: сначала посетителях тренажерного зала,
 потом бассейна, потом групповых занятий.

 Реализовать возможность выводить информацию в консоль каждый раз, когда абонемент регистрируется в одной из зон
  ( добавляется в массив):
1. Фамилия Имя Посещаемая зона (бассейн/тренажерный зал/групповые занятия)
2. Дата и время посещения

 */
