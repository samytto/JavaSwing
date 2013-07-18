package Control;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;

import Abstraction.ImageLibrary;
import Presentation.JBandeau;

public class ControlJBandeau implements Observer{

	ImageLibrary model;
	JBandeau bandeau;
	
	public ControlJBandeau(ImageLibrary lib) {
		this.model = lib;
	}
	
	public void setImage(String nomImg){
		int i;
		for (i=0; i<bandeau.taille() && bandeau.listeCadre[i].getNom() != nomImg; i++);
		model.setCurrent(i);
	}
	
	public void setBandeau(JBandeau B) { this.bandeau=B; }


	@Override
	public void update(Observable library, Object type_Change) {
		// TODO Auto-generated method stub
		if(type_Change==ImageLibrary.MESSAGE_IMAGE_COURANTE) { System.out.println("JBandeau");
		for (int i=0; i<bandeau.taille() ; i++) 
	         if (i != model.getCurrent() ) 
		                bandeau.listeCadre[i].setBorder(BorderFactory.createLineBorder(Color.white));
		     else  bandeau.listeCadre[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                                        } }
}