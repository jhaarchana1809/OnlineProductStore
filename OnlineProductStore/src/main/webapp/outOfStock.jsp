<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid login process</title>
</head>
<body>
<%
String msg1=(String)request.getAttribute("msg");

%>
<%@include file="customerViewProduct.jsp" %>
<script type="text/javascript">
window.onload = function() {
    var msg = "<%= msg1 %>";
    if (msg) {
        alert(msg);
    }
};

</script>

</body>
</html>