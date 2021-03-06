package com.tutorial.main;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class Handler {

	private Image image = new Image();
	private IO �o = new IO();
	
	LinkedList <GameObject> object = new LinkedList<GameObject>();
	
	public void tick (){
		for (int i=0 ; i< object.size() ; i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}	
	public void render (Graphics2D g){
		for (int i=0 ; i< object.size() ; i++){
			GameObject tempObject = object.get(i);
		
			tempObject.render(g);
		}
	}	
	
	public void clearEnemys(){
		for (int i=0 ; i< object.size() ; i++){
			GameObject tempObject = object.get(i);
		
			if (tempObject.getId() == ID.Player ) {
				object.clear();
				if (Gamee.gameState != Gamee.STATE.End)
				addObject(new Player( (int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this ,image ,�o));
			}
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
		
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
		
	}
	
}
