package view;


/**
 * <h1>The interface IEventPerformer</h1>
 *
 * @author Arnaud Rigaut
 * @version 1.0
 */

import java.awt.event.KeyEvent;

interface IEventPerformer {

	/**
	 * method use for transform and send the command set by the player
	 * @param keyCode
     *      key code of the command
	 * @throws Exception
	 * 		key code exception
	 */

	void eventPerform(KeyEvent keyCode) throws Exception;
	
}

