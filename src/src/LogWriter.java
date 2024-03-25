package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {

    private static final String LOG_FILE = "log.txt";

    public static void writeLog(String message) {
        // Formatteur de date et d'heure
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            // Obtention de l'heure actuelle et formatage
            LocalDateTime heureActuelle = LocalDateTime.now();
            String heureFormatee = heureActuelle.format(formatter);

            // Écriture dans le fichier de journal
            bw.write(heureFormatee + " - " + message);
            bw.newLine(); // Pour passer à la ligne suivante dans le fichier
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Exemple d'utilisation
        writeLog("Action effectuée : Description de l'action.");
    }
}
