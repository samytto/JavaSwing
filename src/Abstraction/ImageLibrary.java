package Abstraction;
import java.util.Observable;


/**
 * TP4 : bibliotheque d images
 */

public class ImageLibrary extends Observable {

	private static int message_counter = 0;
	public final static Integer MESSAGE_IMAGE_COURANTE = 1;
	public final static Integer MESSAGE_CHANGEMENT_TAILLE = 2;
	public final static Integer MESSAGE_NOUVELLE_IMAGE = 3;

	
	/**
	 * taille maximale de la bibliotheque d images
	 */
	final int max_size = 50;


	
	private final String images[] = { "Constantine.png", "Annaba.png", "Djanet.png"};
	// tableau d initialisation de la librairie d images

	private ImageItem library[]; // bibliotheque d image
	private int current_size; // taille courante de la bibliotheque
	private int currentindex; // index de l image courante

	public ImageLibrary() {
		library = new ImageItem[max_size];
		current_size = 0;
		for (int i = 0; i < images.length; i++) {
			this.addImage(images[i]);
		}
		currentindex = 0;
	}

	/**
	 * Renvoie la taille de la bibliotheque.
	 * 
	 */
	public int getSize() {
		return current_size;
	}
	
	/**
	 * Renvoie la taille maximale de la bibliotheque.
	 * 
	 */
	public int getMaxSize() {
		return max_size;
	}

	/**
	 * Ajoute une image � la bibliotheque.
	 * 
	 * @param nom donn� � l image
	 * @param chemin complet du fichier
	 */
	public void addImage(String imagename, String fullpathname) {
		if (current_size < max_size) {
			library[current_size] = new ImageItem(imagename, fullpathname);
			current_size++;
		}
		this.setChanged();
		this.notifyObservers(MESSAGE_NOUVELLE_IMAGE);
	}

	/**
	 * Renvoi une image de la bibliotheque.
	 * 
	 * @param i  indice de l image a retourner
	 */
	public ImageItem getImage(int i) {
		if ((i < current_size) && (i >= 0))
			return this.library[i];
		else
			return null;
	}

	/**
	 * Permet de recuperer l indice de l image courante de la bibliotheque
	 */
	public int getCurrent() {
		return this.currentindex;
	}

	/**
	 * Avance d un indice dans la bibliotheque
	 */
	public int getNext() {
		setCurrent(currentindex + 1);
		return this.currentindex;
	}

	/**
	 * Recule d un indice dans la bibliotheque
	 */
	public int getPrev() {
		setCurrent(currentindex - 1);
		return this.currentindex;
	}

	/**
	 * Permet de modifier l indice de l image courante de la bibliotheque
	 */
	public void setCurrent(int cindex) {
		if ((cindex < current_size) && (cindex >= 0)) {
			this.currentindex = cindex;
			this.setChanged();
			this.notifyObservers(MESSAGE_IMAGE_COURANTE);
		}
	}

	/**
	 * Renvoi l image courante de la bibliotheque.
	 * 
	 */	
	public ImageItem getCurrentImage() {
		return this.library[currentindex];
	}

	public int getCurrentScaleFactor() {
		return this.library[currentindex].getScaleFactor();
	}

	public void scaleCurrentImage(Float factor) {
		this.library[currentindex].scaleImage(factor);
		this.setChanged();
		this.notifyObservers(MESSAGE_CHANGEMENT_TAILLE);
	}

	/**
	 * Ajoute une image a la bibliotheque a partir du repertoire ./images
	 * 
	 * @param nom
	 *            du fichier seul de l image placee dans le repertoire ./images
	 *            de l application
	 */
	private void addImage(String filename) {
		this.addImage(filename, "images/" + filename);
	}

}






