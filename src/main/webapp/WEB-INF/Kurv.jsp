<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<div class="backgroundcontainer">

    <c:forEach var="nomoney" items="${requestScope.nomoney}">
        <h3 style="text-align: center; color: red">${nomoney}</h3>
    </c:forEach>

    <div class="row">
        <div class="col-md-3">

        </div>
        <div class="col-md-6">
            <table class="table" style="text-align: center">
                <thead>
                <tr style="font-weight:bold">
                    <th scope="col">#</th>
                    <th scope="col">Cupcake top</th>
                    <th scope="col">Cupcake bund</th>
                    <th scope="col">Antal</th>
                    <th scope="col">Pris</th>
                    <th scope="col">Fjern cupcake</th>
                </tr>
                </thead>
                <c:set var="count" value="0" scope="page"/>
                <c:forEach var="bucket" items="${requestScope.order.cupcakes}">
                    <form action="FrontController" method="post">
                        <input type="hidden" name="target" value="removefromorder">
                        <input type="hidden" name="cupcakeid" value="${bucket.id}">
                        <tbody>
                            <tr>
                                <c:set var="count" value="${count + 1}" scope="page"/>
                                <th scope="row">${count}</th>
                                <td>${bucket.cupcakeTopType}</td>
                                <td>${bucket.cupcakeBottomType}</td>
                                <td>${bucket.antal}</td>
                                <td>${bucket.pris}</td>
                                <td>
                                    <button type="submit" class="button-sm" style="width: auto">Slet
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </form>
                    <br>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-5">

            <div style="width: 840px;">
                <form action="FrontController" method="post">
                    <input type="hidden" name="target" value="buyorder">
                    <input type="hidden" name="userbank" value="${sessionScope.user.bank}">
                    <input type="hidden" name="userid" value="${sessionScope.user.id}">
                    <!-- Values to buy order, maybe userid -->
                    <br>
                    <h4 style="text-align: right">Pris: ${requestScope.order.price} Kr. -
                        <button type="submit" class="button" style="width: auto;">Betal ordre</button>
                    </h4>

                </form>
            </div>

        </div>
    </div>

</div>


<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

</body>
</html>

