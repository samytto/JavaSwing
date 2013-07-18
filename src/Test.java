import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*; 


public class Test {
	
	JFrame fenetre = new JFrame();
	JButton b1 = new JButton("CouCou"); 
	JButton b2 = new JButton("Bouton 2"); 
	JPanel pan_East = new JPanel();
	JPanel pan_West = new JPanel();
	JPanel pan_Center = new JPanel();
	JPanel pan_North = new JPanel();
	JPanel pan_South = new JPanel();
	JLabel lab1 = new JLabel(new ImageIcon("Images/Programs.gif"));
	JLabel lab2 = new JLabel(new ImageIcon("Images/Documents.gif"));
	JLabel lab3 = new JLabel(new ImageIcon("Images/Users.gif"));
	JLabel lab4 = new JLabel(new ImageIcon("Images/System.gif"));
	JLabel lab = new JLabel("0");
	JMenuBar menu = new JMenuBar();
	JMenu fichier = new JMenu("Fichier");
	JMenu edition = new JMenu("Edition");
	JMenuItem ouvrir = new JMenuItem("Ouvrir");
	JMenuItem sauver = new JMenuItem("Sauver");
	JMenuItem copier = new JMenuItem("Copier");
	JMenuItem coller = new JMenuItem("Coller");
	JCheckBoxMenuItem affichage = new JCheckBoxMenuItem("Affichage");
	Container panneau;
            Test () {
            fenetre.setSize(300,200);	
            fenetre.setTitle("Question 1");
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setLocation(10,40);
            fenetre.setResizable(false);
            fenetre.setVisible(true);
                       
            panneau = fenetre.getContentPane();
            panneau.setLayout(new BorderLayout());
            b1.setPreferredSize(new Dimension(140,50)); b2.setPreferredSize(new Dimension(140,50));
            /*panneau.add(b1);   panneau.add(b2);
            panneau.add(new JButton("1"));
            panneau.add(new JButton("2"));
            panneau.add(new JButton("3"));
            panneau.add(new JButton("4"));
            panneau.add(new JButton("5")); panneau.add(new JButton("6"));
            panneau.add(new JButton("7")); */
            
            //on ajoute les labels dans leurs panneaux repsctifs
            pan_East.add(lab1); pan_West.add(lab2); pan_North.add(lab3); pan_South.add(lab4);
           
            // on modifie les bordures de chaque panneaux
            Border B = BorderFactory.createRaisedBevelBorder();
           pan_East.setBorder(B); pan_West.setBorder(B); pan_North.setBorder(B); pan_South.setBorder(B);
            
           // On associe un BorderLayout au Panneau du centre 
            pan_Center.setLayout(new BorderLayout());
            
            // on ajoute pan_North et pan_South dans le pan_Center
            pan_Center.add(pan_North, BorderLayout.CENTER);
            pan_Center.add(pan_South, BorderLayout.SOUTH);
            
            //on ajoute nos panneaux dans notre container
            panneau.add(pan_Center, BorderLayout.CENTER);
            panneau.add(pan_East, BorderLayout.EAST);
            panneau.add(pan_West, BorderLayout.WEST);
            
         // On ajoute un MenuBar a notre fenetre
            fenetre.setJMenuBar(menu);
            //on insere les JMenu a notre JManuBar 
            menu.add(fichier); menu.add(edition);
            
            //On insere les JMeniItem a nos JMenu
            fichier.add(ouvrir); fichier.add(sauver); fichier.addSeparator(); fichier.add(affichage);
            edition.add(copier); edition.add(coller); 
            
            
            
            }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Test F1 = new Test();
	Question5 F2 = new Question5();
	}

}
