<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<script src="/resources/uploader.js"></script>
<script src="/springCRUD/uploader.js"></script>

<script type="text/javascript"
       src='<c:url value="/resources/uploader.js"/>'></script>
       
<body>
	<form method="POST" enctype="multipart/form-data" action="upload">
		File to upload:
		<br> 
		<input type="file" name="file"></input><br> 
		Name:
		<br>
		<input type="submit" value="Upload"> Press here to upload the file!</input>
	</form>
	
	<h6> Multiple File Upload </h6>
	<form method="POST" enctype="multipart/form-data" action="uploads">
		<br> 
		Upload File 1: <input type="file" name="file"> <br/>
		Upload File 2: <input type="file" name="file"> <br/>
		Upload File 3: <input type="file" name="file"> <br/>
		Upload File 4: <input type="file" name="file"> <br/>
		<br/>
		<br/><input type="submit" value="Upload"> 
	</form>
	
	<h3>add files</h3>
	<form method="POST" enctype="multipart/form-data" action="uploads">
		<input type="file" name="file"> <br/>
		<div id="fieldHolder"></div>
		<br>
		<input type="button" onClick="addField()" value="add file">
		<br/>
		<input type="submit" value="Upload"> 
	</form>
</body>
</html>