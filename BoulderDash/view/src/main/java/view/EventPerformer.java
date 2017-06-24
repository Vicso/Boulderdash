package view;

import java.awt.event.KeyEvent;
import controller.IOrderPerformer;
import controller.Order;

/**
 * <h1>The class EventPerformer</h1>
 *
 * @version 1.1
 */

public class EventPerformer implements IEventPerformer {
	
	private IOrderPerformer orderPerformer;


	/**
	 * Instantiate EventPerformer
	 * @param orderPerformer
	 * 		Set what order is perform
	 */
	public EventPerformer(IOrderPerformer orderPerformer){
		this.orderPerformer = orderPerformer;
	}


	/**
	 * do a action in function of what command type by the player
	 * @param keycode
	 * 		the key code of the order
	 * @throws Exception
	 * 		Order perform exception
	 */
    private void keyCodeToUserOrder(int keycode) throws Exception{
		switch(keycode){
			case KeyEvent.VK_DOWN :
				this.orderPerformer.OrderPerform(Order.DOWN);
				break;
			case KeyEvent.VK_UP :
				this.orderPerformer.OrderPerform(Order.UP);
				break;
			case KeyEvent.VK_RIGHT :
				this.orderPerformer.OrderPerform(Order.RIGHT);
				break;
			case KeyEvent.VK_LEFT :
				this.orderPerformer.OrderPerform(Order.LEFT);
				break;
		}
	}


	/**
	 * @see IEventPerformer
	 * @param keyCode
	 * 		The key code of the event
	 * @throws Exception
	 * 		the exception of key code
	 */
	@Override
	public void eventPerform(KeyEvent keyCode) throws Exception {
		
		this.keyCodeToUserOrder(keyCode.getKeyCode());
	}

}
