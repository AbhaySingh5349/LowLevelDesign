package InterpreterDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class Context {
    Map<String, Integer> contextMap;

    public Context() {
        this.contextMap = new HashMap<>();
    }

    public void put(String key, Integer value){
        contextMap.put(key, value);
    }

    public Integer get(String key){
        return contextMap.get(key);
    }
}
