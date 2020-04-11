package kompjuterIya.lesson080420;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWork3 {

    public static void main(String[] args) {
        int maxDistance = 1;
        int minDistance = 100;
        int Distance;
        int i = 0;
        int[] arrayOfX = new int[5];
        int[] arrayOfY = new int[5];

        File myFile = new File("C:\\Users\\Марина\\Java\\Kolobok\\Task3.txt");
        if (myFile.exists() && myFile.canRead()) {

            try {
                Scanner readFromFile = new Scanner(myFile);
                while (readFromFile.hasNext()) {
                    arrayOfX[i] = readFromFile.nextInt();
                    arrayOfY[i] = readFromFile.nextInt();
                    i++;
                }
                readFromFile.close();

                String str1 = Arrays.toString(arrayOfX);
                System.out.println("Массив значений X:" + str1);
                String str2 = Arrays.toString(arrayOfY);
                System.out.println("Массив значений Y:" + str2);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.print("Расстояния между точками: ");
            for (int j = 0; j < 4; j++) {
                Distance = (int) Math.pow(Math.pow((arrayOfX[j + 1] - arrayOfX[j]), 2) + Math.pow((arrayOfY[j + 1] - arrayOfY[j]), 2), 0.5);
                System.out.print(Distance + " ");
                if (Distance > maxDistance) {
                    maxDistance = Distance;
                } else if (Distance < maxDistance && Distance < minDistance) {
                    minDistance = Distance;
                }
            }
            System.out.println("\nНаибольшее расстояние между точками: " + maxDistance);
            System.out.println("Наименьшее расстояние между точками: " + minDistance);
        }
    }
}

