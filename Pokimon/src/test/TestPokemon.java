package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pokimon.pokemon.Bulbasaur;
import pokimon.pokemon.Pokemon;

public class TestPokemon {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void getPokemonStatEqualsIndividualStat() {
		Bulbasaur b = new Bulbasaur();
		Pokemon p = new Bulbasaur();
		assertEquals(b.attack,p.attack);
	}

}
