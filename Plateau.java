public class Plateau {

    public static void main(String[] args) {
        // Prüfe, ob mindestens drei Argumente übergeben wurden
        if(args.length < 3) {
            System.out.println("ERROR: Bitte mindestens drei Argumente übergeben!");
            return;
        }

        // Kopiere die übergebenen Argumente in ein Integer-Array
        int[] numbers = new int[args.length];

        for(int i = 0; i < args.length; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }

        // Variablen zum Speichern von Index und Länge des (bisher gefundenen) längsten Plateaus
        int longestPlateauStartIndex = -1; // initial -1 -> dadurch können wir später sehen, ob überhaupt ein Plateaus gefunden wurde
        int longestPlateauLength = 0;

        // Variablen zum Speichern von Index und Länge des aktuellen Plateaus
        int currentPlateauStartIndex = -1;
        int currentPlateauLength = 0;

        // Gibt an, ob wir uns gerade auf einem Plateau befinden
        boolean currentlyOnPlateau = false;

        // Laufe über Zahlen (WICHTIG: i = 1, da wir auf numbers[i - 1] zugreifen)
        for(int i = 1; i < args.length; i++) {
            // Wenn die aktuelle Zahl größer ist als die letzte, beginnt ein neues Plateau
            if(numbers[i - 1] < numbers[i]) {
                currentlyOnPlateau = true;
                currentPlateauLength = 1;
                currentPlateauStartIndex = i;
            // Falls wir uns auf einem Plateau befinden und die aktuelle Zahl gleich der letzten ist,
            // erhöhen wir die Länge des aktuellen Plateaus
            } else if(numbers[i - 1] == numbers[i] && currentlyOnPlateau) {
                currentPlateauLength++;
            // Ist die aktuelle Zahl kleiner als die letzte, verlassen wir ein Plateau
            } else if(numbers[i - 1] > numbers[i]) {
                // Prüfe, ob das verlassene Plateau länger ist als das bisher längste
                if(currentPlateauLength > longestPlateauLength) {
                    longestPlateauLength = currentPlateauLength;
                    longestPlateauStartIndex = currentPlateauStartIndex;
                }

                currentlyOnPlateau = false;
            }
        }

        // Falls longestPlateauStartIndex noch -1 ist, wurde kein Plateau gefunden
        if(longestPlateauStartIndex == -1 ) {
            System.out.println("Kein Plateau");
        } else {
            // Gebe Index und Länge des längsten Plateaus auf der Standardausgabe aus
            System.out.println(longestPlateauStartIndex + " " + longestPlateauLength);
        }
    }
}
