<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>Home</title>

<body>

<c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
    <jsp:include page="/WEB-INF/imports/NoUserNav.jsp" flush="true"/>
</c:forEach>

<div class="backgroundcontainer">

    <div class="row">
        <h3>Opret dig som bruger her</h3>
    </div>

    <div class="row">
        <div class="col-md-8">
            <br>
            <form action="FrontController" method="POST">
                <input type="hidden" name="target" value="register">

                <div class="form-group">
                    <label for="exampleInputEmail">Fulde navn</label>
                    <input type="text" class="form-control" id="exampleInputName" name="username" aria-describedby="NameHelp" placeholder="Fulde navn" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail">Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail" name="email" aria-describedby="EmailHelp" placeholder="Email address" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password1" placeholder="Password" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">Gentag Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword2" name="password2" placeholder="Gentag password" required>
                </div>
                <a href="FrontController?target=redirect&destination=Signup">
                    <p>Er du ny? Så tryk her for at lave en ny bruger</p></a>
                <button type="submit" class="btn btn-primary btn-sm">Opret</button>
            </form>

        </div>
        <div class="col-md-4"></div>
    </div>

</div>


<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

</body>
</html>
