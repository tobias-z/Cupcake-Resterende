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
            <table class="comonfield1" colspan="3%" align="center" width="1000">
                <tr style="font-weight:bold">
                    <td><c:out value="#"/></td>
                    <td><c:out value="Cupcake top"/></td>
                    <td><c:out value="Cupcake bund"/></td>
                    <td><c:out value="Antal"/></td>
                    <td><c:out value="Pris"/></td>
                    <td><c:out value="TBA (Fjern cupcake)"/></td>
                </tr>

                <c:set var="count" value="0" scope="page"/>
                <c:forEach var="bucket" items="${requestScope.allcupcakes}">
                    <form action="FrontController" method="post">
                        <input type="hidden" name="target" value="removefromorder">
                        <input type="hidden" name="allcupcakes" value="${requestScope.order.cupcakeId}">
                        <input type="hidden" name="userid" value="${sessionScope.user.id}">
                        <input type="hidden" name="cupcakeid" value="${bucket.id}">
                        <input type="hidden" name="cupcakeprice" value="${bucket.pris}">
                        <div style="text-align: justify">
                            <tr style="background-color: #999999; border:1px solid black">
                                <c:set var="count" value="${count + 1}" scope="page"/>
                                <td><c:out value="${count}"/></td>
                                <td><c:out value="${bucket.cupcakeTopType}"/></td>
                                <td><c:out value="${bucket.cupcakeBottomType}"/></td>
                                <td><c:out value="${bucket.antal}"/></td>
                                <td><c:out value="${bucket.pris}"/></td>
                                <td>
                                    <button type="submit" class="button-sm" style="width: auto">Slet (Ikke færdig)
                                    </button>
                                </td>
                            </tr>
                        </div>
                    </form>
                    <br>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">

            <div style="width: 1000px;">
                <form action="FrontController" method="post">
                    <input type="hidden" name="target" value="buyorder">
                    <input type="hidden" name="userbank" value="${sessionScope.user.bank}">
                    <input type="hidden" name="orderprice" value="${requestScope.orderprice}">
                    <input type="hidden" name="userid" value="${sessionScope.user.id}">
                    <!-- Values to buy order, maybe userid -->
                    <br>
                    <h4 style="text-align: right">Pris: ${requestScope.orderprice} Kr. -
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

