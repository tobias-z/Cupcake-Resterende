<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>${sessionScope.username}: Home</title>

<body>

<c:forEach var="adminrole" items="${sessionScope.adminrole}">
    <jsp:include page="/WEB-INF/imports/AdminNav.jsp" flush="true"/>
</c:forEach>
<c:forEach var="customerrole" items="${sessionScope.customerrole}">
    <jsp:include page="/WEB-INF/imports/CustomerNav.jsp" flush="true"/>
</c:forEach>

<div class="backgroundcontainer">
    <div class="row" style="text-align: center">
        <h2>Velkommen til Olsker Cupcakes</h2>
    </div>

    <div class="row">
        <div class="col-md-2"></div>

        <div class="col-md-8">

            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                </ol>
                <div class="carousel-inner">
                    <!-- Insert First picture here -->
                    <div class="carousel-item active">
                        <div class="thumbnail">
                            <img src="${pageContext.request.contextPath}/images/Olskerbanner.png" alt="First slide">
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="thumbnail">
                            <img src="${pageContext.request.contextPath}/images/CupcakeLogo.png" alt="cupcake1"
                                 style="height: 500px">
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
