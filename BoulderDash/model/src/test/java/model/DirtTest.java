package model;

import org.junit.Before;

/**
 * <h1>The Test Dirt Class</h1>
 *
 * @author Alexandre Lecomte
 * @version 1.0
 */
public class DirtTest extends ElementTest {

	/**
	 * Instantiate a new Dirt
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		this.actual = new Dirt(new Position(1,1,10,10), this.mine);
		this.behaviour = new Fix(actual);
	}
	
}
