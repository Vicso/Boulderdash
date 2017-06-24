package model;

import org.junit.Before;

/**
 * <h1>The Test Gravity Class</h1>
 *
 * @author Alexandre Lecomte
 * @version 1.0
 */
public class GravityTest extends BehaviourMoveTest {
	
	/**
	 * Instantiate a Stone before each test
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		this.element = new Stone(new Position(5,5,10,10), mine);
	}
	
}
