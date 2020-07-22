<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: javie
  Date: 22/07/2020
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
<%--146--%>
    <h1>Customer Confirmation</h1>
The customer is confirmed:<br>
First name: ${customer.firstName}<br>
Last name: ${customer.lastName}<br>
Free passess: ${customer.freePasses}
Postal Code: ${customer.postalCode}
<br>
</body>
</html>
