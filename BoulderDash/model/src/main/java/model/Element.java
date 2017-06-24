
package model;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * <h1>The Class Element</h1>
 *
 * @version 1.3
 */
public class Element implements IElement {
	
	/** The position of the element */
	private Position position;
	/** The sprite of the element  */
	private Image Sprite;
	/** The move behaviour of the element */
	BehaviourMove behaviour;
	/** The mine that contains the element */
	private Mine mine;
	/** The sprite's name of the element */
	private String SpriteName;
	/** Direction of the element */
	Direction direction;

	/**
	 * Instantiates a new Element
	 * @param position
	 * 		Position of the Element
	 */
	Element(Position position, String sprite, Mine mine){
    	this.position = position;
    	this.SpriteName = sprite;
    	this.Sprite = loadSprite(this.SpriteName);
    	this.mine = mine;
    }
    
    /**
     * Get the sprite in the database
     * @param sprite
     * 		The sprite's name to load
     * @return the sprite's image
     */
    public static Image loadSprite(String sprite){

    	String path = "ressources/img/"+sprite+".png";
    	
    	Toolkit toolkit = Toolkit.getDefaultToolkit(); 
		Image result = toolkit.getImage(path);


		if(result == null){
			System.out.println("error");
		}
		
		return result;

    }

    /**
     * Gets the Position.
     * @return the position
     */
    @Override
    public Position getPosition(){
        return this.position;
    }

    /**
     * Sets the position
     * @param position
     * 		Position of the element to set
     */
    @Override
    public void setPosition(Position position){
    	this.position = position;
    }
    
    /**
     * Get the element's mine
     */
    public Mine getMine(){
    	return this.mine;
    }

    /**
     * Gets the sprite of the element
     * @return the sprite
     */
    @Override
    public Image getSprite(){
        return this.Sprite;
    }

    /**
     * Sets the sprite of the element
     */
    @Override
    public void setSprite(String sprite){
    	this.Sprite = loadSprite(sprite);
    	this.SpriteName = sprite;
    }
    
    /**
     * Get the name of the sprite's element
     * @return The name of the sprite
     */
    @Override
	public String getSpriteName() {
		return SpriteName;
	}

    /**
     * Gets the movement behavior of the element
     * @return the behavior of move
     */
    public BehaviourMove getBehaviour(){
        return this.behaviour;
    }

    /**
     * Sets the movement behavior of the element
     * @param behaviour
     * 		The movement behavior to set
     */
    public void setBehaviour(BehaviourMove behaviour){
    	this.behaviour = behaviour;
    }

    /**
     * Get the direction of the element
     */
    @Override
	public Direction getDirection() {
		return direction;
	}

    /**
     * Set the direction to the element
     * @param direction
     * 		The direction to set
     */
    @Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}