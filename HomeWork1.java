package kompjuterIya.lesson080420;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        int[] array = new int[20];
        int[] newArray = new int[array.length];
        int k = 0;

        File textFile = new File("C:\\Users\\Марина\\Java\\Kolobok\\Random.txt");
        if (textFile.exists() && textFile.canRead()) {

            try {
                Scanner readFromTheFile = new Scanner(textFile);
                for (int i = 0; i < array.length; i++) {
                    if (readFromTheFile.hasNextInt()) {
                        array[i] = readFromTheFile.nextInt();
                        System.out.print(array[i] + " ");
                    }
                }

                for (int j = 0; j < array.length; j++) {
                    if (array[j] % 2 != 0) {
                        newArray[k] = array[j];
                        k++;
                    }
                }

                System.out.println();
                newArray = Arrays.copyOf(newArray, k);

                for (int i = 0; i < newArray.length; i++) {
                    System.out.print(newArray[i] + " ");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println();
            try (FileWriter writer = new FileWriter(textFile, false)) {
                String newTextOfTheFile = Arrays.toString(newArray);
                System.out.println(newTextOfTheFile);
                writer.write(newTextOfTheFile);
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}






