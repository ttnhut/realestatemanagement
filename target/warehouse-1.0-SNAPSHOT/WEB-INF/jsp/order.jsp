<%-- 
    Document   : order
    Created on : Dec 28, 2021, 3:18:06 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${msg!=''}">
    <div class="alert alert-danger">
        ${msg}
    </div>
</c:if>
<h1 class="text-danger text-center">Đặt Trước Sản Phẩm</h1>
<c:if test="${product!=null}">
    <table class="table">
  <thead>
    <tr>
      <th scope="col">ID sản phẩm</th>
      <th scope="col">Tên sản phẩm</th>
      <th scope="col">Giá</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
    </tr>
 
  </tbody>
</table>
</c:if>
<form action="" method="get" style="margin: 100px 0px">
    <div class="form-group">
        
       Trả hết :  <input type="checkbox" value="1" name="allCost" id="allCost"/>
    </br>
    Hoặc Vay Ngân Hàng VietComBank với mức lãi suất 5%/năm
    <input type="number" id="cost" name="cost" class="form-control" />
    <input type="submit" value="Chấp nhận thanh toán" class="form-control" />
    <input type="hidden" value="${pageContext.request.userPrincipal.name}" name="username" >
    </div>
    
</form>
    <div class="alert alert-success">
        <h2>Vay Ngân Hàng VietComBank với mức lãi suất 5%/năm</h2>
    </div>
    <c:if test="${lendingPrice!=null}">
        <p class="text-danger text-center">ghi chú :E nghĩa là 10^ (mười mũ) . Ví dụ : 5E2 = năm nhân mười mũ hai </p>
        <c:set value="${lendingPrice*(5/100)}" var="comission" />
        <c:set value="${lendingPrice/12}" var="priceRequire" />            
                    <table class="table">       
                        <thead>
                 <tr>
                     <th scope="col">Tháng</th>
                   <th scope="col">Tổng số tiền</th>
                   <th scope="col">Tiền đóng một tháng</th>
                   <th scope="col">Lãi một tháng</th>
                   <th scope="col">Tổng tiền phải đóng</th>
                   <th scope="col">Tiền còn lại</th>

                 </tr>
               </thead>
               <tbody>
        <c:forEach begin="1" end="12" var="i">
                            

            <c:if test="${(lendingPrice - (lendingPrice/12) - comission) >=0}">
                 <tr>
                   <td>${i}</td>
                   <td>${lendingPrice}</td>
                   <td>${priceRequire}</td>
                   <td>${comission}</td>
                   <td>${priceRequire + commision}</td>
                   <td>${lendingPrice - (lendingPrice/12) - comission}</td>
                 </tr>
            </c:if> 
            <c:if test="${(lendingPrice - (lendingPrice/12) - comission) <0}">
                    <td>${i}</td>
                    <td>${lendingPrice}</td>  
                    <td>${lendingPrice}</td>
                   <td>${comission}</td>
                   <td>${lendingPrice + comission}</td>
                   <td>0</td>
            </c:if>
                 <c:set value="${lendingPrice - (lendingPrice/12) - comission}" var="lendingPrice"  />
               
            
                 
        </c:forEach>
                   </tbody>
                    </table>
    </c:if>