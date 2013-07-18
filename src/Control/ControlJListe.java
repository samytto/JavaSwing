package Control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Abstraction.ImageLibrary;

public class ControlJListe implements ListSelectionListener,Observer{
	
	ImageLibrary library;
	JList liste;
	
	public ControlJListe(ImageLibrary lib, JList liste) {
	this.library = lib;
	this.liste = liste;
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		liste.setSelectedIndex(library.getCurrent());
	}



	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		library.setCurrent(liste.getSelectedIndex());
	}

}
