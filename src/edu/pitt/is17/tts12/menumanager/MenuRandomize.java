package edu.pitt.is17.tts12.menumanager;
/**
 * Class MenuRandomize
 * author : Tshering
 * created: 11/06/2018
 */
import java.util.ArrayList;
import java.util.Random;
public class MenuRandomize {
	private ArrayList<Appetizer> appetizers;
	private ArrayList<Entree> entrees;
	private ArrayList<Side> sides;
	private ArrayList<Beer> beers;
	
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
	//public MenuRandomize(String appetizerFile, String entreeFile, String sideFile, String beerFile) 
	//	{
	//		this.appetizers = FileManager.readAppetizers(appetizerFile);
	//		this.entrees = FileManager.readEntrees(entreeFile);
	//		this.sides = FileManager.readSides(sideFile);
	//		this.beers = FileManager.readBeers(beerFile);
	//	}
	/**
	 * Method randomMenu
	 * @param none
	 * @return new random Menu;
	 */
	public Menu randomMenu() {
		String RandomMenu = "RandomMenu";
		Random rand = new Random();
		int randAppetizer = rand.nextInt(appetizers.size());
		Appetizer randomAppetizer = appetizers.get(randAppetizer);   
		int randEntree = rand.nextInt(entrees.size());
		Entree randomEntree = entrees.get(randEntree);
		int randSide = rand.nextInt(sides.size());
		Side randomSide = sides.get(randSide);
		int randBeer = rand.nextInt(beers.size());
		Beer randomBeer = beers.get(randBeer);
		return new Menu(RandomMenu, randomEntree,randomSide, randomAppetizer, randomBeer);

			}	
		}
