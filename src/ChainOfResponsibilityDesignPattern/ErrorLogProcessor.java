package ChainOfResponsibilityDesignPattern;

public class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(int logLevel, String msg) {
        if(logLevel == ERROR){
            System.out.println("Error log: " + msg);
        }else {
            super.log(logLevel, msg);
        }
    }
}
