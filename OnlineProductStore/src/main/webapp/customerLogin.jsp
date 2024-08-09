<%@page import="bean.CustomerBean"%>
<%@page import="bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
<style>
body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background: linear-gradient(135deg, #ff7e5f, #feb47b);
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
}

.main {
    background: white;
    padding: 40px 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    text-align: center;
    max-width: 600px;
    width: 100%;
}

h1 {
    color: #333;
    margin-bottom: 30px;
    font-size: 2.5em;
}

.links {
    display: flex;
    justify-content: center;
    gap: 20px;
    margin-bottom: 30px;
}

.links a {
    text-decoration: none;
    color: white;
    background-color: #007BFF;
    padding: 15px 30px;
    border-radius: 5px;
    transition: background-color 0.3s, transform 0.3s;
    font-size: 1.2em;
}

.links a:hover {
    background-color: #0056b3;
    transform: scale(1.05);
}


</style>
</head>
<body>
	<div class="main">
		<!-- <h1>Welcome to our store</h1> -->
			<%
		CustomerBean ab = (CustomerBean) session.getAttribute("cbean");
		String msg = (String) request.getAttribute("msg");
		%>
		<h1>
			Welcome
			<%=ab.getfName()%></h1>
		
		<div class="links">
			
			 <a href="customerViewProduct">View Product</a> 
				<a href="customerlogout">Log out</a>
		</div>
	
		</div>
<script type="text/javascript">
window.onload = function() {
    var msg = "<%= msg %>";
    if (msg) {
        alert(msg);
    }
};

</script>
</body>
</html>
