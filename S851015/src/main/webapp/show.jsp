<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wqw
  Date: 2020/10/15
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${page.records}" var="dep">
        ${dep.depName}&nbsp;${emp.empName}<br>
    </c:forEach>
</body>
</html>
