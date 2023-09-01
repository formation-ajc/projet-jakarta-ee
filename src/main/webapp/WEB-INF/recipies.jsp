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
	<div class="dark vh-100 vw-100 d-flex flex-column">

		<%@include file="includes/header.jsp"%>


		<div class="container overflow-auto">

			<c:if test='<%= request.getSession().getAttribute("user") != null %>'>
			<div class="d-flex w-100 mb-3">
				<a style="width: 150px" href="<%out.print(request.getContextPath());%>/addRecipe" class="btn btn-success d-flex align-items-center justify-content-center">
					<span class="material-symbols-outlined">add</span>
					New recipe
				</a>
			</div>
			</c:if>

			<div class="d-flex gap-3 flex-wrap overflow-auto">
				<c:choose>
					<c:when test="${!empty recipies }">
							<c:forEach var="recipe" items="${recipies }">
								<div style="width: 300px;" class="d-flex align-content-end flex-column justify-content-between	text-blue blue rounded-3 p-2 gap-2">
<%--									<img class="card-img-top" src="..." alt="Card image cap">--%>
									<div class="d-flex flex-column">
										<c:if test='<%= request.getSession().getAttribute("user") != null %>'>
										<div class="d-flex justify-content-end">
											<a onclick="return confirm('Êtes-vous certain de vouloir supprimer cette recette ? ')" href="<%out.print(request.getContextPath());%>/deleteRecipe?idRecipe=${recipe.id}">
												<span style="font-size: 30px" class="material-symbols-outlined text-danger">delete</span>
											</a>
										</div>
										</c:if>
										<div class="d-flex justify-content-center align-items-center p-5 ">
											<span style="height: 50px" class="material-symbols-outlined">image</span>
										</div>
										<div class="d-flex flex-column gap-1">
											<h5 class="text-white">
												<c:out value="${recipe.name }" />
											</h5><span class="text-muted text-white"><c:out
														value="Créée le: ${recipe.createdAt }" /></span>
											<div class="">${recipe.description }</div>
										</div>
									</div>
									<div class="d-flex gap-2">
										<c:if test='<%= request.getSession().getAttribute("user") != null %>'>
										<a href="<%out.print(request.getContextPath());%>/editRecipe?idRecipe=${recipe.id}" class="btn btn-success primary w-100 border-0">Edit</a>
										</c:if>
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
