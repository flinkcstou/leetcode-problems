package com.example.leetcodeproblems;

import com.example.leetcodeproblems.array.DVD;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeetcodeProblemsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void writingItems() {

        DVD incrediblesDVD = new DVD("The Incredibles", 2004, "Brad Bird");
        DVD findingDoryDVD = new DVD("Finding Dory", 2016, "Andrew Stanton");
        DVD lionKingDVD = new DVD("The Lion King", 2019, "Jon Favreau");

        DVD[] dvds = new DVD[15];
        dvds[3] = incrediblesDVD;
        dvds[4] = findingDoryDVD;
        dvds[5] = lionKingDVD;

    }

    @Test
    void writeAndReadSquareNumber() {
        int[] squareNumbers = new int[15];

        for (int i = 0; i < squareNumbers.length; i++) {

            int square = (i + 1) * (i + 1);
            squareNumbers[i] = square;
        }

        for (int i = 0; i < squareNumbers.length; i++) {

            System.out.println(squareNumbers[i]);
        }

    }

    @Test
    void getLengthAndCapacity() {

        int[] array = new int[10];

        int length = 0;
        for (int i = 0; i < 3; i++) {
            array[i] = i + 1;
            length++;
        }
        System.out.println("The Array has a length of " + length);
        System.out.println("The Array has a capacity of " + array.length);
    }



}
