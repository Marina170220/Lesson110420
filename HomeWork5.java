package kompjuterIya.lesson080420;

import java.io.*;

public class HomeWork5 {
    public static void main(String[] args) {
        int r = 0;
        FileReader readFromFile = null;
        FileWriter writeToFile;

        File filatov = new File("C:\\Users\\Марина\\Java\\Kolobok\\Filatov.txt");
        try {
            boolean fileIsCreated = filatov.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (filatov.exists() && filatov.canRead() && filatov.canWrite()) {
            try {
                writeToFile = new FileWriter(filatov, false);
                String verse = "Может это прозвучит \n" + "Резко, \n" + "Может это прозвучит \n" + "Дерзко, \n" + "Но в театр я хожу \n" + "Редко, \n" + "А Таганку не люблю \n" + "С детства. \n" + "\n";
                writeToFile.write(verse);
                writeToFile.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                readFromFile = new FileReader(filatov);

                while ((r = readFromFile.read()) != -1) {
                    System.out.print((char) r);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                writeToFile = new FileWriter(filatov, true);
                String verse2 = "Можно Лермонтова знать\n" + "Плохо,\n" + "Можно Фета пролистать\n" + "Вкратце,\n" + "Можно вовсе не читать\n" + "Блока,\n" + "Но... всему же есть предел,\n" + "Братцы!";
                writeToFile.write(verse2);
                writeToFile.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (true) {
                try {
                    if (!((r = readFromFile.read()) != -1)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print((char) r);

            }
        }
    }
}
