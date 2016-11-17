package pokimon;
/**
 * Used to represent a given map in the game. It stores a 3D array of given Tile
 * Objects. The first coordinate x represents the width of the map. The second
 * coordinate y represents the height of the map. The third coordinate z
 * represents the level of the map.
 * 
 * @author Fredi100
 *
 */
public class TileMap {

	private Object[][][] map;

	// TODO Mehrere Ansätze. Das Objekt nimmt alle Informationen entgegen, mit
	// denen es die Karte generieren kann.
	// Zweiter Ansatz: Es wird erzeugt, und sorgt dafür, dass alle Attribute mal
	// initialisiert sind. Danach wird eine jeweilige Methode aufgerufen, die
	// dann das Array befüllt
	// So gibt es dann eine Methode, die eine Liste entgegen nimmt, anhand derer
	// sie dann die map f?llt.

	/*
	 * TODO TileMap Hier handelt es sich um eine TileMap Sie speichert in einem
	 * 2D Array alle Tiles aus denem die Karte besteht. Da sich bei diesem
	 * Spiele mehrere Tiles überlappen k?nnen, besteht diese TileMap aus einem
	 * 3D Array Die erste Koordinate x gibt die Breite der Karte an Die zweite
	 * Koordinate y gibt die H?he der Karte an Die dritte Koordinate z gibt an,
	 * welches Tile und/?ber welchem sitzt. Bei der dritte Koordinate gibt es
	 * immer fixe Stufen, so dass diese als Enum verwendet werden können.
	 */
}
