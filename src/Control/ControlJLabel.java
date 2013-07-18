package Control;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import Abstraction.ImageLibrary;

public class ControlJLabel implements Observer {

	private JLabel label;
	private ImageLibrary library;
	
	public ControlJLabel(JLabel L){
		this.label=L;
	}
	
	@Override
	public void update(Observable model, Object type_change) {
		// TODO Auto-generated method stub
		if (model instanceof ImageLibrary) {
if (type_change == ImageLibrary.MESSAGE_IMAGE_COURANTE)  
	   this.label.setIcon(library.getCurrentImage());  

else if (type_change == ImageLibrary.MESSAGE_CHANGEMENT_TAILLE) 
          { 	
	this.label.setIcon(library.getCurrentImage());
	this.label.repaint();
          }                                  }
	}
	public void setModel(ImageLibrary lib) {
		this.library = lib;
	}
}
