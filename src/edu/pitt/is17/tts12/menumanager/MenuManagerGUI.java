package edu.pitt.is17.tts12.menumanager;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.IOException;
	import java.util.ArrayList;
	import javax.swing.*;

	public class MenuManagerGUI {
		private JFrame frame;
		private JComboBox entreeBox;
		private int entreeIndex;
		private JComboBox sideBox;
		private int sideIndex;
		private JComboBox appetizerBox;
		private int appetizerIndex;
		private JComboBox beerBox;
		private int beerIndex;
		private String textAreaAll="";
		private JTextArea textArea;
		private JFrame frame2;
		private JTextField caloriesText= new JTextField();
		private JTextField priceText= new JTextField();
		private JTextArea entreeTextArea= new JTextArea();
		private JTextArea sideTextArea= new JTextArea();
		private JTextArea appetizerTextArea= new JTextArea();
		private JTextArea beerTextArea= new JTextArea();
		private ArrayList<Menu> menus=new ArrayList<>();
		
		public MenuManagerGUI() {
		MenuManager run=new MenuManager("data/dishes.txt");
		frame = new JFrame("Menu Manager");
		frame.setBounds(250,100,800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 40, 346, 221);
		panel_1.setBorder(BorderFactory.createTitledBorder("Build your own Menu"));
		frame.getContentPane().add(panel_1);
		JPanel panel = new JPanel();
		panel.setBounds(35, 297, 346, 221);
		panel_1.setLayout(null);
		
		JLabel entreeLabel = new JLabel("Entree");
		entreeLabel.setBounds(10, 27, 56, 21);
		entreeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(entreeLabel);
		ArrayList<Entree> entrees=new ArrayList<Entree>(run.getEntrees());
		String[] entreeList=new String[entrees.size()+1];
		entreeList[0]="None";
		for(int i=0;i<entrees.size();i++) entreeList[i+1]=entrees.get(i).getName();
		entreeBox = new JComboBox(entreeList);
		entreeBox.setBounds(80, 26, 200, 23);
		panel_1.add(entreeBox);
		entreeTextArea.setText("None");
		entreeBox.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		entreeIndex = cb.getSelectedIndex();
		}
		});

		JLabel sideLabel = new JLabel("Side");
		sideLabel.setBounds(10, 58, 32, 29);
		panel_1.add(sideLabel);
		ArrayList<Side> sides=new ArrayList<Side>(run.getSides());
		String[] sideList=new String[sides.size()+1];
		sideList[0]="None";
		for(int i=0;i<sides.size();i++) sideList[i+1]=sides.get(i).getName();
		sideBox = new JComboBox(sideList);
		sideBox.setBounds(80, 61, 200, 23);
		panel_1.add(sideBox);
		sideTextArea.setText("None");
		sideBox.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		sideIndex = cb.getSelectedIndex();
		}
		});
		
		JLabel appetizerLabel = new JLabel("Appetizer");
		appetizerLabel.setBounds(10, 93, 60, 23);
		panel_1.add(appetizerLabel);
		ArrayList<Appetizer> appetizers=new ArrayList<Appetizer>(run.getAppetizers());
		String[] appetizerList=new String[appetizers.size()+1];
		appetizerList[0]="None";
		for(int i=0;i<appetizers.size();i++) appetizerList[i+1]=appetizers.get(i).getName();
		appetizerBox = new JComboBox(appetizerList);
		appetizerBox.setBounds(80, 93, 200, 23);
		panel_1.add(appetizerBox);
		appetizerTextArea.setText("None");
		appetizerBox.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		appetizerIndex = cb.getSelectedIndex();
		}
		});
		
		JLabel beerLabel = new JLabel("Beer");
		beerLabel.setBounds(10, 130, 45, 15);
		panel_1.add(beerLabel);
		ArrayList<Beer> beers=new ArrayList<Beer>(run.getBeers());
		String[] beerList=new String[beers.size()+1];
		beerList[0]="None";
		for(int i=0;i<beers.size();i++) beerList[i+1]=beers.get(i).getName();
		beerBox = new JComboBox(beerList);
		beerBox.setBounds(80, 126, 200, 23);
		panel_1.add(beerBox);
		beerTextArea.setText("None");
		beerBox.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		beerIndex = cb.getSelectedIndex();
		}
		});
		
		JButton createButton = new JButton("Create Menu with these dishes");
		createButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String menuName = JOptionPane.showInputDialog("Please type the menu name");
		String txt=menuName+"\n";
		textAreaAll+=txt;
		textArea.setText(textAreaAll);
		
		if(entreeIndex==0) {
		entreeTextArea.setText("Entree: None");
		}else {
		entreeTextArea.setText(entrees.get(entreeIndex-1).getName()+"\n"+
		entrees.get(entreeIndex-1).getDescription()+"\n"+
		"Calories: "+ String.valueOf(entrees.get(entreeIndex-1).getCalories())+"\n"+
		"Price: $"+ String.valueOf(entrees.get(entreeIndex-1).getPrice()));
		}
		
		if(sideIndex==0) {
		sideTextArea.setText("Side: None");
		}else {
		sideTextArea.setText(sides.get(sideIndex-1).getName()+"\n"+
		sides.get(sideIndex-1).getDescription()+"\n"+
		"Calories: "+String.valueOf(sides.get(sideIndex-1).getCalories())+"\n"+
		"Price: $"+String.valueOf(sides.get(sideIndex-1).getPrice()));
		}
		
		if(appetizerIndex==0) {
		appetizerTextArea.setText("Appetizer: None");
		}else {
		appetizerTextArea.setText(appetizers.get(appetizerIndex-1).getName()+"\n"+
		appetizers.get(appetizerIndex-1).getDescription()+"\n"+
		"Calories: "+String.valueOf(appetizers.get(appetizerIndex-1).getCalories())+"\n"+
		"Price: $"+String.valueOf(appetizers.get(appetizerIndex-1).getPrice()));
		}
		
		if(beerIndex==0) {
		beerTextArea.setText("Beer: None");
		}else {
		beerTextArea.setText(beers.get(beerIndex-1).getName()+"\n"+
		beers.get(beerIndex-1).getDescription()+"\n"+
		"Calories: "+String.valueOf(beers.get(beerIndex-1).getCalories())+"\n"+
		"Price: $"+String.valueOf(beers.get(beerIndex-1).getPrice()));
		}
		
		priceText.setText(String.valueOf((entreeIndex==0?0:entrees.get(entreeIndex-1).getPrice())+
		(sideIndex==0?0:sides.get(sideIndex-1).getPrice())+
		(appetizerIndex==0?0:appetizers.get(appetizerIndex-1).getPrice())+
		(beerIndex==0?0:beers.get(beerIndex-1).getPrice())));
		caloriesText.setText(String.valueOf((entreeIndex==0?0:entrees.get(entreeIndex-1).getCalories())+
		(sideIndex==0?0:sides.get(sideIndex-1).getCalories())+
		(appetizerIndex==0?0:appetizers.get(appetizerIndex-1).getCalories())+
		(beerIndex==0?0:beers.get(beerIndex-1).getCalories())));
		
		}
		});
		
		createButton.setBounds(66, 170, 219, 23);
		panel_1.add(createButton);
		
		panel.setBorder(BorderFactory.createTitledBorder("Or generate a Menu"));
		frame.getContentPane().add(panel);
		
		JButton randomButton = new JButton("Generate a Random Menu");
		randomButton.setBounds(35, 54, 280, 23);
		randomButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String menuName = JOptionPane.showInputDialog("Please type the menu name");
		String txt=menuName;
		textAreaAll+=txt+"\n";
		textArea.setText(textAreaAll);
		Menu randomMenu=run.randomMenu(txt);
		entreeTextArea.setText(randomMenu.getEntree().getName()+"\n"+
		randomMenu.getEntree().getDescription()+"\n"+
		"Calories: "+String.valueOf(randomMenu.getEntree().getCalories())+"\n"+
		"Price: $"+String.valueOf(randomMenu.getEntree().getPrice()));
		sideTextArea.setText(randomMenu.getSide().getName()+"\n"+
		randomMenu.getSide().getDescription()+"\n"+
		"Calories: "+String.valueOf(randomMenu.getSide().getCalories())+"\n"+
		"Price: $"+String.valueOf(randomMenu.getSide().getPrice()));
		appetizerTextArea.setText(randomMenu.getAppetizer().getName()+"\n"+
		randomMenu.getAppetizer().getDescription()+"\n"+
		"Calories: "+String.valueOf(randomMenu.getAppetizer().getCalories())+"\n"+
		"Price: $"+String.valueOf(randomMenu.getAppetizer().getPrice()));
		beerTextArea.setText(randomMenu.getBeer().getName()+"\n"+
		randomMenu.getBeer().getDescription()+"\n"+
		"Calories: "+String.valueOf(randomMenu.getBeer().getCalories())+"\n"+
		"Price: $"+String.valueOf(randomMenu.getBeer().getPrice()));
		priceText.setText(String.valueOf(randomMenu.getEntree().getPrice()+
		randomMenu.getSide().getPrice()+
		randomMenu.getAppetizer().getPrice()+
		randomMenu.getBeer().getPrice()));
		caloriesText.setText(String.valueOf(randomMenu.getEntree().getCalories()+
		randomMenu.getSide().getCalories()+
		randomMenu.getAppetizer().getCalories()+
		randomMenu.getBeer().getCalories()));
		menus.add(new Menu(txt,
		randomMenu.getEntree(),
		randomMenu.getSide(),
		randomMenu.getAppetizer(),
		randomMenu.getBeer()));
		}
		});
		panel.add(randomButton);
		
		JButton minButton = new JButton("Generate a Minimum Calories Menu ");
		minButton.setBounds(35, 104, 280, 23);
		minButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String menuName = JOptionPane.showInputDialog("Please type the menu name");
		String txt=menuName;
		textAreaAll+=txt+"\n";
		textArea.setText(textAreaAll);
		Menu minMenu=run.minCaloriesMenu(menuName);
		entreeTextArea.setText(minMenu.getEntree().getName()+"\n"+
		minMenu.getEntree().getDescription()+"\n"+
		"Calories: "+String.valueOf(minMenu.getEntree().getCalories())+"\n"+
		"Price: $"+String.valueOf(minMenu.getEntree().getPrice()));
		sideTextArea.setText(minMenu.getSide().getName()+"\n"+
		minMenu.getSide().getDescription()+"\n"+
		"Calories: "+String.valueOf(minMenu.getSide().getCalories())+"\n"+
		"Price: $"+String.valueOf(minMenu.getSide().getPrice()));
		appetizerTextArea.setText(minMenu.getAppetizer().getName()+"\n"+
		minMenu.getAppetizer().getDescription()+"\n"+
		"Calories: "+String.valueOf(minMenu.getAppetizer().getCalories())+"\n"+
		"Price: $"+String.valueOf(minMenu.getAppetizer().getPrice()));
		beerTextArea.setText(minMenu.getBeer().getName()+"\n"+
		minMenu.getBeer().getDescription()+"\n"+
		"Calories: "+String.valueOf(minMenu.getBeer().getCalories())+"\n"+
		"Price: $"+String.valueOf(minMenu.getBeer().getPrice()));
		priceText.setText(String.valueOf(minMenu.getEntree().getPrice()+
		minMenu.getSide().getPrice()+
		minMenu.getAppetizer().getPrice()+
		minMenu.getBeer().getPrice()));
		caloriesText.setText(String.valueOf(minMenu.getEntree().getCalories()+
		minMenu.getSide().getCalories()+
		minMenu.getAppetizer().getCalories()+
		minMenu.getBeer().getCalories()));
		menus.add(new Menu(menuName,
		minMenu.getEntree(),
		minMenu.getSide(),
		minMenu.getAppetizer(),
		minMenu.getBeer()));
		}
		});
		panel.add(minButton);
		
		JButton maxButton = new JButton("Generate a Maximum Calories Menu ");
		maxButton.setBounds(35, 159, 280, 23);
		maxButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String menuName = JOptionPane.showInputDialog("Please type the menu name");
		String txt=menuName;
		textAreaAll+=txt+"\n";
		textArea.setText(textAreaAll);
		Menu maxMenu=run.maxCaloriesMenu(menuName);
		entreeTextArea.setText(maxMenu.getEntree().getName()+"\n"+
		maxMenu.getEntree().getDescription()+"\n"+
		"Calories: "+String.valueOf(maxMenu.getEntree().getCalories())+"\n"+
		"Price: $"+String.valueOf(maxMenu.getEntree().getPrice()));
		sideTextArea.setText(maxMenu.getSide().getName()+"\n"+
		maxMenu.getSide().getDescription()+"\n"+
		"Calories: "+String.valueOf(maxMenu.getSide().getCalories())+"\n"+
		"Price: $"+String.valueOf(maxMenu.getSide().getPrice()));
		appetizerTextArea.setText(maxMenu.getAppetizer().getName()+"\n"+
		maxMenu.getAppetizer().getDescription()+"\n"+
		"Calories: "+String.valueOf(maxMenu.getAppetizer().getCalories())+"\n"+
		"Price: $"+String.valueOf(maxMenu.getAppetizer().getPrice()));
		beerTextArea.setText(maxMenu.getBeer().getName()+"\n"+
		maxMenu.getBeer().getDescription()+"\n"+
		"Calories: "+String.valueOf(maxMenu.getBeer().getCalories())+"\n"+
		"Price: $"+String.valueOf(maxMenu.getBeer().getPrice()));
		priceText.setText(String.valueOf(maxMenu.getEntree().getPrice()+
		maxMenu.getSide().getPrice()+
		maxMenu.getAppetizer().getPrice()+
		maxMenu.getBeer().getPrice()));
		caloriesText.setText(String.valueOf(maxMenu.getEntree().getCalories()+
		maxMenu.getSide().getCalories()+
		maxMenu.getAppetizer().getCalories()+
		maxMenu.getBeer().getCalories()));
		menus.add(new Menu(menuName,
		maxMenu.getEntree(),
		maxMenu.getSide(),
		maxMenu.getAppetizer(),
		maxMenu.getBeer()));
		}
		});
		panel.add(maxButton);
		
		
		JLabel menuLabel = new JLabel("Created Menus:");
		menuLabel.setBounds(424, 40, 120, 15);
		frame.getContentPane().add(menuLabel);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(424, 61, 326, 414);
		frame.getContentPane().add(textArea);
		
		JButton detailsButton = new JButton("Details");
		detailsButton.setBounds(421, 495, 93, 23);
		detailsButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String name = textArea.getSelectedText();
		
		if(name == null) {
			JOptionPane.showMessageDialog(null, "No Menu Selected. \nPlease Select a Menu from the Created Menus and try again! \nThank You!", "Error!", JOptionPane.ERROR_MESSAGE);
	        return;
		} else { 
			frame2 = new JFrame("Menu: " + name);
			frame2.setBounds(300,100,700,600);
			frame2.getContentPane().setLayout(null);
			JLabel lblNewLabel = new JLabel("Entree");
			lblNewLabel.setBounds(49, 45, 74, 42);
			frame2.getContentPane().add(lblNewLabel);
			JLabel lblNewLabel_1 = new JLabel("Side");
			lblNewLabel_1.setBounds(49, 135, 66, 42);
			frame2.getContentPane().add(lblNewLabel_1);
			JLabel lblNewLabel_2 = new JLabel("Appetizer");
			lblNewLabel_2.setBounds(49, 235, 90, 42);
			frame2.getContentPane().add(lblNewLabel_2);
			JLabel lblNewLabel_3 = new JLabel("Beer");
			lblNewLabel_3.setBounds(49, 325, 82, 42);
			frame2.getContentPane().add(lblNewLabel_3);
			JLabel lblNewLabel_4 = new JLabel("Total calories: ");
			lblNewLabel_4.setBounds(49, 440, 103, 42);
			frame2.getContentPane().add(lblNewLabel_4);
			JLabel lblNewLabel_5 = new JLabel("Total price:     $");
			lblNewLabel_5.setBounds(49, 494, 140, 34);
			frame2.getContentPane().add(lblNewLabel_5);

			entreeTextArea.setEditable(false);
			entreeTextArea.setLineWrap(true);
			entreeTextArea.setWrapStyleWord(true);
			JScrollPane entreeScroll = new JScrollPane(entreeTextArea);
			entreeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			entreeScroll.setBounds(150, 60, 525, 72);
			frame2.getContentPane().add(entreeScroll);

			sideTextArea.setEditable(false);
			sideTextArea.setLineWrap(true);
			sideTextArea.setWrapStyleWord(true);
			JScrollPane sideScroll = new JScrollPane(sideTextArea);
			sideScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			sideScroll.setBounds(150, 150, 525, 72);
			frame2.getContentPane().add(sideScroll);
			
			appetizerTextArea.setEditable(false);
			appetizerTextArea.setLineWrap(true);
			appetizerTextArea.setWrapStyleWord(true);
			JScrollPane appetizerScroll = new JScrollPane(appetizerTextArea);
			appetizerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			appetizerScroll.setBounds(150, 248, 525, 72);
			frame2.getContentPane().add(appetizerScroll);
			
			beerTextArea.setEditable(false);
			beerTextArea.setLineWrap(true);
			beerTextArea.setWrapStyleWord(true);
			JScrollPane beerScroll = new JScrollPane(beerTextArea);
			beerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			beerScroll.setBounds(150, 340, 525, 72);
			frame2.getContentPane().add(beerScroll);
			
			priceText.setBackground(new Color(255, 255, 255));
			priceText.setEditable(false);
			priceText.setBounds(149, 501, 66, 21);
			frame2.getContentPane().add(priceText);
			priceText.setColumns(10);

			caloriesText.setBackground(new Color(255, 255, 255));
			caloriesText.setEditable(false);
			caloriesText.setBounds(149, 451, 66, 21);
			frame2.getContentPane().add(caloriesText);
			caloriesText.setColumns(10);
			
			if((entreeIndex*sideIndex*appetizerIndex*beerIndex)!=0) {
				menus.add(new Menu(name,
				entrees.get(entreeIndex-1),
				sides.get(sideIndex-1),
				appetizers.get(appetizerIndex-1),
				beers.get(beerIndex-1)));
				}
			}			
		frame2.setVisible(true);}
		});
		frame.getContentPane().add(detailsButton);
		
		JButton deleteButton = new JButton("Delete all");
		deleteButton.setBounds(532, 495, 97, 23);
		deleteButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "All the menus will be deleted!");
		textArea.setText("");
		menus.clear();
		textAreaAll="";
		}
		});
		
		panel.setLayout(null);
		frame.getContentPane().add(deleteButton);
		JButton saveButton = new JButton("Save to file");
		saveButton.setBounds(641, 495, 109, 23);
		saveButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "The menus are saved in menus.txt in data directory!");
			try {
				FileManager.writeMenu("data/menus.txt", menus);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		});
		frame.getContentPane().add(saveButton);

		}
		public static void main(String[] args) {
			MenuManagerGUI play=new MenuManagerGUI();
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					play.frame.setVisible(true);
					}
				});
			}
		}