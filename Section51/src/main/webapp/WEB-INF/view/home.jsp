<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: javie
  Date: 02/08/2020
  Time: 2:49
  To change this template use File | Settings | File Templates.
--%>
<%--382, 406--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
    <h2>Home page</h2>
    Welcome

    <%--406    Add a logout button--%>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout"/>
    </form:form>

</body>
</html>
