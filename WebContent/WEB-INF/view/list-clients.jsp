<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">

<head>
	<meta charset="utf-8">
	<title>List Clients</title>
	
	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body>

	<div class="container">
		<div class="row">
			<h2>CRM - List of clients</h2>
		</div>
    
	    <div class="row">
			
			<input type="button" value="Add Client" onclick="window.location.href='showFormForAddClient'; return false;"
			class="btn btn-primary" />
			
					
			<table class="table">
				<tr>
					<th scope="col"> First Name </th>
					<th scope="col"> Last Name </th>
					<th scope="col"> Email </th>
					<th scope="col"> Action </th>
				</tr>
				
				<c:forEach var="tempClient" items="${clients}">
					<c:url var="updateLink" value="/client/showFormForUpdateClient">
						<c:param name="clientId" value="${tempClient.idClient}" />
					</c:url>
					<c:url var="deleteLink" value="/client/deleteClient">
						<c:param name="clientId" value="${tempClient.idClient}" />
					</c:url>
					<tr>
						<td> ${tempClient.firstName}</td>
						<td> ${tempClient.lastName}</td>
						<td> ${tempClient.email}</td>
						<td> <a class="btn btn-primary btn-sm" href="${updateLink}">Update</a> <a class="btn btn-danger btn-sm" href="${deleteLink}">Delete</a></td>
					</tr>
				</c:forEach>
            </table>
        </div>
        <div class="row">
	       <a href="${pageContext.request.contextPath}">Go to main menu</a>
        </div>
    </div>	
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>

</html>