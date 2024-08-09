<%@page import="bean.ProductBean"%>
<%@page import="bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
<style>
body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
        height: 100vh;
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
    .main {
    background: white;
    padding: 40px 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    text-align: center;
    max-width: 600px;
    width: 100%;
    margin: 20px auto;
}

.main h1 {
    color: #333;
    margin-bottom: 30px;
    font-size: 2.5em;
}

form {
    display: flex;
    flex-direction: column;
    gap: 20px;
}

form div {
    display: flex;
    flex-direction: column;
    text-align: left;
}

form label {
    margin-bottom: 5px;
    font-size: 1.2em;
    color: #555;
}

input[type="number"],
input[type="submit"] {
    padding: 10px;
    font-size: 1em;
    border: 1px solid #ccc;
    border-radius: 5px;
}

input[type="submit"] {
    background-color: #007BFF;
    color: white;
    cursor: pointer;
    transition: background-color 0.3s, transform 0.3s;
}

input[type="submit"]:hover {
    background-color: #0056b3;
    transform: scale(1.05);
}

</style>
</head>
<body>
<nav>
    <h1>Welcome to our store</h1>
    <div class="links">
        <a href="product.html">Add Product</a>
        <a href="viewProduct">View Product</a> 
        <a href="logout">Log out</a>
    </div>
</nav>
<%
    AdminBean ab = (AdminBean) session.getAttribute("abean");
    ProductBean pb = (ProductBean) session.getAttribute("pb");
    %>
<div class="main">
    <h1>Update Product </h1>
    <h3>Product Name :<%=pb.getName() %> </h3>
    
    <form action="update" method="post" onsubmit="return validateForm()">
        <input type="hidden" name="code" value="<%= pb.getPcode() %>">
        <div>
            <label for="price">Product Price:</label>
            <input type="number" id="price" name="price" value="<%= pb.getPrice() %>" required>
        </div>
        <div>
            <label for="quantity">Product Quantity:</label>
            <input type="number" id="quantity" name="quantity" value="<%= pb.getQty() %>" required>
        </div>
        <input type="submit" value="Update Product">
    </form>
</div>
<script type="text/javascript">
function validateForm() {
    var price = document.getElementById("price").value;
    var quantity = document.getElementById("quantity").value;
    if (price <= 0) {
        alert("Price must be a positive number.");
        return false;
    }
    if (quantity <= 0) {
        alert("Quantity must be a positive number.");
        return false;
    }
    return true;
}
</script>
</body>
</html>
