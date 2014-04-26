<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

    <!--  SOLUCION EJERCICIO 1 -->
    <h2><c:out value="${post.titulo}"/></h2>
    <p>
      <c:out value="${post.contenido}"/>
    </p>


</body>
</html>
