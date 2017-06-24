package model;

/**
 * <h1>The Class Behaviour Move</h1>
 * @version 1.1
 */
public class BehaviourMove implements IBehaviourMove {

	/** The element */
	Element element;
	
	/** Instantiate a new move's behaviour*/
	BehaviourMove(Element element){
		this.element = element;
	}


	/**
	 * @see IBehaviourMove
	 * @throws Exception
	 * 		behaviour exception
	 */
	@Override
	public void move() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see IBehaviourMove
	 * @throws Exception
	 *		position Exception
	 */
	@Override
	synchronized public void moveRight() throws Exception{
		
		int x = this.element.getPosition().getX();
		int y = this.element.getPosition().getY();
		
		this.element.getPosition().setX(x+1);
		this.element.getMine().getElements()[x+1][y] = this.element;
		this.element.getMine().getElements()[x][y] = new Background(new Position(x,y,Mine.WIDTH, Mine.HEIGHT),this.element.getMine());
		
		this.element.getMine().getModel().effectiveChanged();
	}


	/**
	 * @see IBehaviourMove
	 * @throws Exception
	 * 		position exception
	 */

	@Override
	synchronized public void moveLeft() throws Exception{
		
		int x = this.element.getPosition().getX();
		int y = this.element.getPosition().getY();
		
		this.element.getPosition().setX(x-1);
		this.element.getMine().getElements()[x-1][y] = this.element;
		this.element.getMine().getElements()[x][y] = new Background(new Position(x,y,Mine.WIDTH, Mine.HEIGHT),this.element.getMine());
		
		
		this.element.getMine().getModel().effectiveChanged();
	}


	/**
	 * @see IBehaviourMove
	 * @throws Exception
	 *		position exception
	 */
	@Override
	synchronized public void moveUp() throws Exception{
		
		int x = this.element.getPosition().getX();
		int y = this.element.getPosition().getY();
		
		this.element.getPosition().setY(y-1);
		this.element.getMine().getElements()[x][y-1] = this.element;
		this.element.getMine().getElements()[x][y] = new Background(new Position(x,y,Mine.WIDTH, Mine.HEIGHT),this.element.getMine());
		
		
		this.element.getMine().getModel().effectiveChanged();
	}


	/**
	 * @see IBehaviourMove
	 * @throws Exception
	 * 		position exception
	 */
	@Override
	synchronized public void moveDown() throws Exception{
		
		int x = this.element.getPosition().getX();
		int y = this.element.getPosition().getY();
		
		this.element.getPosition().setY(y+1);
		this.element.getMine().getElements()[x][y+1] = this.element;
		this.element.getMine().getElements()[x][y] = new Background(new Position(x,y,Mine.WIDTH, Mine.HEIGHT),this.element.getMine());
		
		
		this.element.getMine().getModel().effectiveChanged();
	}


	/**
	 * @see IBehaviourMove
	 * @throws Exception
	 * 		position exception
	 */
	@Override
	public void moveAll() throws Exception {
		
	}


	/**
	 * @see IBehaviourMove
	 * @throws Exception
	 * 		position exception
	 */
	@Override
	public void Gravit() throws Exception{
		
	}

}
