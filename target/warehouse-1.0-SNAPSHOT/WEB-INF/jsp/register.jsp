<%-- 
    Document   : register
    Created on : Dec 24, 2021, 9:30:06 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/register" var="action" />
<c:if test="${errMsg!=null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<h2 class="text-center text-danger">Đăng ký</h2>
<form:form method="post" action="${action}" style="margin: 100px 0px" modelAttribute="user">
    <div class="form-group">
        <label for="username">Ten dang nhap</label>
        <form:input path="username" type="text" id="username" class="form-control" />
    </div>
    <div class="form-group">
        <label for="password">Mat khau</label>
        <form:input path="password" type="password"  id="password" class="form-control" />
    </div>
    <div class="form-group">
        <label for="passwordConfirm">Nhap lai mat khau</label>
        <form:input path="passwordConfirm" type="password"  id="passwordConfirm" class="form-control" />
    </div>
    <div class="form-group">
        
        <input type="submit" value="Dang Ky" class="form-control" />
    </div>
</form:form>
