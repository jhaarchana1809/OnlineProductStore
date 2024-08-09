<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
     nav {
        background-color: #4CAF50;
        padding: 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    nav h1 {
        color: white;
        margin: 0;
    }
    nav .links {
        display: flex;
        gap: 10px;
    }
    nav a {
        display: inline-block;
        padding: 10px 20px;
        text-decoration: none;
        color: #4CAF50;
        background-color: white;
        border-radius: 5px;
        transition: background-color 0.3s, color 0.3s;
    }
    nav a:hover {
        background-color: #45a049;
        color: white;
    }
    
    .container {
        padding: 2em;
        background-color: #fff;
        margin: 2em auto;
        width: 50%;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .details p {
        margin: 0.5em 0;
    }
</style>
</head>
<body>
<%
int qty=(Integer)request.getAttribute("qty");
String name=(String)session.getAttribute("cname");
String pname=(String)request.getAttribute("pName");
Double price=(Double)request.getAttribute("price");
Double totalPrice=qty*price;
%>
<nav>
    <h1>Welcome to our store</h1>
    <div class="links">
        <a href="customerViewProduct">View Product</a> 
        <a href="customerlogout">Log out</a>
    </div>
</nav>
<div class="container">
    <h4><%=name %> your order confirmed!!!</h4>
    <div class="details">
        <p>Product Name : <%=pname %></p>
        <p>Product Quantity : <%=qty %></p>
        <p>Total Payable amount : <%=totalPrice %></p>    
    </div>
</div>
</body>
</html>
