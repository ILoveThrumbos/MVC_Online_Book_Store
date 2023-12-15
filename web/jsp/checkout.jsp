<%-- 
    Document   : checkout
    Created on : Nov 30, 2022, 10:14:43 AM
    Author     : dalevanh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
   <title>Order</title>
</head>

<%@ page import="model.*" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<body>
    <div>
       <jsp:include page="header.jsp" />
    </div>
   
<h1 class="bigFont" align="center"><font face="Georgia, Times New Roman, Times, serif">Shopping 
  Cart Check Out</font></h1>

   <form method="post" action="jsp/thankyou.jsp">
    <input type="hidden" name="action" value="validate_credit">
  <p style="font-weight: bold">&nbsp;</p>
  <table width="100%" border="0" cellspacing="1" cellpadding="1">
    <tr>
      <td bgcolor="#CCCCCC"> 
        <h3 align="left">You have selected to purchase the following Items</h3>
      </td>
    </tr>

    <c:forEach var="item" items="${cartItems}">
      <tr>
        <td bgcolor="#F0F0F0">${item.book.title}</td>
      </tr>
    </c:forEach>

    <c:if test="${empty cartItems}">
      <tr>
        <td>No items in the cart.</td>
      </tr>
    </c:if>
  </table>

  <p style="font-weight: bold">Please input the following information.</p>

  <table>
    <tr> 
      <td class="right bold">First name:</td>
      <td> 
        <input type="text" name="firstname" size="25" />
      </td>
    </tr>
    <tr> 
      <td class="right bold">Last name:</td>
      <td> 
        <input type="text" name="lastname" size="25" />
      </td>
    </tr>
    <tr> 
      <td class="right bold">Street:</td>
      <td> 
        <input type="text" name="street" size="25" />
      </td>
    </tr>
    <tr> 
      <td class="right bold">City:</td>
      <td> 
        <input type="text" name="city" size="25" />
      </td>
    </tr>
    <tr> 
      <td class="right bold">State:</td>
      <td> 
        <input type="text" name="state" size="2" />
      </td>
    </tr>
    <tr>
      <td class="right bold">Zip code:</td>
      <td> 
        <input type="text" name="zipcode" size="10" />
      </td>
    </tr>
    <tr>
      <td class="right bold">Total Cost:</td>
      <td> 
        <input type="text" name="amount" value="${totalOrderInDollars}" />
      </td>
    </tr>
  </table>
  
  <input type="submit" value="Submit Order" />
</form>
    <div>
       <jsp:include page="footer.jsp" />
    </div>
</body>
</html>
