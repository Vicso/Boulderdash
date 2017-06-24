package view;

import javax.swing.*;


import model.IBoulderDashModel;
import java.awt.event.*;

/**
 * <h1>The Class GameFrame provides the method to use the different keyboard interactions</h1>
 *
 * @version 1.0
 */
class GameFrame extends JFrame implements KeyListener {

	/**
	 * 	Generated Serialized ID
	 */
	private static final long serialVersionUID = 3792052992605473420L;
	private IEventPerformer eventPerformer;


	/**
	 * Create the constructor of GameFrame
	 * @param title
	 * 		For the title of frame
	 * @param performer
	 *		For the event perform
	 * @param builder
	 *		Use for set what element to built
	 * @param model
	 * 		For set a model
	 */
	public GameFrame(String title, IEventPerformer performer, IElementBuilder builder, IBoulderDashModel model){
		
		this.setTitle(title);
		//this.setLocationRelativeTo(null);
		this.setSize(1620, 1010);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		GamePanel panel = new GamePanel(builder, model);
		
		/**
		 * Display Test
		 */
		System.out.println("test");
		
		/**
		 * Say that Pane content panel
		 */
		this.setContentPane(panel);
		
		/**
		 * Add Observer to the panel
		 */
		model.observerAdd(panel);
		
		/**
		 * Use the keyController
		 */
		addKeyListener(this);

		this.eventPerformer = performer;

		/**
		 * Show the frame
		 */
		this.setVisible(true);
		
	    
	}
	 
	/**
	 * Use for research the key who is typed
	 * @param e
	 * 		Name of key event
	 */
	@Override
	public void keyTyped(KeyEvent e) {

		//this.eventPerformer.eventPerform(e);
	}

	/**
	 * Use for research the key who is pressed
	 * @param e
	 * 		Name of key event
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		try {
			eventPerformer.eventPerform(e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Use for research the key who is released
	 * @param e
	 * 		Name of key event
	 */
	@Override
	public void keyReleased(KeyEvent e) {

		//this.eventPerformer.eventPerform(e);

	}
	
	
}
