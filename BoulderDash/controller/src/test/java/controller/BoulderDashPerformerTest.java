package controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <h1>The class test of BoulderDashPerformer</h1>
 *
 * @author Arnaud Rigaut
 * @version 1.0
 */


public class BoulderDashPerformerTest {

	/** The controller to test */
	private BoulderDashPerformer controller;
	
	/**
	 * Instantiate a new controller before each test
	 * @throws Exception
	 * 		Exception in case of build mine failed
	 */
    @Before
    public void setUp() throws Exception {
    	this.controller = new BoulderDashPerformer();
    }

    /**
     * Test if we can't end the game in case of diamondCounter is <10
     * @throws Exception
     *      excepted number of diamond
     */
    @Test
    public void testEndGameNoDiamond() throws Exception {
        try {
        	this.controller.EndGame(8);
        }catch (final Exception e){
            final String excepted = "Not enough diamond";
            assertEquals(excepted, e.getMessage());
        }
    }

}