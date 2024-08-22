package ChainOfResponsibilityDesignPattern;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.log(LogProcessor.ERROR, "just for error");
        logProcessor.log(LogProcessor.DEBUG, "just for debug");
        logProcessor.log(LogProcessor.INFO, "just for info");
    }
}
