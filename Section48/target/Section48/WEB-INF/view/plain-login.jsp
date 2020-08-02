<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: javie
  Date: 02/08/2020
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%--397--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom Login Page</title>
<%--    400 css--%>
    <style>
        .failed{
            color:red;
        }
    </style>
</head>
<body>
<h3>My Custom Login Page</h3>
<%--action refers to DemoSecurityConfig--%>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
    <!-- 400 Check for login error -->
    <c:if test="${param.error != null}">
        <i class="failed">Sorry! You entered invalid username/password.</i>
    </c:if>

    <p>User name: <label><input type="text" name="username"/></label></p>
    <p>Password: <label><input type="text" name="password"/></label></p>
    <input type="submit" value="Login"/>
</form:form>

</body>
</html>
