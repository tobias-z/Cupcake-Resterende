<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>Home</title>

<%
    if (request.getServletContext().getAttribute("notloggedin") == null) {
        request.getServletContext().setAttribute("notloggedin", "notloggedin");
    }
%>

<c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
    <jsp:include page="/WEB-INF/imports/NoUserNav.jsp" flush="true"/>
</c:forEach>

<body>
<div class="backgroundcontainer">
    <div class="row" style="text-align: center">
        <h2>Velkommen til Olsker Cupcakes</h2>
    </div>

    <div class="row">
        <div class="col-md-4"></div>

        <div class="col-md-4">

            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                </ol>
                <div class="carousel-inner" style="align-content: center">
                    <!-- Insert First picture here -->
                    <div class="carousel-item active">
                        <div class="thumbnail">
                            <img class="PictureSlide" src="${pageContext.request.contextPath}/images/CupcakeFirst.jpg" alt="First slide">
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="thumbnail">
                            <img class="PictureSlide" src="${pageContext.request.contextPath}/images/CupcakeSecond.jpg" alt="cupcake1">
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="thumbnail">
                            <img class="PictureSlide" src="${pageContext.request.contextPath}/images/CupcakeThird.jpg" alt="cupcake2">
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="thumbnail">
                            <img class="PictureSlide" src="${pageContext.request.contextPath}/images/CupcakeFourth.jpg" alt="cupcake3">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                    <br>
                </div>
            </div>

        </div>

        <div class="col-md-2"></div>
    </div>
</div>

<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>
</body>
</html>
