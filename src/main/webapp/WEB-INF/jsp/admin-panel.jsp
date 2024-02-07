<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.example.data.User" %>
<%@ page import="org.example.data.DataBase" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
</head>
<body>
<div class="table-container">
    <h1>Таблица пользователей</h1>
    <table class="data-table">
        <tr class="data-table-row">
            <th class="data-table-col">LOGIN</th>
            <th class="data-table-col">NAME</th>
            <th class="data-table-col">USER_TYPE</th>
            <th class="data-table-col">ONLINE</th>
            <th class="data-table-col">IS_BANNED</th>
            <th class="data-table-col">BAN_ACTION</th>
        </tr>
        <c:forEach var="row" items="${users}">
            <tr class="data-table-row">
                <td>${row.login}</td>
                <td>${row.name}</td>
                <td>${row.userType}</td>
                <td>${row.online}</td>
                <td>${row.banned}</td>
                <td>
                    <form action="chat?command=ban_sending_messages" method="POST">
                        <c:choose>
                            <c:when test="${row.banned}">
                                <input type="hidden" name="action" value="Razban">
                                <input type="submit" class="button" value="Разбан">
                            </c:when>
                            <c:otherwise>
                                <input type="hidden" name="action" value="Ban">
                                <input type="submit" class="button" value="Бан">
                            </c:otherwise>
                        </c:choose>
                        <input type="hidden" name="login" value="${row.login}">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div align="left">
        <a href="chat?command=show_chat_page">Назад</a>
    </div>

</div>
</body>
</html>
