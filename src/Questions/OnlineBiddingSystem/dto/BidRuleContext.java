package Questions.OnlineBiddingSystem.dto;

import java.util.HashMap;
import java.util.Map;

public class BidRuleContext {
    private final Map<String, Object> bidRuleContextMap;

    public BidRuleContext() {
        this.bidRuleContextMap = new HashMap<>();
    }

    public void add(String key, Object value) {
        bidRuleContextMap.put(key, value);
    }

    public Object get(String key) {
        return bidRuleContextMap.get(key);
    }

    @Override
    public String toString() {
        return "BidRuleContext{" +
                "bidRuleContextMap=" + bidRuleContextMap +
                '}';
    }
}
