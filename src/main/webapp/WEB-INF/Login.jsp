<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>Login</title>

<body>

<c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
    <jsp:include page="/WEB-INF/imports/NoUserNav.jsp" flush="true"/>
</c:forEach>

<div class="backgroundcontainer">

    <div class="row" style="margin-left: 1px">
        <h3>Velkommen til login siden <br> Her kan du skrive dit login</h3>
    </div>

    <div class="row">
        <div class="col-md-8">
            <br>
            <form action="FrontController" method="POST">
                <input type="hidden" name="target" value="login">
                <div class="form-group">
                    <label for="exampleInputEmail">Email</label>
                    <input type="email" class="form-control" id="exampleInputEmail" name="email"
                           aria-describedby="EmailHelp" placeholder="Enter Email" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="password"
                           placeholder="Password" required>
                </div>
                <a href="FrontController?target=redirect&destination=Signup">
                    <p>Er du ny? Så tryk her for at lave en ny bruger</p></a>
                <button type="submit" class="btn btn-primary btn-sm">Login</button>
                <br>
                <br>
                <br>
            </form>

        </div>
        <div class="col-md-4"></div>
    </div>

</div>


<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

</body>
</html>

