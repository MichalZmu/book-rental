<!DOCTYPE html>

<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Library System</title>
	
	<link type="text/css" rel="stylesheet" 
	href="${pageContext.request.contextPath}/resources/css/style.css" />
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body>
<div class="wrapper">
	<nav id="sidebar">
		<div class="sidebar-header">
	            <h3>CRM Library</h3>
	    </div>	
	        <ul class="list-unstyled components">
	            <li class="active">
	                <a href="#bookSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Books</a>
	                <ul class="collapse list-unstyled" id="bookSubmenu">
	                    <li>
	                        <a href="/book-rental/book/list-books">All books</a>
	                    </li>
	                    <li>
	                        <a href="/book-rental/book/showFormForAdd">Add new book</a>
	                    </li>
	                </ul>
	            </li>
	            <li>
	                <a href="#clientSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Clients</a>
	                <ul class="collapse list-unstyled" id="clientSubmenu">
	                    <li>
	                        <a href="/book-rental/client/list-clients">All clients</a>
	                    </li>
	                    <li>
	                        <a href="/book-rental/client/showFormForAddClient">Add new client</a>
	                    </li>
	                </ul>
	            </li>
	        </ul>
	</nav>
	<div id="content">
		<div class="container center-block">
			<div class="row">
				<h2>CRM - Library System</h2>
			</div>
			<div class="row navigate-main-buttons">
				
				<a href="/book-rental/client/list-clients" class="btn btn-primary btn-lg active mr-1" role="button" aria-pressed="true">Show Clients</a>
				
				<a href="/book-rental/book/list-books" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Show Books</a>
				
			</div>
		</div>
	</div>
</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>