<%--
  Created by IntelliJ IDEA.
  User: javie
  Date: 22/07/2020
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>




<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" type="text/css"

          href="${pageContext.request.contextPath}/resources/css/test.css">
</head>
<body>

<h1>Hello World of Spring!</h1>

<br><br>
Passed as: param.studentName
Student name: ${param.studentName}<br><br>
<br><br>
<%--116 --%>
116. Passed with the HelloWorldController and a uppercase: ${message} <br><br>
120. Getting the name with HttpRequest: ${firstName} <br><br>
120. Getting the lastname with HttpRequest: ${lastName} <br><br>


</body>

</html>




