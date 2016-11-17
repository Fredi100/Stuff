package pokimon;

import pokimon.pokemon.Bulbasaur;
import pokimon.pokemon.Pokemon;

public class ToDo {
	
	public static void main(String[] args) {
		Pokemon p = new Bulbasaur();
		
		System.out.println(p.attack);
	}
	
	/*
	 * TODO
	 * Welt besteht aus einzelnen Tiles
	 *  -> 3D Array (x,y) z als Höhe zum Stapeln von Tiles
	 *  Das Array beinhaltet jeweils nur Pointer zu dem jeweiligen Tile um weniger Objekte zu haben
	 *  
	 *  Beispiel:
	 *  	Wasser Tile ganz unten, darauf ein Land Tile, darauf ein Tile für kleinere Objekte,
	 *  	darauf das Charakter Tile, und darauf dann Objekt die den Charakter verdecken k?nnen
	 *  
	 *  Gehdaten
	 *  -> 2D Array (x,y)
	 *  Basiert auf den Koordinaten des Welt Arrays und legt die GehDaten der jeweiligen f?r
	 *  jedes Tile fest. Besteht nur aus Enums, die beim gehen abgefragt werden.
	 *  
	 *  Scriptdaten:
	 *  -> 2D Array (x,y)
	 *  Basiert auf den Koordinaten des Welt Arrays und legt Script Trigger fest.
	 *  So soll an einer bestimmten Stelle auf der Karte ein Trigger f?r ein Script liegen,
	 *  damit dieses ausgef?hrt wird, sobald der Spieler darauf tritt.
	 *  
	 *  Scripte:
	 *  Scripte sollten dann bevorzugt in einer Script Sprache geschrieben werden, damit
	 *  diese leichert erstellt werden k?nnen. Festen Code zu verbauen w?re schlecht.
	 *  Diese scripte rufen dann in der Engine einfach nur bestehende Commandos auf.
	 *  
	 *  Command:
	 *  Jegliche Interaktion, Bewegung, und alle anderen Aktionen sind Command basiert.
	 *  So gibt es ein Command, welches dann auf ein Objekt ausgeführt wird, dass dann
	 *  diesen Command ausführt. Gibt mehrere Ans?tze. Command, die das zu bearbeitende
	 *  Objekt entgegen nehmen, oder Commands, die bei den Objekten festgelegt sind.
	 *  
	 *  Tile:
	 *  Tiles sind die Grafischen Bausteine. So soll es mehrere Tilesets geben,
	 *  die passend zur Karte, vorgefertigte Bauteile haben. Wird eine Karte erstellt
	 *  so wird jeweils nur das Tile referenziert und dann dort eingefügt.
	 *  Jedes Tile wird ein Objekt sein, welches nur einmal erzeugt wird, und dann
	 *  überall nur referenziert wird.
	 *  
	 *  TileFactory:
	 *  Erzeugt alle notwendigen Tiles.
	 *  Es gibt ne for Schleife, die jedes Kartenfeld durchgeht, dann in einer Liste
	 *  abfragt, welches Tile hier platziert werden soll, und dann die Factory nach dem
	 *  jeweiligen Tile fragt. Diese nimmt die Tileset Nummer sowie x und y Koordinate
	 *  entgegen, und gibt das fertige Tile dann zur?ck.
	 *  Die TileFactory besitz ein 3D Array (TileSet#,x,y)
	 *  Wurde ein Tile angefragt, so wird dieses erzeugt, in das 3D Array gespeichert,
	 *  und dann weiter gegeben. Wird dieses Tile erneut erfragt, so wird es direkt aus
	 *  dem Array weiter gegeben, und nicht nochmal erzeugt und eingefügt.
	 *  
	 *  Sprites:
	 *  Sprites sind unter anderem NPC und Gegenstände die sich auf der Karte befinden.
	 *  Sie werden auf der Karte platziert, und können sich, im vergleich zu Tiles bewegen.
	 *  Man kann mit ihnen interagieren und sie per Commands steuern. Sie sind Objekte, die
	 *  unter anderem ein Bild haben, aber auch Funktionen, die per Command aufgerufen werden k?nnen.
	 *  Hier das pattern verwenden, das Objekte hat, die sich manche Dinge teilen, und manche
	 *  Dinge einzigartig haben.
	 *  
	 *  Interaktion:
	 *  Es gibt das Interaktions-Command, welches alle Objekte, NPC und sonst wer hat,
	 *  mit dem Interagiert werden kann. Vorzugsweise Interface.
	 *  Dieses Command, bestimmt, was passiert, wenn mit ihnen Interagiert wird.
	 *  So steht konkret drin, was sie machen sollen. Entweder hardcoded
	 *  oder bevorzugt als Script welches dann geladen wird.
	 *  
	 *  Sichtung:
	 *  Wird der Spieler von einem Trainer gesicht, so kann nicht die ganze Zeile
	 *  vor ihm jeweils ein Script Trigger liegen. Vielmehr bekommt der Trainer
	 *  einen Listener, der in einer gewissen Range abfragt, ob ein Trainer da ist.
	 *  
	 *  Dateien:
	 *  Das speicherformat der Karte muss ich mir noch ansehen. So muss zu jeder Koordinate
	 *  das jeweilige Tile gespeichert werden.
	 *  Gehdaten werden dann als extra Datei und script daten auch als extra Datei.
	 *  Vielleicht alles drei zusammengefasst gepackt oder so. .map Datei
	 *  
	 *  Overworld:
	 *  Die Overworld besteht immer aus der gerade eben geladenen Karte.
	 *  So handelt es sich dabei nicht um eine Kontinuierliche riesige Karte, sondern vielmehr um
	 *  mehrere Karten, die per verlinkungen mit einander verbunden sind.
	 *  Dabei ist jede Karte ein Objekt, mit je einer Verlinkung für jede offene Seite.
	 *  mit absicht kein 2D Array, da Karten nicht immer gleich gro? sind.
	 *  Das Karten Objekt besteht aus Welt objekt, Geh Daten Objekt und Script Objekt.
	 *  Es kann mehrere Versionen ein Karte geben, die je nach Story Fortschritt des
	 *  Spielers dann geladen werden.
	 */
}
