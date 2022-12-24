package com.company;

public class TwentyDispenser extends PaperCurrencyDispenser {
    public TwentyDispenser() {
        super();
    }
    @Override
    public void dispense(PaperCurrency currency) {
        if (currency != null) {
            int amount = currency.getAmount();
            int remainder = amount;
            if (amount >= 20) {
                int count = amount / 20;
                remainder = amount % 20;
                System.out.printf("Разделяется на '%d' 20 \n", count);
            }
            if (remainder > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispense(new PaperCurrency(remainder));
            }
        }
    }
}