package classes;

// Rectabkge class
public class rectangle implements interface_shape {
	
	//Members
	private String kind;
	private String ID;
	private int length;
	private int width;
	private String color;
	
	
	// Constructors
	public void rectangle(String Kind, String ID, Integer length, Integer width, String Color) {
		this.kind = Kind;
		this.ID = ID;
		this.length = length;
		this.width = width;
		this.color = Color;
	}
	
	// getFunctiosn
	public String getID() {return ID;}
	public String getColor() {return color;}
	public String getKind() {return kind;}
	public Integer getLength() {return length;}
	public Integer getWidth( ) {return width;}
	
	//setFunctions
	public void setType(String Kind) {kind = Kind;}
	public void setID(String id) {ID = id;}
	
	//toString
	public String toString() { return getKind() + "  (" + getID() + ")  " + "\n";}
	
	//GetDetailString
	public String getDetailString() {return getKind() + "  (ID#  " + getID() + ")  " + "\n" + "Color: " + getColor() + "\n" + "Length: " + getLength() + 
			"\n" + "Width: " + getWidth() + "\n" + "Area: " + (getLength()*getWidth()) + "\nPerimeter: " + (getLength()*2 + getWidth()*2);}

}
