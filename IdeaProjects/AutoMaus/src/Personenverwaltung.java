
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

public class Personenverwaltung {

    JFrame frame;
    JTextField name;
    JTextField nachName;
    JTextField eMail;
    JTextField strasse;
    JTextField hausNummer;
    JTextField plz;
    JTextField alter;
    JTextField tel;
    JButton personCreate;
    JButton personRemove;
    JPanel panel;
    JPanel panel1;
    JTable table;
    JScrollPane scrollPane;
    public Vector<Testperson> testPeople = new Vector<>();

    public static void main(String[] arg) {
        Personenverwaltung personenverwaltung = new Personenverwaltung();
        personenverwaltung.frame = new JFrame("Personalverwaltung");
        personenverwaltung.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        personenverwaltung.frame.setSize(800, 600);
        // Fenster in der Mitte des Bildschirms anzeigen
        personenverwaltung.frame.setLocationRelativeTo(null);

        Vector<String> columnNames = new Vector<>();
        columnNames.add("Name");
        columnNames.add("Nachname");
        columnNames.add("E-Mail");
        columnNames.add("Straße");
        columnNames.add("Hausnummer");
        columnNames.add("PLZ");
        columnNames.add("Alter");
        columnNames.add("Telefon");

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        personenverwaltung.table = new JTable(model);
        personenverwaltung.table.setSize(600, 400);
        personenverwaltung.table.setBackground(Color.black);
        personenverwaltung.table.setForeground(Color.WHITE);

        personenverwaltung.panel = new JPanel(new GridLayout(0, 1));
        personenverwaltung.scrollPane = new JScrollPane(personenverwaltung.table);
        personenverwaltung.scrollPane.setVisible(true);
        personenverwaltung.panel.add(personenverwaltung.scrollPane);

        personenverwaltung.name = new JTextField();
        personenverwaltung.nachName = new JTextField();
        personenverwaltung.eMail = new JTextField();
        personenverwaltung.strasse = new JTextField();
        personenverwaltung.hausNummer = new JTextField();
        personenverwaltung.plz = new JTextField();
        personenverwaltung.alter = new JTextField();
        personenverwaltung.tel = new JTextField();

        personenverwaltung.panel1 = new JPanel(new GridLayout(5, 2));
        personenverwaltung.panel1.add(new JLabel("Name:"));
        personenverwaltung.panel1.add(personenverwaltung.name);
        personenverwaltung.panel1.add(new JLabel("Nachname:"));
        personenverwaltung.panel1.add(personenverwaltung.nachName);
        personenverwaltung.panel1.add(new JLabel("E-Mail:"));
        personenverwaltung.panel1.add(personenverwaltung.eMail);
        personenverwaltung.panel1.add(new JLabel("Straße:"));
        personenverwaltung.panel1.add(personenverwaltung.strasse);
        personenverwaltung.panel1.add(new JLabel("Hausnummer:"));
        personenverwaltung.panel1.add(personenverwaltung.hausNummer);
        personenverwaltung.panel1.add(new JLabel("PLZ:"));
        personenverwaltung.panel1.add(personenverwaltung.plz);
        personenverwaltung.panel1.add(new JLabel("Alter:"));
        personenverwaltung.panel1.add(personenverwaltung.alter);
        personenverwaltung.panel1.add(new JLabel("Telefon:"));
        personenverwaltung.panel1.add(personenverwaltung.tel);

        personenverwaltung.personCreate = new JButton("Erstellen");
        personenverwaltung.personCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textfeldName = personenverwaltung.name.getText();
                String textfeldNachName = personenverwaltung.nachName.getText();
                String textfeldEmail = personenverwaltung.eMail.getText();
                String textfeldStrasse = personenverwaltung.strasse.getText();
                String textfeldHaus = personenverwaltung.hausNummer.getText();
                String textfeldPlz = personenverwaltung.plz.getText();
                String textfeldAlter = personenverwaltung.alter.getText();
                String textfeldTel = personenverwaltung.tel.getText();

                Testperson testperson = new Testperson(textfeldName, textfeldNachName, textfeldEmail, textfeldStrasse, Integer.parseInt(textfeldHaus), Integer.parseInt(textfeldPlz), Integer.parseInt(textfeldAlter), textfeldTel);
                personenverwaltung.testPeople.add(testperson);
                personenverwaltung.speichern();

                // Neue Zeile zur Tabelle hinzufügen
                model.addRow(new Object[]{textfeldName, textfeldNachName, textfeldEmail, textfeldStrasse, textfeldHaus, textfeldPlz, textfeldAlter, textfeldTel});

                // Optional: Felder nach dem Hinzufügen leeren
                personenverwaltung.name.setText("");
                personenverwaltung.nachName.setText("");
                personenverwaltung.eMail.setText("");
                personenverwaltung.strasse.setText("");
                personenverwaltung.hausNummer.setText("");
                personenverwaltung.plz.setText("");
                personenverwaltung.alter.setText("");
                personenverwaltung.tel.setText("");
            }
        });
        personenverwaltung.panel1.add(personenverwaltung.personCreate);

        personenverwaltung.personRemove = new JButton("Löschen");
        personenverwaltung.personRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = personenverwaltung.table.getSelectedRow();
                if (selectedRow != -1) {
                    // Eintrag aus der Liste entfernen
                    personenverwaltung.testPeople.remove(selectedRow);
                    // Tabelle aktualisieren
                    model.removeRow(selectedRow);
                    // Geänderte Liste speichern
                    personenverwaltung.speichern();
                    JOptionPane.showMessageDialog(null, "Eintrag erfolgreich gelöscht!");
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Eintrag aus der Tabelle aus.");
                }
            }
        });
        personenverwaltung.panel1.add(personenverwaltung.personRemove);

        JPanel container = new JPanel(new BorderLayout());
        container.add(personenverwaltung.panel, BorderLayout.CENTER);
        container.add(personenverwaltung.panel1, BorderLayout.SOUTH);

        personenverwaltung.frame.add(container);
        personenverwaltung.frame.setVisible(true);

        // Daten laden und Tabelle aktualisieren
        personenverwaltung.laden(model);
    }
    public void laden(DefaultTableModel model) {
        File file = new File("person.txt");
        if (!file.exists()) {
            System.out.println("Datei nicht gefunden, es wird eine neue Datei erstellt.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            testPeople = (Vector<Testperson>) ois.readObject();
            JOptionPane.showMessageDialog(null, "Daten erfolgreich geladen: " + testPeople.size() + " Personen vorhanden");

            // Tabelle aktualisieren
            for (Testperson person : testPeople) {
                model.addRow(new Object[]{
                        person.getName(),
                        person.getNachName(),
                        person.getEmail(),
                        person.getStrasse(),
                        person.getHausNummer(),
                        person.getPlz(),
                        person.getAlter(),
                        person.getTel()
                });
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Klasse nicht gefunden");
            c.printStackTrace();
        }
    }

    public void speichern() {
        try (FileOutputStream fos = new FileOutputStream("person.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(testPeople);
            JOptionPane.showMessageDialog(null, "Daten erfolgreich gespeichert: " + testPeople.size() + " Personen vorhanden");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
