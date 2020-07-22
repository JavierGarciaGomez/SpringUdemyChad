<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Customer form</title>
    <style>
        .error{color:darkred}
    </style>
</head>
<body>

<%--146--%>
<h1>Sections 15 Customer registration form</h1>
<i> Fill out the form. Asterisk (*) means required </i>
<form:form action="processCustomer" modelAttribute="customer">
    <br><br>
    First name: <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Free passes: <form:input path="freePasses"/>
    <form:errors path="freePasses" cssClass="error"/>
    <br><br>
    Postal Code: <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>
    <br><br>
    <input type="submit" value="Submit">

</form:form>


</body>
</html>
