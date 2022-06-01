<%-- 
    Document   : product
    Created on : Dec 18, 2021, 9:40:23 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  

 <form method="get" action="<c:url value="/category" />">
        <div class="form-group">
            <div class="row text-center">
                <div class="col-10">
                    <input placeholder="kết quả tìm kiếm sẽ tìm kiếm dựa trên tất cả sản phẩm" type="text" id="search" name="search" class="form-control" />
                </div>
                <div class="col-1">
                    <input type="submit" value="Tìm kiếm" />
                </div>
            </div>
        </div>
    </form>
      
<nav aria-label="Page navigation example">
  <ul class="pagination">
      <c:forEach  begin="1" end="${Math.ceil(counter/6)}" var="i">
          <li class="page-item"><a class="page-link" href="<c:url value="/category?page=${i}" />">${i}</a></li>  
    </c:forEach>
</nav>
<div class="container" style="margin: 100px 0px">
   
    <div class="row text-center">
       
            <c:forEach items="${products}" var="p">
                <div class="col-12 col-md-4">
              <div class="card" style="height: 600px">
                    <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                      <img
                        src="${p.image}"
                        class="img-fluid"
                      />
                      <a href="#!">
                        <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                      </a>
                    </div>
                    <div class="card-body">
                      <h5 class="card-title">${p.name}</h5>
                      <p class="card-text">
                        ${p.description}
                      </p>
                     
                    </div>
                      <a href="/product/${p.id}" > <button 
                            data-mdb-toggle="modal"
                               data-mdb-target="#order" 
                               id="order" type="button" class="btn btn-success">Đặt ngay với giá tốt : ${p.price} VNĐ</button> 
                      </a>
               </div>
                      
               </div>
             </c:forEach>
        
    </div>
</div>
