package core.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import vk.VKManager;

/**
 * @author Arthur Kupriyanov
 */
public class Unknown extends Command {

    public Unknown(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
    	String answer = transformString(message.getBody());
        new VKManager().sendMessage(answer, message.getUserId());
    }
    
    public static String transformString(String str) {
    	String result = str.toUpperCase();
    	
    	String[] avalible_variantsOfQue = {"", "", "", "UE"};  
    	java.util.Random random = new java.util.Random();
    	int index = random.nextInt(avalible_variantsOfQue.length);
    	
    	result = result.replaceAll("�(�|�|�|�){0,1}\\b", "QUE" + avalible_variantsOfQue[index])
		    			.replaceAll("�", "A")
		    			.replaceAll("�", "A")
				    	.replaceAll("�", "B")
				    	.replaceAll("�", "V")
				    	.replaceAll("�", "G")
				    	.replaceAll("�", "D")
				    	.replaceAll("�", "E")
				    	.replaceAll("�", "YO")
				    	.replaceAll("�", "ZH")
				    	.replaceAll("�", "Z")
				    	.replaceAll("�", "EE")
				    	.replaceAll("�", "EE")
				    	.replaceAll("�", "K")
				    	.replaceAll("�", "L")
				    	.replaceAll("�", "M")
				    	.replaceAll("�", "N")
				    	.replaceAll("�", "O")
				    	.replaceAll("�", "P")
				    	.replaceAll("�", "R")
				    	.replaceAll("�", "S")
				    	.replaceAll("�", "T")
				    	.replaceAll("�", "U")
				    	.replaceAll("�", "F")
				    	.replaceAll("�", "H")
				    	.replaceAll("�", "TS")
				    	.replaceAll("�", "4")
				    	.replaceAll("�", "SH")
				    	.replaceAll("�", "SH'")
				    	.replaceAll("�", "'")
				    	.replaceAll("�", "'")
				    	.replaceAll("�", "Y")
				    	.replaceAll("�", "E")
				    	.replaceAll("�", "YU")
				    	.replaceAll("�", "YA");
    	return result;
    }
}





