package package1;

import java.awt.Graphics;

public class Visage implements IObjetAnimable{
	
	public static final int LARGEUR_DEFAUT =50;
	
	public static final int HAUTEUR_DEFAUT =50;
	
	public static final int LARGEUR_MIN =15;
	
	public static final int HAUTEUR_MIN =15;
	
	public static final int DEPLACEMENT_DEFAUT =5;
	
	private Dessin d;
	
	private int xhg = 0;
	
	private int yhg = 0;
	
	private int largeur;
	
	private int hauteur;
	
	private int dx = DEPLACEMENT_DEFAUT;
	private int dy = DEPLACEMENT_DEFAUT;
	
	private boolean impassible = true;
	
	public Visage(Dessin d) {
		this(d, d.getLargeur() / 2, d.getHauteur() / 2, LARGEUR_DEFAUT, HAUTEUR_DEFAUT);
	}
	
	public Visage(Dessin d, int xg, int yg) {
		this(d, xg, yg, LARGEUR_DEFAUT, HAUTEUR_DEFAUT);
	}
	
	public Visage(Dessin d, int xg, int yg, int larg, int haut) {
		this.d = d;
		this.xhg= xg;
		this.yhg= yg;
		this.largeur = Math.max(larg,  LARGEUR_MIN);
		this.hauteur = Math.max(haut,  HAUTEUR_MIN);
	}
	
	public int getDex() {
		return dx;
	}
	
	public void setDex(int v) {
		this.dx = v;
	}
	
	public int getDy() {
		return dy;
	}
	
	public void setDy(int v) {
		this.dy = v;
	}
	
	public void inverserDx() {
		dx = -dx;
		this.changeExpression();
	}
	public void inverserDy() {
		dy = -dy;
		this.changeExpression();
	} 
	
	public void inverserDxEtDy() {
		dx =-dx;
		dy = -dy;
		this.changeExpression();
	}
	
	public void changeExpression() {
		impassible = !impassible;
	}
	
	public void deplacerSansRebond() {
		xhg += dx;
		xhg += dy;
	}
	
	public void deplacer() {
		if (bordGaucheAtteint() || bordDroitAtteint()) {
			inverserDx();
		}
		if(bordHautAtteint() || bordBasAtteint()) {
			inverserDy();
		}
		deplacerSansRebond();
	}
	
	public boolean bordGaucheAtteint() {
		return (xhg < 0 );
	}
	
	public boolean bordDroitAtteint() {
		return ((xhg + largeur)> d.getLargeur() );
	}
	
	public boolean bordHautAtteint(){
		return (yhg < 0);
	}
	
	public boolean bordBasAtteint() {
		return ((yhg + hauteur)>= d.getHauteur() );
	}
	
	public boolean bordAtteint() {
		return bordDroitAtteint() ||  bordGaucheAtteint() || bordHautAtteint() || bordBasAtteint(); 
	}
	
	
	public void dessiner(Graphics g) {
	   g.drawOval(xhg, yhg, largeur, hauteur);
	   if(impassible) {
		   g.drawLine(xhg +largeur /4, yhg +(2 * hauteur) /3,
				   xhg + (3 * largeur) /4, yhg + (2 * hauteur)/ 3);
	   } else {
		   g.drawArc(xhg +largeur /4, yhg +(2 * hauteur) /3,
				   largeur /2, hauteur/ 5, -45, -90);
	   }
	   
	   int largeurOeil = largeur / 5;
	   int hauteurOeil = hauteur / 5;
	   g.drawOval(xhg + largeurOeil, yhg +hauteurOeil, largeurOeil,hauteurOeil);
	   g.drawOval(xhg + 3 * largeurOeil, yhg + hauteurOeil, largeurOeil,hauteurOeil);
	}

}
