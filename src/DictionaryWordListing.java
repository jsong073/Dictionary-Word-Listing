/*
Jaeha Song
This program should receive 10 words from a user and sort them in ascending and descending order, the print out the
words.
1. Set up variables:
    a. A String array
    b. A Scanner to receive user input
    c. A String to store user input (userInput)
    d. An int to store the array length

3. Ask the user for 10 words
    a. Use for loop and the Scanner to store 10 words in the array
2. Use bubble sorting algorithm to sort the words:
    a. The compareToIgnoreCase method returns a different value depending on where it is in the alphabet, so it can be
        used to sort words one at a time
    b. A loop is needed to cycle through each element of the original array
    c. In each iteration, the value of two adjacent array positions should be compared
        i. With the way bubble sort works, the "greatest" value is always pushed to the back. So after the loop
            completes, the word that is alphabetically last should be at the end of the loop.
    d. When the loop completes, it needs to start again to keep comparing words until no more comparisons need to be
        made. This means an outer loop is necessary.
        i. The inner loop should look like >> for (int i = 1; i < arr.length; i++);
            a. This allows the program to avoid the IndexOutOfBounds exception when used with the conditional statement
                if (arr[i] < arr[i-1]), as i will never be greater than the length of the the array, but every value is
                still compared.
        ii. The outer loop should either:
            a. continue until it detects that none of the elements in the array have been re-ordered (a while/do-while
                loop)
            b. Run the inner loop a set number of times, based on the length of the array.
3. Once the words have been sorted one way or the other, in my case ascending order, to get the descending order the
    program will print out the array in reverse
4. To get vowels, a for loop with a switch statement can be used to check if the charAt(0) is equal to a e i o u. If it
    is, then print the element at that index. The array will have been sorted by then so the printed statements don't
    have to be re-ordered.
 */

import java.util.Arrays;
import java.util.Scanner;

public class DictionaryWordListing {
    public static void main (String[] args) {
        //Variables
        Scanner sc = new Scanner(System.in);
        String[] listOfWords = new String[10];
        String userInput = "";
        int arrLength = listOfWords.length;
        String temp = "";                   //Stores an array element so it can be moved to a new slot

        //Asks the user for words, stores them in array
        System.out.println("Enter 10 words");
        for (int i = 0; i < arrLength; i++) {
            System.out.print("(" + (i + 1) + "/10): ");
            userInput = sc.nextLine();
            listOfWords[i] = userInput;
        }


        System.out.println("Original Order: ");
        for (int i = 0; i < arrLength; i++) {
            System.out.print(listOfWords[i] + " ");
        }
        System.out.println();
        System.out.println();

        /*Bubble sorts the listOfWords in ascending order alphabetically, ignoring case
          Outer loop: Runs the inner loop a number of times depending on the array length
          Inner loop: if the first element comes after the second, swap. Loop limit determined by outer loop, which
                      decreases by one to account for the fact that the last element of the array doesn't need to be
                      checked after it's been moved
        */
        for (int i = arrLength; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (listOfWords[j-1].compareToIgnoreCase(listOfWords[j]) > 0) {
                    temp = listOfWords[j-1];
                    listOfWords[j-1] = listOfWords[j];
                    listOfWords[j] = temp;
                }
            }
        }

        System.out.println("Alphabetical Order: ");
        for (int i = 0; i < arrLength; i++) {
            System.out.print(listOfWords[i] + " ");
        }
        System.out.println();
        System.out.println();

        //Reverses listOfWords array for reverse alphabetical order
        System.out.println("Reverse Alphabetical Order: ");
        for (int i = arrLength - 1; i >= 0; i--) {
            System.out.print(listOfWords[i] + " ");
        }
        System.out.println();
        System.out.println();

        //Prints out words that start with a vowel. Already alphabetically sorted because listOfWords was sorted earlier
        System.out.println("Words that start with a vowel:");
        for (int i = 0; i < arrLength; i++) {
            switch (listOfWords[i].charAt(0)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.print(listOfWords[i] + " ");
                    break;

            }
        }
    }
}
