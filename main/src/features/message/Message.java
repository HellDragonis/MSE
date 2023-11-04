package features.message;

import features.Feature;
import features.contact.*;
import features.conversation.Conversation;
import static features.message.MessageState.*;

public class Message extends Feature {
    private final Conversation conversation;
    Contact sender;
    Contact receiver;
    MessageState state;

    public Message(Contact sender, Contact receiver, Conversation conversation){
        super("Message");
        this.conversation = conversation;
        this.sender = sender;
        this.receiver = receiver;
        this.state = sending;
    }

    public Message(String name, Contact sender, Contact receiver, Conversation conversation){
        super(name);
        this.conversation = conversation;
        this.sender = sender;
        this.receiver = receiver;
        this.state = sending;
    }

    public Contact getSender() {
        return this.sender;
    }

    public Contact getReceiver() {
        return this.receiver;
    }

    public void send(){
        //TODO send the message to the receiver user
        this.state = sent;
        this.receive();
    }

    public void receive(){
        if(this.state == sent && this.receiver.getStatus() == Status.online)
            this.state = received;
    }

    public void seen(){
        // TODO implement logic when receiver has read the message
    }

    public void delete(Contact contact) {
        if(contact.getProfile() == sender)
            this.conversation.removeMessage(this);
    }
}
