<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/imports/header.jsp" flush="true"/>

<title>Home</title>

<body>

<%
    if (request.getServletContext().getAttribute("notloggedin") == null) {
        request.getServletContext().setAttribute("notloggedin", "notloggedin");
    }
%>

<c:forEach var="notloggedin" items="${applicationScope.notloggedin}">
    <jsp:include page="/WEB-INF/imports/NoUserNav.jsp" flush="true"/>
</c:forEach>

<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form action="FrontController" method="post">
            <input type="hidden" name="target" value="createcupcake">
            <div class="form-group">
                <label for="Cupcaketop">Choose a cupcake top:</label>
                <select name="Cupcaketop" id="Cupcaketop">
                    <option value="Flødeskum">Flødeskum</option>
                    <option value="Glasur">Glasur</option>
                    <option value="Hindbær glacur">Hindbær glacur</option>
                    <option value="Chokolade">Chokolade</option>
                </select>
            </div>
            <div class="form-group">

                <label for="Cupcakebottom">Choose a cupcake top:</label>
                <select name="Cupcakebottom" id="Cupcakebottom">
                    <option value="Chokolade">Chokolade</option>
                    <option value="saab">Saab</option>
                    <option value="mercedes">Mercedes</option>
                    <option value="audi">Audi</option>
                </select>
            </div>

                <button type="submit" class="btn btn-primary">hello this is microsoft</button>



        </form>
    </div>
</div>

<jsp:include page="/WEB-INF/imports/footer.jsp" flush="true"/>
</body>
</html>
