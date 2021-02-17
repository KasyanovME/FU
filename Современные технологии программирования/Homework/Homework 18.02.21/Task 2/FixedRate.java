package com.company;

public class FixedRate extends Employee{
    public final double fixedRate;
    public FixedRate (int id, double fixedRate, String name){
        super(id, name);
        this.fixedRate=fixedRate;
    }

    @Override
    public double calculator() {
        return fixedRate;
    }
}
