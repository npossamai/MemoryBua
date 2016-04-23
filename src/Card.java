/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;

/**
 * 
 * Version 1.0
 * 
 * @author Nicholas Possamai    
 */

public class Card {
    boolean coperta;
    boolean trovata;
    int ID;
    ImageIcon imageFront;
	ImageIcon imageBack;
	Image IF, IB;
    Point2D p;
    Dimension d;
    
    
    /**
     * Crea la nuova carta.
     * 
     * @param front indirizzo dell'immagine frontale
     * @param back indirizzo dell'immagine del retro
     * @param width larghezza della carta
     * @param height altezza della carta
     */
    Card(String front, String back, int width, int height){
        
    }
    /**
     * Crea la nuova carta.
     * 
     * @param front indirizzo dell'immagine frontale
     * @param back indirizzo dell'immagine del retro
     * @param width larghezza della carta
     * @param height altezza della carta
     * @param ID identifica il numero di coppia
     */
    Card(String front, String back, int width, int height, int ID){
    	imageFront = new ImageIcon(front);
    	imageBack = new ImageIcon(back);
    	d = new Dimension(width, height);
    	trovata = false;
    	this.ID = ID;
    }
    /**
     * Imposta la posizione della carta nella superficie di gioco.
     * 
     * @param x coordinate dell'ascissa
     * @param y coordinate dell'ordinta
     */
    void setPosition(int x, int y){
        
    }
    /**
     * Imposta la posizione della carta nella superficie di gioco.
     * 
     * @param p punto di coordinate X e Y
     */
    void setPosition(Point2D p){
        
    }
    /**
     * Imposta lo stato coperto della carta.
     * 
     * @param b se TRUE la carta è coperta, se FALSE la carta è scoperta.
     */
    void setCoperta(boolean b){
        
    }
    /**
     * Disegna la carta.
     * @param g 
     */
    void draw(Graphics2D g){
        
    }
    
    int getID(){
    	return this.ID;
    }
}
