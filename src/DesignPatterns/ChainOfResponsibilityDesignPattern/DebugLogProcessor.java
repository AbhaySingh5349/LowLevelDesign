package DesignPatterns.ChainOfResponsibilityDesignPattern;

public class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(int logLevel, String msg) {
        if(logLevel == DEBUG){
            System.out.println("Debug log: " + msg);
        }else {
            super.log(logLevel, msg);
        }
    }
}
