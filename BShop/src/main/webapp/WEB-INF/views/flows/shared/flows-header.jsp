<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<spring:url value="/resources/css" var="css"/>
<spring:url value="/resources/js" var="js"/>
<spring:url value="/resources/images" var="images"/>
<%@ page session="false" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Test Site-${title}</title>
    <script>
    window.menu='${title}';
    
    window.contextRoot = '${contextRoot}';
    </script>

    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
   <!-- Bootstrap Readable Theme -->
  <!--  <link href="${css}/bsthemeone.css" rel="stylesheet"> -->
  
     <!-- Bootstrap DataTables -->
    <link href="${css}/dataTable.bootstrap.css" rel="stylesheet"> 
    
    <!-- Custom CSS -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

    

</head>

<body>
 
 <div class="wrapper">
 
 
    <!-- Navigation -->

   <%@include file = "flows-nav.jsp" %>    

    <!-- Page Content -->
    
    <div class="content">