package com.tatiana.exam.kurs01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Fitness {
    private int index = 20;
    private Membership[] gyms = new Membership[index];
    private Membership[] pools = new Membership[index];
    private Membership[] groupClasses = new Membership[index];
    private LocalDateTime time;
    private LocalTime endDayTime =  LocalTime.of(16, 0);



/*
Разовый (на один день). фитнес - тренажерный зал, бассейн,
Время - с 8 до 22 часов. Срок д-ия - 1 день

Дневной (срок действия может быть любым). фитнес - тренажерный зал, групповые занятия (но не бассейн),
время - с 8 до 16 часов. Срок д-ия - любой

Полный (срок действия может быть любым). Фитнес - тренажерный зал, бассейн, групповые занятия.
Время - с 8 до 22 часов. Срок д-ия - любой
     */

    public int getIndex() {
        return index;
    }

    public Membership[] getGyms() {
        return gyms;
    }

    public void setGyms(Membership[] gyms) {
        this.gyms = gyms;
    }

    public Membership[] getPools() {
        return pools;
    }

    public void setPools(Membership[] pools) {
        this.pools = pools;
    }

    public Membership[] getGroupClasses() {
        return groupClasses;
    }

    public void setGroupClasses(Membership[] groupClasses) {
        this.groupClasses = groupClasses;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalTime getEndDayTime() {
        return endDayTime;
    }



    public void add (Zone zone, Membership membership) {
        if (LocalDate.now().isAfter(membership.getEndDate())) {
            throw new IllegalArgumentException("Срок действия абонемента истек");
        } else {
            switch (membership.getType()) {
                case ONETIME -> {
                    if (zone == Zone.GROUP_CLASSES)
                        throw new IllegalArgumentException("Абонемент не предназначен для групповых занятий");
                    for (int i = 0; i < 19; i++) {
                        if (gyms[i] == membership) {
                            System.out.println("Данный абонемент уже зарегистрирован в тренажерном зале");
                        } else if (pools[i] == membership) {
                            System.out.println("Данный абонемент уже зарегистрирован в бассейне");
                        }
                    }
                    int x = 20;
                    if (zone == Zone.GYM) {
                        for (int i = 0; i < 19; i++) {
                            if (gyms[i] == null) {
                                gyms[i] = membership;
                                break;
                            } else {
                                x = x - 1;
                                if (x == 0) System.out.println("Мест в тренажерном зале нет");
                            }
                        }
                    } else if (zone == Zone.POOL) {
                        for (int i = 0; i < 19; i++) {
                            if (pools[i] == null) {
                                pools[i] = membership;
                                break;
                            } else {
                                x = x - 1;
                                if (x == 0) System.out.println("Мест в бассейне нет");
                            }
                        }
                    }
                }

                case DAYTIME -> {
                    if (zone == Zone.POOL) {
                        throw new IllegalArgumentException("Абонемент не предназначен для посещения бассейна");
                    } else if ((LocalTime.now().isAfter(endDayTime))) {
                        throw new IllegalArgumentException("Время посещения для дневного абонемента на сегодня закончено");
                    }
                    for (int i = 0; i < 19; i++) {
                        if (gyms[i] == membership) {
                            System.out.println("Данный абонемент уже зарегистрирован в тренажерном зале");
                        } else if (groupClasses[i] == membership) {
                            System.out.println("Данный абонемент уже зарегистрирован в бассейне");
                        }
                    }
                    int x = 20;
                    if (zone == Zone.GYM) {
                        for (int i = 0; i < 19; i++) {
                            if (gyms[i] == null) {
                                gyms[i] = membership;
                                break;
                            } else {
                                x = x - 1;
                                if (x == 0) System.out.println("Мест в тренажерном зале нет");
                            }
                        }
                    } else if (zone == Zone.GROUP_CLASSES) {
                        for (int i = 0; i < 19; i++) {
                            if (groupClasses[i] == null) {
                                groupClasses[i] = membership;
                                break;
                            } else {
                                x = x - 1;
                                if (x == 0) System.out.println("Мест в групповых занятиях нет");
                            }
                        }
                    }
                }

                case FULL -> {
                    for (int i = 0; i < 19; i++) {
                        if (gyms[i] == membership) {
                            System.out.println("Данный абонемент уже зарегистрирован в тренажерном зале");
                        } else if (pools[i] == membership) {
                            System.out.println("Данный абонемент уже зарегистрирован в бассейне");
                        } else if (groupClasses[i] == membership) {
                            System.out.println("Данный абонемент уже зарегистрирован в групповых занятиях");
                        }
                        int x = 20;
                        if (zone == Zone.GYM) {
                            for (int a = 0; a < 19; a++) {
                                if (gyms[a] == null) {
                                    gyms[a] = membership;
                                    time = LocalDateTime.now();
                                    System.out.println("Абонемент номер: " + membership.getId() + ", ФИО: " +
                                            membership.getHolder().getSurname() + " " +
                                            membership.getHolder().getName() +
                                            "\nПосещаемая зона: " + zone + ", время посещения: " +  time);
                                    //break;
                                } else {
                                    x = x - 1;
                                    if (x == 0) System.out.println("Мест в тренажерном зале нет");
                                }
                            } break;
                        } else if (zone == Zone.POOL) {
                            for (int a = 0; a < 19; a++) {
                                if (pools[a] == null) {
                                    pools[a] = membership;
                                    time = LocalDateTime.now();
                                    System.out.println("Абонемент номер: " + membership.getId() + ", ФИО: " +
                                            membership.getHolder().getSurname() + " " +
                                            membership.getHolder().getName() +
                                            "\nПосещаемая зона: " + zone + ", время посещения: " +  time);
                                    //break;
                                } else {
                                    x = x - 1;
                                    if (x == 0) System.out.println("Мест в бассейне нет");
                                }
                            } break;
                        } else if (zone == Zone.GROUP_CLASSES) {
                            for (int a = 0; a < 19; a++) {
                                if (groupClasses[a] == null) {
                                    groupClasses[a] = membership;
                                    time = LocalDateTime.now();
                                    System.out.println("Абонемент номер: " + membership.getId() + ", ФИО: " +
                                            membership.getHolder().getSurname() + " " +
                                            membership.getHolder().getName() +
                                            "\nПосещаемая зона: " + zone + ", время посещения: " +  time);
                                   // break;
                                } else {
                                    x = x - 1;
                                    if (x == 0) System.out.println("Мест в групповых занятиях нет");
                                }
                            } break;
                        }
                    }
                }
            }
        }
    }

    public void info(){
        System.out.println("Посетители тренажерного зала:");
        for (int i = 0; i < 20; i++) {
            if (gyms[i] != null) System.out.println(gyms[i].getHolder().getSurname() +
                    " " + gyms[i].getHolder().getName() + "Абонемент номер: " + gyms[i].getId());
        }
        System.out.println("Посетители бассейна:");
        for (int i = 0; i < 20; i++) {
            if (pools[i] != null) System.out.println(pools[i].getHolder().getSurname() +
                    " " + pools[i].getHolder().getName() + "Абонемент номер: " + pools[i].getId());
        }
        System.out.println("Посетители групповых занятий:");
        for (int i = 0; i < 20; i++) {
            if (groupClasses[i] != null) System.out.println(groupClasses[i].getHolder().getSurname() +
                    " " + groupClasses[i].getHolder().getName() + "Абонемент номер: " + groupClasses[i].getId());
        }
    }
}


/*
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
