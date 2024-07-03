import java.io.Serializable;

public class Testperson implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String nachName;
    private String eMail;
    private String strasse;
    private int alter;
    private int plz;
    private String tel;
    private int hausNummer;

    public Testperson(String name, String nachname, String eMail, String strasse, int hausNummer, int plz, int alter, String tel) {
        this.name = name;
        this.nachName = nachname;
        this.eMail = eMail;
        this.strasse = strasse;
        this.alter = alter;
        this.plz = plz;
        this.tel = tel;
        this.hausNummer = hausNummer;
    }

    public Testperson() {

    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }
    public String getNachName() {
        return nachName;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }
    public String getEmail() {
        return eMail;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    public String getStrasse() {
        return strasse;
    }

    public void setHausNummer(int hausNummer) {
        this.hausNummer = hausNummer;
    }
    public int getHausNummer() {
        return hausNummer;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }
    public int getPlz() {
        return plz;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }
    public int getAlter() {
        return alter;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getTel() {
        return tel;
    }
}
