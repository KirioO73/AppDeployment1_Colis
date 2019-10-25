<%--
  Created by IntelliJ IDEA.
  User: quent
  Date: 09/10/2019
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Progression</title>
</head>
<body>
<p>
    Colis <br>
    id : ${colis.id} <br>
    prix : ${colis.prix} <br>
    poids : ${colis.poids} <br>
    localisation : ${colis.suivi.localisation.toString()} <br>
    etat : ${colis.suivi.getEtat().toString()} <br>
</p>

<form method="post" action="../suivi">
    <label> Colis id : </label>
    <input type="text" name="colisId" value=${colis.id} readonly>
    <label>Nouvelle position du colis</label> <br>
    <label for="lattitudeP">Lattitude : </label><input type="text" name="lattitudeP" id="lattitudeP">
    <label for="longitudeP">Longitude : </label><input type="text" name="longitudeP" id="longitudeP"> <br>
    <label for="emplacementP">Emplacement (optionnel) : </label><input type="text" name="emplacementP" id="emplacementP"> <br> <br>

    <label>Suivi du colis </label> <br>
    <input type="radio" name="etat" id="PREPARE"> Préparé <br>
    <input type="radio" name="etat" value="EXPEDIER"> Expédié<br>
    <input type="radio" name="etat" value="POINT RELAI"> En point relai<br>
    <input type="radio" name="etat" value="EN LIVRAISON"> En livraison<br>
    <input type="radio" name="etat" value="LIVRE"> Livré<br>
    <br>

    <input type="submit" value="Enregistrer" />
</form>
</body>
</html>
