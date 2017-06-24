package model;

import java.awt.Image;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <h1>The Interface IBoulderDashModel.</h1>
 *
 * @version 1.0
 */
public interface IBoulderDashModel {

	/**
	 * Gets the list of the elements 
	 * @return a list of the elements
	 */
	IElement[][] getElements();
	
	/**
	 * Adds an object to the list of the elements
	 * @param element
	 * 		element to add in the list
	 */
	void addElement(IElement element);
	
	/**
	 * Removes an object of the list of elements
	 * @param element
	 * 		element to remove of the list
	 */
	void removeElement(IElement element);
    
	/**
	 * Add an observer to the model
	 * @param o
	 * 		the observer to add
	 */
	void observerAdd(Observer o);
	
	/**
	 * Gets an element by it position
	 * @param x
	 * 		The x position of the element to get
	 * @param y
	 * 		The y position of the element to get
	 * @return an Element
	 */
	IElement getElementByPosition(int x, int y);

	/**
	 * Add a diamond to the hero
	 * @throws Exception
	 * 		exception from destroyElement
	 */
	void getDiamond(IElement element) throws Exception;

	/**
	 * Get the number of diamond get by the hero
	 * @return the number of diamonds collected
	 * @throws Exception
	 * 		Exception "Hero is dead"
	 */
	int diamondCounter() throws Exception;

	/**
	 * Get the hero element
	 * @return the hero
	 */
	IElement getHero();

	/**
	 * Try to read and write on a array list
	 * @return array list of enemy element
	 */
	CopyOnWriteArrayList<IElement> getEnemy();

	/**
	 * Try to read and write on a array list
	 * @return array list of gravity element
	 */
	CopyOnWriteArrayList<IElement> getGravity();

	/**
	 * Use for set get the game over moment
	 * @return a picture Game Over
	 */
	Image getGameOver();

	void observerDelete(Observer o);

	boolean isGame();

	void setGame(boolean game);

	int getScore();


}
