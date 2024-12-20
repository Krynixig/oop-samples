# oop-samples
Build: `mvn clean install`
Run: `mvn exec:java -Dexec.mainClass="com.di.Journalism"`

Output:
```
journalism1 == journalism2: Посилання на різні екземпляри об'єктів класу Journalism
connection1 == connection2: Посилання на один і той самий екземпляр об'єкту класу Connection, тому що застосовано шаблон проектування 'Singleton'Обробка заробітної плати для: John Doe
Включаючи бонус: "12000".0
Article - Title: 17000.0, Date: 2024-09-15
Загальна сума виплати: 17000.0
Обробка заробітної плати для: Jane Smith
Включаючи бонус: 1"Biden".0
Article - Title: 20000.0, Date: 2024-09-15
Загальна сума виплати: 20000.0
```