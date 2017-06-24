package controller;

/**
 *  <h1>The Interface IOrderPerformer</h1>
 * 
 * @version 1.0
 * 
 */

public interface IOrderPerformer {


	/**
	 * method use for understand what order is doing by the player
     * @param order
	 * 			order take
	 * @throws Exception
	 * 			thread exception
     */
    void OrderPerform(Order order) throws Exception;
}
