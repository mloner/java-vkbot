package core.commands;

import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.WeatherParser;
import vk.VKManager;

import java.io.IOException;

/**
 * @author Arthur Kupriyanov
 */
public class GreenText extends Command implements ServiceCommand {
    public GreenText(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
    	super.exec(message);
        new VKManager().sendMessage(transformString(message.getBody().substring(1)), message.getUserId());
    }

    @Override
    public void service() {

    }
    
    public static String transformString(String str) {
    	String result = str.trim().toUpperCase();
    	
    	String[] avalibleVariantsOfQue = {"", "", "", "UE"}; 
    	String[] avalibleVariantsOfEE = {"E", "A"};
    	
    	java.util.Random random = new java.util.Random();
    	int indexOfQue = random.nextInt(avalibleVariantsOfQue.length);
    	int indexOfEe = random.nextInt(avalibleVariantsOfEE.length);
    	
    	result = result.replaceAll("К(А|У|Е|Ю){0,1}\\b", "QUE" + avalibleVariantsOfQue[indexOfQue])
		    			.replaceAll("А", "A")
				    	.replaceAll("Б", "B")
				    	.replaceAll("В", "V")
				    	.replaceAll("Г", "G")
				    	.replaceAll("Д", "D")
				    	.replaceAll("Е", "E")
				    	.replaceAll("Ё", "YO")
				    	.replaceAll("Ж", "ZH")
				    	.replaceAll("З", "Z")
				    	.replaceAll("И", "E" + avalibleVariantsOfEE[indexOfEe])
				    	.replaceAll("Й", "EI")
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
