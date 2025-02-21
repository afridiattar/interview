package org.example;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program2 {
    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1,1,1,4,2,3,5,3,6,4,10,11,2);


        Set<Integer> set = new HashSet<>();

        list.stream().filter(i -> !set.add(i)).distinct().forEach(System.out::println);


        List<Integer> list2 = Arrays.asList(10,11,23,14,51,16,101);

        list2.stream().map(String::valueOf).filter(value -> value.startsWith("1")).forEach(System.out::println);
        System.out.println();
        list2.stream().map(String::valueOf).filter(value -> value.charAt(0) == '1').forEach(System.out::println);


//        John -> 3
//        Jake -> 2
//        Amit -> 1

        System.out.println();
        List<String> names = Arrays.asList("John", "Jake", "Jake", "John", "John", "Amit");

        names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.println(e.getKey()+ " -> "+e.getValue()));

        names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .forEach(System.out::println);

        System.out.println();

        //9,9,-1,8,6,8,-1


        int[] array2 = {5,2,9,7,4,6,8};

        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = array2.length - 1; i >= 0; i--) {
            // If stack is not empty and top of the stack is greater than the current element, replace it with the top of the stack
            if (!stack.isEmpty() && stack.peek() > array2[i]) {
                array2[i] = stack.peek();
                stack.push(array2[i]);
            } else {
                // If no greater element is found, replace it with -1
                stack.push(array2[i]);
                array2[i] = -1;
            }

            // Push the current element onto the stack for future comparisons
        }

        System.out.println(Arrays.toString(array2));

        Thread t1 = new Thread(() -> {
            System.out.println("1");
        });

        check();

        t1.run();
        t1.run();
        t1.start();
        t1.start();




    }

    public static void check() {
        int[] array = {5,2,9,7,4,6,8};
        int n = array.length;
        Stack<Integer> stack = new Stack<>();


        for (int i = n - 1; i >= 0; i--) {
            // Pop elements smaller than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }

            // If the stack is not empty, the top element is the next greatest element
            if (!stack.isEmpty()) {
                int element = stack.peek();
                stack.push(array[i]);
                array[i] = element;
            } else {
                // If the stack is empty, there is no greater element, set -1
                stack.push(array[i]);
                array[i] = -1;
            }

            // Push the current element onto the stack
        }
        System.out.println("===============================");
        System.out.println(Arrays.toString(array));
        System.out.println("===============================");





    }
}
