package core;

import com.vk.api.sdk.objects.messages.Message;

import core.commands.GreenText;
import core.commands.Unknown;

import java.util.Collection;

/**
 * ќпредел¤ет команду
 *
 * @author јртур  упри¤нов
 * @version 1.1.0
 */
public class CommandDeterminant {

	
    public static Command getCommand(Collection<Command> commands, Message message) {
        String body = message.getBody();

        for (Command command : commands) {
        		if(body.startsWith(">"))
        			return new GreenText("green text");
        	
                if (command.name.equals(body.split(" ")[0])) {
                    return command;
                }
        }
        return new Unknown("unknown");
    }

}
