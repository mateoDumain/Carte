package carte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import processing.core.PApplet;

public class Carte {

    static ArrayList<Systeme> liste;
    private static final String cheminFichier = "save/lesSystemes.save";
    
    public static void main(String[] args) {
        
        liste = load();

        for (int i= 0; i<liste.size(); i++) {
            System.out.println(liste.get(i).x);
        }
        
        PApplet.runSketch(new String[]{""}, new Fenetre(liste));
        
        save();
    }
    
    public static void save() {
        try {
          File f = new File(cheminFichier);
          f.createNewFile();
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
          oos.writeObject(liste);
          oos.flush();
          oos.close();
        }
        catch(Exception e) {
          e.printStackTrace();
        }
    }
    
    public static ArrayList<Systeme> load() {
        ArrayList<Systeme> s = null;
        try {
            File f = new File(cheminFichier);
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(f)) ;
            s = (ArrayList<Systeme>) ois.readObject();
            ois.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    
}
