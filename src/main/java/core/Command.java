package core;


import com.vk.api.sdk.objects.messages.Message;


import vk.VKManager;

public abstract class Command {
	//UserRepo userRepo;

    public final String name;

    public Command(String name){
        this.name = name;
    }
    
    public void exec(Message message) {	
    	int myId = 121823936;
    	if(message.getUserId() != myId)
    		//send msg to me
    		new VKManager().sendMessage(String.format("[MSG] from %d:\n%s", message.getUserId(),  message.getBody()), myId);
		//new VKManager().sendMessage(userRepo.findAll().toString(), message.getUserId());
    }

    @Override
    public String toString() {
        return String.format("name: %s",this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

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
