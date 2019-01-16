package classes;

// circle class
public class circle implements interface_shape {
	
	//members
	private String kind;
	private String ID;
	private double radius;
	private String color;
	private Integer circleArea;
	private Integer pCircle;
	
	//Contructor
	public void circle(String kind, String ID, double radius, String color) {
		this.kind = kind;
		this.ID = ID;
		this.radius = radius;
		this.color = color;
	}
	
	//GetFunctions
	public String getID() {return ID;}
	public String getColor() {return color;}
	public String getKind() {return kind;}
	public double getRadius() {return radius;}

	//setFucntions
	public void setType(String Kind) {kind = Kind;}
	public void setID(String id) {ID = id;}
	public void setColor(String Color) {color = Color;}
	
	//To string that dispalys kind and ID
	public String toString() { return getKind() + "  (" + getID() + ")  " + "\n";}
	
	// string that displays all properties
	public String getDetailString() {return getKind() + "  (ID#  " + getID() + ")" + "\n" + "Color: " + getColor() + "\n" + "Radius: " +
			getRadius() + "\n" + "Area: " + Math.round(3.1415*getRadius()*getRadius()) + "\n" + "Perimeter: " + Math.round(2*3.1415*getRadius());}
}
