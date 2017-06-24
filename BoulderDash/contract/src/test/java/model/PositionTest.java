package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * <h1>The class test PositionTest</h1>
 * @author Alexandre LECOMTE
 * @version 1.0
 */
public class PositionTest {

	/**
	 * The position to test
	 */
    private Position actual;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 *  Instantiate a position before each test
	 * @throws Exception
	 * 		Position Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.actual = new Position(1,1,10,10);
	}
	
	/**
	 * Test if Xmax is not < 0 in case of new position instantiation
	 */
	@Test
	public void testXmaxMin(){
		
		try{
			new Position(1,1,-10,10);
			fail("Should throw exception when Xmax < 0"); 
		}catch(final Exception e){
			final String expected = "Xmax out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/**
	 *  Test if Ymax is not > 0 in case of new position instantiation
	 */
	@Test
	public void testYmaxMin(){
		
		try{
			new Position(1,1,10,-10);
			fail("Should throw exception when Ymax < 0"); 
		}catch(final Exception e){
			final String expected = "Ymax out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/**
	 * Test if X is not < 0 in case of new position instantiation
	 */
	@Test
	public void testXMin(){
		
		try{
			new Position(-1,1,10,10);
			fail("Should throw exception when X < 0"); 
		}catch(final Exception e){
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/**
	 * Test if X is not > Xmax in case of new position instantiation
	 */
	@Test
	public void testXMax(){
		
		try{
			new Position(10,10,5,50);
			fail("Should throw exception when X > Xmax"); 
		}catch(final Exception e){
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/**
	 * Test if Y is not < 0 in case of new position instantiation
	 */
	@Test
	public void testYMin(){
		
		try{
			new Position(1,-1,10,10);
			fail("Should throw exception when Y < 0"); 
		}catch(final Exception e){
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/**
	 * Test if Y is not > Ymax in case of new position instantiation
	 */
	@Test
	public void testYMax(){
		
		try{
			new Position(10,10,50,5);
			fail("Should throw exception when Y > Ymax"); 
		}catch(final Exception e){
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}

	/**
	 * Test get the x coordinate of a position
	 */
	@Test
	public void testGetX() {
		int expected = 1;
		assertSame(expected, actual.getX());
	}

	/**
	 * Test set the x coordinate of a position
	 * @throws Exception
	 * 		Positon Exception
	 */
	@Test
	public void testSetX() throws Exception {
		int expected = 2;
		actual.setX(2);
		assertSame(expected, actual.getX());
	}

	/**
	 * Test get the y coordinate of a position
	 */
	@Test
	public void testGetY() {
		int expected = 1;
		assertSame(expected, actual.getY());
	}

	/**
	 * Test set the y coordinate of a position
	 * @throws Exception
	 *		Position Exception
	 */
	@Test
	public void testSetY() throws Exception {
		int expected = 2;
		actual.setY(2);
		assertSame(expected, actual.getY());
	}

	/**
	 * Test get the max x coordinate of a position
	 */
	@Test
	public void testGetMaxX() {
		int expected = 10;
		assertSame(expected, actual.getMaxX());
	}

	/**
	 * Test set the max x coordinate of a position
	 */
	@Test
	public void testSetMaxX() {
		int expected = 20;
		actual.setMaxX(20);
		assertSame(expected, actual.getMaxX());
	}

	/**
	 * Test get the max y coordinate of a position
	 */
	@Test
	public void testGetMaxY() {
		int expected = 10;
		assertSame(expected, actual.getMaxY());
	}

	/**
	 * Test set the max y coordinate of a position
	 */
	@Test
	public void testSetMaxY() {
		int expected = 20;
		actual.setMaxY(20);
		assertSame(expected, actual.getMaxY());
	}

	/**
	 * Test if the x set is not > Xmax 
	 */
	@Test
	public void testSetXmax() {
		
		try{
			actual.setX(11);
			fail("Should throw exception when X > Xmax"); 
		}catch(final Exception e){
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}

	/**
	 * Test if the y set is not > Ymax 
	 */
	@Test
	public void testSetYmax() {

		try{
			actual.setY(11);
			fail("Should throw exception when Y > Ymax"); 
		}catch(final Exception e){
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	/**
	 * Test if the x set is not < 0 
	 */
	@Test
	public void testSetXmin() {
		
		try{
			actual.setX(-1);
			fail("Should throw exception when X < 0"); 
		}catch(final Exception e){
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}

	/**
	 * Test if the y set is not < 0 
	 */
	@Test
	public void testSetYmin() {

		try{
			actual.setY(-1);
			fail("Should throw exception when Y < 0"); 
		}catch(final Exception e){
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}
}
