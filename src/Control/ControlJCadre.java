package Control;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;

import javax.swing.BorderFactory;

import Abstraction.ImageLibrary;
import Presentation.JVignette;

public class ControlJCadre implements MouseListener{
    
	JVignette cadre;
	ControlJBandeau ctrBandeau; 
	
	public ControlJCadre(JVignette vignette, ControlJBandeau B) {
    	   this.cadre = vignette ;
    	   ctrBandeau = B;
       }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		ctrBandeau.setImage(cadre.getNom());
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
