<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Author - DataNest</title>
    <style>
        body { font-family: 'Inter', sans-serif; background-color: #f4f7f6; display: flex; justify-content: center; padding: 50px; }
        .form-container { background: white; padding: 40px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); width: 400px; }
        h2 { color: #2c3e50; margin-bottom: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"] { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        .btn { width: 100%; padding: 10px; background-color: #f39c12; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 1em; }
        .btn:hover { background-color: #e67e22; }
        .error { color: #e74c3c; margin-bottom: 15px; }
        .back-link { display: block; margin-top: 15px; text-align: center; color: #7f8c8d; text-decoration: none; }
        .back-link:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Update Author</h2>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <form action="/updateAuthor" method="post">
            <input type="hidden" name="id" value="${author.id}" />
            <div class="form-group">
                <label for="name">Author Name:</label>
                <input type="text" id="name" name="name" value="${author.name}" required />
            </div>
            <div class="form-group">
                <label for="country">Country:</label>
                <input type="text" id="country" name="country" value="${author.country}" required />
            </div>
            <button type="submit" class="btn">Update Author</button>
        </form>
        <a href="/" class="back-link">Back to List</a>
    </div>
</body>
</html>
