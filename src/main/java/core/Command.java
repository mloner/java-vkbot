package core;


import com.vk.api.sdk.objects.messages.Message;

/**
 * Abstract class for all executable classes-commands
 * Field {@link #name} identification command,he is called by this name
 *
 * @author Arthur Kupriyanov
 * @version 1.1
 */
public abstract class Command {

    public final String name;

    public Command(String name){
        this.name = name;
    }

    /**
     * �����, ������� ����� ���������� ��� ���������� �������
     * @param message ��������� ������������
     */
    public abstract void exec(Message message);

    /**
     * ���������� ������ � �������:<br>
     * name: ����������<br>
     *
     * @return ��������������� ��� � ��� �������
     */
    @Override
    public String toString() {
        return String.format("name: %s",this.name);
    }

    /**
     * ����� ���-��� ��������� ���� {@link #name}
     *
     * @return ���-��� �������
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }


    /**
     * ������� ������������ ������, ���� ���� <code>{@link #name}</code> �����
     * ����� ���������� �������� � ������ �������� �������-����������� {@link Command}
     * @param obj ������������ ������
     * @return {@code true} ���� ������� ������������; {@code false} ���� ������� �����������
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Command){
            if (name.equals(((Command) obj).name)){
                return true;
            }
        }
        return false;
    }
}
