<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book - DataNest</title>
    <style>
        body { font-family: 'Inter', sans-serif; background-color: #f4f7f6; display: flex; justify-content: center; padding: 50px; }
        .form-container { background: white; padding: 40px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); width: 400px; }
        h2 { color: #2c3e50; margin-bottom: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="number"], select { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        .btn { width: 100%; padding: 10px; background-color: #3498db; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 1em; }
        .btn:hover { background-color: #2980b9; }
        .error { color: #e74c3c; margin-bottom: 15px; }
        .back-link { display: block; margin-top: 15px; text-align: center; color: #7f8c8d; text-decoration: none; }
        .back-link:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add New Book</h2>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <form action="/saveBook" method="post">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required />
            </div>
            <div class="form-group">
                <label for="publishedYear">Published Year:</label>
                <input type="number" id="publishedYear" name="publishedYear" required />
            </div>
            <div class="form-group">
                <label for="author">Author:</label>
                <select id="author" name="author.id" required>
                    <c:forEach var="auth" items="${authors}">
                        <option value="${auth.id}">${auth.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn">Save Book</button>
        </form>
        <a href="/" class="back-link">Back to List</a>
    </div>
</body>
</html>
