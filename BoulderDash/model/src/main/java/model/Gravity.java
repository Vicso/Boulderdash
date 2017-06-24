package model;

import java.util.Iterator;

//import java.util.Iterator;

/**
 * <h1>The Class Element</h1>
 *s
 * @version 1.0
 */

public class Gravity extends BehaviourMove {
	
	private boolean motion = false;
	
	/**
     * Instantiates the Gravity
     */
	public Gravity(Element element) {
			super(element);
	}
	
	
	public void Gravit() throws Exception{
		Iterator<IElement> iterator = this.element.getMine().getGravity().iterator();
		while (iterator.hasNext()) {
			iterator.next().getBehaviour().move();
		}
	}

    /**
     *  @see BehaviourMove
     */
	@Override
	public void move() throws Exception{

		IElement down = element.getMine().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];
		IElement downr = element.getMine().getElements()[element.getPosition().getX()+1][element.getPosition().getY()+1];
		IElement right = element.getMine().getElements()[element.getPosition().getX()+1][element.getPosition().getY()];
		IElement downl = element.getMine().getElements()[element.getPosition().getX()-1][element.getPosition().getY()+1];
		IElement left = element.getMine().getElements()[element.getPosition().getX()-1][element.getPosition().getY()];
	
		if(down.getClass() == model.Background.class){
			this.motion = true;
			this.element.getBehaviour().moveDown();
		}
		if(down.getClass() != model.Background.class && left.getClass() == model.Background.class && downl.getClass() == model.Background.class && (down.getClass() == model.Diamond.class || down.getClass() == model.Stone.class)){
			this.motion = true;
			this.element.getBehaviour().moveLeft();
			this.element.getBehaviour().moveDown();
		}
		
		if(down.getClass() != model.Background.class && right.getClass() == model.Background.class && downr.getClass() == model.Background.class && (down.getClass() == model.Diamond.class || down.getClass() == model.Stone.class)){
			this.motion = true;
			this.element.getBehaviour().moveRight();
			this.element.getBehaviour().moveDown();
		}
		if(down.getClass() != model.Background.class && down.getClass() == model.Enemy.class) {
			IElement enemy = element.getMine().getElements()[element.getPosition().getX()][element.getPosition().getY()+1];
			
			int x = enemy.getPosition().getX();
	    	int y = enemy.getPosition().getY();
	    	int xMax = enemy.getPosition().getMaxX();
	    	int yMax = enemy.getPosition().getMaxY();
	    	
	    	this.element.getMine().destroyElement(enemy);
	    	
	    	IElement diamond = new Diamond(new Position(x,y,xMax,yMax),Enemy.mine);

	    	this.element.getMine().setElement(x, y, diamond);

	    	this.element.getMine().addGravity(diamond);
		}
		if(down.getClass() != model.Background.class && down.getClass() == model.Hero.class && this.motion == true) {
			
	    	Hero.getInstance().explosion();

		}
		if(down.getClass() != model.Background.class){
			this.motion = false;
		}
	}
	
}
