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
    <title>Student Confirmation</title>
</head>
<body>
<%--129--%>
    <h1>Student Confirmation</h1>
The student is confirmed:
<br>
First name: ${student.stFirstName}
<br>
Last name: ${student.stLastName}
<br>
Country: ${student.country}
<br>
Loaded country: ${student.countryLoaded}
<br>
Sex: ${student.sex}
<br>
Operating System:
<ul>
    <c:forEach var="temp" items="${student.operatingSystem}">
        <li>${temp}</li>
    </c:forEach>
</ul>
</body>
</html>
