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
<div class="backgroundcontainer">
<div class="row">
    <div class="col-md-3">

    </div>
    <div class="col-md-6">
        <table class="comonfield1" colspan="3%" align="center" width="1000">
            <tr style="font-weight:bold">
                <td><c:out value="Cupcake top"/></td>
                <td><c:out value="Cupcake bund"/></td>
                <td><c:out value="Antal"/></td>
                <td><c:out value="Pris"/></td>
                <td><c:out value="Fjern cupcake"/></td>
            </tr>
            <c:forEach var="bucket" items="${requestScope.allpreorders}">
                <form action="FrontController" method="post">
                    <input type="hidden" name="target" value="removecarid">
                    <input type="hidden" name="preordercarid" value="${requestScope.preorder.carID}">
                    <input type="hidden" name="preorderuserid" value="${requestScope.preorder.userID}">
                    <input type="hidden" name="carid" value="${bucket.id}">
                    <div style="text-align: justify">
                        <tr style="background-color: #999999; border:1px solid black">
                            <td><c:out value="${bucket.cupcakeTop}"/></td>
                            <td><c:out value="${bucket.cupcakeBottom}"/></td>
                            <td><c:out value="${bucket.antal}"/></td>
                            <td><c:out value="${bucket.pris}"/></td>
                            <td><button type="submit" class="btn btn-secondary btn-sm">Remove Item</button></td>
                        </tr>
                    </div>
                </form>
                <br>
            </c:forEach>
        </table>


            </div>

        </form>

    </div>

</div>
</div>


<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

</body>
</html>

