package commands;

import context.Context;

import java.util.List;

public class Block extends Command{
    public Block(String name, List<Context> contexts, String command){
        super(name, contexts, command);
    }
    @Override
    public void run() {

    }

    @Override
    public List<String> getArguments() {
        return null;
    }

    @Override
    public void error(String err) {

    }

    @Override
    public void feedback(String feedback) {

    }

    @Override
    public void help(){

    }
}