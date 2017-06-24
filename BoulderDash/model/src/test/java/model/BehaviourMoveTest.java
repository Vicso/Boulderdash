package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <h1>The Test BehaviourMove Class</h1>
 *
 * @author Alexandre Lecomte
 * @version 1.0
 */
public class BehaviourMoveTest {
	
	/** The tested element */
	protected IElement element;
	/** The mine of the tested element */
	protected static Mine mine;

	/**
	 * Instantiate a new Mine to realize move test
	 * @throws Exception
	 * 		Failed to build the mine
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mine = new Mine(new BoulderDashModel());
	}
	
	/**
	 * Instantiate an element before each test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {}

	/**
	 * Test the move right
	 * @throws Exception 
	 * 		Exception if the position is out of range
	 */
	@Test
	public void testMoveRight() throws Exception {
		this.element.getBehaviour().moveRight();
		final Position expected = new Position(6,5,10,10);
		assertEquals(expected.getX(),this.element.getPosition().getX());
	}

	/**
	 * Test the move left
	 * @throws Exception 
	 * 		Exception if the position is out of range
	 */
	@Test
	public void testMoveLeft() throws Exception {
		this.element.getBehaviour().moveLeft();
		final Position expected = new Position(4,5,10,10);
		assertEquals(expected.getX(),this.element.getPosition().getX());
	}

	/**
	 * Test the move up
	 * @throws Exception 
	 * 		Exception if the position is out of range
	 */
	@Test
	public void testMoveUp() throws Exception {
		this.element.getBehaviour().moveUp();
		final Position expected = new Position(5,4,10,10);
		assertEquals(expected.getY(),this.element.getPosition().getY());
	}

	/**
	 * Test the move down
	 * @throws Exception 
	 * 		Exception if the position is out of range
	 */
	@Test
	public void testMoveDown() throws Exception {
		this.element.getBehaviour().moveDown();
		final Position expected = new Position(5,6,10,10);
		assertEquals(expected.getY(),this.element.getPosition().getY());
	}

}
