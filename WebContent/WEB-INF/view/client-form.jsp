<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html lang="en">

<head>
	<title>Save Client</title>
	
	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body>
	<div class="container">
		<div class="row">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	
	    <div class="row">
		    <h3>Save Customer</h3>
        </div>
        
        <div class="row">
		
            <form:form action="saveClient" modelAttribute="client" method="POST">
            <form:hidden path="idClient" />		

            <div class="form-group">
                <label>First Name:</label>
                <form:input class="form-control" path="firstName" /> <form:errors path="firstName" cssClass="error" />
            </div>

            <div class="form-group">
                <label>Last Name:</label>
                <form:input class="form-control" path="lastName" /> <form:errors path="lastName" cssClass="error" />
            </div>

            <div class="form-group">				
               <label>Email:</label>
               <form:input class="form-control" path="email" /> <form:errors path="email" cssClass="error" />
            </div>

            <button type="submit" value="Save" class="btn btn-primary">Save</button>


            </form:form>
        </div>
        
        <div class="row">
            <a href="${pageContext.request.contextPath}/client/list-clients">Back to List</a>
		</div>
		
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>

</html>