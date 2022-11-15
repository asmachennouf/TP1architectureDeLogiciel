package package1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp1 {

	public static void main(String[] args) throws IOException {
		
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// cr�ation de la fen�tre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// cr�ation de la z�ne de dessin dans la fen�tre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fen�tre
		laFenetre.setVisible(true);
		
		// les objets formes graphique mouvement circulaire
				d.ajouterObjet(new AnimationForme(new Etoile(350,100,50,8.f,Color.RED,Color.YELLOW), new MvtCirculaire(250,250,180,0,5)));
				d.ajouterObjet(new AnimationForme(new PolygoneRegulier(5,240,40,40,4.0f,Color.DARK_GRAY, null), new MvtCirculaire(210,210,180,0,5)));
				d.ajouterObjet(new AnimationForme(new Visage(d,300,500,40,60), new MvtCirculaire(250,250,180,0,5)));
		
		
				
		// les trains de cercles avec image et en couleur
		TrainCercle[] lesTrains= new TrainCercle[5];
		lesTrains[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesTrains[0]);
		lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesTrains[1]);
		for (int i = 2; i < 5; i++) {
			lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		d.ajouterObjet(lesTrains[i]);
		}
		
		
		
		
		while(true) {
		// la zone de dessin se r�affiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//r�aliser � tous les trains un d�placement �l�mentaire
		d.animer();
		
		}

	}

}
