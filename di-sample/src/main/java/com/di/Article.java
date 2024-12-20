package com.di;

// Клас Article
class Article {
    private String title;
    private String payDate;

    // Конструктор
    public Article(String title, String payDate) {
        this.title = title;
        this.payDate = payDate;
    }

    // Геттери
    public String getTitle() {
        return title;
    }

    public String getPayDate() {
        return payDate;
    }

    // Метод для відображення деталей зарплати
    public void displayArticleInfo() {
        System.out.println("Article - Title: " + title + ", Date: " + payDate);
    }
}