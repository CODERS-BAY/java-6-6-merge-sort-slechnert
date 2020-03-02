package com.codersbay;

import java.util.Arrays;

public class MergeSort {


    private static int[] split(int[] array) {
        int half = (array.length) / 2;

        //zu klein, kein split
        if (array.length < 3) {
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
                    result[indexResult++] = front[indexBack++];
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
        System.out.println("Mergerinho");
        int[] numbers = new int[]{54, 26, 7, 1, 421, 5, 3241, 412, 21, 64};
        System.out.println(Arrays.toString(numbers));

        numbers = split(numbers);

        System.out.println(Arrays.toString(numbers));
    }


}
