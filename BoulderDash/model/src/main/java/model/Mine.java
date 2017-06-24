package model;

import java.util.concurrent.CopyOnWriteArrayList;

import model.dao.level;

/**
 * <h1>The Class Element</h1>
 *
 * @version 1.2
 */

public class Mine {

	/** The height of the mine */ 
	static int HEIGHT = 30;
	/** The width of the mine */
	static int WIDTH = 50;
	/** The tab of the different elements */
	private IElement[][] elements;
	/** The model that contain the mine */
	private BoulderDashModel model;
	/**  */
	private CopyOnWriteArrayList<IElement> enemy;
	
	private CopyOnWriteArrayList<IElement> gravity;
	
	private IElement hero;

	/**
	 * Instantiates the constructor
	 * @throws Exception
	 *		BuildMine exception
	 */
	public Mine(BoulderDashModel model) throws Exception{
		this.elements = new IElement[Mine.WIDTH][Mine.HEIGHT];
		this.model = model;
		this.enemy = new CopyOnWriteArrayList<IElement>();
		this.gravity = new CopyOnWriteArrayList<IElement>();
		this.buildMine();
	}
	
	/**
	 * Builds the mine
	 * @throws Exception
	 * 		position Exception
	 */
	private void buildMine() throws Exception{
		
		String currentLevel = loadLevel("level4");
		int i = 0;
		for(int y = 0 ;y<Mine.HEIGHT; y++){
			for (int x = 0; x<Mine.WIDTH;x++){
					
				char element = currentLevel.charAt(i);
					
				i++; 
				System.out.print(element);
				
				switch(element){
					case 'o':
						IElement gravit = new Stone(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this);
						this.gravity.add(gravit);
						this.setElement(x,y,gravit);
						break;
					case 'x':
						this.setElement(x,y,new Wall(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this));
						break;
					case 'v':
						gravit = new Diamond(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this);
						this.gravity.add(gravit);
						this.setElement(x,y,gravit);
						break;
					case '.':
						this.setElement(x,y,new Dirt(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this));
						break;
					case 'u':
						this.setElement(x,y,ExitGate.getInstance(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this));
						break;
					case 'y':
						this.hero = Hero.getInstance(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this);
						this.setElement(x,y,this.hero);
						break;
					case ' ':
						this.setElement(x,y,new Background(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this));
						break;
					case 'n':
						IElement enemy = new Enemy(new Position(x,y,Mine.WIDTH,Mine.HEIGHT),this);
						this.enemy.add(enemy);
						this.setElement(x,y,enemy);
						break;
					}
			}
		}
	}
	
	/**
	 * Load the level, get it from the database
	 * @param levelToLoad
	 * 		The level to load 
	 * @return a String that contain the level template
	 */
	private String loadLevel(String levelToLoad){
		
		String result = "";
		
		try {
			result = level.getLevel(levelToLoad);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Get a tab that contain all the mine's elements
	 * @return a tab of Elements
	 */
	public IElement[][] getElements() {
		
		return elements;
	}
	
	/**
	 * Add a element in the mine
	 * @param x
	 * 		The x column where add the element
	 * @param y
	 * 		The y column where add the element
	 * @param add
	 * 		The element to add
	 */
	public void setElement(int x, int y, IElement add) {
		
		this.elements[x][y] = add;
	}

	/**
	 * Get the model of the mine
	 * @return the model of the mine
	 */
	public BoulderDashModel getModel() {
		return model;
	}

	public CopyOnWriteArrayList<IElement> getEnemy() {
		return enemy;
	}
	
	public void destroyElement(IElement element) throws Exception{
		
		this.elements[element.getPosition().getX()][element.getPosition().getY()] = new Background(new Position(element.getPosition().getX(),element.getPosition().getY(),Mine.WIDTH,Mine.HEIGHT), this);
		
		for (IElement e : this.enemy) {
			if (e.equals(element)) {
				this.enemy.remove(e);
			}
		}
		
		for (IElement e : this.gravity) {
			if (e.equals(element)) {
				this.gravity.remove(e);
			}
		}
		
		if(this.hero.equals(element)){
			this.hero = null;
		}
	}

	/**
	 * Method for add an enemy
	 * @param enemy.
	 * 		Name of enemy to add
	 */
	public void addEnemy(IElement enemy) {
		this.enemy.add(enemy);
	}

	/**
	 * Use for copy and write on a array list
	 * @return gravity
	 */
	public CopyOnWriteArrayList<IElement> getGravity() {
		return gravity;
	}

	/**
	 * try to synchronize thread
	 * @param gravity
	 * 		element affect by  gravity
	 */
	public void addGravity(IElement gravity) {
		this.gravity.add(gravity);
	}

	/**
	 * Method for get the hero
	 * @return hero
	 */
	public IElement getHero() {
		return hero;
	}

}
