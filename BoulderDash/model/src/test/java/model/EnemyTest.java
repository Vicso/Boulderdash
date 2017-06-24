package model;

import org.junit.Before;

public class EnemyTest extends ElementTest {
	
	/**
	 * Instantiate a new Dirt
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		this.actual = new Enemy(new Position(1,1,10,10),this.mine);
		this.behaviour = new Automatic(this.actual);
	}

}
