package classes;

//triangle class
public class triangle implements interface_shape {
	
	//members
	private static String kind;
	private String ID;
	private int side1;
	private int side2;
	private int side3;
	private String color;
	
	//Constructors
	public void triangle(String Kind, String ID, Integer side1, Integer side2, Integer side3, String Color) {
		this.kind = Kind;
		this.ID = ID;
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.color = Color;
	}
	
	//getFunctions
	public String getID() {return ID;}
	public String getColor() {return color;}
	public String getKind() {return kind;}
	public Integer getside1() {return side1;}
	public Integer getside2() {return side2;}
	public Integer getside3() {return side3;}
	
	//SetFunctions
	public static void setType(String Kind) {kind = Kind;}
	public void setID(String id) {ID = id;}
	
	// To String
	public String toString() { return getKind() + "  (" + getID() + ")  " + "\n";}
	
	// // string that displays all properties
	public String getDetailString() {return getKind() + "  (ID#  " + getID() + ")" + "\n" + "Color: " + getColor() + "\n" + "Side 1: " + getside1() + 
			"\n" + "Side 2: " + getside2() + "\n" + "Side 3: " + getside3() + "\n" + "Area: " + (.5*getside1()*getside2()) + "\n" + "Perimeter: " + 
			(getside1() + getside2() + getside3());}

}
