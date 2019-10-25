<%--
  Created by IntelliJ IDEA.
  User: quent
  Date: 07/10/2019
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enregistrement</title>
</head>
<body>
    <form method="post" action="enregistrement">
        <label> Origine</label> <br>
        <label for="lattitudeO">Lattitude : </label><input type="text" name="lattitudeO" id="lattitudeO">
        <label for="longitudeO">Longitude : </label><input type="text" name="longitudeO" id="longitudeO"> <br>
        <label for="emplacementO">Emplacement (optionnel) : </label><input type="text" name="emplacementO" id="emplacementO"> <br> <br>

        <label> Destination</label> <br>
        <label for="lattitudeD">Lattitude : </label><input type="text" name="lattitudeD" id="lattitudeD">
        <label for="longitudeD">Longitude : </label><input type="text" name="longitudeD" id="longitudeD"> <br>
        <label for="emplacementD">Emplacement (optionnel) : </label><input type="text" name="emplacementD" id="emplacementD"> <br> <br>

        <label for="prix">Prix : </label>
        <input type="text" name="prix" id="prix" /> <br>

        <label for="poids">Poids : </label>
        <input type="text" name="poids" id="poids" /> <br>

        <input type="submit" value="Enregistrer" />
    </form>
</body>
</html>
