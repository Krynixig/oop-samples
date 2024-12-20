package com.di;

// Клас Employee, що реалізує Person і BonusEligible
public class Journalist extends Person implements BonusEligible {
    private String bonus;

    // Конструктори
    public Journalist() {
        super();
        this.bonus = DEFAULT_BONUS; // Встановити бонус за замовчуванням
    }

    public Journalist(String name) {
        super(name);
        this.bonus = DEFAULT_BONUS; // Встановити бонус за замовчуванням
    }

    public Journalist(String name, String bonus) {
        super(name);
        setBonus(bonus); // Встановити бонус через метод-сетер
    }

    // Реалізація методів інтерфейсу BonusEligible
    @Override
    public String getBonus() {
        return bonus;
    }

    @Override
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    @Override
    public void displayInfo() {
        System.out.println(getFullDetails() + ", Бонус: " + getBonus());
    }
}