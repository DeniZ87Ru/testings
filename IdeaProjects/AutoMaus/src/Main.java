import java.awt.*;
import java.net.URI;
import java.util.Random;

public class Main {
    public void getBrowsGoogle() {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("http://www.google.de"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws AWTException {
        Main main = new Main();
        Robot robot = new Robot();
        Random random = new Random();
        while (true) {
            robot.delay(10000); // Warte 10 Sekunden
            Point point = MouseInfo.getPointerInfo().getLocation(); // Aktuelle Mausposition abrufen
            int x = point.x + random.nextInt(100) - 50; // Zufällige X-Koordinate generieren
            int y = point.y + random.nextInt(100) - 50; // Zufällige Y-Koordinate generieren
            robot.mouseMove(x, y); // Bewege die Maus zur neuen Position
            robot.delay(2000); // Warte 2 Sekunden
        }
    }
}
