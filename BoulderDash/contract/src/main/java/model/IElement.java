package model;

import java.awt.Image;
/**
 * <h1>The interface IElement</h1>
 *
 * @version 1.0
 */


public interface IElement {

    /**
     * Gets the Position.
     * @return the position
     */
    Position getPosition();

    /**
     * Sets the position
     * @param position
     * 		Position of the element to set
     */
    void setPosition(Position position);
    
    /**
     * Gets the sprite of the element
     * @return the sprite
     */
    Image getSprite();

    /**
     * Sets the sprite of the element
     * @param sprite
     *      sprite want to apply
     */
    void setSprite(String sprite);
    
    /**
     * Get the move's behaviour of the element
     * @return the behaviour
     */
    IBehaviourMove getBehaviour();

    /**
     * Get the name of the element's sprite
     * @return the sprite name
     */
	String getSpriteName();

    /**
     * Get the direction of a element
     * @return the direction of the element
     */
	Direction getDirection();

    /**
     * Set the direction of a element
     * @param direction
     *      direction like up, down...
     */
	void setDirection(Direction direction);
}
