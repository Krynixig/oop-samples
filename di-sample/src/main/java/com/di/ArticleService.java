package com.di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.inject.Inject;

/**
 * Клас PaymentService відповідає за збереження об'єктів Article у базі даних.
 * Використовує ін'єкцію залежностей для отримання з'єднання з базою даних.
 */
/**
 * Сервіс для обробки платежів.
 */
public class ArticleService {
    private final Connection connection;

    /**
     * Конструктор з впровадженням залежності від драйвера бази даних.
     *
     * @param connection з'єднання з базою даних
     */
    @Inject
    public ArticleService(Connection connection) {
        this.connection = connection;
    }

    protected Connection getConnection() {
        return connection;
    }

    /**
     * Метод для збереження об'єкта Article в базі даних.
     * 
     * Цей метод приймає об'єкт Article, створює SQL-запит для вставки даних
     * про зарплату в базу даних і виконує цей запит.
     *
     * @param article об'єкт Article, який містить дані про зарплату
     * @throws RuntimeException якщо виникає помилка під час збереження даних
     */
    public void saveArticle(Article article) {
        String sql = "INSERT INTO articles (title, pay_date) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getPayDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save article", e);
        }
    }
}