package com.company;

public class TenDispenser extends PaperCurrencyDispenser {
    public TenDispenser() {
        super();
    }
    @Override
    public void dispense(PaperCurrency currency) {
        if (currency != null) {
            int amount = currency.getAmount();
            int remainder = amount;
            if (amount >= 10) {
                int count = amount / 10;
                remainder = amount % 10;
                System.out.printf("Разделяется на '%d' 10 \n", count);
            }
            if (remainder > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispense(new PaperCurrency(remainder));
            }
        }
    }
}
