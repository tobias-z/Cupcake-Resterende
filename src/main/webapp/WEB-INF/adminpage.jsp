<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>${sessionScope.user.name}: Admin</title>


<c:forEach var="adminrole" items="${sessionScope.adminrole}">
    <jsp:include page="/WEB-INF/imports/AdminNav.jsp" flush="true"/>
</c:forEach>
<c:forEach var="customerrole" items="${sessionScope.customerrole}">
    <jsp:include page="/WEB-INF/imports/CustomerNav.jsp" flush="true"/>
</c:forEach>
<div class="row">

    <div class="col-md-12" style="text-align: center">

        <div class="btn-group" role="group" aria-label="Users">
            <button class="button" onclick="getUsers()">Administrer brugere</button>
        </div>

        <div class="btn-group" role="group" aria-label="Orders">
            <button class="button" onclick="getOrders()">Administrer Ordre</button>
        </div>

        <div class="btn-group" role="group" aria-label="Orders">
            <button class="button" onclick="getCupcakes()">Administrer Cupcakes</button>
        </div>

    </div>
</div>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <br>
        <div id="myUSER" style="display:none; text-align: center;">
            <br>
            <h3 class="title">Bruger valgmuligheder</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="adminoptions">
                <div class="form-group">
                    <select class="form-control" name="adminselect" id="useroptionselect">
                        <option>Vis brugere</option>
                        <option>Administrer bruger saldo</option>
                    </select>
                </div>
                <button type="submit" class="btn button" style="width: 250px">Send</button>
            </form>
        </div>

        <div id="myORDER" style="display:none; text-align: center;">
            <br>
            <h3 class="title">Ordre valgmuligheder</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="adminoptions">
                <div class="form-group">
                    <select class="form-control" name="adminselect" id="orderoptionselect">
                        <option>Vis alle ordre</option>
                    </select>
                </div>
                <button type="submit" class="btn button" style="width: 250px">Send</button>
            </form>
        </div>

        <div id="myCUPCAKE" style="display:none; text-align: center;">
            <br>
            <h3 class="title">Cupcake valgmuligheder</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="adminoptions">
                <div class="form-group">
                    <select class="form-control" name="adminselect" id="cupcakeoptionselect">
                        <option>Tilføj topping</option>
                        <option>Tilføj bund</option>
                    </select>
                </div>
                <button type="submit" class="btn button" style="width: 250px">Send</button>
            </form>
        </div>

        <!-- This is supposed to be in buttons.js but for some reason it's not loading when put in there? -->
        <script>
            function getOrders() {
                var x = document.getElementById("myORDER");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }

            function getCupcakes() {
                var x = document.getElementById("myCUPCAKE");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }

            function getUsers() {
                var x = document.getElementById("myUSER");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }
        </script>


    </div>
</div>


<!-- LAV ORDER MENU
HVIS ALLE ORDER HVIS VALGT-->


<div class="row">

    <div class="col-md-4"></div>
    <div class="col-md-4">
        <br>

        <c:forEach var="addtopping" items="${requestScope.addtopping}">
            <div style="text-align: center">
                <h3 class="title">Tilføj cupcake topping</h3>
                <form action="FrontController" method="post">
                    <input type="hidden" name="target" value="addtopping">
                    <div class="form-group">
                        <label for="InputType">Type</label>
                        <input type="text" name="type" class="form-control" id="InputType" placeholder="Type">
                    </div>

                    <div class="form-group">
                        <label for="InputPrice">Pris kr.</label>
                        <input type="number" name="amount" class="form-control" id="InputPrice" placeholder="Pris kr.">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn button">Tilføj topping</button>
                    </div>
                </form>
            </div>
        </c:forEach>

        <c:forEach var="addbottom" items="${requestScope.addbottom}">
            <div style="text-align: center">
                <h3 class="title">Tilføj cupcake bund</h3>
                <form action="FrontController" method="post">
                    <input type="hidden" name="target" value="addbottom">
                    <div class="form-group">
                        <label for="InputBottom">Type</label>
                        <input type="text" name="type" class="form-control" id="InputBottom" placeholder="Type">
                    </div>

                    <div class="form-group">
                        <label for="InputPriceBottom">Pris kr.</label>
                        <input type="number" name="amount" class="form-control" id="InputPriceBottom"
                               placeholder="Pris kr.">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn button">Tilføj bund</button>
                    </div>
                </form>
            </div>
        </c:forEach>

        <c:forEach var="allorders" items="${requestScope.allorders}">
            <div style="text-align: center">
                <p>Ordre nr. ${allorders.id} - Bruger nr. ${allorders.userId}</p>
                <p>Cupcake nr. ${allorders.cupcakes}</p>
                <p>Købt: ${allorders.paydate}</p>
                <p>Pris: ${allorders.price}</p>
                <p>Afleveret: ${allorders.delivered}</p>
            </div>
            <hr>
        </c:forEach>

        <c:forEach var="managemoney" items="${requestScope.managemoney}">
            <br>
            <div style="text-align: center">
                <h3 class="title">Administrer saldo</h3>
                <form action="FrontController" method="post">
                    <input type="hidden" name="target" value="managemoney">
                    <div class="form-group">
                        <label for="InputName">Email</label>
                        <input type="email" name="email" class="form-control" id="InputName" placeholder="email">
                    </div>

                    <div class="form-group">
                        <label for="InputMoney">Mængde - Kr.</label>
                        <input type="text" name="amount" class="form-control" id="InputMoney" placeholder="Kr.">
                    </div>

                    <div class="form-group">
                        <button style="margin:5px;" name="moneyans" value="add" type="submit" class="btn button">Tilføj
                            Penge
                        </button>
                        <button style="margin:5px;" name="moneyans" value="take" type="submit" class="btn button">
                            Træk Penge
                        </button>
                    </div>
                </form>
            </div>
        </c:forEach>

        <c:forEach var="showusers" items="${requestScope.showusers}">
            <br>
            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="showuserorders">
                <input type="hidden" name="userid" value="${showusers.id}">
                <div style="text-align: center">
                    <h3 class="title">Bruger ${showusers.id}</h3>

                    <c:out value="${showusers.name}: ${showusers.bank}"/>
                    <br>
                    <c:out value="${showusers.email}"/>
                    <br>
                    <div class="form-group">
                        <button style="margin:5px; width: 100px" name="answer" value="active" type="submit"
                                class="button-sm">Vis
                            aktive ordre
                        </button>
                        <button style="margin:5px; width: 125px" name="answer" value="closed" type="submit"
                                class="button-sm">Vis
                            afleveret ordre
                        </button>
                    </div>
                </div>
                <hr>
            </form>
        </c:forEach>

        <!-- User has no order -->
        <c:forEach var="noorder" items="${requestScope.noorder}">
            <h3 style="text-align: center">${noorder}</h3>
        </c:forEach>

        <c:forEach var="chosenuser" items="${requestScope.chosenuser.name}">
            <h3 style="text-align: center">${chosenuser}</h3>
        </c:forEach>

        <c:forEach var="order" items="${requestScope.activeorders}">
            <!-- List of all the users orders -->
            <form action="FrontController" method="post">
                <div style="text-align: center">
                    <input type="hidden" name="target" value="orderdelivered">
                    <input type="hidden" name="orderid" value="${order.order.id}">
                    <br>
                    <p>Order: ${order.order.id}</p>
                    <p>Pris: ${order.order.price}</p>
                    <p>Betalt tidspunkt: ${order.order.paydate}</p>
                    <p>${order.cupcakes}</p>
                    <button class="button-sm" style="height: 40px" type="submit">Ordre afleveret</button>
                    <hr>
                </div>
            </form>
        </c:forEach>

        <c:forEach var="order" items="${requestScope.closedorders}">
            <!-- List of all the users orders -->
                <div style="text-align: center">
                    <br>
                    <p>Order: ${order.order.id}</p>
                    <p>Pris: ${order.order.price}</p>
                    <p>Betalt tidspunkt: ${order.order.paydate}</p>
                    <p>${order.cupcakes}</p>
                    <hr>
                </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>

</body>
</html>
