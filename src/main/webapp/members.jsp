<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 19/07/2023
  Time: 01:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="equipe.css">
    <style>
        .teamTasks  button{
            width: 100%;
            padding: 8px;
            background-color:#e4a037;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .teamTasks button:hover{
            background-color: #45a049;
        }
        #redirectButton{
            margin-top: 10px;
        }

    </style>
</head>
<body>
<div class="container">
 <h2>Membres d'Equipe</h2>
    <!-- <ul class="equipe-list">
    <li>
    <li><a onclick="redirectlink()">Zouhir Zakaria</a></li>
 <li><a href="https://www.example1.com">Amoussa Yahya</a></li>
    </li>
  </ul>-->
  <ul class="equipe-list">
    <!--<p><c:out value=" ${token}"/> </p>-->
    <c:forEach var="member" items="${members}"><!--boucle fiha dak depts li hya wahd l arraylist can affichiwha -->
    <li>

        <a onclick="redirectlink(${member.id_user}) " >-  <c:out value="${member.name_user}"/> </a>
   <!-- <p> membr id:    <c:out value="${member.id_user}"/> </p>-->
    </li>
    </c:forEach>
  </ul>


  <div class="teamTasks">
    <button  id="redirectButton" onclick="homepage()" >Home page</button>
  </div>

</div>



<script>
  function redirectlink(id,name) {

    var tokenthird =${token};
    var mmbrid=id;


    var servletURl="memberPageServlet?tokenthird="+ tokenthird+"&mmbrid="+mmbrid;
    // Redirect to the servlet
    window.location.href = servletURl;
  }
  function homepage() {


    var variableName =${token};
    var servletURl="homePageServlet?variableName=" + variableName;
    // Redirect to the servlet
    window.location.href = servletURl;
  }
</script>
</body>

</html>
