package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Program4 {
    public static void main(String[] args) {

        int[] array = {3, -4, 2, -3, 1, 7, -5};


        int minArrayLength = Integer.MAX_VALUE;
        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;

        for (int i = 0; i < array.length-1; i++) {

            int subArrayLenght = 1;
            int sum = array[i];

            for(int j = i+1; j < array.length; j++) {
                sum+= array[j];
                subArrayLenght++;

                if(sum == 0 && subArrayLenght < minArrayLength) {
                    minArrayLength = subArrayLenght;
                    start = i;
                    end = j;

                }

            }

        }

        int[] result = new int[(end-start) + 1];

        for(int i = 0; i < result.length ; i++) {
            result[i] = array[start++];
        }

        System.out.println(Arrays.toString(result));


        ArrayList<Object> al = new ArrayList<>();

        al.add(1);

        al.add(2.0);

        al.add("abc");

        System.out.println(al.stream().sorted().collect(Collectors.toSet()));

    }

}
