<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: javie
  Date: 22/07/2020
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Hello World Input Form</title>
</head>
<body>

<%--    <form action="processForm" method="get">--%>
<%--116--%>

<form action="processFormVersionTwo" method="get">
    <h1>Sections 12 and 13</h1>
        <input type="text" name="studentName"
        placeholder="What's your name?"/><br><br>
        <input type="text" name="lastName"
           placeholder="What's your last name?"/><br><br>
    <br><br>
    <input type="submit"/>

</form>
<br><br>
<h1>Sections 14 128</h1>
<form:form action="processFormTags" modelAttribute="student">
    <br><br>
    First name: <form:input path="stFirstName"/>
    <br><br>
    Last name: <form:input path="stLastName"/>
    <br><br>
    Country:
    <form:select path="country">
        <form:option value="Mexico" label="Mexico"/>
        <form:option value="Spain" label="Spain"/>
        <form:option value="Venezuela" label="Venezuela"/>
    </form:select>
    <br><br>
    Country (loaded from the class):
    <form:select path="countryLoaded">
        <form:options items="${student.countryOptions}"/>
    </form:select>
    <br><br>
    <input type="submit" value="Submit">
</form:form>


</body>
</html>
