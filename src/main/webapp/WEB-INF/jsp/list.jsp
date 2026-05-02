<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Management - DataNest</title>
    <style>
        body { font-family: 'Inter', sans-serif; background-color: #f4f7f6; color: #333; margin: 0; padding: 20px; }
        h1, h2 { color: #2c3e50; }
        .container { max-width: 1000px; margin: auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; margin-bottom: 40px; }
        th, td { padding: 12px 15px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #3498db; color: white; }
        tr:hover { background-color: #f1f1f1; }
        .btn { display: inline-block; padding: 10px 20px; text-decoration: none; color: white; background-color: #27ae60; border-radius: 5px; transition: background 0.3s; }
        .btn:hover { background-color: #2ecc71; }
        .btn-edit { background-color: #f39c12; padding: 5px 10px; font-size: 0.9em; }
        .btn-edit:hover { background-color: #f1c40f; }
        .header-actions { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }
    </style>
</head>
<body>
<div class="container">
    <h1>Library Management System</h1>
    
    <div class="header-actions">
        <h2>Authors</h2>
        <a href="/addAuthor" class="btn">Add Author</a>
    </div>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="author" items="${authors}">
                <tr>
                    <td>${author.id}</td>
                    <td>${author.name}</td>
                    <td>${author.country}</td>
                    <td><a href="/updateAuthor/${author.id}" class="btn btn-edit">Edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="header-actions">
        <h2>Books</h2>
        <a href="/addBook" class="btn">Add Book</a>
    </div>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Published Year</th>
                <th>Author</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.publishedYear}</td>
                    <td>${book.author.name}</td>
                    <td><a href="/updateBook/${book.id}" class="btn btn-edit">Edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
