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
    <a href="https://www.javaguides.net" class="navbar-brand"> Product Management
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
 <div class="container col-md-5">
  <div class="card">
   <div class="card-body">
    <c:if test="${listProduct != null}">
     <form action="update" method="post">
    </c:if>
    <c:if test="${listProduct == null}">
     <form action="insert" method="post">
    </c:if>

    <caption>
     <h2>
      <c:if test="${listProduct != null}">
               Edit Product
              </c:if>
      <c:if test="${listProduct == null}">
               Add New Product
              </c:if>
     </h2>
    </caption>

    <c:if test="${listProduct != null}">
     <input type="hidden" name="id" value='${listProduct.id}' />" />
    </c:if>

    <fieldset class="form-group">
     <label>Product Name</label> <input type="text" value="<c:out value='${listProduct.productName}'/>" class="form-control" name="productName" required="required" minlength="5">
         </fieldset>

   <fieldset class="form-group">
    <label>Price</label>
    <input type="text" class="form-control" name="price" required="required" minlength="5" value="${listProduct.price}">
</fieldset>

<fieldset class="form-group">
    <label>Quantity in stock</label>
    <input type="text" class="form-control" name="quantityInStock" required="required" minlength="5" value="${listProduct.quantityInStock}">
</fieldset>

<fieldset class="form-group">
    <label>Vendor</label>
    <input type="text" class="form-control" name="vendor" required="required" minlength="5" value="${listProduct.vendor}">
</fieldset>

<fieldset class="form-group">
    <label>Warranty</label>
    <input type="text" class="form-control" name="waranty" required="required" minlength="5" value="${listProduct.waranty}">
</fieldset>
  
    
    <button type="submit" class="btn btn-success">Save</button>
   </form>
   </div>
  </div>
 </div>

</body>
</html>