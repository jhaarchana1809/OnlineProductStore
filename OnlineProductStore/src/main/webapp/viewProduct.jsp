<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList, bean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Product</title>
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
		width: 80%;
		margin: 20px auto;
		background: white;
		padding: 20px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	}
	table {
		width: 100%;
		border-collapse: collapse;
		margin-top: 20px;
	}
	th, td {
		padding: 10px;
		border: 1px solid #ddd;
		text-align: left;
	}
	th {
		background-color: #f2f2f2;
	}
	.action-links a {
		margin: 10px;
		color: blue;
		text-decoration: none;
		cursor: pointer;
			}
	.action-links a:hover {
		text-decoration: underline;
		background: blue;
		color: white;
				
	}
</style>
</head>
<body>
	<nav>
		<h1>Welcome to our store</h1>
		<div class="links">
			<a href="product.html">Add Product</a>
			<a href="logout">Log out</a>
		</div>
	</nav>
	<div class="container">
		<table>
			<tr>
				<th>Product Code</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
				<th>Edit / Delete</th>
			</tr>
			<%
				ArrayList<ProductBean> productList = (ArrayList<ProductBean>) session.getAttribute("productList");	
				if (productList == null || productList.size() == 0) {
					out.println("<p>Product Not available...</p>");
				} else {
					Iterator<ProductBean> it = productList.iterator();
					while (it.hasNext()) {
						ProductBean pb = it.next();
						out.println("<tr><td>" + pb.getPcode() + "</td>"
							+ "<td>" + pb.getName() + "</td>"
							+ "<td>" + pb.getPrice() + "</td>"
							+ "<td>" + pb.getQty() + "</td>"
							+ "<td class='action-links'><a href='edit?code="+pb.getPcode()+"'>Edit</a><a href='delete?code="+pb.getPcode()+"'>Delete</a></td>"
							+ "</tr>");
											}
				}
			%>
		</table>
	</div>
</body>
</html>
