# DataNest - Spring Boot Library Management Application

## 1. Approach & Entity Relationship Design

### Entities Chosen
We have chosen a typical **Library Domain** representing two main entities: `Author` and `Book`.

### Relationship Design
- The relationship is defined as **One-To-Many** from the Author's perspective. One `Author` can write multiple `Book`s.
- From the Book's perspective, it is a **Many-To-One** relationship, where multiple `Book`s belong to a single `Author`.
- **JPA Annotations**: We used `@Entity` for mapping classes to DB tables, `@Id` and `@GeneratedValue` for primary keys, `@OneToMany` in the `Author` class, and `@ManyToOne` along with `@JoinColumn` in the `Book` class to enforce the foreign key constraint. We also included cascading (`CascadeType.ALL`) to easily manage related entities.

## 2. Implementation Details

- **Database Population**: We configured an H2 embedded, in-memory database using `application.properties`. We used a `CommandLineRunner` interface (in `DataLoader.java`) to inject our repositories and pre-populate the tables with 10 rows for each entity if the database is empty.
- **Create Operation**: Handled by adding `add-author.jsp` and `add-book.jsp` files. The user inputs data into forms. Submissions hit `@PostMapping` methods in the `LibraryController.java`. Exceptions (like `DataIntegrityViolationException`) are caught and handled gracefully in the view.
- **Read Operation**: Implemented within `list.jsp`, which fetches all authors and books, using an `inner join` query `SELECT b FROM Book b JOIN b.author a` inside `BookRepository.java` to fulfill the custom query requirement.
- **Update Operation**: Similar to Create, we pass the existing entity details mapped via an ID from the URI to `update-author.jsp` or `update-book.jsp`, and re-save the details via the `LibraryService.java`.

*Note: Screenshots can be captured by running the application using `mvn spring-boot:run` and accessing `http://localhost:8080/`*

## 3. Challenges Faced & Solutions

1. **JSP Configuration with Spring Boot**: Spring Boot favors Thymeleaf over JSP. To use JSP smoothly, we had to carefully specify dependencies (`tomcat-embed-jasper` and JSTL) and adjust the `application.properties` to map `/WEB-INF/jsp/` views.
2. **Entity Lazy Initialization & Forms**: In `update` scenarios, detaching and attaching entities with relations caused nested object instantiation issues. We resolved this by carefully querying the database inside the controller before sending standard attributes to the view logic.
3. **Exception Handling for Constraints**: Handling potential uniqueness constraints meant that direct saves could throw 500 errors to the user. We solved this by using try-catch blocks over `DataIntegrityViolationException` to surface a clean alert to the user.

## 4. GitHub URL
The project is maintained on Github at: [https://github.com/Monika-Bhardwaj/DataNest](https://github.com/Monika-Bhardwaj/DataNest)
