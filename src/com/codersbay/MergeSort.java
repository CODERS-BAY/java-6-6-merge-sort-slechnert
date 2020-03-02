package com.codersbay;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {


    private static int[] split(int[] array) {
        int half = (array.length) / 2;

        //zu klein, kein split
        if (array.length < 2) {
            return array;
        }

        //split
        int[] front = new int[half];
        int[] back;

        if (array.length % 2 == 0) {
            back = new int[half];
        } else {
            back = new int[half + 1];
        }

        for (int i = 0; i < front.length; i++) {
            front[i] = array[i];
        }
        for (int j = 0; j < back.length; j++) {
            back[j] = array[front.length + j];
        }

        front = split(front);
        back = split(back);

        int[] newArray = new int[array.length];
        newArray = merge(front, back);
        return newArray;

    }

    public static int[] merge(int[] front, int[] back) {

        int indexFront = 0;
        int indexBack = 0;
        int indexResult = 0;
        int[] result = new int[front.length + back.length];

        while (indexFront < front.length || indexBack < back.length) {
            if (indexFront < front.length && indexBack < back.length) {
                if (front[indexFront] < back[indexBack]) {
                    result[indexResult++] = front[indexFront++];
                } else {
                    result[indexResult++] = back[indexBack++];
                }
            } else if (indexFront < front.length) {
                result[indexResult++] = front[indexFront++];

            } else if (indexBack < back.length) {
                result[indexResult++] = back[indexBack++];
            }
        }
        return result;
    }


    public static void main(String[] args) {


        System.out.println("How long should the array be?");
        Scanner sc = new Scanner(System.in);
        int arrayLength = sc.nextInt();

        System.out.println("What the highest possible number be?");
        Scanner sc2 = new Scanner(System.in);
        int highestRandom = sc2.nextInt();

        int myArray[] = randomArray(arrayLength, highestRandom);

        System.out.println(Arrays.toString(myArray));
        int[] output = split(myArray);
        System.out.println(Arrays.toString(output));


    }


    private static int[] randomArray(int length, int girth) {
        int[] randomArray = new int[length];
        int i = 0;
        while (i < length) {
            Random rando = new Random();
            randomArray[i] = rando.nextInt(girth + 1);
            ++i;
        }
        return randomArray;
    }
}