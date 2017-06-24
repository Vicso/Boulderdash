package model;

/**
 * <h1>The Class Element</h1>
 *
 * @version 1.1
 */
public class Hero extends Element implements IExplosion{

	
	private static String SPRITE = "5";
	private static Hero hero;
	
	private int timeout;
	private int diamonds;
	private Direction direction;


    /**
     * Instantiates the hero
     */
    private Hero(Position position, Mine mine){
		super(position, SPRITE,mine);
		behaviour = new Controlled(this);
	}

    /**
     * Create the chess-clock and decrease the time
     */
	public void startTimeOut(){
		
	}

	/**
	 * method use for create an instance of hero
	 * @return return a new hero
	 */
	static public Hero getInstance(Position position, Mine mine){
		
		if(hero == null){
			hero = new Hero(position, mine);
		}
		return hero;
	}
	
	static public Hero getInstance(){
		return hero;
	}

    /**
     * method use for return the selected SPRITE for the hero
     * @return the SPRITE of a hero
     */
	public static String getSPRITE() {
		return SPRITE;
	}

    /**
     * method use for set a SPRITE for the hero
     * @param sprite
     */
	public static void setSPRITE(String sprite) {
		SPRITE = sprite;
	}

    /**
     * return diamonds if collision
     * @return diamonds
     */
	public int getDiamonds() {
		return diamonds;

	
		
		
	}

    /**
     * setDiamond on the map
     * @param diamonds
     */
	public void setDiamonds(int diamonds) {
		this.diamonds = diamonds;
	}


    /**
     * return the time for test if it is not at 0
     * @return timeout
     */
	public int getTimeout() {
		return timeout;
	}

    /**
     * define the time as we want
     * @param timeout
     */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

    /**
     * get the direction who come from the action of the player
     * @return direction
     */
	public Direction getDirection() {
		return direction;
	}


    /**
     * with the direction get before, set the direction of the hero
     * @param direction
     */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}


    /**
     * @throws Exception 
     * @see IExplosion
     */
	@Override
	synchronized public void explosion() throws Exception {
		this.getMine().destroyElement(Hero.hero);
		this.getMine().getModel().setGame(false);
		Hero.hero = null;
	}
}
