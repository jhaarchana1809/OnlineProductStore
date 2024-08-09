<%@page import="bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Product</title>
<link rel="stylesheet" href="home.css">
<style>
	
	 body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction:column;
       /* justify-content: center;
        align-items: center;*/
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
    
    .container {
        background: white;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
       /* width: 50%;*/
        max-width: 600px;
        text-align: left;
		margin:10px auto;        
    }
    h1 {
        margin-bottom: 5px;
        color: #333;
        text-align: center;
    }
    form {
        display: flex;
        flex-direction: column;
        gap: 15px;
    }
    label {
        font-size: 1.1em;
        color: #555;
        margin-bottom: 5px;
        text-align: left;
    }
    input[type="text"],
    input[type="number"],
    input[type="submit"] {
        padding: 10px;
        font-size: 1em;
        outline:0;
        border:0;
        border-radius: 5px;
        width: 50%;
        box-sizing: border-box;
    }
    .input-group {
        display: flex;
        align-items: center;
        gap: 5px;
    }
    button {
        padding: 10px;
        font-size: 1.2em;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #007BFF;
        color: white;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.3s;
    }
    .input-group button:hover {
        background-color: #0056b3;
        transform: scale(1.05);
    }
    input[type="submit"] {
        background-color: #28a745;
        color: white;
        cursor: pointer;
        font-size: 1.2em;
        transition: background-color 0.3s, transform 0.3s;
    }
    #totalPrice
    {
    width: 45%
    }
    #buyerName
    {
    padding: 10px;
        font-size: 1em;
        outline:0;
        border:0;
        border-radius: 5px;
        width: 50%;
        box-sizing: border-box;
        border:1px solid grey;
    }
    #quantity{
    width:100px;
    padding:10px;
    text-align:center;
    border:1px solid white;
    }
    input[type="submit"]:hover {
        background-color: #218838;
        transform: scale(1.05);
    }
	
	</style>
</head>
<body>
<%
ProductBean pb=(ProductBean)session.getAttribute("pb");

%>
<nav>
		<h1>Welcome to our store</h1>
		<div class="links">
		<a href="customerViewProduct">View Product</a> 
			<a href="customerlogout">Log out</a>
		</div>
	</nav>

	<div class="container">
		<h1>Buy Product</h1>
		<form id="buyForm" action="confirmPurchase" method="post" onsubmit="return validateForm()">
			<div>
				<label for="productCode">Product Code:</label>
				<input type="text" id="productCode" name="productCode" required readonly value="<%= pb.getPcode() %>">
			</div>
			<div>
				<label for="productCode">Product Name:</label>
				<input type="text" id="productCode" name="productCode" required readonly value="<%= pb.getName() %>">
			</div>
			<div>
				<label for="productPrice">Product Price:</label>
				<input type="number" id="productPrice" name="productPrice" required readonly value="<%= pb.getPrice() %>">
			</div>
			<div class="input-group">
				<label for="quantity">Quantity:</label>
				<button type="button" onclick="decrementQuantity()">-</button>
				<input type="number" id="quantity" name="quantity" min="1" required value="1">
				<button type="button" onclick="incrementQuantity()">+</button>
			</div>	
			<div>
              <button type="button" onclick="updateTotalPrice()">Total Price = </button>
                <input type="number" id="totalPrice" name="totalPrice" readonly>
            </div>	
				<div>
				<label for="buyerName">Your Name:</label>
				<input type="text" id="buyerName" name="buyerName" required>
			</div>
			<input type="submit" value="Buy Now">
		</form>
	</div>
	<script type="text/javascript">
		function validateForm() {
			var quantity = document.getElementById("quantity").value;
			var buyerName = document.getElementById("buyerName").value;
			if (quantity <= 0) {
				alert("Quantity must be a positive number.");
				return false;
			}
			if (buyerName.trim() === "") {
				alert("Buyer name must be filled out.");
				return false;
			}
			return true;
		}
		
		function incrementQuantity() {
			var quantityInput = document.getElementById("quantity");
			var currentValue = parseInt(quantityInput.value);
			quantityInput.value = currentValue + 1;
		}

		function decrementQuantity() {
			var quantityInput = document.getElementById("quantity");
			var currentValue = parseInt(quantityInput.value);
			if (currentValue > 1) {
				quantityInput.value = currentValue - 1;
			}
		}
		
		
		 function updateTotalPrice() {
	            var quantity = parseInt(document.getElementById("quantity").value);
	            var price = parseFloat(document.getElementById("productPrice").value);
	            var totalPrice = document.getElementById("totalPrice");

	            totalPrice = quantity * price;
	            document.getElementById("totalPrice").value = totalPrice.toFixed(2);
		        }

	        // Initialize total price on page load
	        document.addEventListener('DOMContentLoaded', function() {
	            updateTotalPrice();
	        });
	</script>
</body>
</html>
