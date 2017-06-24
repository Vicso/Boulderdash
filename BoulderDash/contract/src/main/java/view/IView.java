package view;

import controller.IOrderPerformer;
import model.IBoulderDashModel;

/**
 * <h1>The Interface IView.</h1>
 *
 * @version 1.0
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);


    /**
     * start the game view
     * @param model
     *      Get actual Model
     * @param order
     *      Get the order
     */
    void start(IBoulderDashModel model, IOrderPerformer order);
}
