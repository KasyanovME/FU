package com.company;

public class HundredDispenser extends PaperCurrencyDispenser {
    public HundredDispenser() {
        super();
    }
    @Override
    public void dispense(PaperCurrency currency) {
        if (currency != null) {
            int amount = currency.getAmount();
            int remainder = amount;
            if (amount >= 100) {
                int count = amount / 100;
                remainder = amount % 100;
                System.out.printf("Разделяется на '%d' 100 \n", count);
            }
            if (remainder > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispense(new PaperCurrency(remainder));
            }
        }
    }
}
