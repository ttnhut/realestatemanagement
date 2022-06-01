<%-- 
    Document   : header
    Created on : Dec 18, 2021, 8:51:52 PM
    Author     : Asus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
    <div class="container-fluid">
      <button
              class="navbar-toggler"
              type="button"
              data-mdb-toggle="collapse"
              data-mdb-target="#navbarExample01"
              aria-controls="navbarExample01"
              aria-expanded="false"
              aria-label="Toggle navigation"
      >
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarExample01">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item active">
              <a class="nav-link" aria-current="page" href="<c:url value="/" />">Home</a>
          </li>
          <c:forEach items="${categories}" var="cat">
          <li class="nav-item">
              <a class="nav-link" href="<c:url value='/category/?cat=${cat.id}' />">${cat.name}</a>
          </li>
          </c:forEach>
          
        </ul>
      </div>
            
              <c:if test="${pageContext.request.userPrincipal.name ==null}">
                  <a href="<c:url value="/login" />"><button type="button" class="btn btn-danger">Đăng nhập</button></a>
                  <a href="<c:url value="/register" />"><button type="button" class="btn btn-danger">Đăng ký</button></a>
              </c:if>
              <c:if test="${pageContext.request.userPrincipal.name !=null}">
                  <a href="<c:url value="/${pageContext.request.userPrincipal.name}/history" />"><button type="button" class="btn btn-success">${pageContext.request.userPrincipal.name}</button></a>
                  <a href="<c:url value="/logout" />"><button type="button" class="btn btn-danger">Đăng xuất</button></a>
              </c:if>
        
        
    </div>
  </nav>
  <!-- Navbar -->

  <!-- Jumbotron -->
  <div class="p-5 text-center bg-light" style="margin-top: 100px">
    <h1 class="mb-3">WareHouse</h1>
    <h4 class="mb-3">Bất động sản của mọi nhà</h4>
    
  </div>
  <!-- Jumbotron -->
</header>

