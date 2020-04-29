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
    	
    	result = result.replaceAll("К(А|У|Е|Ю){0,1}\\b", "QUE" + avalible_variantsOfQue[index])
		    			.replaceAll("А", "A")
				    	.replaceAll("Б", "B")
				    	.replaceAll("В", "V")
				    	.replaceAll("Г", "G")
				    	.replaceAll("Д", "D")
				    	.replaceAll("Е", "E")
				    	.replaceAll("Ё", "YO")
				    	.replaceAll("Ж", "ZH")
				    	.replaceAll("З", "Z")
				    	.replaceAll("И", "EE")
				    	.replaceAll("Й", "EE")
				    	.replaceAll("К", "K")
				    	.replaceAll("Л", "L")
				    	.replaceAll("М", "M")
				    	.replaceAll("Н", "N")
				    	.replaceAll("О", "O")
				    	.replaceAll("П", "P")
				    	.replaceAll("Р", "R")
				    	.replaceAll("С", "S")
				    	.replaceAll("Т", "T")
				    	.replaceAll("У", "U")
				    	.replaceAll("Ф", "F")
				    	.replaceAll("Х", "H")
				    	.replaceAll("Ц", "TS")
				    	.replaceAll("Ч", "4")
				    	.replaceAll("Ш", "SH")
				    	.replaceAll("Щ", "SH'")
				    	.replaceAll("Ь", "'")
				    	.replaceAll("Ъ", "'")
				    	.replaceAll("Ы", "Y")
				    	.replaceAll("Э", "E")
				    	.replaceAll("Ю", "YU")
				    	.replaceAll("Я", "YA");
    	return result;
    }
}





