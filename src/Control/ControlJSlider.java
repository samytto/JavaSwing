package Control;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Abstraction.ImageLibrary;

public class ControlJSlider implements Observer, ChangeListener {
	
	ImageLibrary library;
	JSlider slider;
	
	public ControlJSlider(ImageLibrary lib, JSlider slider) {
		this.library = lib;
		this.slider = slider;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
this.slider.setValue(library.getCurrentScaleFactor());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
      this.library.scaleCurrentImage((float) slider.getValue());
      
      System.out.println("Jslider "+this.library.getCurrentScaleFactor());
	}

}
