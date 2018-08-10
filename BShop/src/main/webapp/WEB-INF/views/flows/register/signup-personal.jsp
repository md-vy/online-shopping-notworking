<%@taglib prefix= "sf" uri= "http://www.springframework.org/tags/form" %>

<%@include file = "../shared/flows-header.jsp" %>

<div class="conatiner">

<div class= "row">
<div class= "col-md-6 col-md-offset-3">
<div class= "panel panel-primary">

<div class= "panel-heading">
<h4>Sign Up-Personal</h4>
</div>

<div class = "panel-body">

<sf:form 
method = "POST"
class= "form-horizontal"
id= "registerForm"
modelAttribute="user"
>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">First Name</label>  
  <div class="col-md-4">
  <sf:input path="firstName" placeholder="First Name" class="form-control input-md" type="text"/>
    <sf:errors path="firstName" cssClass="help-block" element="em"/>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Last Name</label>  
  <div class="col-md-4">
  <sf:input path="lastName" placeholder="Last Name" class="form-control input-md" type="text"/>
    <sf:errors path="lastName" cssClass="help-block" element="em"/>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Email</label>  
  <div class="col-md-4">
  <sf:input path="email" placeholder="e.g.: abc@gml.com" class="form-control input-md" type="text"/>
    <sf:errors path="email" cssClass="help-block" element="em"/>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Contact Number</label>  
  <div class="col-md-4">
  <sf:input path="contactNumber" placeholder="XXXXXXXXXX" class="form-control input-md" type="text"/>
    <sf:errors path="contactNumber" cssClass="help-block" element="em"/>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Password</label>
  <div class="col-md-4">
    <sf:input path="password" placeholder="Password" class="form-control input-md" type="password"/>
    	<sf:errors path="password" cssClass="help-block" element="em"/>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Confirm Password</label>
  <div class="col-md-4">
    <sf:input path="confirmpassword" placeholder="Re-enter Password" class="form-control input-md" type="password"/>
    	<sf:errors path="confirmpassword" cssClass="help-block" element="em"/>
  </div>
</div>


<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="radios">Select Role</label>
  <div class="col-md-8"> 
    <label class="radio-inline">
      <sf:input path="role" value="USER" checked="checked" type="radio"/>
      User
    </label> 
    <label class="radio-inline" >
      <sf:input path="role" value="SUPPLIER" type="radio"/>
      Supplier
    </label>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <div class="col-md-offset-4 col-md-8">
    <button type="submit" name="_eventId_billing" class="btn btn-primary">
    Next - Billing <span class = "glyphicon glyphicon-chevron-right"></span>
    </button>
  </div>
</div>

</sf:form>
</div>
</div>
</div>
</div>



</div>

<%@include file = "../shared/flows-footer.jsp" %>    
    
