package model;

import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <h1>The Class BoulderDashModel</h1>
 *
 * @version 1.3
 */
public class BoulderDashModel extends Observable implements IBoulderDashModel {

	/** The  mine who contains the elements */
	private Mine mine;
	/** The game over image*/
	private Image gameOver;
	/** True if the game is running, false in case of game over or win */
	private boolean game; 
	
	private int score;
	
	/**
	 * Instantiates the BoulderDashModel.
	 * @throws Exception
	 * 		Mine exception
	 */
	public BoulderDashModel() throws Exception{
		this.mine = new Mine(this);
		this.gameOver = Element.loadSprite("gameover");
		this.game = true;
	}

	/**
	 * Gets the list of the elements 
	 * @return a list of the elements
	 */
	@Override
	public IElement[][] getElements() {
		return this.mine.getElements();
	}
	
	/**
	 * Get the element that is to the x and y coordinates
	 * @param x
	 * 		The x coordinate
	 * @param y
	 * 		The y coordinate
	 * @return an Element
	 */
	@Override
	public IElement getElementByPosition(int x, int y) {
		return this.mine.getElements()[x][y];
	}
	
	/**
	 * Adds an object to the list of the elements
	 * @param element
	 * 		element to add in the list
	 */
	@Override
	synchronized public void addElement(IElement element){
		this.mine.setElement(element.getPosition().getX(), element.getPosition().getY(), element);
	}
	
	/**
	 * Removes an object of the list of elements
	 * @param element
	 * 		element to remove of the list
	 */
	@Override
	synchronized public void removeElement(IElement element){
		this.mine.setElement(element.getPosition().getX(), element.getPosition().getY(), null);
	}
		
	/**
	 * Notify the model's observer (the view) that it changed values
	 */
	public void effectiveChanged(){
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Add a diamond for the hero
	 * @throws Exception
	 * 		Destroy Exception
	 *
	 */
	@Override
	synchronized public void getDiamond(IElement element) throws Exception{
		Hero hero = Hero.getInstance();
		this.mine.destroyElement(element);
		hero.setDiamonds(hero.getDiamonds()+1);
		System.out.println(hero.getDiamonds());
		this.effectiveChanged();
		
	}
	
	/**
	 * Get the number of diamond get by the hero
	 * @throws Exception
	 * 		Destroy Exception
	 */
	@Override
	public int diamondCounter() throws Exception{
		Hero hero = Hero.getInstance();
			
		if(hero == null)
			throw new Exception("Hero is dead");
		
		return this.score = hero.getDiamonds();
	}
	
	@Override
	public IElement getHero(){
		return this.getMine().getHero();
	}
	
	@Override
	synchronized public CopyOnWriteArrayList<IElement> getEnemy(){
		return this.getMine().getEnemy();
	}
	
	@Override
	synchronized public CopyOnWriteArrayList<IElement> getGravity(){
		return this.getMine().getGravity();
	}

	/**
	 * Gets the mine
	 * @return the mine of the model
	 */
	private Mine getMine() {
		return mine;
	}

	/**
	 * Sets the mine of the model
	 * @param mine
	 * 		The mine to set
	 */
	public void setMine(Mine mine) {
		this.mine = mine;
	}

	@Override
	public void observerAdd(Observer o) {
		addObserver(o);
	}
	
	@Override
	public void observerDelete(Observer o){
		this.deleteObserver(o);
	}

	@Override
	public Image getGameOver() {
		return gameOver;
	}

	@Override
	public boolean isGame() {
		return game;
	}

	@Override
	public void setGame(boolean game) {
		this.game = game;
	}

	@Override
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
