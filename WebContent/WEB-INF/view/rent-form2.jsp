<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Rent a book</title>
	
	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body>

	<div class="container main-home-page">
		<div class="row">
			<h2>Rent Form</h2>
		</div>
	
		<div class="row d-block">
			<h3>I am renting: ${book.idBook} ${book.title}</h1>
			<h3>Renting for: ${client.idClient} ${client.firstName} ${client.lastName}</h1>
        </div>
        <div class="row pt-5">
				
			<form action="rentBook" method="post">						
					<spring:bind path="book.idBook">
					   <input value="${book.idBook}" type="hidden" name="idBook"/>
					   <input value="${book.title}" type="hidden" name="title"/>
					   <input value="${book.author}" type="hidden" name="author"/>
					   <input value="${book.genre}" type="hidden" name="genre"/>
					</spring:bind>
					
					<spring:bind path="client.idClient">
					   <input value="${client.idClient}" type="hidden" name="idClient"/>
					   <input value="${client.firstName}" type="hidden" name="firstName"/>
					   <input value="${client.lastName}" type="hidden" name="lastName"/>
					</spring:bind>
					
					<div class="form-group">
                        <label>Rental Date:</label>		
                        <spring:bind path="book.rentalDate" >
                           <input type="text" value="${book.rentalDate}" name="rentalDate"/> <form:errors path="book.rentalDate" cssClass="error" />
                        </spring:bind>
                    </div>
					
            		<div class="form-group">
                        <label>Return Date:</label>
                        <spring:bind path="book.returnDate">
                           <input type="text" value="${book.returnDate}" name="returnDate"/> <form:errors path="book.returnDate" cssClass="error" />
                        </spring:bind>
                    </div>
		
                    <button type="submit" class="btn btn-primary" value="Submit">Save</button>
						
			</form>
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