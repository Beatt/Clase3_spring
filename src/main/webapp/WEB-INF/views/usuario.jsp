<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<!-- c:choose es del core de JSP Y ES EQUIVALENTE A UN SWITCH-CASE -->
	<!--
         when es EQUIVALENTE AL CASE
         otherwise es EQUIVALENTE AL DEFAULT
     -->
	<c:choose>
		<c:when test="${not empty usuario}">

			<h1>Usuario</h1>
			<p>
				nombre:
				<c:out value="${usuario.nombre}" />
			</p>
			<p>
				email:
				<c:out value="${usuario.email}" />
			</p>

			<h2>Post del usuario</h2>

			<c:forEach var="post" items="${usuario.posts }">
				<h3>
					<c:out value="${post.titulo }"></c:out>
				</h3>
				<p>
					<c:out value="${post.contenido }"></c:out>
				</p>
			</c:forEach>

		</c:when>
		<c:otherwise>
			<h2>NO existe el usuario!!</h2>
		</c:otherwise>
	</c:choose>



</body>
</html>
