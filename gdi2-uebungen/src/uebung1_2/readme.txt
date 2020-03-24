Aufgabe 2: Labyrinth
In der folgenden Aufgabe wollen wir ein zuf¨alliges Labyrinth erzeugen. Die folgende Grafik zeigt ein
Beispiellabyrinth der Gr¨oße 10 (10 x 10 Felder). Ein - Zeichen steht fur ein freies Feld im Labyrinth. ¨
Ein X steht fur eine Wand/Sperre, die nicht betreten bzw. ¨ uberquert werden kann. ¨
Das gegebene Labyrinth wurde in der main folgendermaßen konstruiert:
public static void main ( String [] args ) {
Labyrinth l = new Labyrinth (10) ; // erzeugt das Labyrinth ohne Sperren
l . print () ; // Ausgabe : Labyrinth ohne Sperren
l . erzeugeSperrenSimple (20) ; // 20 Sperren zum Labyrinth hinzu
l . print () ; // Ausgabe : Beispiel Labyrinth 10 x10
}
• Erstellen Sie zun¨achst die Klasse Labyrinth und schreiben Sie einen Konstruktor, der die leere
Fl¨ache des Labyrinths erzeugt. Wir verwenden hierzu das char Array plan, wie im folgenden
Codeaussschnitt zu sehen ist. Bei dem char LEER handelt es sich um das Zeichen, welches fur ¨
ein leeres Feld im Labyrinth verwendet wird.
private char [][] plan ;
private static final char LEER = ’-’;
public Labyrinth ( int groesse ) {
// toDo : Labyrinth ohne Sperren anlegen ( Mehrdimensionales char Array )
}
• Im n¨achsten Schritt soll das leere Labyrinth mit Sperren versehen werden (siehe oben: Beispiel
Labyrinth 10x10). Diese Sperren sollen zuf¨allig innerhalb des Labyrinths verteilt werden.
Zun¨achst muss bei der Verteilung der Sperren nicht darauf geachtet werden, dass an der gleichen
Position mehrere Sperren platziert werden.
private void erzeugeSperrenSimple (int anzahlSperren ) {
// toDo : Sperren zum Labyrinth hinzufuegen
}
• Implementieren Sie eine verbesserte Version von erzeugeSperrenSimple. Diese soll so konzipiert sein, dass eine Sperre nicht an einer Position platziert werden kann, an der bereits eine
Sperre platziert wurde.
private void erzeugeSperren (int anzahlSperren ) {
// toDo
}
• Implementieren Sie eine print-Methode welche das Labyrinth wie im obigen Beispiel ausgibt.
