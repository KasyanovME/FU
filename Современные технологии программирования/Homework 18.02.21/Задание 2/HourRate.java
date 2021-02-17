package com.company;

public class HourRate extends Employee{
    public final double hourRate;
    public HourRate(int id, double hourRate, String name){
        super(id, name);
        this.hourRate=hourRate;
    }

    @Override
    public double calculator() {
        return 20.8 * 8 * hourRate;
    }
}
