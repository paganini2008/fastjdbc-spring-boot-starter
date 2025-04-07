# fastjdbc-spring-boot-starter

`fastjdbc-spring-boot-starter` is a lightweight wrapper around Spring's `NamedParameterJdbcTemplate`.  
It enables developers to define SQL queries using annotations directly within interfaces, eliminating the need for hardcoded strings and making your code more elegant and maintainable.

## ✨ Features

- Built on Spring Boot and NamedParameterJdbcTemplate
- Define SQL using annotations—no more XML or hardcoded queries
- Interface-based design for clarity and ease of maintenance
- Supports parameter binding, pagination, custom return types, and more
- Plug-and-play with zero configuration

## 🚀 Quick Start

### 1. Add Dependency

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>fastjdbc-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 2. Define Interface with SQL Annotations

```java
@JdbcRepository
public interface UserRepository {

    @Select("SELECT * FROM users WHERE id = :id")
    User findById(@Param("id") Long id);

    @Update("UPDATE users SET name = :name WHERE id = :id")
    int updateName(@Param("id") Long id, @Param("name") String name);
}
```

### 3. Enable Scanning

```java
@SpringBootApplication
@JdbcRepositoryScan("com.example.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## 📄 Annotations

| Annotation      | Description                           |
|-----------------|---------------------------------------|
| `@JdbcRepository` | Marks an interface as a JDBC repository |
| `@Select`         | Defines a SELECT query                 |
| `@Update`         | Defines an UPDATE query                |
| `@Insert`         | Defines an INSERT query                |
| `@Delete`         | Defines a DELETE query                |
| `@Param`          | Binds method parameters to SQL params |

## 🧪 Tests & Examples

Check the `examples` directory for usage scenarios and test cases.

## 📦 Build & Publish

Build using Maven:

```bash
mvn clean install
```

## 📃 License

This project is open-sourced under the MIT License. Contributions and feedback are welcome!

---

> Project URL: [https://github.com/your-username/fastjdbc-spring-boot-starter](https://github.com/your-username/fastjdbc-spring-boot-starter)
