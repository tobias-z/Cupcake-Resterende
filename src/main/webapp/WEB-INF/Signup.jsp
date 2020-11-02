<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>Opret bruger</title>

<body class="text-center">

<c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
    <jsp:include page="/WEB-INF/imports/NoUserNav.jsp" flush="true"/>
</c:forEach>

<br>

<form class="form-signin" action="FrontController" method="POST">
    <input type="hidden" name="target" value="register">
    <img class="mb-4" src="${pageContext.request.contextPath}/images/CupcakeLogo.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Opret din bruger her</h1>

    <label for="inputName" class="sr-only">Fulde navn</label>
    <input type="text" id="inputName" class="form-control" name="username" placeholder="Fulde navn" required=""
           autofocus="">

    <label for="inputEmail" class="sr-only">Email adresse</label>
    <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email adresse" required="">

    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" name="password1" placeholder="Password" required="">

    <label for="inputPassword2" class="sr-only">Gentag password</label>
    <input type="password" id="inputPassword2" class="form-control" name="password2" placeholder="Gentag password" required="">
    <button class="btn btn-lg button btn-block" style="width: 300px" type="submit">Opret</button>
    <p class="mt-5 mb-3 text-muted">© 2020-2020</p>
</form>

<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

</body>
</html>
