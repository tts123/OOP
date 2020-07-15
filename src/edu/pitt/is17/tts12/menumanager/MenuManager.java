package edu.pitt.is17.tts12.menumanager;

import java.util.ArrayList;
import java.util.Random;


public class MenuManager {
	private ArrayList<Entree> entrees = new ArrayList<Entree>();
	private ArrayList<Side> sides=new ArrayList<Side>();
	private ArrayList<Appetizer> appetizers=new ArrayList<Appetizer>();
	private ArrayList<Beer> beers=new ArrayList<Beer>();
	
	public MenuManager(String dishesFile) {	
		ArrayList<MenuItem> menuItems = FileManager.readItems(dishesFile);
			for(int i = 0; i < menuItems.size(); i++) {
				if(menuItems.get(i)instanceof Entree) {
					entrees.add((Entree) menuItems.get(i));
				}
				if(menuItems.get(i)instanceof Side) {
					sides.add((Side) menuItems.get(i));
				}
				if(menuItems.get(i)instanceof Appetizer) {
					appetizers.add((Appetizer) menuItems.get(i));
				}
				if(menuItems.get(i)instanceof Beer) {
					beers.add((Beer) menuItems.get(i));
				}
		}
	}

	public Menu randomMenu(String name){
		Random rand = new Random();
		int min = 0;
		
		int max = appetizers.size();
		int appetizerIndex = rand.nextInt((max - min)) + min;
		
		max = entrees.size();
		int entreeIndex = rand.nextInt((max - min)) + min;
		
		max = sides.size();
		int sideIndex = rand.nextInt((max - min)) + min;
		
		max = beers.size();
		int beerIndex = rand.nextInt((max - min)) + min;
		
		Menu randomMenu = new Menu(name, entrees.get(entreeIndex), sides.get(sideIndex), appetizers.get(appetizerIndex), beers.get(beerIndex));
		
		return randomMenu;
		}

	public Menu minCaloriesMenu(String name) {
		int min=Integer.MAX_VALUE;
		int[] index=new int[4];
		for(int i=0;i<entrees.size();i++) {
		if(min>entrees.get(i).getCalories()) {
		min=entrees.get(i).getCalories();
		index[0]=i;
		}
		}
		min=Integer.MAX_VALUE;
		for(int i=0;i<sides.size();i++) {
		if(min>sides.get(i).getCalories()) {
		min=sides.get(i).getCalories();
		index[1]=i;
		}
		}
		min=Integer.MAX_VALUE;
		for(int i=0;i<appetizers.size();i++) {
		if(min>appetizers.get(i).getCalories()) {
		min=appetizers.get(i).getCalories();
		index[2]=i;
		}
		}

		min=Integer.MAX_VALUE;
		for(int i=0;i<beers.size();i++) {
		if(min>beers.get(i).getCalories()) {
		min=beers.get(i).getCalories();
		index[3]=i;
		}
		}
		
		return new Menu(name,entrees.get(index[0]), sides.get(index[1]), appetizers.get(index[2]), beers.get(index[3]));
		}

	public Menu maxCaloriesMenu(String name) {
		int max=Integer.MIN_VALUE;
		int[] index=new int[4];
		for(int i=0;i<entrees.size();i++) {
			if(max<entrees.get(i).getCalories()) {
				max=entrees.get(i).getCalories();
				index[0]=i;
			}
		}
		max=Integer.MIN_VALUE;
		for(int i=0;i<sides.size();i++) {
			if(max<sides.get(i).getCalories()) {
				max=sides.get(i).getCalories();
				index[1]=i;
			}
		}
		max=Integer.MIN_VALUE;
		for(int i=0;i<appetizers.size();i++) {
			if(max<appetizers.get(i).getCalories()) {
				max=appetizers.get(i).getCalories();
				index[2]=i;
			}
		}
		max=Integer.MIN_VALUE;
		for(int i=0;i<beers.size();i++) {
			if(max<beers.get(i).getCalories()) {
				max=beers.get(i).getCalories();
				index[3]=i;
			}
		}
		return new Menu(name,entrees.get(index[0]), sides.get(index[1]), appetizers.get(index[2]), beers.get(index[3]));
		}

	public ArrayList<Appetizer> getAppetizers() {
		return appetizers;
	}
	public void setAppetizers(ArrayList<Appetizer> appetizers) {
		this.appetizers = appetizers;
	}
	public ArrayList<Entree> getEntrees() {
		return entrees;
	}
	public void setEntrees(ArrayList<Entree> entrees) {
		this.entrees = entrees;
	}
	public ArrayList<Side> getSides() {
		return sides;
	}
	public void setSides(ArrayList<Side> sides) {
		this.sides = sides;
	}
	public ArrayList<Beer> getBeers() {
		return beers;
	}
	public void setBeers(ArrayList<Beer> beers) {
		this.beers = beers;
	}
	

}
