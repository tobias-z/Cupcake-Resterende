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
<c:forEach var="managemoney" items="${requestScope.managemoney}">
    <br>
    <h3 class="title">Add Money</h3>
    <form action="FrontController" method="post">
        <input type="hidden" name="target" value="formmoney">
        <input type="hidden" name="userbank" value="${sessionScope.user.bank}">
        <div class="form-group">
            <label for="InputName">Username</label>
            <input type="text" name="name" class="form-control" id="InputName" placeholder="Username">
        </div>

        <div class="form-group">
            <label for="InputMoney">Amount - $</label>
            <input type="text" name="amount" class="form-control" id="InputMoney" placeholder="$">
        </div>

        <div class="form-group">
            <button style="margin:5px;" name="moneyans" value="add" type="submit" class="btn btn-secondary">Add Money</button>
            <button style="margin:5px;" name="moneyans" value="take" type="submit" class="btn btn-secondary">Take Money</button>
        </div>
    </form>
</c:forEach>

</div>

<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

</body>
</html>
