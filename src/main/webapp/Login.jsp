
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <title>Login</title>
    <style>
        p{
            color: red;
            text-align:center;
            margin-bottom: 20px;
             font-size: 16px;
            font-weight: lighter;

        }
        .visible{

        }
        .notvisible{
            display:none
        }

    </style>
</head>
<body>
<div class="logo">
    <img src="collabtechEmg.png">
</div>
<div class="container">

    <h2>Connectez-vous à votre compte</h2>
    <p class="${red}">username or password incorrect</p>
    <form  method="post">
        <div class="form-group">
            <label for="name_user">Nom d'utilisateur</label>
            <input type="text" id="name_user" name="name_user" required>
        </div>
        <div class="form-group">
            <label for="mdp_user">Mot de passe</label>
            <input type="password" id="mdp_user" name="mdp_user" required>
        </div>
        <div class="form-group">
            <button type="submit">Connexion</button>
        </div>
    </form>
</div>
</body>
</html>
