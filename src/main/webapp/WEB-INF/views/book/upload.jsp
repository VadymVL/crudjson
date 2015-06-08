<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<form method="POST" enctype="multipart/form-data" action="upload">
		File to upload:
		<br> 
		<input type="file" name="file"></input><br> 
		Name:
		<br>
		<input type="text" name="file_name"></input><br> 
		<br> 
		<input type="submit" value="Upload"> Press here to upload the file!</input>
	</form>
</body>
</html>