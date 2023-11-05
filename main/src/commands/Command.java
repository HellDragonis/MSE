package commands;

import constant.Colors;
import context.Context;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    final List<Context> contexts;
    private final String keyword;
    final String command;

    public Command(String name, List<Context> contexts, String command){
        this.contexts = contexts;
        this.keyword = name;
        this.command = command;
    }

    public abstract void run();
    public List<String> getArguments(boolean lowerCase) {
        List<String> arguments = new ArrayList<>();
        for(String s: command.split(" ")) {
            if(!s.equalsIgnoreCase(this.getKeyword())) {
                if(lowerCase) arguments.add(s.toLowerCase());
                else arguments.add(s);
            }
        }
        return arguments;
    }
    public void error(String err){
        System.out.println(Colors.ANSI_RED + "Command Error: " + this.getKeyword() + " --> " + err + Colors.currentColor);
    }
    public void feedback(String feedback){
        System.out.println(Colors.ANSI_BLUE + feedback + Colors.currentColor);
    }

    public abstract void help();

    public String getKeyword(){
        return this.keyword;
    }
}
