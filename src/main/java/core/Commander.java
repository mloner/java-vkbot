package core;

import com.vk.api.sdk.objects.messages.Message;

public class Commander {

    /**
     * ��������� ���������, ���������� ����� ������ ���������. ����� ��� �������������� ����������.
     * @param message ��������� (������) ������������
     */
    public static void execute(Message message){
        CommandDeterminant.getCommand(CommandManager.getCommands(), message).exec(message);
    }

}
