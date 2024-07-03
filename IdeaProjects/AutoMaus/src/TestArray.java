import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class TestArray {

    int testZahl;
    int zweiteTestZahl;
    String testString;
    String zweiterTestString;
    boolean testBoolean;
    char testChar;
    List<Integer> testIntArray = new ArrayList<>();
    List<String> testStringArray = new ArrayList<>();
    int[] eindimensionalArray;
    int[][] zweidimensionalArray;
    String[] eindimString;
    String[][] zweidimString;
    Testperson testperson;

    Vector<Testperson> testpersonen = new Vector<Testperson>();

    public Vector<Testperson> getTestpersonen() {
        return testpersonen;
    }
    public void setTestpersonen(Vector<Testperson> testpersonen) {
        this.testpersonen = testpersonen;
    }

    public StringBuilder personenAusgabe() {
        setTestpersonen(testpersonen);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < testpersonen.size(); i++) {
            sb.append(i + 1 + ".\n Vorname: " + testpersonen.get(i).getName() + "\n" + " Nachname: " + testpersonen.get(i).getNachName() + "\n" + " Alter: " + testpersonen.get(i).getAlter() + "\n" +
                    " E-Mail: " + testpersonen.get(i).getEmail() + "\n" + " Straße: " + testpersonen.get(i).getStrasse() + " " + testpersonen.get(i).getHausNummer() + "\n" + " PLZ: " +
                    testpersonen.get(i).getPlz() + "\n" + " Tel: " + testpersonen.get(i).getTel() + "\n" + "\n");
        }
        return sb;
    }

    public void testenEinerForSchleife() {
        for(int i = 0; i < 11; i++) {
            System.out.println("ich teste meine Erste For-Schleife: " + i);
        }
    }

    public void testenEinerForSchleife2() {
        testZahl = 50;
        for(int i = 1; i <= testZahl; i++) {
            System.out.println("ich teste meine Zweite For-Schleife: " + i);
        }
        for (int j = testZahl; j >= 1; j--) {
            System.out.println("ich teste meine Zweite For-Schleife auch rückwerts: " + j);
        }
    }

    public void testenEinerForSchleife3() {
        testZahl = 50;
        testString = "Dieser Text kommt immer nach 5 Zahlen!";
        for(int i = 1; i <= testZahl; i++) {
            System.out.println("ich teste meine Zweite For-Schleife: " + i);
            if(i == 5 || i == 10 || i == 15 || i == 20 || i == 25 || i == 30 || i == 35 || i == 40 || i == 45 || i == 50) {
                System.out.println(testString);
            }
        }
    }

    public void testenEinerForWhileSchleife() {
        testZahl = 5;
        zweiteTestZahl = 0;
        testString = "Wenn alles gut ging sollte die testzahl hier mit 5 Multipliziert werden: ";
        while (zweiteTestZahl < testZahl) {
            zweiteTestZahl++;
            addToEindimensionalArray(zweiteTestZahl);
            System.out.println(Arrays.toString(getEindimensionalArray()));
            System.out.println(testString + zweiteTestZahl * testZahl);
        }
        System.out.println();
        for(zweiteTestZahl = 1; zweiteTestZahl <= testZahl; zweiteTestZahl++) {
            addToEindimensionalArray(zweiteTestZahl);
            System.out.println(Arrays.toString(getEindimensionalArray()) + " " + testString + zweiteTestZahl * testZahl);
        }
    }

    public void spieleMitStringsUndInteger() {
        testIntArray = new ArrayList<>();
        testStringArray = new ArrayList<>();
        String eins = "Hier würde ich beginnen, ";
        String zwei = "hoffentlich bleibt die Reihenfolge gleich... ";
        String drei = "denn, hier endet es bereits!";
        int eins1 = 1;
        int zwei2 = 2;
        int drei3 = 3;
        testIntArray.add(eins1);
        testIntArray.add(zwei2);
        testIntArray.add(drei3);
        testStringArray.add(eins + zwei + drei);
        for(Integer i : testIntArray) {
            System.out.println();
            for (String a : testStringArray) {
                System.out.println(i + " " + a);
            }
        }
    }

    public void arrayFüllung() {
        int x = 10;
        for(int i = 1; i < x; i++) {
            testIntArray.add(i);
            System.out.println("hier die Zahlen die ins Array wandern: " + i);
        }
        System.out.println();
        int y = 0;
        for(int j = 9; j > y; j--) {
            testIntArray.add(y);
            System.out.println("hier nochmal rückwerts: " + j);
        }
    }

    public void mapErsteller() {
        zweidimensionalArray = new int[0][0];
        zweidimString = new String[0][0];
        for(int i : testIntArray) {
            for(int j : testIntArray) {
                zweidimensionalArray = new int[i][j];
                System.out.println(Arrays.deepToString(zweidimensionalArray));
            }
        }
    }
    public List<String> getTestStringArray() {
        return testStringArray;
    }

    public List<Integer> getTestIntArray() {
        return testIntArray;
    }

    public int[] getEindimensionalArray() {
        return eindimensionalArray;
    }
    public void setEindimensionalArray(int[] eindimensionalArray) {
        this.eindimensionalArray = eindimensionalArray;
    }
    public void addToEindimensionalArray(int i) {
        this.eindimensionalArray = new int[]{i};
    }

    public int[][] getZweidimensionalArray() {
        return zweidimensionalArray;
    }
    public void setZweidimensionalArray(int[][] zweidimensionalArray) {
        this.zweidimensionalArray = zweidimensionalArray;
    }

    public String[] getEindimString() {
        return eindimString;
    }
    public void setEindimString(String[] eindimString) {
        this.eindimString = eindimString;
    }

    public static void main(String[] args) {
        TestArray testArray = new TestArray();
        testArray.testenEinerForSchleife();
        System.out.println();
        testArray.testenEinerForSchleife2();
        System.out.println();
        testArray.testenEinerForSchleife3();
        System.out.println();
        testArray.testenEinerForWhileSchleife();
        System.out.println();
        testArray.spieleMitStringsUndInteger();
        System.out.println();
        testArray.mapErsteller();
        System.out.println();
        testArray.arrayFüllung();
        System.out.println();
        System.out.println(testArray.personenAusgabe());
    }
}