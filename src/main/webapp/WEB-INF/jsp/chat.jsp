<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Чат</title>
    </head>
    <body>



    <div align="left">
        <a href="chat?command=logout">Выход</a>
    </div>

    <!-- Ссылка на блокировку пользователей (только для ADMIN) -->
    <c:if test="${user.userType eq 'ADMIN'}">
        <a href="chat?command=show_admin_page">Блокировать отправку сообщений для пользователей</a>
    </c:if>
    </div>

    </div>
        <div align="center" class="container">


            <!-- Главная страница Чата -->
            <!-- Форма для отправки сообщений -->
            <form action="chat?command=send_chat_message" method="post">
                <input type="text" id="message" name="message" placeholder="Введите ваше сообщение" required>
                <button type="submit">Отправить</button>
            </form>
           <%-- <h4>${bannedMessage}</h4>--%>
            <c:if test="${not empty bannedMessage}">
                <p>${bannedMessage}</p>
            </c:if>

            <!-- Отображение чата -->
            <div class="chat-box">
                <c:forEach var="message" items="${messages}">
                    <p>${message}</p>
                </c:forEach>
            </div>
        </div>


    </body>
</html>