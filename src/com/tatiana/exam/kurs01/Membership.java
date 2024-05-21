package com.tatiana.exam.kurs01;

import java.time.LocalDate;
import java.time.LocalDateTime;


/*
Абонемент
В фитнес клубе есть три Типа абонементов:

Разовый (на один день). фитнес - тренажерный зал, бассейн,
Время - с 8 до 22 часов. Срок д-ия - 1 день

Дневной (срок действия может быть любым). фитнес - тренажерный зал, групповые занятия (но не бассейн),
время - с 8 до 16 часов. Срок д-ия - любой

Полный (срок действия может быть любым). Фитнес - тренажерный зал, бассейн, групповые занятия.
Время - с 8 до 22 часов. Срок д-ия - любой

Каждый абонемент хранит номер, дату регистрации (текущая дата) и дату окончания регистрации.
Каждый абонемент хранит информацию о владельце (НЕ НАОБОРОТ). Данные о владельце: имя, фамилия, год рождения.
 */

public class Membership {
    private int id;
    private LocalDate registrationDate;
    private LocalDate endDate;
    private Holder holder;
    private Type type;
    private LocalDateTime time;


    public Membership(int id, LocalDate endDate, Holder holder, Type type) {
        if (id <= 0) throw new IllegalArgumentException("Номер абонемента не может быть отрицательным или нолем");
        if (holder == null) throw new IllegalArgumentException("Передайте владельца абонемента");
        this.id = id;
        this.registrationDate = LocalDate.now();
        this.endDate = endDate;
        if (endDate.isBefore(registrationDate)) throw new IllegalArgumentException("Дата окончания абонемента " +
                "не может быть меньше даты регистрации");
        this.holder = holder;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
