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
    	
    	result = result.replaceAll("Ê(Ó|À|Å|Þ){0,1}\\b", "QUE" + avalible_variantsOfQue[index])
		    			.replaceAll("À", "A")
		    			.replaceAll("À", "A")
				    	.replaceAll("Á", "B")
				    	.replaceAll("Â", "V")
				    	.replaceAll("Ã", "G")
				    	.replaceAll("Ä", "D")
				    	.replaceAll("Å", "E")
				    	.replaceAll("¨", "YO")
				    	.replaceAll("Æ", "ZH")
				    	.replaceAll("Ç", "Z")
				    	.replaceAll("È", "EE")
				    	.replaceAll("É", "EE")
				    	.replaceAll("Ê", "K")
				    	.replaceAll("Ë", "L")
				    	.replaceAll("Ì", "M")
				    	.replaceAll("Í", "N")
				    	.replaceAll("Î", "O")
				    	.replaceAll("Ï", "P")
				    	.replaceAll("Ð", "R")
				    	.replaceAll("Ñ", "S")
				    	.replaceAll("Ò", "T")
				    	.replaceAll("Ó", "U")
				    	.replaceAll("Ô", "F")
				    	.replaceAll("Õ", "H")
				    	.replaceAll("Ö", "TS")
				    	.replaceAll("×", "4")
				    	.replaceAll("Ø", "SH")
				    	.replaceAll("Ù", "SH'")
				    	.replaceAll("Ü", "'")
				    	.replaceAll("Ú", "'")
				    	.replaceAll("Û", "Y")
				    	.replaceAll("Ý", "E")
				    	.replaceAll("Þ", "YU")
				    	.replaceAll("ß", "YA");
    	return result;
    }
}





