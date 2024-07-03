import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Experimente {

    private boolean laufzeit = true;
    Scanner scanner = new Scanner(System.in);
    Testperson testperson = new Testperson();

    public Vector<Testperson> testpersonen = new Vector<Testperson>();


    public void speichern() {
        try {
            FileOutputStream fos = new FileOutputStream("personen.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(testpersonen);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void laden() {
        try {
            FileInputStream fis = new FileInputStream("personen.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            testpersonen = (Vector<Testperson>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Klasse nicht gefunden");
            c.printStackTrace();
        }
    }
    public StringBuilder personenAusgabe() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < testpersonen.size(); i++) {
            sb.append(i + 1 + ".\n Vorname: " + testpersonen.get(i).getName() + "\n" + " Nachname: " + testpersonen.get(i).getNachName() + "\n" + " Alter: " + testpersonen.get(i).getAlter() + "\n" +
                    " E-Mail: " + testpersonen.get(i).getEmail() + "\n" + " Straße: " + testpersonen.get(i).getStrasse() + " " + testpersonen.get(i).getHausNummer() + "\n" + " PLZ: " +
                    testpersonen.get(i).getPlz() + "\n" + " Tel: " + testpersonen.get(i).getTel() + "\n" + "\n");
        }
        return sb;
    }

    public boolean personenVerwaltung() {
        while (laufzeit) {
            System.out.println();
            System.out.println("Willkommen in der Personen Verwaltung");
            System.out.println("Wie möchten sie vorgehen?");
            System.out.println("Drücken sie die 1 um alle gespeicherten Personen an zu zeigen.");
            System.out.println("Drücken sie die 2 um eine neue Person an zu legen.");
            System.out.println("Drücken sie die 3 um eine Person wieder zu entfernen.");
            System.out.println("Drücken sie die 4 um das System zu beenden.");
            System.out.println();
            System.out.println("Bitte hier die entsprechende Nummer eingeben: ");
            switch (scanner.nextLine()) {
                case "1":
                    laden();
                    System.out.println(personenAusgabe());
                    break; // return würde an dieser Stelle die Schleife beenden, deswegen break und erst zum schluss return.
                case "2":
                    System.out.println("Name: ");
                    testperson.setName(scanner.nextLine());

                    System.out.println("Nachname: ");
                    testperson.setNachName(scanner.nextLine());

                    System.out.println("Alter: ");
                    testperson.setAlter(scanner.nextInt());
                    scanner.nextLine(); // Nach einem nextInt() sollte man so einen Zeilenumbruch nextLine() erstellen, um Fehler zu vermeiden.

                    System.out.println("E-Mail: ");
                    testperson.setEmail(scanner.nextLine());

                    System.out.println("Straße: ");
                    testperson.setStrasse(scanner.nextLine());

                    System.out.println("Hausnummer: ");
                    testperson.setHausNummer(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("PLZ: ");
                    testperson.setPlz(scanner.nextInt());
                    scanner.nextLine();

                    System.out.println("Telefon: ");
                    testperson.setTel(scanner.nextLine());
                    scanner.nextLine();

                    testperson = new Testperson(testperson.getName(), testperson.getNachName(), testperson.getEmail(), testperson.getStrasse(), testperson.getHausNummer(), testperson.getPlz(), testperson.getAlter(), testperson.getTel());
                    testpersonen.add(testperson);
                    speichern();
                    break;
                case "3":
                    laden();
                    System.out.println(personenAusgabe());
                    System.out.println("Welche Person soll gelöscht werden?");
                    System.out.println();
                    System.out.println("Person: ");
                    testpersonen.remove(scanner.nextInt() - 1);
                    System.out.println("Die Person "+ testperson.getName() + " wurde gelöscht!");
                    speichern();
                    break;
                case "4":
                    System.out.println("Personenverwaltungssystem wurde erfolgreich beendet.");
                    laufzeit = false;
                    break;
                default:
                    System.out.println("Das war keine gültige Eingabe!");
                    break;
            }
        }
        return laufzeit;
    }


    public static void main(String[] args) {
        Experimente experimente = new Experimente();
        experimente.personenVerwaltung();
    }
}
