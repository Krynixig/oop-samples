package com.di;

import java.sql.Connection;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

// Клас Journalism
public class Journalism {
    private List<Person> journalists; // Агрегація: Journalism використовує список Person
    private Article article;      // Композиція: Journalism володіє Article

    private ArticleService articleService;

    @Inject
    public void setPaymentService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Inject
    public void setEmployees(List<Person> journalists) {
        this.journalists = journalists;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new JournalismModule());

        // Створення екземплярів Journalism (не Singleton)
        Journalism journalism1 = injector.getInstance(Journalism.class);
        Journalism journalism2 = injector.getInstance(Journalism.class);

        // Перевірка екземплярів Journalism
        System.out.println("journalism1 == journalism2: " + 
            ((journalism1 == journalism2) ? 
            "Посилання на один і той самий екземпляр об'єкту класу Journalism, тому що застосовано шаблон проектування 'Singleton'" : 
            "Посилання на різні екземпляри об'єктів класу Journalism"));

        // Отримання екземпляра Connection
        Connection connection1 = injector.getInstance(Connection.class);
        Connection connection2 = injector.getInstance(Connection.class);

        // Перевірка екземплярів з'єднання
        System.out.println("connection1 == connection2: " + 
            ((connection1 == connection2) ? 
            "Посилання на один і той самий екземпляр об'єкту класу Connection, тому що застосовано шаблон проектування 'Singleton'" : 
            "Посилання на різні екземпляри об'єктів класу Connection"));

        // Обробка заробітної плати для кожного працівника
        journalism1.processJournalism("Biden");
    }

    void processJournalism(String articleName) {
        for (Person journalist : journalists) {
            System.out.println("Обробка заробітної плати для: " + journalist.getName());

            // Створення платіжної відомості для кожного працівника
            article = new Article(articleName, "2024-09-15");
            article.displayArticleInfo();

            articleService.saveArticle(article);

            System.out.println("Загальна сума виплати: " + articleName);
            // Додаткова логіка обробки заробітної плати
        }
    }
}