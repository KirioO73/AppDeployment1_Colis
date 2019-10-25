<%--
  Created by IntelliJ IDEA.
  User: quent
  Date: 15/10/2019
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Suivi</title>
</head>
<body>
<p>
    Colis <br>
    id : ${colis.id} <br>
    prix : ${colis.prix} <br>
    poids : ${colis.poids} <br>
    localisation : ${colis.suivi.localisation.getEmplacement()} <br>
    destination : ${colis.destination.getEmplacement()} <br>
    etat : ${colis.suivi.getEtat().toString()} <br>
</p>
</body>
</html>
