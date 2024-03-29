<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<spring:url value="/resources/css" var="css" />
<%@ page session="false"%>
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
    </script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap Readable Theme -->
<!--  <link href="${css}/bsthemeone.css" rel="stylesheet"> -->
<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">



</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Home</a>
				</div>
			</div>
		</nav>


		<!-- Page Content -->

		<div class="content">

			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class=jumbotron">
							<h1>${errorTitle}</h1>
							<hr />
							<blockquote style="word-wrap: break word">
								${errorDescription}</blockquote>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
	</div>


</body>

</html>
