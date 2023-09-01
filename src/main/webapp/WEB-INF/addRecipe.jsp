<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Add Games</title>
        <link rel="stylesheet" type="text/css" href="<% out.print(request.getContextPath()); %>/assets/css/master.css">
        <script src="<% out.print(request.getContextPath()); %>/assets/js/bootstrap.bundle.min.js"></script>
    </head>
<body>
	<div class="container">
		<div class="row justify-content-center" >
			<h2 class="mb-3 text-center text-light mb-3">Add Recipe</h2>
			<div class="col-md-8 border p-5 bg-light text-light rounded">
				<form action="<% out.print(request.getContextPath()); %>/addRecipe" method="POST">
					<input type="text" name="name" class="form-control mb-2" value="${recipe.name }" placeholder="nom">
					<c:if test="${!empty form.errors['name'] }">
						<p class="text-danger">${ form.errors['name']}"</p>
					</c:if>
					<textarea name="description" rows="5" class="form-control mb-2" placeholder="Ecrivez une description"><c:out value="${recipe.description }"/></textarea>
					<c:if test="${!empty form.errors['description'] }">
						<p class="text-danger">${ form.errors['description']}</p>
					</c:if>
					<div class="d-flex justify-content-end mt-3">
						<button class="btn btn-primary">Add</button>
					</div>
				</form>
			<c:if test="${!empty form.errors || !empty form.fail}">
				<p class="alert alert-danger mt-3"><c:out value="${ form.fail}"/></p>
			</c:if>
		
			<c:if test="${!empty form.success}">
				<p class="alert alert-success mt-3"><c:out value="${ form.success}"/></p>
			</c:if>
			</div>
		</div>
	</div>
</body>
</html>