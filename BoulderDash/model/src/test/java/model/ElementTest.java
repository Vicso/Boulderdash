package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * <h1>The Test Element Class</h1>
 *
 * @author Alexandre Lecomte
 * @version 1.1
 */
public class ElementTest {
	
	/** The tested Element */
    protected Element actual;
	/** The behaviour of the tested Element */
	protected BehaviourMove behaviour;
	/** The mine of the tested element */
	protected Mine mine;

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Check if the element has a move behaviour and the good one
	 */
	@Test
	public void testGetBehaviour() {
		
		assertNotNull(this.actual.getBehaviour());
		assertEquals(behaviour.getClass(),this.actual.getBehaviour().getClass());
	}
	
	/**
	 * Check if the element has a position
	 * @throws Exception 
	 */
	@Test
	public void testGetPosition() throws Exception {
		
		assertNotNull(this.actual.getPosition());
		
		Position expected = new Position(1,1,10,10);
		
		assertEquals(expected.getX(), this.actual.getPosition().getX());
		assertEquals(expected.getY(), this.actual.getPosition().getY());
	}
	
	/**
	 * Check if the element has a sprite
	 */
	@Test
	public void testGetSprite() {
		assertNotNull(this.actual.getSprite());
	}
	
	/**
	 * Check if the setter position work correctly
	 * @throws Exception 
	 */
	@Test
	public void testSetPosition() throws Exception {
		
		Position expected = new Position(2,3,10,10);
		
		this.actual.setPosition(new Position(2,3,10,10));
		
		assertEquals(expected.getX(), this.actual.getPosition().getX());
		assertEquals(expected.getY(), this.actual.getPosition().getY());
		assertEquals(expected.getMaxX(), this.actual.getPosition().getMaxX());
		assertEquals(expected.getMaxY(), this.actual.getPosition().getMaxY());

	}

	

}
