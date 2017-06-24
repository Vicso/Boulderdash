package view;

import controller.IOrderPerformer;
import model.IBoulderDashModel;

/**
 * <h1>The class BoulderDashView</h1>
 *
 * @version 1.2
 */

public class BoulderDashView implements Runnable, IView {
	
	/** Allow to perform an element to the controller */
	private IEventPerformer eventPerformer;
	/** Print the different model's element on the screen */
	private IElementBuilder elementBuilder;
	/** The controller */
	private IOrderPerformer OrderPerformer;
	/** The model, principal data of the game */
	private IBoulderDashModel model;
	
	/**
	 * Instantiate a new View
	 */
	public BoulderDashView(){}

    /**
     * Set the current model and take the actual order
     * @param model
	 * 		Use for set the actual model
     * @param order
     *      Use for set the order perform
     */
	public void start(IBoulderDashModel model, IOrderPerformer order) {
        this.OrderPerformer = order;
		this.model = model;
		this.run();
	}


    /**
     * @see IView
     * @param message
     *      the message to display
     */
	@Override
	public void displayMessage(String message) {
	}


    /**
     * @see Runnable
     */
    @Override
	public void run() {
		this.eventPerformer = new EventPerformer(OrderPerformer);
    	this.elementBuilder = new ElementBuilder(this.model);
    	new GameFrame("BoulderDash", this.eventPerformer, elementBuilder, model);
	}

}