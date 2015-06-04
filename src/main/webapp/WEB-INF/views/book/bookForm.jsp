<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
	<title>
		Book
	</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
</head>
<body>
<c:url var="actionUrl" value="save" />

<form:form id="bookForm" commandName="book" method="post"
       action="${actionUrl }" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="name">Name</label>
              <form:input path="name" placeholder="Book Name" />
          </div>
         
          <div class="pure-control-group">
              <label for="price">Price</label>
              <form:input path="price" placeholder="Price" maxlength="10" />
          </div>
          <div class="pure-control-group">
              <label for="authors">Author</label>
              <form:input path="author" placeholder="Author" />
          </div>
          
          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>
</body>
</html>