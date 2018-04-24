package carte;

import java.util.ArrayList;
import javax.swing.JButton;
import processing.core.PApplet;

public class Fenetre extends PApplet {
    
    private ArrayList<Systeme> liste;
    
    private static final int DIMENSIONS = 400;
    private static final int TAILLE_MENU = 200;
    
    public Fenetre(ArrayList<Systeme> l){
        super();
        liste = l;
    }
    
    public void settings(){
        size(DIMENSIONS + TAILLE_MENU,DIMENSIONS);
    }
    
    public void setup(){
        stroke(255);
    }
    
    public void draw(){
        background(0);
        for(Systeme s : liste){
            point(s.x, s.y);
        }
        drawMenu(); 
    }
    
    public void drawMenu(){
        
    }
    
}
