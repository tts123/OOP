package edu.pitt.is17.tts12.menumanager;
/**
 * Class FileManager
 * author : Tshering
 * created: 11/06/2018
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

	public class FileManager {
		public static ArrayList<MenuItem> readItems(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<MenuItem> menuItems=new ArrayList<MenuItem>();
		String s=null;
		try {
			FileReader fr=new FileReader(fileName);
			BufferedReader br=new BufferedReader(fr);
			while((s=br.readLine())!=null) {
				list.add(s);
				}
			for(String line : list){
				String [] res = line.split("@@");
				if(res[1].equals("beer")) {
					Beer b=new Beer(res[0],res[2],Integer.parseInt(res[3]),Double.parseDouble(res[4]));
					menuItems.add(b);
					}else if(res[1].equals("entree")) 
					{Entree e=new Entree(res[0],res[2],Integer.parseInt(res[3]),Double.parseDouble(res[4]));
					menuItems.add(e);
					}else if(res[1].equals("appetizer"))
					{ Appetizer a=new Appetizer(res[0],res[2],Integer.parseInt(res[3]),Double.parseDouble(res[4]));
					menuItems.add(a);
					}else if(res[1].equals("side")) 
					{Side si=new Side(res[0],res[2],Integer.parseInt(res[3]),Double.parseDouble(res[4]));
					menuItems.add(si);
					}
				}
			br.close();
			fr.close();
			}catch(IOException e) {System.out.println(e.getMessage());
			}
		return menuItems;
		}
		public static void writeMenu( String fileName, ArrayList<Menu> menus ) throws IOException 
		{
				try{
					PrintWriter bw = new PrintWriter(fileName);
					for (int i = 0; i < menus.size(); i++) {
					bw.write("Menu: " + menus.get(i).getName() +
							"\n"+ menus.get(i).description()+
							"Total calories: "+menus.get(i).totalCalories()+
							"\n"+"Total price: $"+menus.get(i).totalPrice() +"\n"+"\n");
					}
					bw.close();

				}
				catch(FileNotFoundException fnfe){
					fnfe.printStackTrace();
					}			


		}
	}

