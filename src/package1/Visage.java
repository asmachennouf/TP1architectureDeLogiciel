package package1;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Visage extends Forme{
	
	public static final int LARGEUR_DEFAUT =50;
	
	public static final int HAUTEUR_DEFAUT =50;
	
	public static final int LARGEUR_MIN =15;
	
	public static final int HAUTEUR_MIN =15;
	
	public static final int DEPLACEMENT_DEFAUT =5;
	
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
		
		super(xg,yg,5.f, Color.BLACK,Color.PINK);
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
	
	
	
	
	
	

	
	public void dessiner(Graphics g) {
	  
	   Graphics2D g2=(Graphics2D) g.create();
	   g2.setColor(Color.BLACK);
	   g2.setStroke(new BasicStroke(epaisseurTrait));
       g2.drawOval(super.x, super.y, largeur, hauteur);
       g2.setPaint(Color.PINK);
       g2.fillOval(super.x, super.y, largeur, hauteur);
       
	   if(impassible) {
		   g.drawLine(super.x +largeur /4, super.y +(2 * hauteur) /3,
				   super.x + (3 * largeur) /4, super.y + (2 * hauteur)/ 3);
	   } else {
		   g.drawArc(super.x +largeur /4, super.y +(2 * hauteur) /3,
				   largeur /2, hauteur/ 5, -45, -90);
	   }
	   
	   int largeurOeil = largeur / 5;
	   int hauteurOeil = hauteur / 5;
	   g.drawOval(super.x + largeurOeil, super.y +hauteurOeil, largeurOeil,hauteurOeil);
	   g.drawOval(super.x + 3 * largeurOeil, super.y + hauteurOeil, largeurOeil,hauteurOeil);
	}

	@Override
	public void deplacer() {
		// TODO Auto-generated method stub
		
	}

}
