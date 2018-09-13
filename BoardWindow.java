import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.*;

public class BoardWindow implements ActionListener{
	ImageIcon image = new ImageIcon("Risk.PNG");
	JLabel Alaska = new JLabel("Alaska");
	JLabel NWTerritory = new JLabel("Northwest Territory");
	JLabel Alberta = new JLabel("Alberta");
	JLabel Ontario = new JLabel("Ontario");
	JLabel Quebec = new JLabel("Quebec");
	JLabel Greenland = new JLabel("Greenland");
	JLabel WUnitedStates = new JLabel("Western United States");
	JLabel EUnitedStates = new JLabel("Eastern United States");
	JLabel CAmerica = new JLabel("Central America");
	JLabel Venezuela = new JLabel("Venezuela");
	JLabel Peru = new JLabel("Peru");
	JLabel Brazil = new JLabel("Brazil");
	JLabel Argentina = new JLabel("Argentina");
	JLabel Iceland = new JLabel("Iceland");
	JLabel GBritain = new JLabel("Great Britain");
	JLabel Scandinavia = new JLabel("Scandinavia");
	JLabel WEurope = new JLabel("Western Europe");
	JLabel NEurope = new JLabel("Northern Europe");
	JLabel SEurope = new JLabel("Southern Europe");
	JLabel Ukraine = new JLabel("Ukraine");
	JLabel Ural = new JLabel("Ural");
	JLabel Siberia = new JLabel("Siberia");
	JLabel Yakutsk = new JLabel("Yakutsk");
	JLabel Irkutsk = new JLabel("Irkutsk");
	JLabel Kamchatka = new JLabel("Kamchatka");
	JLabel Mongolia = new JLabel("Mongolia");
	JLabel Japan = new JLabel("Japan");
	JLabel Afganistan = new JLabel("Afganistan");
	JLabel China = new JLabel("China");
	JLabel MiddleEast = new JLabel("Middle East");
	JLabel India = new JLabel("India");
	JLabel Siam = new JLabel("Siam");
	JLabel NAfrica = new JLabel("North Africa");
	JLabel Egypt = new JLabel("Egypt");
	JLabel EAfrica = new JLabel("East Africa");
	JLabel Congo = new JLabel("Congo");
	JLabel SAfrica = new JLabel("South Africa");
	JLabel Madagascar = new JLabel("Madagascar");
	JLabel Indonesia = new JLabel("Indonesia");
	JLabel NGuinea = new JLabel("New Guinea");
	JLabel EAustralia = new JLabel("Eastern Australia");
	JLabel WAustralia = new JLabel("Western Australia");
	JFrame main;
	JPanel left;
	JPanel right;
	JPanel bottom;
	JTextField field;
	JTextField field2;
	JButton enterButton;
	JPanel middle;
	JComboBox<String> list;
	String readText;
	int cBoxSelection;
	boolean hasChanged = false;
	String [] stringList = {"Alaska","Alberta","Central America","Eastern United States","Greenland","Northwest Territory","Ontario","Quebec","Western United States","Argentina","Brazil","Peru","Venezuela","Great Britain","Iceland","Northern Europe","Scandinavia","Southern Europe","Ukraine","Western Europe","Congo","East Africa","Egypt","Madagascar","North Africa","South Africa","Afganistan","China","India","Irkutsk","Japan","Kamchatka","Middle East","Mongolia","Siam","Siberia", "Ural","Yakutsk","Eastern Australia","Indonesia","New Guinea","Western Australia"};
	
	public void init(){
		main = new JFrame("Risk");
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		left = new JPanel(new GridLayout(20,1));
		Alaska.setOpaque(true);
		Alaska.setBackground(new Color(244, 220, 66));
		left.add(Alaska);
		NWTerritory.setOpaque(true);
		NWTerritory.setBackground(new Color(244, 220, 66));
		left.add(NWTerritory);
		Alberta.setOpaque(true);
		Alberta.setBackground(new Color(244, 220, 66));
		left.add(Alberta);
		Ontario.setOpaque(true);
		Ontario.setBackground(new Color(244, 220, 66));
		left.add(Ontario);
		Quebec.setOpaque(true);
		Quebec.setBackground(new Color(244, 220, 66));
		left.add(Quebec);
		Greenland.setOpaque(true);
		Greenland.setBackground(new Color(244, 220, 66));
		left.add(Greenland);
		WUnitedStates.setOpaque(true);
		WUnitedStates.setBackground(new Color(244, 220, 66));
		left.add(WUnitedStates);
		EUnitedStates.setOpaque(true);
		EUnitedStates.setBackground(new Color(244, 220, 66));
		left.add(EUnitedStates);
		CAmerica.setOpaque(true);
		CAmerica.setBackground(new Color(244, 220, 66));
		left.add(CAmerica);
		Venezuela.setOpaque(true);
		Venezuela.setBackground(new Color(252, 112, 88));
		left.add(Venezuela);
		Peru.setOpaque(true);
		Peru.setBackground(new Color(252, 112, 88));
		left.add(Peru);
		Brazil.setOpaque(true);
		Brazil.setBackground(new Color(252, 112, 88));
		left.add(Brazil);
		Argentina.setOpaque(true);
		Argentina.setBackground(new Color(252, 112, 88));
		left.add(Argentina);
		Iceland.setOpaque(true);
		Iceland.setBackground(new Color(173, 153, 239));
		left.add(Iceland);
		GBritain.setOpaque(true);
		GBritain.setBackground(new Color(173, 153, 239));
		left.add(GBritain);
		Scandinavia.setOpaque(true);
		Scandinavia.setBackground(new Color(173, 153, 239));
		left.add(Scandinavia);
		WEurope.setOpaque(true);
		WEurope.setBackground(new Color(173, 153, 239));
		left.add(WEurope);
		NEurope.setOpaque(true);
		NEurope.setBackground(new Color(173, 153, 239));
		left.add(NEurope);
		SEurope.setOpaque(true);
		SEurope.setBackground(new Color(173, 153, 239));
		left.add(SEurope);
		Ukraine.setOpaque(true);
		Ukraine.setBackground(new Color(173, 153, 239));
		left.add(Ukraine);
		right = new JPanel(new GridLayout(22,1));
		Ural.setOpaque(true);
		Ural.setBackground(new Color(123, 206, 129));
		right.add(Ural);
		Siberia.setOpaque(true);
		Siberia.setBackground(new Color(123, 206, 129));
		right.add(Siberia);
		Yakutsk.setOpaque(true);
		Yakutsk.setBackground(new Color(123, 206, 129));
		right.add(Yakutsk);
		Irkutsk.setOpaque(true);
		Irkutsk.setBackground(new Color(123, 206, 129));
		right.add(Irkutsk);
		Kamchatka.setOpaque(true);
		Kamchatka.setBackground(new Color(123, 206, 129));
		right.add(Kamchatka);
		Mongolia.setOpaque(true);
		Mongolia.setBackground(new Color(123, 206, 129));
		right.add(Mongolia);
		Japan.setOpaque(true);
		Japan.setBackground(new Color(123, 206, 129));
		right.add(Japan);
		Afganistan.setOpaque(true);
		Afganistan.setBackground(new Color(123, 206, 129));
		right.add(Afganistan);
		China.setOpaque(true);
		China.setBackground(new Color(123, 206, 129));
		right.add(China);
		MiddleEast.setOpaque(true);
		MiddleEast.setBackground(new Color(123, 206, 129));
		right.add(MiddleEast);
		India.setOpaque(true);
		India.setBackground(new Color(123, 206, 129));
		right.add(India);
		Siam.setOpaque(true);
		Siam.setBackground(new Color(123, 206, 129));
		right.add(Siam);
		NAfrica.setOpaque(true);
		NAfrica.setBackground(new Color(206, 179, 122));
		right.add(NAfrica);
		Egypt.setOpaque(true);
		Egypt.setBackground(new Color(206, 179, 122));
		right.add(Egypt);
		EAfrica.setOpaque(true);
		EAfrica.setBackground(new Color(206, 179, 122));	
		right.add(EAfrica);
		Congo.setOpaque(true);
		Congo.setBackground(new Color(206, 179, 122));
		right.add(Congo);
		SAfrica.setOpaque(true);
		SAfrica.setBackground(new Color(206, 179, 122));
		right.add(SAfrica);
		Madagascar.setOpaque(true);
		Madagascar.setBackground(new Color(206, 179, 122));
		right.add(Madagascar);
		Indonesia.setOpaque(true);
		Indonesia.setBackground(new Color(255, 142, 142));
		right.add(Indonesia);
		NGuinea.setOpaque(true);
		NGuinea.setBackground(new Color(255, 142, 142));
		right.add(NGuinea);
		EAustralia.setOpaque(true);
		EAustralia.setBackground(new Color(255, 142, 142));
		right.add(EAustralia);	
		WAustralia.setOpaque(true);
		WAustralia.setBackground(new Color(255, 142, 142));
		right.add(WAustralia);
		main.add(left, BorderLayout.WEST);
		main.add(right, BorderLayout.EAST);
		bottom = new JPanel(new GridLayout(1,4));
		field = new JTextField();
		field.setEditable(false);
		bottom.add(field);
		list = new JComboBox<String>(stringList);
		field2 = new JTextField();
		field2.setText("Enter text here...");
		bottom.add(list);
		bottom.add(field2);
		enterButton= new JButton("Enter");
		enterButton.setActionCommand("Click");
		enterButton.addActionListener(this);
		bottom.add(enterButton);
		main.add(bottom, BorderLayout.SOUTH);
		JLabel label = new JLabel("", image, JLabel.CENTER);
		main.add(label, BorderLayout.CENTER);
		main.pack();
		main.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		cBoxSelection = list.getSelectedIndex();
		readText = field2.getText();
		field2.setText("");
		main.repaint();
		hasChanged = true;
	}
	
	public void setCountryLabel(int selection, int player, int numTroops){
		if(selection == 0){
			Alaska.setText("P" + player + " : Alaska : Troops: " + numTroops);
		}
		else if(selection == 1){
			Alberta.setText("P" + player + " : Alberta : Troops: " + numTroops);
		}
		else if(selection == 2){
			CAmerica.setText("P" + player + " : Central America : Troops: " + numTroops);
		}
		else if(selection == 3){
			EUnitedStates.setText("P" + player + " : Eastern United States : Troops: " + numTroops);
		}
		else if(selection == 4){
			Greenland.setText("P" + player + " : Greenland : Troops: " + numTroops);
		}
		else if(selection == 5){
			NWTerritory.setText("P" + player + " : Northwest Territory : Troops: " + numTroops);
		}
		else if(selection == 6){
			Ontario.setText("P" + player + " : Ontario : Troops: " + numTroops);
		}
		else if(selection == 7){
			Quebec.setText("P" + player + " : Quebec : Troops: " + numTroops);
		}
		else if(selection == 8){
			WUnitedStates.setText("P" + player + " : Western United States : Troops: " + numTroops);
		}
		else if(selection == 9){
			Argentina.setText("P" + player + " : Argentina : Troops: " + numTroops);
		}
		else if(selection == 10){
			Brazil.setText("P" + player + " : Brazil : Troops: " + numTroops);
		}
		else if(selection == 11){
			Peru.setText("P" + player + " : Peru : Troops: " + numTroops);
		}
		else if(selection == 12){
			Venezuela.setText("P" + player + " : Venezuela : Troops: " + numTroops);
		}
		else if(selection == 13){
			GBritain.setText("P" + player + " : Great Britain : Troops: " + numTroops);
		}
		else if(selection == 14){
			Iceland.setText("P" + player + " : Iceland : Troops: " + numTroops);
		}
		else if(selection == 15){
			NEurope.setText("P" + player + " : Northern Europe : Troops: " + numTroops);
		}
		else if(selection == 16){
			Scandinavia.setText("P" + player + " : Scandinavia : Troops: " + numTroops);
		}
		else if(selection == 17){
			SEurope.setText("P" + player + " : Southern Europe : Troops: " + numTroops);
		}
		else if(selection == 18){
			Ukraine.setText("P" + player + " : Ukraine : Troops: " + numTroops);
		}
		else if(selection == 19){
			WEurope.setText("P" + player + " : Western Europe : Troops: " + numTroops);
		}
		else if(selection == 20){
			Congo.setText("P" + player + " : Congo : Troops: " + numTroops);
		}
		else if(selection == 21){
			EAfrica.setText("P" + player + " : East Africa : Troops: " + numTroops);
		}
		else if(selection == 22){
			Egypt.setText("P" + player + " : Egypt : Troops: " + numTroops);
		}
		else if(selection == 23){
			Madagascar.setText("P" + player + " : Madagascar : Troops: " + numTroops);
		}
		else if(selection == 24){
			NAfrica.setText("P" + player + " : North Africa : Troops: " + numTroops);
		}
		else if(selection == 25){
			SAfrica.setText("P" + player + " : South Africa : Troops: " + numTroops);
		}
		else if(selection == 26){
			Afganistan.setText("P" + player + " : Afganistan : Troops: " + numTroops);
		}
		else if(selection == 27){
			China.setText("P" + player + " : China : Troops: " + numTroops);
		}
		else if(selection == 28){
			India.setText("P" + player + " : India : Troops: " + numTroops);
		}
		else if(selection == 29){
			Irkutsk.setText("P" + player + " : Irkutsk : Troops: " + numTroops);
		}
		else if(selection == 30){
			Japan.setText("P" + player + " : Japan : Troops: " + numTroops);
		}
		else if(selection == 31){
			Kamchatka.setText("P" + player + " : Kamchatka : Troops: " + numTroops);
		}
		else if(selection == 32){
			MiddleEast.setText("P" + player + " : Middle East : Troops: " + numTroops);
		}
		else if(selection == 33){
			Mongolia.setText("P" + player + " : Mongolia : Troops: " + numTroops);
		}
		else if(selection == 34){
			Siam.setText("P" + player + " : Siam : Troops: " + numTroops);
		}
		else if(selection == 35){
			Siberia.setText("P" + player + " : Siberia : Troops: " + numTroops);
		}
		else if(selection == 36){
			Ural.setText("P" + player + " : Ural : Troops: " + numTroops);
		}
		else if(selection == 37){
			Yakutsk.setText("P" + player + " : Yakutsk : Troops: " + numTroops);
		}
		else if(selection == 38){
			EAustralia.setText("P" + player + " : Eastern Australia : Troops: " + numTroops);
		}
		else if(selection == 39){
			Indonesia.setText("P" + player + " : Indonesia : Troops: " + numTroops);
		}
		else if(selection == 40){
			NGuinea.setText("P" + player + " : New Guinea : Troops: " + numTroops);
		}
		else if(selection == 41){
			WAustralia.setText("P" + player + " : Western Australia : Troops: " + numTroops);
		}
		main.repaint();
	}
	
	public void setOutput(String output){
		field.setText(output);
		main.repaint();
	}
	
	public String getInputS(){
		hasChanged = false;
		int x = 0;
		while(!hasChanged){
			setOutput(field.getText());
			x++;
		}
		return readText;
	}
	public int getInputI(){
		int x = 0;
		hasChanged = false;
		while(!hasChanged){
			setOutput(field.getText());
			x++;
		}
		return Integer.parseInt(readText);
	}

	public String getSelectionS(){
		hasChanged = false;
		while(!hasChanged){
			setOutput(field.getText());
		}
		return stringList[list.getSelectedIndex()];
	}
	
	public int getSelectionI(){
		hasChanged = false;
		while(!hasChanged){
			setOutput(field.getText());
		}
		return list.getSelectedIndex();
	}
	
	public void refreshBoard(){
		main.repaint();
	}
}