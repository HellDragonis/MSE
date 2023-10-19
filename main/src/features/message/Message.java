package features.message;

import features.contact.*;

import static features.message.MessageState.*;

public class Message {
    Contact sender;
    Contact receiver;
    MessageState state;

    public Message(Contact sender, Contact receiver){
        this.sender = sender;
        this.receiver = receiver;
        this.state = sending;
        this.send();
    }

    public void send(){
        //TODO send the message to the receiver user
        this.state = sent;
    }

    public void receive(){
        if(this.state == sent && this.receiver.getStatus() == Status.online)
            this.state = received;
    }

    public void seen(){
    }
}
