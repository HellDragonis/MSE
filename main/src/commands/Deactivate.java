package commands;

import context.Context;
import database.Features;
import features.FeatureBehavior;

import java.util.List;

public class Deactivate extends Command {
    public Deactivate(List<Context> contexts, String command){
        super("deactivate", contexts, command);
    }

    @Override
    public void run() {
        List<String> args = this.getArguments(true);
        if(args.size() < 2) {
            error("need at least 2 arguments: context/feature and then the context or feature name to activate");
        }
        String key = args.get(0);
        args.remove(0);
        if(key.equals("context")) {
            for(String arg: args) {
                int index = contexts.stream().map(Context::getName).toList().indexOf(arg);
                if(index != -1){
                    contexts.get(index).deactivate();
                }else Context.error(arg + " not found!");
            }
        }else if(key.equals("feature")){
            for(String arg: args) {
                FeatureBehavior behavior = Features.INSTANCE.get(arg);
                // TODO list alternative to check if activated and deactivate them
                if(behavior.getOptional()){
                    if(behavior.isActivated()){
                        behavior.deactivate();
                        feedback(arg + " is now deactivated." );
                    }else error(arg + " is already deactivated!");
                }else if(behavior.getMandatory()) error("Mandatory features can't be deactivated");
            }
        }else error("Not recognized argument: " + key);
    }

    @Override
    public void help(){

    }
}
