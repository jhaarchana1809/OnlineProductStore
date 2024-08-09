<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Added</title>
</head>
<body>

<%@include file="adminLogin.jsp" %>
<div class="container">

        <%
        String msg1 = (String)request.getAttribute("msg");
                %>
    </div>
    <script type="text/javascript">
window.onload = function() {
    var msg = "<%= msg1 %>";
    if (msg) {
        confirm(msg);
    }
};

</script>
    
</body>
</html>
