package model;

import java.util.Iterator;

/**
 * <h1>The Class Automatic Move Behaviour</h1>
 * @version 1.3
 */
public class Automatic extends BehaviourMove {

	/**
	 * Instantiate a new automatic move behaviour
	 * @param element
	 * 		The element to set the behaviour
	 */
	public Automatic(Element element){
		super(element);
	}
	
	/**
	 * Launch the move of all the element with an automatic move
	 */
	@Override
	public void moveAll() throws Exception{
		Iterator<IElement> iterator = this.element.getMine().getEnemy().iterator();
		while (iterator.hasNext()) {
			iterator.next().getBehaviour().move();
		}
	}
	
	/**
	 * The automatic move
	 */
	@Override
	synchronized public void move() throws Exception {
		
		Direction dir = this.element.getDirection();
		
		switch(dir){
			case LEFT :
				this.goLeft();
				break;
			case RIGHT :
				this.goRight();
				break;
			case UP :
				this.goUp();
				break;
			case DOWN :
				this.goDown();
				break;
		}
		
	}
	
	/**
	 * Check and if it's possible move to the left
	 * @throws Exception
	 * 		behaviour exception
	 */
	private void goLeft() throws Exception{
		
		IElement left = element.getMine().getElements()[element.getPosition().getX()-1][element.getPosition().getY()];
		
		if(left.getClass() == model.Background.class){
			this.element.getBehaviour().moveLeft();
		}
		else if(left.equals(Hero.getInstance())){
			this.element.getBehaviour().moveLeft();
			Hero.getInstance().explosion();
		}
		else{
			this.element.setDirection(Direction.DOWN);
		}
	}
	
	/**
	 * Check and if it's possible move to the right
	 * @throws Exception
	 * 		behaviour exception
	 */
	private void goRight() throws Exception{
		
		IElement right = element.getMine().getElements()[element.getPosition().getX()+1][element.getPosition().getY()];
		
		if(right.getClass() == model.Background.class){
			this.element.getBehaviour().moveRight();
		}
		else if(right.equals(Hero.getInstance())){
			this.element.getBehaviour().moveRight();
			Hero.getInstance().explosion();
		}
		else{
			this.element.setDirection(Direction.UP);
		}
	}
	
	/**
	 * Check and if it's possible move to the up
	 * @throws Exception
	 *		behaviour exception
	 */
	private void goUp() throws Exception{
		
		IElement up = element.getMine().getElements()[element.getPosition().getX()][element.getPosition().getY()-1];
		
		if(up.getClass() == model.Background.class){
			this.element.getBehaviour().moveUp();
		}
		else if(up.equals(Hero.getInstance())){
			this.element.getBehaviour().moveUp();
			Hero.getInstance().explosion();
		}
		else{
			this.element.setDirection(Direction.LEFT);
		}
	}
	
	/**
	 * Check and if it's possible move to the down
	 * @throws Exception
	 * 		behaviour exception
	 */
	private void goDown() throws Exception{
		
		IElement down = element.getMine().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];
		
		if(down.getClass() == model.Background.class){
			this.element.getBehaviour().moveDown();
		}
		else if(down.equals(Hero.getInstance())){
			this.element.getBehaviour().moveDown();
			Hero.getInstance().explosion();
		}
		else{
			this.element.setDirection(Direction.RIGHT);
		}
	}

}
