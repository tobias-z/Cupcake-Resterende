<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>Kvitering</title>

<body>
<c:forEach var="adminrole" items="${sessionScope.adminrole}">
    <jsp:include page="/WEB-INF/imports/AdminNav.jsp" flush="true"/>
</c:forEach>
<c:forEach var="customerrole" items="${sessionScope.customerrole}">
    <jsp:include page="/WEB-INF/imports/CustomerNav.jsp" flush="true"/>
</c:forEach>

<div class="backgroundcontainer">

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <br>
        <div>
            <h3 class="title">Your Receipt for Order: ORD00${requestScope.order.id}</h3>
            <br>
            <p>Ordre Betailt: ${requestScope.order.paid}</p>
            <p>Ordre Nummer: ORD00${requestScope.order.id}</p>
            <p>Ordre Dato: ${requestScope.order.paydate}</p>
            <p>Betalings Metode: Server Penge</p>
            <p>Total Pris ${requestScope.orderprice}</p>
            <br>

            <hr>

            <br>
            <h3>Order Summary</h3>
            <table class="comonfield1" colspan="3%" align="center" width="1000" style="top: -20px">
                <tr style="font-weight:bold">
                    <td><c:out value="#"/></td>
                    <td><c:out value="Cupcake"/></td>
                    <td><c:out value="Pris"/></td>
                </tr>

                <c:set var="count" value="0" scope="page"/>
                <c:forEach var="bucket" items="${requestScope.allcupcakes}">
                    <div style="text-align: justify">
                        <tr>
                            <c:set var="count" value="${count + 1}" scope="page"/>
                            <td><c:out value="${count}"/> </td>
                            <td><c:out value="Topping: ${bucket.cupcakeTopType} - Bottom: ${bucket.cupcakeBottomType}"/></td>
                            <td><c:out value="$${bucket.pris}"/></td>
                        </tr>
                    </div>
                    <br>
                </c:forEach>
            </table>
            <br>
            <hr>
            <br>
            <p>You can always see all of your orders at: "youruser" - Dropdown</p>
            <p>If you have any questions, feel free to drop a message to our support</p>
        </div>
        <br>
    </div>
    <div class="col-md-2"></div>
</div>

</div>



<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>
</body>
</html>
