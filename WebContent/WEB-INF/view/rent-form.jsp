<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">

<head>
	<title>Rent a book</title>
	
	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body>

	<div class="container">
		<div class="row">
			<h2>CRM - Rent Form</h2>
		</div>
	<div class="row">
		
		<a href="/book-rental/client/showFormForAddClient" class="btn btn-primary" role="button" aria-pressed="true">Add new client</a>
			
								
			<table class="table">
				<tr>
					<th scope="col"> First Name </th>
					<th scope="col"> Last Name </th>
					<th scope="col"> Email </th>
					<th scope="col"> Action </th>
				</tr>
				
				<c:forEach var="tempClient" items="${client}">
					<c:url var="rentLink" value="/book/showFormForRent2">
						<c:param name="clientId" value="${tempClient.idClient}" />
						<c:param name="bookId" value="${book.idBook}" />
					</c:url>
							
					<tr>
						<td> ${tempClient.firstName}</td>
						<td> ${tempClient.lastName}</td>
						<td> ${tempClient.email}</td>
						<td> <a class="btn btn-primary btn-sm" href="${rentLink}">Choose</a></td>
					</tr>
				</c:forEach>
			</table>
	</div>	
	<div class="row">
		<a href="${pageContext.request.contextPath}/book/list-books">Back to List</a>
	</div>
	</div>	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	

</body>

</html>