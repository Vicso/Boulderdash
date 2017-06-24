package model;

import org.junit.Before;

/**
 * <h1>The Test Controlled Class</h1>
 *
 * @author Alexandre Lecomte
 * @version 1.1
 */
public class ControlledTest extends BehaviourMoveTest {
	
	/**
	 * Instantiate a new Hero
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		this.element = Hero.getInstance();
		this.element.getPosition().setX(5);
		this.element.getPosition().setY(5);
	}

}
