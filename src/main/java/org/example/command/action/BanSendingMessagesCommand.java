package org.example.command.action;

import org.example.command.Command;
import org.example.command.show.ShowChatPageCommand;
import org.example.data.DataBase;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.COMMAND_SHOW_ADMIN_PAGE;
import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.command.CommandType.SHOW_ADMIN_PAGE;

public class BanSendingMessagesCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("action");
        String login = request.getParameter("login");
        var user = DataBase.getUserByLogin(login);
        if (user != null) {
            user.setBanned(action.equals("Ban"));

        }


        return new RedirectResult(COMMAND_SHOW_ADMIN_PAGE);
    }
}
