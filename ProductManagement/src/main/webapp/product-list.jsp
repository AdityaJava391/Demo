<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Product Management Application</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>
<body>
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
   <div>
    <a href="https://www.google.com" class="navbar-brand"> Product
     App</a>
   </div>

   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list"
     class="nav-link">Products</a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>

 <div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
   <h3 class="text-center">List of Products</h3>
   <hr>
   <div class="container text-left">

    <a href="<%=request.getContextPath()%>/new"
     class="btn btn-success">Add Product</a>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Product name</th>
      <th>Price</th>
      <th>Quantity in stock</th>
      <th>Vendor</th>
      <th>Waranty</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach var="value" items="${listProduct}">

      <tr>
       <td><c:out value="${value.productName}" /></td>
       <td><c:out value="${value.price}" /></td>
       <td><c:out value="${value.quantityInStock}" /></td>
       <td><c:out value="${value.vendor}" /></td>
       <td><c:out value="${value.waranty}" /></td>
       
       <td><a href="edit?id=<c:out value='${value.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="delete?id=<c:out value='${value.id}' />">Delete</a></td>
      </tr>
     </c:forEach>
     <!-- } -->
    </tbody>

   </table>
  </div>
 </div>
</body>
</html>