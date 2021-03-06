<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: javie
  Date: 02/08/2020
  Time: 2:49
  To change this template use File | Settings | File Templates.
--%>
<%--382, 406, 412, 424 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
<h2>Home page</h2>
Welcome

<hr>
<%--412 Display user name and role    --%>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role: <security:authentication property="principal.authorities"/>
</p>

<%--424. Add a security in order that this is shown just for managers --%>
<security:authorize access="hasRole('MANAGER')">
    <%--416. Add a limk that points to /leaders --%>
    <p><a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a></p>
</security:authorize>
<%--424. Add a security in order that this is shown just for admin --%>
<security:authorize access="hasRole('ADMIN')">

    <%--419. Add a limk that points to /systems --%>
    <p><a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a></p>
</security:authorize>
<%--406    Add a logout button--%>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>

</body>
</html>
