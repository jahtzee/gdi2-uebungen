Ubungsblatt 1 ¨
23. M¨arz 2020
Aufgabe 1: Wiederholung - Klassen und Vererbung
In der folgenden Aufgabe wollen wir das Thema Klassen und Vererbung wiederholen. Dabei soll die
folgende Klassenstruktur implementiert werden:
Person
• Jede Person hat einen Namen (String) und eine id (int). Die id soll beim Anlegen einer Person
automatisch (beginnend bei der 10000) vergeben werden. In einem Array (meineFahrzeuge)
vom Typ Fahrzeug werden die Fahrzeuge einer Person gespeichert.
• Jede Person hat eine Anzahl von Parkpl¨atzen um Fahrzeuge zu Parken. Die Menge an Parkpl¨atzen wird als double gespeichert.
• Schreiben Sie einen Konstruktor mit Parametern um eine Person mit allen Eigenschaften zu
erstellen.
• Schreiben Sie eine Methode fahrzeugeAusgeben um alle Fahrzeuge einer Person auf der Konsole
auszugeben. Greifen Sie zur Ausgabe auf das Array meineFahrzeuge zu.
• Schreiben Sie eine Methode kaufeFahrzeug, die es einer Person erm¨oglicht ein Fahrzeug zu
erwerben. Dabei ist zu beachten, dass nur Fahrzeuge erworben werden k¨onnen, falls die Person
genugend Parkpl ¨ ¨atze zur Verfugung hat. 1 Parkplatz ist die Fl ¨ ¨ache auf der 1 Auto bzw. 4
E-Bikes geparkt werden k¨onnen.
Fahrzeug
• Die Klasse Fahrzeug ist eine abstrakte Klasse.
• Schreiben Sie einen Konstruktor, um ein Fahrzeug zu erstellen.
• Fur jedes Fahrzeug wird seine Bezeichnung (String) sowie die Anzahl der R ¨ ¨ader (int) gespeichert.
• Jedes Fahrzeug soll seinem Fahrer eine Warnung anzeigen, falls der Treibstoff zu Ende geht.
Verpflichten Sie alle Unterklassen der Klasse Fahrzeug dazu, eine Methode pruefeReichweite()
zu implementieren (abstrakte Methode). In den Unterklassen von Fahrzeug soll die Methode
folgende Signatur besitzen:
public void pruefeReichweite ()
Auto
• Ein Auto ist ein Fahrzeug. Jedes Auto hat ein Kennzeichen (String) sowie einen Tankinhalt in
Litern (double).
• Schreiben Sie einen Konstruktor, der ein Auto mit all seinen Attributen erstellt. Verwenden
Sie den Oberklassenkonstruktor um die Attribute der Oberklasse zu initialisieren.
• Hat ein Auto weniger als 10 Liter im Tank, soll beim Aufruf von pruefeReichweite eine Warnung
ausgegeben werden. Sind mehr als 10 Liter im Tank soll der aktuelle Tankinhalt ausgegeben
werden.
• Schreiben Sie eine toString Methode fur die Klasse Auto. ¨
E-Bike
• Ein E-Bike ist ein Fahrzeug. Fur jedes E-Bike wird der aktuelle Ladestand in Prozent gespei- ¨
chert (double).
• Schreiben Sie einen Konstruktor, der ein E-Bike mit all seinen Attributen erstellt. Verwenden
Sie den Oberklassenkonstruktor um die von Fahrzeug geerbten Attribute zu initialisieren.
• Hat ein E-Bike einen Akkuladestand von weniger als 25.0 Prozent soll die Methode pruefeReichweite eine Warnung ausgeben.
• Es muss sichergestellt werden, dass der Ladestand immer in einem Bereich zwischen 0 und 100
liegt.
• Schreiben Sie eine toString Methode fur die Klasse E-Bike.
