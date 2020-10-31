<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>${sessionScope.user.name}: Home</title>

<body>

<c:forEach var="adminrole" items="${sessionScope.adminrole}">
    <jsp:include page="/WEB-INF/imports/AdminNav.jsp" flush="true"/>
</c:forEach>
<c:forEach var="customerrole" items="${sessionScope.customerrole}">
    <jsp:include page="/WEB-INF/imports/CustomerNav.jsp" flush="true"/>
</c:forEach>

<div class="backgroundcontainer">
    <div class="Titel" style="margin-left: auto; margin-right: auto; text-align: center;">
        <h2>Velkommen til Olsker Cupcakes</h2>
        <div class="info" style="font-size: 20px; font-weight: lighter">
            <br>
            <p> Her hos Olsker cupcakes laver vi super lækre cupcakes til en lav pris!</p>
            <p> De bliver lavet i vores bageri samme dag som de bliver solgt, så man er altid garanteret en dejlig frisk cupcake.</p>
            <p> Vi har nogle fantastiske bagere med mange års erfaring som virkelig kan finde ud af at bage kærligheden ind i vores cupcakes.</p>
            <p> Så hvis du har en sød tand, og kunne bruge lidt lækkert at spise så prøv en cupcake fra Olsker cupcakes du vil blive overrasket.</p>
        </div>
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
