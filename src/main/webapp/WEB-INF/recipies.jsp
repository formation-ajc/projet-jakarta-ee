<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Display recipies</title>
<link rel="stylesheet" type="text/css"
	href="<%out.print(request.getContextPath());%>/assets/css/master.css">
<script
	src="<%out.print(request.getContextPath());%>/assets/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div>
		<div class="container">
			<div class="row d-flex">
				<c:choose>
					<c:when test="${!empty recipies }">
							<c:forEach var="recipe" items="${recipies }">
								<div class="card mt-5">
									<img class="card-img-top" src="..." alt="Card image cap">
									<div class="card-body">
										<h5 class="card-title">
											<c:out value="${recipe.name }" />
										</h5><span class="text-muted"><c:out
													value="Créée le: ${recipe.createdAt }" /></span>
										<p class="card-text">${recipe.description }</p>
										<a href="<%out.print(request.getContextPath());%>/editRecipe?idRecipe=${recipe.id}" class="btn btn-primary">Edit</a>
										<a onclick="return confirm('Êtes-vous certain de vouloir supprimer cette recette ? ')" href="<%out.print(request.getContextPath());%>/deleteRecipe?idRecipe=${recipe.id}" class="btn btn-danger">Delete</a>
									</div>
								</div>
							</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="d-flex justify-content-center ">
							<p class="alert alert-danger col-md-6 mt-5 text-center">
								<c:out value="${ result}" />
							</p>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>
