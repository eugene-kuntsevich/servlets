<!DOCTYPE html>
<html>
<head>
	<title>Geo location servlet</title>
</head>
<body>
<h1>Get time zone by ZIP code</h1>
<form action="<%= request.getContextPath() %>/geo-location-servlet"
		<%
			String zipCode = (String) request.getAttribute("zip_code");
			String timezone = (String) request.getAttribute("timezone");
		%>
		method="get">
	Country ZIP code:
	<label>
		<input type="text" name="zip_code" value="<%= zipCode != null ? zipCode : "" %>">
	</label>
	<br>
	<input type="submit" value="Get timezone">
</form>
<br>
<div>
	Country timezone: <%= timezone != null ? timezone : "" %>
</div>
</body>
</html>
