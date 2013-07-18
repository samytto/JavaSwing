import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format.Field;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Question5 {
	JFrame fenetre = new JFrame();
    JPanel pan_North = new JPanel();
	JPanel pan_South = new JPanel();
	JPanel pan_Center = new JPanel();
	JPanel pan_liste = new JPanel();
	JPanel pan_slider = new JPanel();
	JPanel pan_bg_button = new JPanel();
	String couleur[] ={"green","blue","red","magenta","orange"};
	SpinnerListModel modelecouleur = new SpinnerListModel(couleur);
	JSpinner spinner = new JSpinner(modelecouleur);
	JComboBox liste = new JComboBox(couleur);
	JSlider slider = new JSlider(0,1,5,1);
	ButtonGroup bg = new ButtonGroup();
	JRadioButton green = new JRadioButton("green");
	JRadioButton blue = new JRadioButton("blue");
	JRadioButton red = new JRadioButton("red");
	JRadioButton magenta = new JRadioButton("magenta");
	JRadioButton orange = new JRadioButton("orange");
	JTextField text = new JTextField("green",10);
 Question5(){
	 fenetre.setSize(700,200);	
     fenetre.setTitle("Question 5");
     fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     fenetre.setLocation(400,40);
     fenetre.setResizable(false);
     fenetre.setVisible(true);
     
     Container panneau = fenetre.getContentPane();
     panneau.setLayout(new BorderLayout());
     spinner.setPreferredSize(new Dimension(80,30));
     // On joute le JSpinner au panel du haut
     pan_North.add(spinner);
     //on initialise le panel de la liste
     pan_liste.setPreferredSize(new Dimension (100,70));
     pan_liste.add(liste);
   //on initialise le panel de la JSlider
     pan_slider.setPreferredSize(new Dimension(200,70));
     slider.setMinorTickSpacing(1);
     slider.setPaintTicks(true);
     pan_slider.add(slider);
   //on initialise le panel du groupe button
     pan_bg_button.setPreferredSize(new Dimension (350,70));
     bg.add(blue); bg.add(green); bg.add(red); bg.add(magenta); bg.add(orange);
     pan_bg_button.add(green); pan_bg_button.add(blue); pan_bg_button.add(red); 
     pan_bg_button.add(magenta); pan_bg_button.add(orange);
     // on ajoute nos panneux au panel du centre de la fenetre
     pan_Center.add(pan_liste); pan_Center.add(pan_slider); pan_Center.add(pan_bg_button);
   //on initialise le panel du JTextField
     JLabel lab1 = new JLabel("color name (english) ? ");
     pan_South.add(lab1);
     pan_South.add(text);
     pan_South.setBorder(BorderFactory.createTitledBorder("panel de saisie"));
     // On ajoute les panneaux south, north et center au panneau principal
     panneau.add(pan_North,BorderLayout.NORTH);
     panneau.add(pan_Center,BorderLayout.CENTER);
     panneau.add(pan_South,BorderLayout.SOUTH);
     
     //on ajoute les listener a nos composants
     text.addActionListener(new Composant_Listener());
     liste.addActionListener(new Composant_Listener()); 
     green.addActionListener(new Composant_Listener());
     blue.addActionListener(new Composant_Listener());
     red.addActionListener(new Composant_Listener());
     magenta.addActionListener(new Composant_Listener());
     orange.addActionListener(new Composant_Listener());
     spinner.addChangeListener(new Composant_Listener());
     slider.addChangeListener(new Composant_Listener());
 }
 
 public class Composant_Listener implements ActionListener,ChangeListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==text) {pan_South.setBackground(getColor(text.getText()));}
		if (e.getSource()==liste) {pan_liste.setBackground(getColor(couleur[liste.getSelectedIndex()]));}
		if (e.getSource()==green){pan_bg_button.setBackground(getColor(couleur[0]));}
		if (e.getSource()==blue){pan_bg_button.setBackground(getColor(couleur[1]));}
		if (e.getSource()==red){pan_bg_button.setBackground(getColor(couleur[2]));}
		if (e.getSource()==magenta){pan_bg_button.setBackground(getColor(couleur[3]));}
		if (e.getSource()==orange){pan_bg_button.setBackground(getColor(couleur[4]));}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==spinner) {pan_North.setBackground(getColor((String)spinner.getValue()));}
		if (e.getSource()==slider)  {pan_slider.setBackground(getColor(couleur[slider.getValue()-1]));}
	 } 
 }
 
 public Color getColor(String colorName) {
	 try {
	 // Find the field and value of colorName
	 java.lang.reflect.Field field = Class.forName("java.awt.Color").getField(colorName);
	 return (Color)field.get(null);
	 }
	 catch (Exception e) { return null;}
	 }
 
}
