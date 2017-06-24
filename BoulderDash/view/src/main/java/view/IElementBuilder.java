package view;

import model.IBoulderDashModel;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

		/**
		 * 
		 * @version 1.0
		 */
		interface IElementBuilder {


		/**
		 * Translate The Model into Graphic 
		 * @param graphics
		 * 		Name of the graphic
		 * @param obs
		 * 		Name of observer
		 */
	void applyModelToGraphic(Graphics graphics, ImageObserver obs) throws Exception;

	IBoulderDashModel getModel();
	
}
