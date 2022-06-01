<%-- 
    Document   : base
    Created on : Dec 18, 2021, 8:47:51 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" /></title>
                <!-- Font Awesome -->
        <link
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
          rel="stylesheet"
        />
        <!-- Google Fonts -->
        <link
          href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
          rel="stylesheet"
        />
        <!-- MDB -->
        <link
          href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.css"
          rel="stylesheet"
        />
    </head>
    <body>
        <div class="container">
        <!--Header-->
        <tiles:insertAttribute name="header" />
        
        <!--Content-->
        <tiles:insertAttribute name="content" />
        
        <!--Footer-->
        <tiles:insertAttribute name="footer" />
        
        </div>
        
        <!-- MDB -->
        <script
          type="text/javascript"
          src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.js"
        ></script>
    </body>
</html>
