package DesignPatterns.ChainOfResponsibilityDesignPattern;

public class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(int logLevel, String msg) {
        if(logLevel == INFO){
            System.out.println("Info log: " + msg);
        }else {
            super.log(logLevel, msg);
        }
    }
}
