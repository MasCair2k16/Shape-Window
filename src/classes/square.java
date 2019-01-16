package classes;
//square Class
public class square implements interface_shape {
	
	// members
	private String kind;
	private String ID;
	private int side;
	private String color;
	
	
	//constructor
	public void square(String kind, String ID, Integer side, String Color) {
		this.kind = kind;
		this.ID = ID;
		this.side = side;
		this.color = Color;
	}
	
	// getFunctions
	public String getID() {return ID;}
	public String getColor() {return color;}
	public String getKind() {return kind;}
	public Integer getSide() {return side;}
	
	//SetFunctions
	public void setType(String Kind) {kind = Kind;}
	public void setID(String id) {ID = id;}
	
	// toString
	public String toString() { return getKind() + "  (" + getID() + ")  " + "\n";}
	
	// string that displays all properties
	public String getDetailString() {return getKind() + "  (ID#  " + getID() + ")  " + "\n" + "Color: " + getColor() + "\n" +
			"Side: " + getSide() + "\n" + "Area: " + (side*side) + "\n" + "Perimeter: " + (side*4);}

}
