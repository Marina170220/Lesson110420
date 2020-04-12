package kompjuterIya.lesson080420;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class HomeWork2 {
    public static void main(String[] args) {
        int[] arrayOfRandomNumbers = new int[10];
        Random number = new Random();

        File randomNumbers = new File("C:\\Users\\Марина\\Java\\Kolobok\\Random numbers.txt");
        try {
            boolean created = randomNumbers.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
      
            for (int i = 0; i < arrayOfRandomNumbers.length; i++) {
                arrayOfRandomNumbers[i] = number.nextInt(20);
                System.out.print(arrayOfRandomNumbers[i] + " ");
                
            System.out.println();
            Arrays.sort(arrayOfRandomNumbers);
                
            for (int i = 0; i < arrayOfRandomNumbers.length; i++) {
                System.out.print(arrayOfRandomNumbers[i] + " ");
            }
       
        try (FileWriter writer = new FileWriter(randomNumbers, false)) {
            String newTextOfTheFile = Arrays.toString(arrayOfRandomNumbers);
            System.out.println("\n"+newTextOfTheFile);
            writer.write(newTextOfTheFile);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}






