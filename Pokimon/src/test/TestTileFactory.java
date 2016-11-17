/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pokimon.TileFactory;

/**
 * @author Fredi100
 *
 */
public class TestTileFactory {
	
	private TileFactory tf;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tf = new TileFactory();
	}

	@Test
	public void getTileIndexOutOfBounds() {
		assertEquals(null, tf.getTile(11, 11, 11));
	}

}
