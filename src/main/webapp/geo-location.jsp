<!DOCTYPE html>
<html>
<head>
	<title>Geo location servlet</title>
</head>
<body>
<h1>Get time zone by ZIP code</h1>
<form action="<%= request.getContextPath() %>/geo-location-servlet" method="get">
	Country ZIP code:
	<label>
		<input type="text" name="zip_code" value="<%= request.getAttribute("zip_code") != null ?
		request.getAttribute("zip_code") : "" %>">
	</label>
	<br>
	<input type="submit" value="Get timezone">
</form>
<p>
	Country timezone: <%= request.getAttribute("timezone") != null ? request.getAttribute("timezone") : ""%>
</p>
</body>
</html>
