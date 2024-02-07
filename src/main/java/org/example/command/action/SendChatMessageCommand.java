package org.example.command.action;

import org.example.command.Command;
import org.example.data.ChatMessage;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.COMMAND_SHOW_LOGIN_PAGE;

public class SendChatMessageCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        var user = (User) request.getSession().getAttribute("user");
        var message = (String) request.getParameter("message");
        if (user == null) {
            return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
        }
        if (user.isBanned()) {
            request.getSession().setAttribute("bannedMessage", "You have been banned");
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
        } else {
            request.getSession().setAttribute("bannedMessage", null);
        }

        if (message != null && !message.isEmpty()) {

            DataBase.getMessages().add(new ChatMessage(message, user));
        }
        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
