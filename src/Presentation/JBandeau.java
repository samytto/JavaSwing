package Presentation;

import java.awt.Dimension;

import javax.swing.JPanel;

public class JBandeau extends JPanel {

	public JVignette[] listeCadre;   
	
	JBandeau (JVignette[] tabV) {
		super();
		listeCadre = tabV;
		for(int i=0; i<tabV.length; i++) this.add(tabV[i]); 
	}
	
	public int taille() {
		return listeCadre.length; 
		                  }
	
}
