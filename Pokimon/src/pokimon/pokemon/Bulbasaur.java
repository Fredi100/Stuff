package pokimon.pokemon;

import pokimon.abilities.Ability;
import pokimon.abilities.Chlorophyll;
import pokimon.abilities.Overgrow;

public class Bulbasaur extends Pokemon {

	private static int BASE_HP = 45;
	private static int BASE_ATTACK = 49;
	private static int BASE_DEFENSE = 49;
	private static int BASE_SP_ATTACK = 65;
	private static int BASE_SP_DEFENSE = 65;
	private static int BASE_SPEED = 45;
	private static byte GENDER_THRESHOLD = 0x0; //TODO Richtigen Wert bestimmen
	private static Ability[] abilities = {new Overgrow(),new Chlorophyll()};

	public Bulbasaur() {
		// TODO Schaun, ob man diesen Part hier bei jedem Pokemon gleich machen
		// kann, so dass ich ihn nur einmal schreiben muss, und nicht bei jedem
		// Pokemon neu
		this.attack = BASE_ATTACK;
		this.defense = BASE_DEFENSE;
		this.specialAttack = BASE_SP_ATTACK;
		this.specialDefense = BASE_SP_DEFENSE;
		this.hp = BASE_HP;
		this.speed = BASE_SPEED;
		this.genderThreshold = GENDER_THRESHOLD;
		
		this.pv = new PersonalityValue();
	}

	@Override
	public void calculateAbility() {
		// TODO Auto-generated method stub
		
	}
	
}
