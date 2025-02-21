package org.example;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Program5 {
    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        //String num = "MCMXCIV";
        String num = "IV";
        int sum = 0;

        for(int i = 0; i < num.length(); i++) {
            if (i == 0) {
                sum += map.get(num.charAt(i));
            } else {
                int lastNum = map.get(num.charAt(i-1));
                int currentNum = map.get(num.charAt(i));
                if (lastNum < currentNum) {
                    sum = sum + (map.get(num.charAt(i)) - (2*map.get(num.charAt(i-1))));
                } else {
                    sum += map.get(num.charAt(i));
                }
            }
        }

        System.out.println(sum);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate pastData = LocalDate.parse("10/03/2024", format);
        Period period = Period.between(pastData, LocalDate.now());
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

    }
}
