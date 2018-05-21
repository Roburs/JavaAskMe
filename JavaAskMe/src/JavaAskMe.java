import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
    Zdecydowanie się późno za to zabrałem...
    Odczyt jest próbkowy, ale działa, nie ważne przy jakiej ilości danych.
    Zapisywanie do pliku zadań też działa... tylko, że zamiast dopisywać to nadpisuje :/
*/
class AskMe {
    public static void readFile(String name) throws IOException {
        FileReader plikIn = null;

        try {
            plikIn = new FileReader(name);
            int c;
            while ((c = plikIn.read()) != -1) {
                System.out.print((char) c);
            }
        }finally {
            if (plikIn != null) {
                plikIn.close();
            }
        }
    }

    public static void deleteFile(String name) throws IOException {
        //nie wiem, brak czasu (słaba wymówka xD)
    }


    public static void addFile(String name) throws IOException {
        PrintWriter save = new PrintWriter(name);

        Scanner act = new Scanner(System.in);
        String questName;
        String questType;
        String questWeight;
        String timeStart;
        String timeStop;
        System.out.print("Podaj nazwę zadania:\n");
        questName = act.nextLine();
        System.out.print("Podaj typ zadania:\n");
        questType = act.nextLine();
        System.out.print("Podaj wagę zadania:\n");
        questWeight = act.nextLine();
        System.out.print("Podaj czas rozpoczęcia:\n");
        timeStart = act.nextLine();
        System.out.print("Podaj czas zakończenia:\n");
        timeStop = act.nextLine();
        save.print("Nazwa zadania: " + questName+ ", Typ: " + questType + ", Waga" + questWeight
                + ", Czas rozpoczęcia: " + timeStart + ", Czas zakończenia: " + timeStop);
        save.close();
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Co chcesz zrobić?\n");
        System.out.print("Wybierz 1, jeżeli chcesz doddać zadanie\n");
        System.out.print("Wybierz 2, jeżeli chcesz wyświetlić dostępne zadania\n");
        System.out.print("Wybierz 3, jeżeli chcesz usunąć zadanie\n");

        Scanner now = new Scanner(System.in);
        int number;
        String plikTxt = "Dane.txt";
        number = now.nextInt();

        switch (number) {
            case 1:
                System.out.print("Wybrałeś 1\n");
                addFile(plikTxt);
                break;
            case 2:
                System.out.print("Wybrałeś 2\n");
                readFile(plikTxt);
                break;
            case 3:
                System.out.print("Wybrałeś 3\n");
                deleteFile(plikTxt);
                break;
        }
    }
}