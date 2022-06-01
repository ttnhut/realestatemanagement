<%-- 
    Document   : login
    Created on : Dec 24, 2021, 8:53:05 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${param.error!=null}">
    <div class="alert alert-danger">
        Da co loi xay ra !!!
    </div>
</c:if>
<c:if test="${param.accessDenied!=null}">
    <div class="alert alert-danger">
        Bạn không có quyền đăng nhập vào mục này !!!
    </div>
</c:if>
<c:url value="/login" var="action" />
<h2 class="text-center text-danger">Đăng nhập</h2>
<form method="post" action="${action}" style="margin: 100px 0px">
    <div class="form-group">
        <label for="username">Ten dang nhap</label>
        <input type="text" name="username" id="username" class="form-control" />
    </div>
    <div class="form-group">
        <label for="password">Mat khau</label>
        <input type="password" name="password" id="password" class="form-control" />
    </div>
    <div class="form-group">
        
        <input type="submit" value="Dang Nhap" class="form-control" />
    </div>
</form>
