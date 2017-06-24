package model;

/**
 * <h1>The Enemy Element</h1>
 *
 * @version 1.1
 */
public class Enemy extends Element {

    /** Variable who will use for seek sprite **/
    private static String spriteName = "Enemy";
    
    static Mine mine;
	
    /**
     * create constructor
     */
    public Enemy(Position position, Mine mine){
    	super(position, setSpriteNameAlea(), mine);
    	Enemy.mine = mine;
    	behaviour = new Automatic(this);
    	direction = Direction.LEFT;
    }

    /**
     * set a sprite for one enemy. This sprite is choose randomly
     */
    private static String setSpriteNameAlea(){
    	
    	int alea = (int) (Math.random()*4);
		
		switch(alea){
			case 0:
				return "enemy";
			case 1:
				return "enemy";
			case 2:
				return "enemy";
			case 3:
				return "enemy";
			default:
				return "enemy";
		}

    }
    
    /**
     * Get the name of the enemy's sprite
     * @return The sprite's name
     */
	public String getSpriteName() {
		return spriteName;
	}

	/**
	 * Set the name of the enemy's sprite
	 * @param spriteName
	 */
	public void setSpriteName(String spriteName) {
		Enemy.spriteName = spriteName;
	}
}
