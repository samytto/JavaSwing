package Presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JVignette extends JPanel{
	
	private String nom;
	
	JVignette(String nomImg){
		super();
		this.nom = nomImg;
		JLabel img = new JLabel(new ImageIcon("images/"+nomImg+".png"));
		img.setPreferredSize(new Dimension (10, 50));
		JLabel etiq = new JLabel (nomImg);
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(100,100));
		img.setPreferredSize(new Dimension(60,40));
		this.add(img);
		this.add(etiq);
	}
	
	public String getNom() { return this.nom; }


}
