package kompjuterIya.lesson080420;

//Создать текстовый файл "Хармс", записать в него половину стихотворения.
//Создать второй текстовый файл "Хармс2", записать в него текст из первого файла.
//В первый файл дописать вторую половину стихотворения.

import java.io.*;
import java.util.Scanner;

public class HomeWork6 {
    public static void main(String[] args) {
        FileWriter writeToFile = null;
        String verse = "";

        File newTextFile = new File("C:\\Users\\Марина\\Java\\Kolobok\\Хармс.txt");
        File newTextFile2 = new File("C:\\Users\\Марина\\Java\\Kolobok\\Хармс2.txt");
        try {
            boolean create = newTextFile.createNewFile();
            boolean create2 = newTextFile2.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (newTextFile.exists() && newTextFile.canRead() && newTextFile.canWrite()) {
            try {
                writeToFile = new FileWriter(newTextFile);
                String firsPartOfVerse = "Мышь меня на чашку чая\n" + "Пригласила в новый дом.\n" + "Долго в дом не мог войти я,\n" + "Все же влез в него с трудом.\n";
                writeToFile.write(firsPartOfVerse);
                writeToFile.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (newTextFile2.exists() && newTextFile2.canRead() && newTextFile2.canWrite()) {

            try {
                Scanner readFromFirstFile = new Scanner(newTextFile);
                while (readFromFirstFile.hasNext()) {
                    verse = readFromFirstFile.nextLine();
                    System.out.println(verse);

                    try {
                        writeToFile = new FileWriter(newTextFile2, true);
                        writeToFile.write(verse + "\n");
                        writeToFile.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                readFromFirstFile.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                writeToFile = new FileWriter(newTextFile, true);
                String secondPartOfVerse = "\nА теперь вы мне скажите:\n" + "Почему и отчего\n" + "Нет ни дома и ни чая,\n" + "Нет буквально ничего!";
                writeToFile.write(secondPartOfVerse);
                writeToFile.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
