import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        //answerUsingArrayLists();
        answerUsingArrays();
    }

    //ArrayLists
    public static void answerUsingArrayLists() throws Exception {
        File f = new File("Official.in.txt");
        Scanner scan = new Scanner(f);
        int trials = Integer.parseInt(scan.nextLine());
        //System.out.println("Number of Trials: " + trials);
        for (int k = trials; k > 0; k--) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            int firstArraySize = Integer.parseInt(tokens[0]);
            int secondArraySize = Integer.parseInt(tokens[1]);
            //System.out.println("Array sizes are " + firstArraySize + " and " + secondArraySize);

            ArrayList<String> firstArray = new ArrayList<String>();
            for (int i = 0; i < firstArraySize; i++) {
                firstArray.add(scan.nextLine());
                //System.out.println(firstArray);
            }
            ArrayList<String> secondArray = new ArrayList<String>();
            for (int i = 0; i < secondArraySize; i++) {
                secondArray.add(scan.nextLine());
                //System.out.println(secondArray);
            }
            ArrayList<String> answers = new ArrayList<String>();
            for (int i = 0; i < firstArraySize; i++) {
                if (!secondArray.contains(firstArray.get(i))) {
                    answers.add(firstArray.get(i));
                }
            }
            Collections.sort(answers);
            System.out.println(answers);
        }
    }
    // -----------------------------------------------------------------------------------------------------------------
    //Arrays
    public static void answerUsingArrays() throws Exception {
        File f = new File("Official.in.txt");
        Scanner scan = new Scanner(f);

        int trials = Integer.parseInt(scan.nextLine());
        for (int trialCount = 0; trialCount < trials; trialCount++) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            int yardArraySize = Integer.parseInt(tokens[0]);
            int shipArraySize = Integer.parseInt(tokens[1]);

            String[] yardArray = new String[yardArraySize];
            for (int i = 0; i < yardArraySize; i++) {
                yardArray[i] = scan.nextLine();
            }

            String[] shipArray = new String[shipArraySize];
            for (int i = 0; i < shipArraySize; i++) {
                shipArray[i] = scan.nextLine();
            }

            int answersCount = 0;
            for (String yardVal : yardArray) {
                if(lackStrInArray(yardVal, shipArray)) {
                    answersCount++;
                }
            }
            String[] answers = new String[answersCount];
            int countIndex = 0;
            for (String yardVal : yardArray) {
                if (lackStrInArray(yardVal, shipArray)) {
                    answers[countIndex] = yardVal;
                    countIndex++;
                }
            }
            answers = getAlphabetizedStrArray(answers);
            //printStrArray(answers);
            altPrint(answers);
        }
    }
    public static boolean lackStrInArray(String val, String[] array) {
        for (String s : array) {
            if (s.equals(val)) {
                return false;
            }
        }
        return true;
    }

    public static String[] getAlphabetizedStrArray(String[] array) {
        int length = array.length;
        if (length <= 1) {
            return array;
        }
        String[] alphabetized = new String[length];
        for (int i = 0; i < length; i++) {
            alphabetized[i] = array[i];
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (alphabetized[j].toLowerCase().compareTo(alphabetized[i].toLowerCase()) > 0) {
                    String temp = alphabetized[j];
                    alphabetized[j] = alphabetized[i];
                    alphabetized[i] = temp;
                }
            }
        }
        return alphabetized;
    }
    public static void altPrint(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }

    public static void printStrArray(String[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length-1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[array.length - 1]);
            }
        }
        System.out.println("]");
    }
}