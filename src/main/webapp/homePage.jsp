<%@ page import="com.example.todolistemgproject.taskDisplay" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="cssHomePage.css">
    <title>Title</title>
    <style>
        .disc  button {
            width: 100%;
            padding: 8px;
            background-color:#e4a037;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .disc button:hover{
            background-color: #45a049;
        }
        #disco{
            margin-top: 10px;
        }
        .state0{
            text-decoration: line-through;
            color: gray;
        }
        .state1{

        }
        .container{
            position: relative;
        }
        #addButton{
            margin-bottom: -20px;
        }
        #deletetask{
            position: absolute; /* Set the button to absolute positioning */
            right: 20px;
            background-color:#e4a037;
            color: #fff;
        }
        #deletetask:hover{
            background-color: #45a049;
        }

    </style>
</head>
<body>

<!--<p><c:out value=" ${token}"/> </p>-->
<div class="container">
    <h2>My To-Do List</h2>


<!--<ul class="task-list">

        <li class="${classValue}">
            <input type="checkbox" id="task2" checked>
            <label  for="task2">Appeler John</label>
        </li>
        <li class="notcompleted">
            <input type="checkbox" id="task3" id="checkbox" onclick="toggleLabelColor()">
            <label  id="label" for="task3">Préparer la présentation</label>
        </li>
    </ul>-->

    <ul class="task-list">
        <c:forEach var="task" items="${tasks}"><!--boucle fiha dak depts li hya wahd l arraylist can affichiwha -->
        <li>
            <input type="checkbox" onclick="toggleLabel(${task.state_task},${task.id_task})">
            <label  class="state${task.state_task}">  <c:out value="${task.desc_task}" /></label>
            <button onclick="deletetask(${task.id_task},${token})"  id="deletetask">x</button>
            <!--<p> task state:    <c:out value="${task.state_task}"/> </p>
            <p> task id:    <c:out value="${task.id_task}"/> </p>-->
        </li>
        </c:forEach>
    </ul>

    <form method="post" >
    <div class="add-task">
        <input type="text" name="newTask" id="newTask" placeholder="Ajouter une nouvelle tâche">
        <button type="submit"   id="addButton">Ajouter Tâche</button>
    </div>
    </form>
    <div class="teamTasks">
        <button onclick="redirect()" id="redirectButton">Membres Équipe</button>
    </div>
    <div class="disc">
        <button onclick="deco()" id="disco">Déconnexion</button>
    </div>
</div>
<script>
    function redirect() {

        var tokenscnd =${token};
        var servletURl="membersServlet?tokenscnd=" + tokenscnd;
        // Redirect to the servlet
        window.location.href = servletURl;
    }
    function deco() {

        var servletURl="LoginServlet";
        // Redirect to the servlet
        window.location.href = servletURl;


    }
    function deletetask(id,token){
        var variableName=token;
        var idTask=id;
        var servletURl="deleteTaskServlet?idTask=" + idTask + "&variableName=" + variableName;
        window.location.href = servletURl;
    }

    function toggleLabel(state,id) {

        console.log(state);
        console.log(id);
      var statetochange =state;
      var idstatetochange=id;
        var servletURl="updatingServlet?statetochange=" + statetochange +"&idstatetochange="+ idstatetochange +"&variableName="+${token};
          // Redirect to the servlet
       window.location.href = servletURl;

    }





</script>
</body>
</html>
