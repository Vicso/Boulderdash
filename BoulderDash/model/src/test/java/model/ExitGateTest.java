package model;

import org.junit.Before;

/**
 * <h1>The Test ExitGate Class</h1>
 *
 * @author Alexandre Lecomte
 * @version 1.0
 */
public class ExitGateTest extends ElementTest {

	/**
	 * Instantiate the ExitGate
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		this.actual = ExitGate.getInstance(new Position(1,1,10,10),this.mine);
		this.actual.getPosition().setX(1);
		this.actual.getPosition().setY(1);
		this.behaviour = new Fix(actual);
	}

}
