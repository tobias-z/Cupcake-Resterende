<div class="row">
    <div class="col-md-12">
        <img class="d-block w-100" src="${pageContext.request.contextPath}/images/Olskerheadergraphic.png" height="250" ; alt="Headerlogo">
    </div>
</div>
<nav class="navbar navbar-light" style="background-color: #ECEEEF; padding: 10px; margin:20px 20px 30px">
    <div class="row">
        <a href="FrontController?target=redirect&destination=customerpage">
            <img class="navbarlogo" src="${pageContext.request.contextPath}/images/CupcakeLogo.png" style="margin-left: 20px" alt="OlskerLogo">
        </a>
        <div class="btn-group" role="group" aria-label="Main menu">
            <a class="nav-link" href="FrontController?target=redirect&destination=customerpage">Home</a>
        </div>
        <div class="btn-group" role="group" aria-label="Bestil">
            <a class="nav-link" href="FrontController?target=redirect&destination=findcupcakes">Bestil</a>
        </div>
        <div class="btn-group" role="group" aria-label="FAQ">
            <a class="nav-link" href="#">FAQ</a>
        </div>
        <div class="btn-group" role="group" aria-label="Adminpage">
            <a class="nav-link" href="FrontController?target=redirect&destination=adminpage">Adminpage</a>
        </div>

    </div>
    <div class ="nav-right" align="right">

        <div class="btn-group" role="group" aria-label="login">
            <button id="btnGroupDrop1" type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${sessionScope.user.email} - Pung: ${sessionScope.user.bank} Kr.
            </button>
            <div class="dropdown-menu w-75" aria-labelledby="btnGroupDrop1" style="text-align: center">
                <button class="dropdown-item">Settings</button>
                <a class="dropdown-item" href="FrontController?target=redirect&destination=findkurv">Orders</a>
                <button class="dropdown-item" id="myBtn">Logout</button>
            </div>

            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div id="myModal" class="modal">
                        <div class="modal-content">
                            <span class="close">&times;</span>
                            <h4 class="form-text">Vil du gerne gemme din ordre?</h4>
                            <form action="FrontController" method="post">
                                <input type="hidden" name="target" value="logoutuser">
                                <input type="hidden" name="userid" value="${sessionScope.user.id}">
                                <br>
                                <br>
                                <div style="text-align: center">
                                    <button style="margin:5px;" name="logoutans" value="Yes" type="submit"
                                            class="button-sm">Ja
                                    </button>
                                    <button style="margin:5px;" name="logoutans" value="No" type="submit"
                                            class="button-sm">Nej
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <a href="FrontController?target=redirect&destination=findkurv">
                <img class="navbarlogo" src="${pageContext.request.contextPath}/images/Shoppingbasket.png"
                     style="width: 45px; height: 50px; margin-left: 20px; margin-right: 20px" alt="Shoppingbasket">
            </a>

        </div>
    </div>

</nav>