<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Upload File</title>
	</head>
<body>
	<c:if test="${!empty file}">
		<p><c:out value="File ${file} (${description}) is uploaded" /></p>
	</c:if>
	<form method="post" action="upload-file" enctype="multipart/form-data">
		<p>
			<label for="description">Description: </label>
			<input type="text" name="description" id="description" />
		</p>
		
		<p>
			<label for="file">File:</label>
			<input type="file" name="file" id="file" />
		</p>
		
		<input type="submit" />
	</form>
</body>
</html>