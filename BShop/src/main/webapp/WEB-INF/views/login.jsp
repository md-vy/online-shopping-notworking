<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/images" var="images" />
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
	window.menu = '${title}';

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
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/mhome">TestSite</a>
				</div>
			</div>
		</nav>


		<!-- Page Content -->

		<div class="content">

			<div class="container">

				<!-- This will be displayed if the credentials are wrong -->
				<c:if test="${not empty message}">
					<div class="row">
						<div class="col-md-offset-3 col-md-6">
							<div class="alert alert-danger">${message}</div>
						</div>
					</div>

				</c:if>
				
				
				
				<!-- This will be displayed if user logged out -->
				<c:if test="${not empty logout}">
					<div class="row">
						<div class="col-md-offset-3 col-md-6">
							<div class="alert alert-success">${logout}</div>
						</div>
					</div>

				</c:if>



				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="panel panel-primary">

							<div class="panel-heading">
								<h4>Sign Up-Personal</h4>
							</div>

							<div class="panel-body">

								<form action="${contextRoot}/login" method="POST"
									class="form-horizonttal" id="loginForm">
									<fieldset>
										<!-- Text input-->
										<div class="form-group">
											<label class="col-md-4 control-label" for="username">Email:</label>
											<div class="col-md-4">
												<input id="username" name="username" placeholder=""
													class="form-control input-md" type="text">

											</div>
										</div>

										<!-- Password input-->
										<div class="form-group">
											<label class="col-md-4 control-label" for="password">Password:</label>
											<div class="col-md-4">
												<input id="password" name="password" placeholder=""
													class="form-control input-md" type="password">

											</div>
										</div>

										<!-- Button -->
										<div class="form-group">
											<div class="col-md-offset-4 col-md-8">
												<button type="submit" name="Login" class="btn btn-primary">Login</button>
												<input type="hidden" name="${_csrf.parameterName}"
													value="${_csrf.token}" />
											</div>
										</div>

									</fieldset>
								</form>

							</div>
							<div class="panel-footer">
								<div class="text-right">
									New User - <a href="${contextRoot}/register">Register Here</a>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="container">

			<hr>

			<!-- Footer -->
			<%@include file="./shared/footer.jsp"%>
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


		<!-- Self coded -->
		<script src="${js}/myapp.js"></script>
	</div>

</body>

</html>
