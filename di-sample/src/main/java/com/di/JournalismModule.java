package com.di;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class JournalismModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class)
            .annotatedWith(Names.named("JDBC URL"))
            .toInstance("jdbc:sqlite:target/journalism.db");
    }

    // Метод для надання списку працівників
    @Provides
    List<Person> provideEmployees() {
        List<Person> journalistList = new ArrayList<>();
        Journalist journalist1 = new Journalist("John Doe");
        journalist1.setBonus("12000");

        Journalist journalist2 = new Journalist("Jane Smith");
        journalist2.setBonus("Biden");

        journalistList.add(journalist1);
        journalistList.add(journalist2);
        
        return journalistList;
    }

    @Provides
    @Singleton
    Connection provideConnection(@Named("JDBC URL") String url) {
        try {
            Connection connection = DriverManager.getConnection(url);
            createTableIfNotExists(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create database connection", e);
        }
    }

    /**
     * Створює таблицю "articles" у базі даних, якщо вона ще не існує.
     * Таблиця містить такі колонки:
     * - title: значення типу REAL, яке не може бути null, що представляє суму виплати.
     * - pay_date: значення типу TEXT, яке не може бути null, що представляє дату виплати.
     *
     * @param connection з'єднання з базою даних, яке використовується для створення таблиці
     * @throws RuntimeException у разі виникнення помилки під час створення таблиці
     */
    private void createTableIfNotExists(Connection connection) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS articles (" +
                                "title TEXT NOT NULL, " +
                                "pay_date TEXT NOT NULL)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }
}