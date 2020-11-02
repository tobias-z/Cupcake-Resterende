<div class="row">
    <div class="col-md-12">
        <img class="d-block w-100" src="${pageContext.request.contextPath}/images/Olskerheadergraphic.png" height="250"
             ; alt="Headerlogo">
    </div>
</div>
<nav class="navbar navbar-light">
    <div class="row">
        <a href="FrontController?target=redirect&destination=customerpage">
            <img class="navbarlogo" src="${pageContext.request.contextPath}/images/CupcakeLogo.png"
                 style="margin-left: 20px" alt="OlskerLogo">
        </a>
        <div class="btn-group" role="group" aria-label="Main menu">
            <a class="nav-link" href="FrontController?target=redirect&destination=customerpage"
               style="font-size: 20px;color: #4b4c4f">Home</a>
        </div>
        <div class="btn-group" role="group" aria-label="Bestil">
            <a class="nav-link" href="FrontController?target=redirect&destination=findcupcakes"
               style="font-size: 20px;color: #4b4c4f">Bestil</a>
        </div>
        <div class="btn-group" role="group" aria-label="FAQ">
            <a class="nav-link" href="#" style="font-size: 20px;color: #4b4c4f">FAQ</a>
        </div>


    </div>
    <div class="nav-right" align="right">

        <div class="btn-group" role="group" aria-label="login">
            <button type="button" class="button"
                    style="width: auto; padding-left: 20px; padding-right: 20px; text-align: center">${sessionScope.user.email} - Pung: ${sessionScope.user.bank} Kr.</button>
            <button type="button" class="button dropdown-toggle dropdown-toggle-split" style="width: 50px"
                    data-toggle="dropdown">
                <img src="${pageContext.request.contextPath}/images/dropdownArrow.png" style="height: 20px; width: 23px;" alt="DropdownArrow">
            </button>
            <div class="dropdown-menu" style="width: 300px; text-align: center">
                <button class="dropdown-item" href="FrontController?target=redirect&destination=customerpage">Settings</button>
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