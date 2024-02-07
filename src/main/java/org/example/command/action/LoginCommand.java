package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        // Ваша реализация выполнения входа в Чат
        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");

        User user = DataBase.getUserByLogin(login);
        if (user == null) {
            request.getSession().setAttribute("errorLoginMessage", "Invalid login");
            return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
        }

        if (user.getPassword().equals(password)) {
            setOnlineStatus(user, request);
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);

        } else {
            request.getSession().setAttribute("errorLoginMessage", "Invalid password");
            return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);

        }


    }

    private void setOnlineStatus(User user, HttpServletRequest request) {
        user.setOnline(true);
        request.getSession().setAttribute("user", user);
    }
}
