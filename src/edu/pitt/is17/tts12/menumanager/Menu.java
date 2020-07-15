package edu.pitt.is17.tts12.menumanager;

/**
 * Class Menu
 * author : Tshering
 * created: 10/24/2018
 */
public class Menu {
private String name;
private Appetizer appetizer;
private Entree entree;
private Side side;
private Beer beer;
	
	public Menu(String name) {
		this.name=name;
		this.entree=null;
		this.side=null;
		this.beer=null;
		}
	public Menu(String name, Entree entree, Side side) {
		this.name=name;
		this.entree=entree;
		this.side=side;
		this.beer=null;
		}
	public Menu(String name, Entree entree, Side side, Appetizer appetizer, Beer beer) {
		this.name = name;
		this.entree = entree;
		this.side = side;
		this.appetizer = appetizer;
		this.beer = beer;
		}

	public int totalCalories() {
		int sum=0;
		if(!(entree==null)){
			sum+=entree.getCalories();
			}
		if(!(side==null)) {
			sum+=side.getCalories();
			}
		if(!(appetizer==null)) {
			sum+=appetizer.getCalories();
			}
		if(!(beer==null)) {
			sum+=beer.getCalories();
			}
		return sum;
		}
	public int totalPrice() {
		int sum=0;
		if(!(entree==null)){
			sum+=entree.getPrice();
			}
		if(!(side==null)) {
			sum+=side.getPrice();
			}
		if(!(appetizer==null)) {
			sum+=appetizer.getPrice();
			}
		if(!(beer==null)) {
			sum+=beer.getPrice();
			}
		return sum;
		}
    
	public Appetizer getAppetizer() {
		return appetizer;
	}

	public void setAppetizer(Appetizer appetizer) {
		this.appetizer = appetizer;
	}

	public Entree getEntree() {
		return entree;
	}

	public void setEntree(Entree entree) {
		this.entree = entree;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public Beer getBeer() {
		return beer;
	}

	public void setBeer(Beer beer) {
		this.beer = beer;
	}

	public String getName(){
	    return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String description() {
		return	"Entree: "+entree.getName()+
				"\n"+entree.getDescription()+"\n"+"Calories: "+entree.getCalories()+"\n"+
				"Price: $"+entree.getPrice()+"\n"+"Side: "+side.getName()+"\n"+side.getDescription()+
				"\n"+"Calories: "+side.getCalories()+"\n"+"Price: $"+side.getPrice()+"\n"+
				"Appetizer: "+appetizer.getName()+"\n"+appetizer.getDescription()+"\n"+
				"Calories: "+appetizer.getCalories()+"\n"+"Price: $"+appetizer.getPrice()+"\n"+
				"Beer: "+beer.getName()+"\n"+beer.getDescription()+"\n"+"Calories: "+beer.getCalories()+
				"\n"+"Price: $"+beer.getPrice()+"\n";
		}
	@Override
	public String toString() {
		return this.name;
    }

    
    }



