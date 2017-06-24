package controller;

import model.Direction;
import model.IBoulderDashModel;
import model.IElement;
import view.IView;

/**
 * <h1>The class BoulderDashPerformer</h1>
 *
 * @version 1.0
 */

public class BoulderDashPerformer implements IOrderPerformer{

	/** The model */
    private IBoulderDashModel ActualModel;
    /** The view */
    private IView ActualView;
    /** The hero */
    private IElement hero;
    /** The enemy */
    private IElement enemy;
    /** The gravity */
    private IElement gravity;

    /**
     * Create constructor
      * @param BoulderDashModel
     *      Use for set the actual model
     * @param view
     *      Use for set the actual view
     */
	public BoulderDashPerformer(IBoulderDashModel BoulderDashModel, IView view) {

        ActualModel = BoulderDashModel;
        ActualView = view;
    }

	/**
	 * Instantiate a controller only
	 */
    public BoulderDashPerformer() {}

	/**
     * Principal method use for get back initial position of some element
      * @throws Exception
     *      Game loop exception
     */
	public void play() throws Exception {
       ActualView.start(this.ActualModel, this);
       this.hero = this.ActualModel.getHero();
       
       if(!this.ActualModel.getEnemy().isEmpty()){
    	   this.enemy = this.ActualModel.getEnemy().get(1);
       }
 
       this.gravity = this.ActualModel.getGravity().get(1);
       this.gameLoop();
	}

	/**
	 * create a loop and a thread for enemy and gravity
	 * @throws Exception
     *      thread exception
	 */
	private void gameLoop() throws Exception {
		while(this.hero != null){
			if(!this.ActualModel.getEnemy().isEmpty()){
				this.enemy.getBehaviour().moveAll();
		    }
			this.gravity.getBehaviour().Gravit();
			Thread.sleep(100);
		}
	}
	
	/**
	 * @throws Exception
	 * 		Thread Exception
	 * @see IOrderPerformer
	 */
	@Override
	public void OrderPerform(Order order) throws Exception {

		if (order == Order.DOWN){
			this.hero.setDirection(Direction.DOWN);
	    }
	    if (order == Order.UP){
	      	this.hero.setDirection(Direction.UP);
	    }
	    if (order == Order.RIGHT){
	        this.hero.setDirection(Direction.RIGHT);
	    }
	    if (order == Order.LEFT){
	       	this.hero.setDirection(Direction.LEFT);
	    }
	    this.hero.getBehaviour().move();
    }

    /**
     * Method use when we want end the game
     * @throws Exception
	 * 		Exception not enough diamond
     */
	public void EndGame(int diamond) throws Exception{

            if (diamond < 10)
                throw new Exception("Not enough diamond");
            else
                this.ActualModel.setGame(false);
    }
}
