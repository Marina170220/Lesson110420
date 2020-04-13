package kompjuterIya.lesson080420;

import java.io.*;
import java.util.Scanner;

public class HomeWork4 {
    public static void main(String[] args) {

        File guberman = new File("C:\\Users\\Марина\\Java\\Kolobok\\Губерман.txt");
        if (guberman.exists() && guberman.canRead()) {
            try {
                Scanner readFromFile = new Scanner(guberman);
                while (readFromFile.hasNext()) {
                    System.out.println(readFromFile.nextLine());
                }
                readFromFile.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                FileWriter writeToFile = new FileWriter(guberman, true);
                String verse = "Не горюй, что не всюду успел,\n" + "Может, ты опоздал на «Титаник»." + "\n\t\t\tИ.Губерман";
                System.out.println(verse);
                writeToFile.write(verse);
                writeToFile.flush();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
