<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="memberPage.css">
    <title>Title</title>
    <style>
        .state0{
            text-decoration: line-through;
            color: gray;
        }
        .state1{

        }
        .teamTasks button{
            width: 100%;
        }

    </style>
</head>
<body>
<body>

<div class="container">
    <h2>Membre To-Do List</h2>

    <ul class="task-list">
        <c:forEach var="task" items="${tasks}"><!--boucle fiha dak depts li hya wahd l arraylist can affichiwha -->
        <li>

            <label  class="state${task.state_task}"> -  <c:out value="${task.desc_task}" /></label> <!--means element of the araylist gha wahd-->
            <!--<p> task state:    <c:out value="${task.state_task}"/> </p>
            <p> task id:    <c:out value="${task.id_task}"/> </p>-->
        </li>
        </c:forEach>
    </ul>



    <div class="teamTasks">
        <button  onclick="redirect2()"id="redirectButton">Membres Équipe</button>
    </div>
</div>
<script>
    function redirect2() {


        var tokenscnd =${token};
        var servletURl="membersServlet?tokenscnd=" + tokenscnd;
        // Redirect to the servlet
        window.location.href = servletURl;
    }
</script>

</body>

</html>
