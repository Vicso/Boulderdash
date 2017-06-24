package model;

/**
 * <h1>The Class Controlled</h1>
 *
 * @version 1.2
 */

public class Controlled extends BehaviourMove {

	/**
	 * Instantiate a new controlled move
	 * @param element
	 * 		element to controlled
	 */
	public Controlled(Element element) {
		super(element);
	}

	/**
	 * @see BehaviourMove
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
	 * 		Behaviour Exception
	 */
	private void goLeft() throws Exception{
		
		IElement left = element.getMine().getElements()[element.getPosition().getX()-1][element.getPosition().getY()];
		
		if(left.getClass() == model.Background.class || left.getClass() == model.Dirt.class){
			this.element.getBehaviour().moveLeft();
		}
		else if(left.getClass() == model.Stone.class){
			IElement left2 = element.getMine().getElements()[element.getPosition().getX()-2][element.getPosition().getY()];;
			if(left2.getClass() == model.Background.class){
				left.getBehaviour().moveLeft();
				this.element.getBehaviour().moveLeft();
			}
		}
		else if (left.getClass() == model.Diamond.class){
			this.element.getMine().getModel().getDiamond(left);
			this.element.getMine().destroyElement(left);
			this.element.getBehaviour().moveLeft();
			
			}
		
		else if (left.getClass() == model.ExitGate.class){
			System.exit(0);
		}
	}
	
	/**
	 * Check and if it's possible move to the right
	 * @throws Exception
	 * 		position exception
	 */
	private void goRight() throws Exception{
		
		IElement right = element.getMine().getElements()[element.getPosition().getX()+1][element.getPosition().getY()];
		
		if(right.getClass() == model.Background.class || right.getClass() == model.Dirt.class){
			this.element.getBehaviour().moveRight();
		}
		else if(right.getClass() == model.Stone.class){
			IElement right2 = element.getMine().getElements()[element.getPosition().getX()+2][element.getPosition().getY()];;
			if(right2.getClass() == model.Background.class){
				right.getBehaviour().moveRight();
				this.element.getBehaviour().moveRight();
			}
		}
		else if (right.getClass() == model.Diamond.class){
			this.element.getMine().getModel().getDiamond(right);
			this.element.getMine().destroyElement(right);
			this.element.getBehaviour().moveRight();
			
		}
		else if (right.getClass() == model.ExitGate.class){
			System.exit(0);
		}
		
	}
	
	/**
	 * Check and if it's possible move to the up
	 * @throws Exception
	 * 		position exception
	 */
	private void goUp() throws Exception{
		
		IElement up = element.getMine().getElements()[element.getPosition().getX()][element.getPosition().getY()-1];
		
		if(up.getClass() == model.Background.class || up.getClass() == model.Dirt.class){
			this.element.getBehaviour().moveUp();
		}
		else if(up.getClass() == model.Stone.class){
			
		}
		else if (up.getClass() == model.Diamond.class){
			this.element.getMine().getModel().getDiamond(up);
			this.element.getMine().destroyElement(up);
			this.element.getBehaviour().moveUp();
			
		}
		else if (up.getClass() == model.ExitGate.class){
			System.exit(0);
		}
	}
	
	/**
	 * Check and if it's possible move to the down
	 * @throws Exception
	 * 		position exception
	 */
	private void goDown() throws Exception{
		
		IElement down = element.getMine().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];
		
		if(down.getClass() == model.Background.class || down.getClass() == model.Dirt.class){
			this.element.getBehaviour().moveDown();
		}
		else if(down.getClass() == model.Stone.class){
			
		}
		else if (down.getClass() == model.Diamond.class){
			this.element.getMine().getModel().getDiamond(down);
			this.element.getMine().destroyElement(down);
			this.element.getBehaviour().moveDown();
			
		}
		else if (down.getClass() == model.ExitGate.class){
			System.exit(0);
		}
	}
	

}
