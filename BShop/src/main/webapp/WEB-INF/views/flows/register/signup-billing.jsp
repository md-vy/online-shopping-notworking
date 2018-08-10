<%@taglib prefix= "sf" uri= "http://www.springframework.org/tags/form" %>

<%@include file = "../shared/flows-header.jsp" %>

<div class="conatiner">

<div class= "row">
<div class= "col-md-6 col-md-offset-3">
<div class= "panel panel-primary">

<div class= "panel-heading">
<h4>Sign Up-Address</h4>
</div>

<div class = "panel-body">

<sf:form 
method = "POST"
class= "form-horizontal"
id= "billingForm"
modelAttribute="billing"
>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="addressLineOne">Address Line One</label>  
  <div class="col-md-4">
  <sf:input path="addressLineOne" placeholder="Enter Address Line One" class="form-control input-md" type="text"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="addressLineTwo">Address Line Two</label>  
  <div class="col-md-4">
  <sf:input path="addressLineTwo" placeholder="Enter Address Line Two" class="form-control input-md" type="text"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="city">City</label>  
  <div class="col-md-4">
  <sf:input path="city" placeholder="Enter City Name" class="form-control input-md" type="text"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="postalCode">Postal Code</label>  
  <div class="col-md-4">
  <sf:input path="postalCode" placeholder="XXXXXX" class="form-control input-md" type="text"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="state">State</label>  
  <div class="col-md-4">
  <sf:input path="state" placeholder="State" class="form-control input-md" type="text"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="country">Country</label>  
  <div class="col-md-4">
  <sf:input path="country" placeholder="Country" class="form-control input-md" type="text"/>
    
  </div>
</div>




<!-- Button -->
<div class="form-group">
  <div class="col-md-offset-4 col-md-8">
    <button type="submit" name="_eventId_billing" class="btn btn-primary">
    <span class = "glyphicon glyphicon-chevron-left"></span>Previous - Personal 
    </button>
    
       <button type="submit" name="_eventId_billing" class="btn btn-primary">
   Next - Confirm  <span class = "glyphicon glyphicon-chevron-right"></span>
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
    
