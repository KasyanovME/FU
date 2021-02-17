package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>() {{
            add(new HourRate(1, 12.2, "Anton"));
            add(new FixedRate(2, 500, "Past"));
            add(new HourRate(3, 10, "Max"));
            add(new FixedRate(4, 600, "Artem"));
            add(new HourRate(5, 15, "Anastasia"));
            add(new FixedRate(6, 750, "Viktoria"));
        }};
        System.out.println("Вывести id, имя и зарплату для каждого работника из списка");
        for (Employee employee: employees){
            System.out.println("[" + employee.getID() + "]: " + employee.getName() + " - " + employee.calculator() + "$");
        }
    }
}
