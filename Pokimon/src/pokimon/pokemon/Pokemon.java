package pokimon.pokemon;

import pokimon.Move;
import pokimon.abilities.Ability;
import pokimon.pokemon.PersonalityValue.ByteRange;

public abstract class Pokemon {

	/*
	 * Jedes Pokemon hat folgende Sprites:
	 * 		Front Sprite m�nnlich, Front Sprite weiblich
	 * 		Back Sprite m�nnlich, Back Sprite weiblich
	 * 		Item Sprite
	 * 
	 * 		Front Sprite m�nnlich shiny, Front Sprite weiblich shiny
	 * 		Back Sprite m�nnlich shiny, Back Sprite weiblich shiny
	 * 		Item Sprite shiny
	 */
	
	/*
	 * Jedes Pokemon hat folgende Statistiken:
	 * 		HP EV, HP IV, HP Base
	 * 		Attack EV, Attack IV, Attack Base
	 * 		Defense EV, Defense IV, Defense Base
	 * 		Sp. Attack EV, Sp. Attack IV, Sp. Attack Base
	 * 		SP. Defense EV, Sp. Defense IV, Sp. Defense Base
	 * 		Initiative EV, Initiative IV, Initiative Base
	 * 		Erfahrung gesammelt, Erfahrung ben�tigt
	 * 		Level
	 * 		Vier Attacken
	 * 		Pokedex Nummer
	 * 		Pokedex Beschreibung
	 * 		Gender
	 * 
	 * 
	 */
	
	/*
	 * Level
	 * When a Pok�mon grows a level, its stats will increase.
	 * For each level gained (ignoring Nature), stats will increase by 1/50 the base stat
	 * value, and 1/100 the combined individual value and effort value.
	 * This means that it is impossible, through leveling up, for a Pok�mon to ever lose
	 * points in a stat unless it evolves into a Pok�mon with a lower base stat value
	 * for that specific stat or an EV-reducing Berry is used.
	 * It is also impossible for any Pok�mon other than Shedinja not to gain HP upon
	 * leveling up without using a Pomeg Berry (Pok�mon Emerald onward) as no evolutionary
	 * line has members with a lower base HP than the pre-evolved forms. 
	 */
	
	/*
	 * Genauigkeit bei K�mpfen wird folgenderma�en definiert
	 * 
	 * P = Abase * (Accuracy/Evasion)
	 * 
	 * P entspricht hierbei der Wahrscheinlichkeit ob die Attacke trifft.
	 * 1 bedeutet auf jedenfall getroffen. Alle Kommawerte darunter k�nnen daneben gehen.
	 * Abase entspricht der Basis genauigkeit der jeweiligen Attacke. 95 entspricht in der Gleichung 0.95
	 * Accuracy entspricht der derzeitigen Genauigkeit des Benutzers (in Prozent - Beispiel Die Genauigkeit um drei Stufen zu erh�hen, erh�t diese Nummer auf 2)
	 * Evasion enstpricht der verringerung der Genauigkeit des Benutzers (in Prozent - Beispiel Die Genauigkeit zwei mal zu verringern setzt den Wert auf 0.6)
	 * 
	 * 
	 */
	
	/*
	 * Nature
	 * 
	 * Most Natures enhance the growth of one stat, while hindering the growth of another.
	 * After all other calculations are finished, the stat that the Nature enhances will
	 * be 110% of what it would be without the Nature, and the stat hindered will be 90%
	 * of its normal value.
	 * 
	 */
	
	/*
	 * Modification entspricht den im Kampf zugef�gten Stat �nderungen.
	 * Diese werden In Stages aufgeteilt, wobei verschiedenste Attacken nicht den Wert
	 * konkret �ndern, sondern lediglich die Stage erh�hen oder verringern.
	 */
	
	/* --- Moves --- */
	//Kann noch umgeschrieben werden, erster Prototyp
	private static final int MAX_MOVES = 4;
	private Move[] moveset = new Move[MAX_MOVES];
	
	/* --- Base Stats --- */
	//Diese Werte gehen von 1 - 252 und definieren damit fixe Werte einer jeden
	//Pokemon Rasse. Sie sind bei jedem einzelnen Pokemon einer Rasse gleich.
	
	public int attack;
	public int defense;
	public int specialAttack;
	public int specialDefense;
	public int hp;
	public int speed;
	
	/* --- Personality Value --- */
	//Besteht aus 4 Byte an daten. Es wird eine zuf�llige Zahl generiert, die dann
	//abgespeichert wird. Ab da werden eher die Bits diese Zahl beachtet.
	protected PersonalityValue pv;
	
	
	
	private Gender gender; 
	protected byte genderThreshold;
	private boolean isShiny;
	
	/**
	 * For Algorithm informations visit following website:
	 * http://bulbapedia.bulbagarden.net/wiki/Personality_value
	 */
	public void calculateGender(){
		byte b = pv.getPVByte(ByteRange.FOURTH);
		if(b == 0x255){
			gender = Gender.GENDERLESS;
		}
		if(b == 0x254){
			gender = Gender.FEMALE;
		}
		if(b == 0x0){
			gender = Gender.MALE;
		}
		if(b >= genderThreshold){
			gender = Gender.MALE;
		}else{
			gender = Gender.FEMALE;
		}
	}
	
	public void calculateShinyness(){
		//TODO Hier den Algorythmus zum �berpr�fen ob ein Pokemon Shiny is verwenden.
	}
	
	/* --- Ability --- */
	private Ability ability;
	
	public abstract void calculateAbility();
	
	/*
	 * Jedes Pokemon kann Status�nderungen haben.
	 * 
	 */
	
	/*
	 * Kann derzeit 2 Interfaces machen wenn notwendig Levable und Trainable
	 * Levable erm�glicht es einem Pokemon im Level aufzusteigen und Erfahrung zu sammeln.
	 * Trainable erm�glicht es einem Pokemon durch besiegen eines anderen Pokemons EV zu sammeln.
	 */
}
