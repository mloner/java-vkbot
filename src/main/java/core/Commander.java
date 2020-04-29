package core;

import com.vk.api.sdk.objects.messages.Message;

public class Commander {

    /**
     * ќбработка сообщений, получаемых через сервис ¬контакте. »меет р¤д дополнительной информации.
     * @param message сообщение (запрос) пользовател¤
     */
    public static void execute(Message message){
        CommandDeterminant.getCommand(CommandManager.getCommands(), message).exec(message);
    }

}
