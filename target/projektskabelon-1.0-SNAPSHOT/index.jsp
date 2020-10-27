<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cupcake welcome page</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS START -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/normalize.css">
    <!-- Bootstrap CSS END -->

</head>
<body>
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
</body>
</html>
