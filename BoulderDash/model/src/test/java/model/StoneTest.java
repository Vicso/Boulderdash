package model;

import org.junit.Before;

/**
 * <h1>The Test Stone Class</h1>
 *
 * @author Alexandre Lecomte
 * @version 1.0
 */
public class StoneTest extends ElementTest {

	/**
	 * Instantiate a new Stone
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		this.actual = new Stone(new Position(1,1,10,10),this.mine);
		this.behaviour = new Gravity(actual);
	}

}
