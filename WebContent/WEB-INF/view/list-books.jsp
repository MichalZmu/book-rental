<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">

<head>
	<meta charset="utf-8">
	<title>List Books</title>
	
	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body>

	<div class="container">
		<div class="row">
			<h2>CRM - list of books</h2>
		</div>
		<div class="row">			
					
            <input type="button" value="Add Book" onclick="window.location.href='showFormForAdd'; return false;" 
			class="btn btn-primary" />
									
			<table class="table">
			<tr>
				<th scope="col"> Author </th>
				<th scope="col"> Title </th>
				<th scope="col"> Genre </th>
				<th scope="col"> Rental Date </th>
				<th scope="col"> Return Date </th>
				<th scope="col"> Client </th>
				<th scope="col"> Action </th>
			</tr>
			
			<c:forEach var="tempBook" items="${books}">
			<c:url var="updateLink" value="/book/showFormForUpdate">
			    <c:param name="bookId" value="${tempBook.idBook}" />
			</c:url>
			<c:url var="rentLink" value="/book/showFormForRent">
				<c:param name="bookId" value="${tempBook.idBook}" />
			</c:url>
			<c:url var="deleteLink" value="/book/deleteBook">
				<c:param name="bookId" value="${tempBook.idBook}" />
			</c:url>
			<c:url var="returnLink" value="/book/returnBook">
				<c:param name="bookId" value="${tempBook.idBook}" />
			</c:url>		
			<tr>
				<td> ${tempBook.author}</td>
				<td> ${tempBook.title}</td>
				<td> ${tempBook.genre}</td>
				<td> ${tempBook.rentalDate}</td>
				<td> ${tempBook.returnDate}</td>
				<td> ${tempBook.client}</td>
				<td> <a class="btn btn-primary btn-sm" href="${updateLink}">Update</a> <a class="btn btn-primary btn-sm" href="${rentLink}">Rent</a> <a class="btn btn-danger btn-sm" href="${deleteLink}">Delete</a> <a class="btn btn-primary btn-sm pt-1" href="${returnLink}">Return</a></td>
			</tr>
			</c:forEach>
			</table>
			<p>
				<a href="${pageContext.request.contextPath}">Go to main menu</a>
			</p>
		</div>		
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>

</html>