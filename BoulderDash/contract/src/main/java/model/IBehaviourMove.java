package model;

/**
 * <h1>The interface IBehaviourMove </h1>
 *
 * @version 1.0
 */
public interface IBehaviourMove {

	/**
	 * All method of movement call in mobile elements
	 * @throws Exception
	 * 		except this.  movement
	 */
	
	void move() throws Exception;
	void moveRight() throws Exception;
	void moveLeft() throws Exception;
	void moveUp() throws Exception;
	void moveDown() throws Exception;

	/**
	 * Method use for move all enemy in the same time
	 * @throws Exception
	 *		iteration exception
	 */
	void moveAll() throws Exception;

	/**
	 * Movement method for stones and diamonds gravitation
	 * @throws Exception
	 *		Iteration exception
	 */
	void Gravit() throws Exception;
}
