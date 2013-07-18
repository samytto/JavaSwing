package Presentation;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Abstraction.*;
import Control.*;

public class TP4 extends JFrame {

	ImageLibrary model;
	int currentCadre;
	JLabel ImageCenter;
	JVignette[] V;
	ControlJLabel cjl;
	//simplifie le code de construction de la JFrame
	final Container pane = this.getContentPane();
	
	/**
	 * on declare en donnee membres les composants importants de l interface qui
	 * vont servir a plusieurs endroits
	 */
	
	// TODO 1 
		
	public TP4(ImageLibrary imglib) {

		// TODO : A CHANGER  
		setTitle("MVC");		
		// on conserve la reference du modele de bibliotheque d Images
		model = imglib;

		// JFrame organisee en BorderLayout
		pane.setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		});

		BuildCentre();
		BuildSlider();
		BuildBas();
		BuildListe();		
		BuildMenu();	// la question optionnelle	

	}
	/**
	 * Question 4.1.2 : La vue (IHM)
	 */

	/**
	 * A : Afficher l'image courante
	 */
	void BuildCentre() {
		/**
		 * JPanel central contenant le JLabel (et donc l image)
		 */
		
		// TODO
		ImageCenter = new JLabel(model.getImage(0));
		cjl = new ControlJLabel(ImageCenter);
		model.addObserver(cjl);
		cjl.setModel(model);
		
		pane.add(ImageCenter, BorderLayout.CENTER);
		
	}
	
	/**
	 * B : Bandeau des images dans la partie basse
	 */
	void BuildBas() {
		// TODO
		V = new JVignette[model.getSize()]; JBandeau B=null;
		ControlJCadre[] ctrl = new ControlJCadre[V.length];
		ControlJBandeau ctrJB = new ControlJBandeau(model);
		
		for (int i=0; i<model.getSize(); i++) 
		{
			 // on créé l'instance cadre
		     V[i] = new JVignette(model.getImage(i).getName());
		     //on créé le controleur du cadre
		     ctrl[i] = new ControlJCadre(V[i], ctrJB);
		     // on ajoute au cadre son controleur comme observateur
		     V[i].addMouseListener(ctrl[i]);
		     
		 }
		
		B = new JBandeau (V);
		ctrJB.setBandeau(B);
		model.addObserver(ctrJB);
		pane.add(B, BorderLayout.SOUTH);
	}


	/**
	 *  C : Le slider de redimensionnement
	 */
	void BuildSlider() {
		// TODO
		JSlider slider = new JSlider(1,0,300,0);
		ControlJSlider ctrSlider = new ControlJSlider(model, slider);
		slider.addChangeListener(ctrSlider);
		model.addObserver(ctrSlider);
		slider.setMajorTickSpacing(100);
		slider.setMinorTickSpacing(10);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		pane.add(slider, BorderLayout.EAST);
	}

	/**
	 *  D : La liste sur la gauche
	 */
	void BuildListe() {
		// TODO
		String[] images = {"Constantine","Annaba","Djanet"};
		JList liste =new JList(images);
		ControlJListe ctrListe = new ControlJListe(model, liste);
		model.addObserver(ctrListe);
		liste.addListSelectionListener(ctrListe);
		pane.add(liste, BorderLayout.WEST);
	}

	/**
	 * Question 4.3 (Optionnelle) : Menu pour ajouter une image
	 */ 
	void BuildMenu() {
		// TODO
		JMenuBar MB = new JMenuBar();
		JMenu M = new JMenu("Fichier");
		JMenuItem AjoutImg = new JMenuItem ("Ajouter une image");
		JMenuItem quit = new JMenuItem ("Quitter");
		MB.add(M); M.add(AjoutImg); M.add(quit);
		this.setJMenuBar(MB);
	}
	
	public void SetImage(JLabel img) {
		this.ImageCenter=img;
	}
	
}