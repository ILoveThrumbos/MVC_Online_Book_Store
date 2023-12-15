<%-- 
    Document   : error
    Created on : Nov 30, 2022, 10:14:43 AM
    Author     : dalevanh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<html>
<body bgcolor="white">

<%  
    String msg = (String) request.getAttribute("result");
    out.print("<h3>" + msg); 
    session.invalidate();
%>

</body>
</html>
