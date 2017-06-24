package view;


import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


import model.IBoulderDashModel;

/**
 * <h1>The Class GamePanel</h1>
 *
 * @version 1.0
 */
class GamePanel extends JPanel implements Observer {
	
	
	/**
	 * Generated Serialized ID
	 */
	private static final long serialVersionUID = 2451228009089487119L;

	private IElementBuilder elementBuilder;
	
	public GamePanel(IElementBuilder builder, IBoulderDashModel model){
		
		this.elementBuilder = builder;
		repaint();
	}

	/**
	 * the method create from Observable
	 * @param o
	 * 		observable name
	 * @param arg
	 * 		object name to update
	 */
	@Override
	public void update(Observable o, Object arg) {

		repaint();
	}
	
	/**
	 * allows to paint the component on the frame
	 * @param g
	 * 		name the graphic
	 */
	public void paintComponent(Graphics g){
		
		
		if(this.elementBuilder.getModel().isGame()){
			try {
				this.elementBuilder.applyModelToGraphic(g, this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(!this.elementBuilder.getModel().isGame()) {
			this.elementBuilder.getModel().observerDelete(this);
			int score = this.elementBuilder.getModel().getScore();
			JOptionPane.showMessageDialog(null, "End of the Game\n Score : "+String.valueOf(score));
			System.exit(0);
		}

	}
}
