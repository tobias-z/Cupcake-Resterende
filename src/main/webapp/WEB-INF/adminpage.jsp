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



                </div>
            </div>

        </div>

        <div class="col-md-2"></div>
    </div>
</div>



<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

</body>
</html>
