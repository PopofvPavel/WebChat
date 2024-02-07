package org.example.command;

import org.example.command.action.BanSendingMessagesCommand;
import org.example.command.action.LoginCommand;
import org.example.command.action.LogoutCommand;
import org.example.command.action.SendChatMessageCommand;
import org.example.command.show.ShowAdminPageCommand;
import org.example.command.show.ShowChatPageCommand;
import org.example.command.show.ShowLoginPageCommand;

public enum CommandType {
    EMPTY(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),

    SEND_CHAT_MESSAGE(new SendChatMessageCommand()),

    BAN_SENDING_MESSAGES(new BanSendingMessagesCommand()),

    SHOW_CHAT_PAGE(new ShowChatPageCommand()),

    SHOW_ADMIN_PAGE(new ShowAdminPageCommand()),
    SHOW_LOGIN_PAGE(new ShowLoginPageCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
