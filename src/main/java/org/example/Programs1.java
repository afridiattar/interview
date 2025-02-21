package org.example;

import java.util.Arrays;
import java.util.function.Predicate;

public class Programs1 {
    public static void main(String[] args) {


//        *________* // 8 spaces
//        **______** // 6 spaces
//        ***____*** // 4 spaces
//        ****__**** // 2 spaces
//        ********** // 0 spaces
        int n = 5;
        for (int i = 1; i <= n; i++) {

            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= n-i; j++) {
                System.out.print("_");
            }

            for (int j = 1; j <= n-i; j++) {
                System.out.print("_");
            }


            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }


        String[] array = {"aaaaa", "java", "aa", "world", "bb", "aaa"};

        Predicate<String> p = data -> {

            char firstChar = data.charAt(0);

            for (char c : data.toCharArray()) {
                if (c != firstChar) {
                    return false;
                }
            }

          return true;
        };


        Arrays.stream(array).filter( i -> p.test(String.valueOf(i))).forEach(System.out::println);


        System.out.println();
        Arrays.stream(array).filter(word -> word.length() > 1 && (word.chars().distinct().count() ==1 )).forEach(System.out::println);
        System.out.println();
        Arrays.stream(array).filter(word -> word.length() > 1 && (word.chars().mapToObj(i -> (char) i).allMatch(i -> i == word.charAt(0)))).forEach(System.out::println);


    }
}
