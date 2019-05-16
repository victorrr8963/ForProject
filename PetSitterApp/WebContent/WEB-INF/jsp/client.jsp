<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- DOCTYPE html-->
<html>
<head>
<!-- meta charset="ISO-8859-1"-->
<title>bull shit</title>
</head>
<body>

	<h2>Clients Info</h2>
	<form:form method="GET" action="/PetSitterApp/clients">
		<table>
			<tr>
				<td>Email:</td>
				<td>${email}</td>
			</tr>

			<tr>
				<td>Name:</td>
				<td>${name}</td>
			</tr>

			<tr>
				<td>Password:</td>
				<td>${password}</td>
			</tr>
			
			<tr>
				<td>Address:</td>
				<td>${address}</td>
			</tr>

			<tr>
				<td>Phone Number:</td>
				<td>${phoneNumber}</td>
			</tr>

			<tr>
				<td>Pets List:</td>
				<td>${petsList}</td>
			</tr>

			<tr>
				<td>Requests List:</td>
				<td>${requestsList}</td>
			</tr>

		</table>
	</form:form>
</body>
</html>