# Week 3 - Hands-on 4
# Difference between JPA, Hibernate and Spring Data JPA

## Objective

Understand the relationship between JPA, Hibernate, and Spring Data JPA, and learn why Spring Data JPA is widely used in enterprise Java applications.

---

# What is JPA?

**JPA (Java Persistence API)** is a Java Specification (JSR-338) that defines standards for persisting Java objects into relational databases.

### Key Points

- It is only a specification.
- It does not provide any implementation.
- It defines annotations like:
    - `@Entity`
    - `@Table`
    - `@Id`
    - `@Column`
- ORM frameworks such as Hibernate implement JPA.

---

# What is Hibernate?

Hibernate is an **Object Relational Mapping (ORM)** framework that implements the JPA specification.

It converts Java Objects into Database Tables and vice versa.

### Responsibilities

- Implements JPA
- Generates SQL queries
- Manages Sessions
- Handles Transactions
- Maps Java Objects to Database Tables

Example:

```java
Session session = factory.openSession();

Transaction tx = session.beginTransaction();

session.save(employee);

tx.commit();

session.close();
```

Hibernate requires developers to manually manage sessions and transactions.

---

# What is Spring Data JPA?

Spring Data JPA is a Spring Framework module built on top of JPA implementations like Hibernate.

It significantly reduces boilerplate code by providing ready-made repository interfaces.

Example Repository

```java
public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {

}
```

Example Service

```java
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```

No Session or Transaction management is required because Spring handles it automatically.

---

# Comparison

| Feature | JPA | Hibernate | Spring Data JPA |
|----------|-----|-----------|-----------------|
| Type | Specification | ORM Framework | Spring Module |
| Implementation | ❌ No | ✅ Yes | ❌ No |
| Developed By | Oracle | Hibernate Team (Red Hat) | Spring Team |
| Database Operations | Defines API | Implements API | Uses Hibernate Internally |
| Boilerplate Code | High | Medium | Very Low |
| Transaction Management | No | Manual | Automatic |
| Repository Support | No | No | Yes (`JpaRepository`) |
| Ease of Use | Medium | Easy | Very Easy |

---

# Architecture

```
Application
      │
      ▼
Spring Data JPA
      │
      ▼
Hibernate
      │
      ▼
JPA Specification
      │
      ▼
MySQL Database
```

---

# Advantages of Spring Data JPA

- Less Boilerplate Code
- Built-in CRUD Operations
- Automatic Transaction Management
- Pagination Support
- Sorting Support
- Query Methods
- Custom JPQL Queries
- Native SQL Queries
- Easy Integration with Spring Boot

---

# Advantages of Hibernate

- Powerful ORM Framework
- Database Independent
- Automatic SQL Generation
- Caching Support
- Lazy Loading
- Association Mapping

---

# Advantages of JPA

- Standard Specification
- Vendor Independent
- Easy Migration between ORM Providers
- Portable Code

---

# Interview Questions

### Is JPA a Framework?

No.

JPA is only a specification.

---

### Who implements JPA?

Popular implementations include:

- Hibernate
- EclipseLink
- OpenJPA

---

### Does Spring Data JPA replace Hibernate?

No.

Spring Data JPA internally uses Hibernate (or any other JPA implementation).

---

### Which one should we use?

In modern Spring Boot applications, the recommended stack is:

```
Spring Boot
        ↓
Spring Data JPA
        ↓
Hibernate
        ↓
MySQL
```

This combination provides minimal code, automatic transaction management, and high productivity.

---

# Conclusion

- **JPA** defines the persistence standard.
- **Hibernate** implements the JPA specification.
- **Spring Data JPA** simplifies Hibernate usage by reducing boilerplate code and providing repository abstractions.

This architecture is widely used in enterprise Java applications.