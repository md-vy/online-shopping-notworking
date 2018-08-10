<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<c:if test="${not empty message}">

			<div class="col-xs-12">

				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>

					"${message}"

				</div>

			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="planel-body">
					<!-- FORM ELEMENTS -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<!-- Name -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="name">Enter
								Product Name:</label>
							<div class="col-md-4">
								<sf:input id="name" path="name" placeholder="Product Name"
									class="form-control input-md" type="text" />
								<sf:errors path="name" cssClass="help-block" element="em" />

							</div>
						</div>

						<!-- Brand -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="brand">Enter
								Brand Name:</label>
							<div class="col-md-4">
								<sf:input id="brand" path="brand" placeholder="Brand Name"
									class="form-control input-md" type="text" />
								<sf:errors path="brand" cssClass="help-block" element="em" />

							</div>
						</div>

						<!-- Description -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="description">Product
								Description:</label>
							<div class="col-md-4">
								<sf:textarea class="form-control" id="description"
									path="description" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Price -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="unitPrice">Enter
								Unit Price:</label>
							<div class="col-md-4">
								<sf:input id="unitPrice" path="unitPrice"
									placeholder="Unit Price in Rs." class="form-control input-md"
									type="number" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />

							</div>
						</div>

						<!-- Quantity -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="quantity">Quantity
								Available:</label>
							<div class="col-md-4">
								<sf:input id="quantity" path="quantity"
									placeholder="Quantity Available" class="form-control input-md"
									type="number" />
							</div>
						</div>

						<!-- file element for image-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="file">Select
								an Image:</label>
							<div class="col-md-4">
								<sf:input id="file" path="file" class="form-control" type="file" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Button Drop Down -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<div class="input-group">
									<sf:select id="categoryId" path="categoryId"
										class="form-control" placeholder="Select Category"
										items="${categories}" itemLabel="name" itemValue="id" />

									<c:if test="${product.id==0}">
										<div class="text-right">
											<br />
											<button type="button" data-toggle="modal"
												data-target="#mycategoryModal"
												class="btn btn-warning btn-xs">Add Category</button>
										</div>
									</c:if>


								</div>
							</div>
						</div>

						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit"
									placeholder="Submit" class="btn btn-primary" />

								<!-- Hidden fields for products -->

								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />


							</div>

						</div>

					</sf:form>


				</div>

			</div>
		</div>


	</div>

	<div class="row">
		<div class='col-xs-12'>
			<h3>Available Products</h3>
			<hr />
		</div>

		<div class='col-xs-12'>
		
		<div class = "container-fluid">
		<div class= "table-responsive">
		
				<!-- Product table for admin -->
				<table id="adminProductsTable"
					class="table table-striped table-bordered">

					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>


				</table>
				</div>
		</div>

		</div>


	</div>

	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex = "-1">
		<div class="modal-dialog" role="documente">
			<div class="modal-content">
				<div class="modal-header">
				<button type= "button" class= "close" data-dismiss = "modal">
				<span>&times;</span>
				</button>
				<h4 class= "modal-title">Add New Category</h4>
				</div>
				<div class = "modal-body">
				<!-- Category Form -->
				<sf:form id = "categoryForm" modelAttribute= "category" action="${contextRoot}/manage/category" method = "POST"
				class = "form-horizontal">
				
				<div class = "form-group">
				<label for= "category_name" class = "control-label col-md-4">Category Name</label>
				<div class = "col-md-8">
					<sf:input type = "text" path="name" id= "category_name" class = "form-control"/>
				</div>
				</div>
				
				<div class = "form-group">
				<label for= "category_description" class = "control-label col-md-4">Category Description</label>
				<div class = "col-md-8">
					<sf:textarea cols= "" row = "5" path="description" id = "category_description" class = "form-control"/>
				</div>
				</div>
				
					<div class = "form-group">
				<div class = "col-md-offset-4 col-md-8">
				<input type= "submit" value = "Add Category" class= "btn btn-primary"/>
				</div>
				</div>
				
				
				</sf:form>
				
				</div>
			</div>

		</div>

	</div>

</div>