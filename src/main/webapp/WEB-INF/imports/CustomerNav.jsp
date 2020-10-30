<div class="row">
    <div class="col-md-12">
        <img class="d-block w-100" src="${pageContext.request.contextPath}/images/Olskerheadergraphic.png" height="250" ; alt="Headerlogo">
    </div>
</div>
<nav class="navbar navbar-light" >
    <div class="row">
        <a href="FrontController?target=redirect&destination=index">
            <img class="navbarlogo" src="${pageContext.request.contextPath}/images/CupcakeLogo.png" style="margin-left: 20px" alt="OlskerLogo">
        </a>
        <div class="btn-group" role="group" aria-label="Main menu">
            <a class="nav-link" href="FrontController?target=redirect&destination=index" style="font-size: 20px;color: #4b4c4f">Home</a>
        </div>
        <div class="btn-group" role="group" aria-label="Bestil">
            <a class="nav-link" href="FrontController?target=redirect&destination=findcupcakes" style="font-size: 20px;color: #4b4c4f">Bestil</a>
        </div>
        <div class="btn-group" role="group" aria-label="FAQ">
            <a class="nav-link" href="#" style="font-size: 20px;color: #4b4c4f">FAQ</a>
        </div>


    </div>
    <div class ="nav-right" align="right">

        <div class="btn-group" role="group" aria-label="login">
            <button type="button" class="btn btn-secondary">${sessionScope.user.email}</button>
            <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
            </button>
            <div class="dropdown-menu">
                <button class="dropdown-item" style="text-align: center" href="#">Settings</button>
                <form action="FrontController" method="post">
                    <input type="hidden" name="target" value="getusersorders">
                    <input type="hidden" name="userid" value="${sessionScope.user.id}">
                    <button class="dropdown-item" style="text-align: center;" href="#">Orders</button>
                </form>
                <button class="dropdown-item" id="myBtn" style="text-align: center">Logout</button>
            </div>

            <a href="FrontController?target=redirect&destination=index">
                <img class="navbarlogo" src="${pageContext.request.contextPath}/images/Shoppingbasket.png" style="width: 45px; height: 50px; margin-left: 20px; margin-right: 20px" alt="Shoppingbasket">
            </a>
        </div>
    </div>

</nav>