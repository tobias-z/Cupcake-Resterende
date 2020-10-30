<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>Bestillingsside</title>

    <body>
    <c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
        <jsp:include page="/WEB-INF/imports/NoUserNav.jsp" flush="true"/>
    </c:forEach>
    <c:forEach var="adminrole" items="${sessionScope.adminrole}">
        <jsp:include page="/WEB-INF/imports/AdminNav.jsp" flush="true"/>
    </c:forEach>
    <c:forEach var="customerrole" items="${sessionScope.customerrole}">
        <jsp:include page="/WEB-INF/imports/CustomerNav.jsp" flush="true"/>
    </c:forEach>

    <!-- Sende cupcaketop + cupcakebottom + antal + userid til target=addcupcaketoorder -->
<div class="row">
    <div class="col-md-4">

    </div>
    <div class="col-md-4">
        <form action="FrontController" method="post">
            <input type="hidden" name="target" value="addcupcaketoorder">
            <input type="hidden" name="userid" value="${sessionScope.user.id}">
            <div class="form-group">
                <label for="Cupcaketop">Choose a cupcake top:</label>
                <select name="cupcaketop" id="Cupcaketop">
                    <c:forEach var="toppings" items="${requestScope.toppings}">
                        <option>${toppings.id}, ${toppings.type}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">

                <label for="Cupcakebottom">Choose a cupcake top:</label>
                <select name="cupcakebottom" id="Cupcakebottom">
                <c:forEach var="bottoms" items="${requestScope.bottoms}">
                    <option> ${bottoms.id}, ${bottoms.type}</option>
                </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleInputAntal">Antal</label>
                <input type="text" class="form-control" id="exampleInputAntal" name="antal" aria-describedby="AntalHelp" placeholder="Antal cupcakes" required>
            </div>
        </form>

    </div>


</div>


    <jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

    </body>
    </html>

