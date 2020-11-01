<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>${sessionScope.user.name}: Home</title>


<c:forEach var="adminrole" items="${sessionScope.adminrole}">
    <jsp:include page="/WEB-INF/imports/AdminNav.jsp" flush="true"/>
</c:forEach>
<c:forEach var="customerrole" items="${sessionScope.customerrole}">
    <jsp:include page="/WEB-INF/imports/CustomerNav.jsp" flush="true"/>
</c:forEach>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">


        <button class="button" onclick="getUsers()">Administrer brugere</button>

        <span style="display:inline-block; width: 300px;"></span>

        <button class="button" onclick="getOrders()">Administrer Ordre</button>


    </div>
</div>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <div id="myUSER" style="display:none">
            <br>
            <h3 class="title">User Options</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="adminoptions">
                <div class="form-group">
                    <select class="form-control" name="adminselect" id="useroptionselect">
                        <option>Vis brugere</option>
                        <option>Administrer bruger saldo</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-secondary">Submit</button>
            </form>
        </div>
    </div>
</div>


<div class="row">

    <div class="col-md-4"></div>
    <div class="col-md-4">
        <c:forEach var="managemoney" items="${requestScope.managemoney}">
            <br>
            <h3 class="title">Add Money</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="managemoney">
                <div class="form-group">
                    <label for="InputName">Email</label>
                    <input type="email" name="email" class="form-control" id="InputName" placeholder="email">
                </div>

                <div class="form-group">
                    <label for="InputMoney">Amount - Kr.</label>
                    <input type="text" name="amount" class="form-control" id="InputMoney" placeholder="Kr.">
                </div>

                <div class="form-group">
                    <button style="margin:5px;" name="moneyans" value="add" type="submit" class="btn btn-primary">Tilføj
                        Penge
                    </button>
                    <button style="margin:5px;" name="moneyans" value="take" type="submit" class="btn btn-primary">
                        Træk Penge
                    </button>
                </div>
            </form>
        </c:forEach>

        <c:forEach var="showusers" items="${requestScope.showusers}">
            <br>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="showuserorders">
                <input type="hidden" name="userid" value="${showusers.id}">
                <h3 class="title">Bruger ${showusers.id}</h3>

                <c:out value="${showusers.name}: ${showusers.bank}"/>
                <br>
                <c:out value="${showusers.email}"/>
                <br>
                <button class="button-sm" type="submit">Vis bruger</button>
                <br>
            </form>
        </c:forEach>

        <!-- User has no order -->
        <c:forEach var="noorder" items="${requestScope.noorder}">
            <c:out value="${noorder}"/>
        </c:forEach>

        <c:set var="count" value="0" scope="page"/>
        <c:forEach var="cupcake" items="${requestScope.cupcakenames}">
            <c:set var="count" value="${count + 1}" scope="page"/>
            <c:out value="Cupcake ${count}: ${cupcake}"/>
        </c:forEach>

        <c:forEach var="userorders" items="${requestScope.userorders}">
            <!-- List of all the users orders -->
            <br>
            <c:out value="${userorders.cupcakeId}"/>
            <br>
            <c:out value="Betalt tidspungt: ${userorders.paydate}"/>
            <br>
            <c:out value="Pris: ${userorders.price}"/>
            <br>
        </c:forEach>
    </div>
</div>

<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

</body>
</html>
