<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>Login</title>

<body class="text-center">

<c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
    <jsp:include page="/WEB-INF/imports/NoUserNav.jsp" flush="true"/>
</c:forEach>

<c:forEach var="loginfailnav" items="${requestScope.notloggedin}">
    <jsp:include page="/WEB-INF/imports/NoUserNav.jsp" flush="true"/>
</c:forEach>

<c:forEach var="loginfail" items="${requestScope.loginfail}">
    <h3 style="text-align: center;">${loginfail}</h3>
</c:forEach>

<br>

<form class="form-signin" action="FrontController" method="POST">
    <input type="hidden" name="target" value="login">
    <img class="mb-4" src="${pageContext.request.contextPath}/images/CupcakeLogo.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Venligst Login</h1>

    <label for="inputEmail" class="sr-only">Email adresse</label>
    <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email adresse" required=""
           autofocus="">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required="">
    <button class="btn btn-lg button btn-block" style="width: 300px" type="submit">Login</button>
    <a href="FrontController?target=redirect&destination=Signup">
        <p>Klik her for at lave en ny bruger</p></a>
    <p class="mt-5 mb-3 text-muted">© 2020-2020</p>
</form>

<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

</body>
</html>

