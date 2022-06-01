<%-- 
    Document   : addproduct
    Created on : Dec 19, 2021, 1:19:14 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/admin/addproduct" var="action" />
<div class="container" style="margin:100px 0px;">
    <div class="row text-center">
        <div class="col-12">
            <h2 class="text-danger">Thêm Sản Phẩm</h2>
        </div>
        
    </div>
    <div class="row">
         <form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
                <form:errors path="*" element="div" cssClass="text-danger text-center"/>
               
                <div class="form-group">
                    <label for="name">Tên</label>
                    <form:input id="name" path="name" type="text" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <label for="price">Giá</label>
                    <form:input id="price" path="price" type="text" cssClass="form-control" />
                </div>
                
                 <div class="form-group">
                    <label for="description">Mô tả</label>
                    <form:textarea id="description" path="description" cssClass="form-control" />
                </div>
                  <div class="form-group">
                    <label for="categoryId">Danh mục</label>
                    <form:select id="categoryId" path="categoryId" cssClass="form-control">
                        <c:forEach items="${categories}" var="cat">
                            <option value="${cat.id}">${cat.name}</option>
                        </c:forEach>
                    </form:select>
                </div>
                 <div class="form-group">
                    <label for="file">Ảnh sản phẩm</label>
                    <form:input id="file" path="file" type="file" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <input type="submit"  value="Nhap vao day" class="form-control"/>
                </div>
            </form:form>
    </div>
</div>
          
   


