<%-- 
    Document   : history
    Created on : Dec 29, 2021, 5:06:19 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <table class="table">
  <thead>
    <tr>
  
      <th scope="col">tên người dùng</th>
    
      
    </tr>
  </thead>
  <tbody>
    <tr>
      
      <td>${user.username}</td>
      
      
    </tr>
 
  </tbody>
</table>

         <table class="table">
  <thead>
    <tr>
      <th scope="col">Mã số đơn hàng</th>
      <th scope="col">Mã sản phẩm</th>
      <th scope="col">Giá đặt trước</th>
      <th scope="col">Thời gian</th>
    </tr>
  </thead>
  <tbody>
    <tr>
        <c:forEach items="${listTransaction}" var="i">
            <tr>
                    <td>${i.id}</td> 
                    <td>${i.productId.id}</td>
                    <td>${i.price}</td>
                    <td>${i.date}</td>
            </tr>
        </c:forEach>
     
    
 
  </tbody>
</table>