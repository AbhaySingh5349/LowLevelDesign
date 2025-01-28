package Questions.Splitwise.model;

import Questions.Splitwise.enums.CurrencyType;

public class Currency {
    private final CurrencyType currencyType;
    private final String symbol;

    public Currency(CurrencyType currencyType, String symbol) {
        this.currencyType = currencyType;
        this.symbol = symbol;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public String getSymbol() {
        return symbol;
    }
}
