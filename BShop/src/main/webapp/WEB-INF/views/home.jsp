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
    
    <meta name= "_csrf" content= "${_csrf.token}">
     <meta name= "_csrf_header" content= "${_csrf.headerName}">

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
  <%@include file="./shared/nav.jsp" %>
    

    <!-- Page Content -->
    
    <div class="content">
    
    
    <c:if test="${userClickHome==true }">
      <%@include file="mhome.jsp" %>
    </c:if>
    
    <c:if test="${userClickRegistration==true }">
      <%@include file="registration.jsp" %>
    </c:if>
    
      <c:if test="${userClickAbout==true }">
      <%@include file="about.jsp" %>
    </c:if>
    
      <c:if test="${userClickContact==true }">
      <%@include file="contact.jsp" %>
    </c:if>
    
    <c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">
      <%@include file="listProducts.jsp" %>
    </c:if>
    
    
    <!--Load only when user clicks contact  -->
     <c:if test="${userClickShowProduct==true}">
      <%@include file="singleProduct.jsp" %>
    </c:if>
    
    <!--Load only when user manage products  -->
     <c:if test="${userClickManageProducts==true}">
      <%@include file="manageProducts.jsp" %>
    </c:if>
</div>
   
    <div class="container">

        <hr>

        <!-- Footer -->
       <%@include file="./shared/footer.jsp" %>
    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="${js}/jquery.js"></script>
     <!-- jQuery val -->
    <script src="${js}/jquery.validate.js"></script>
     <!-- jQuery val min -->
   <!--  <script src="${js}/jquery.validate.min.js"></script> -->

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>
    
    <!-- DataTable Plugin -->
    <script src="${js}/jquery.dataTables.js"></script>   
    
        <!-- DataTable Bootstrap Script -->
    <script src="${js}/dataTables.bootstrap.js"></script>  
    
     <!-- BootBox -->
    <script src="${js}/bootbox.min.js"></script>  
    
    
    
    <!-- Self coded -->
    <script src="${js}/myapp.js"></script>
   </div> 

</body>

</html>
