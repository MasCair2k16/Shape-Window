import java.awt.EventQueue;

import classes.circle;
import classes.interfaceShape;
import classes.rectangle;
import classes.square;
import classes.triangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.*;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class shapes implements MouseMotionListener, ActionListener, MouseListener {

	// these are my global variables
	// each variable is used to specify functions, arrays.  
	private JFrame frame;
	JPanel panel;
	JTextArea textArea;
	JScrollPane scrollPane;
	JLabel lblNewLabel;
	JButton btnGetShapeInfo;
	JButton btnUserInput;
	InputStream read;
	Integer check = 0;
	JTextArea textAreaDisplay;
	JLabel labelLogo;
	
	// These are my arrayList that hold shape values. Each of them are initialized below the performAction
	ArrayList<circle> circleList = new ArrayList<>();
	ArrayList<square> squareList = new ArrayList<>();
	ArrayList<triangle> triangleList = new ArrayList<>();
	ArrayList<rectangle> rectangleList = new ArrayList<>();
	
	// This list Model is used for my Jlist. it hold all shapes in a string form.
	ListModel<String> listModel = new DefaultListModel<>();
	JList<String> list = new JList<String>(listModel);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shapes window = new shapes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public shapes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Panel
		panel = new JPanel();
		panel.setBounds(0, 0, 768, 502);
		frame.getContentPane().add(panel);
		panel.addMouseMotionListener(this);
		panel.setLayout(null);
		
		// button to hit to get info
		btnGetShapeInfo = new JButton("Get Shape Info");
		btnGetShapeInfo.setBounds(276, 16, 206, 46);
		btnGetShapeInfo.addActionListener(this);
		btnGetShapeInfo.addMouseMotionListener(this);
		panel.setLayout(null);
		panel.add(btnGetShapeInfo);
		
		// TextDispaly of shape properties, etc
		textAreaDisplay = new JTextArea();
		textAreaDisplay.setLineWrap(true);
		textAreaDisplay.setWrapStyleWord(true);
		textAreaDisplay.setBackground(Color.LIGHT_GRAY);
		textAreaDisplay.setBounds(567, 129, 191, 257);
		textAreaDisplay.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		panel.add(textAreaDisplay);
		
		// Icons of different shapes ar show here
		labelLogo = new JLabel("Shape Picture Shown here");
		labelLogo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		labelLogo.setIcon(new ImageIcon());
		labelLogo.setBounds(216, 73, 341, 395);
		labelLogo.setBackground(Color.WHITE);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelLogo);
		
		// This is my jlist. I used 
		list = new JList<String>(listModel);
		list.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		list.setBounds(10, 61, 181, 430);
		list.setSelectedIndex(0);
		list.addMouseListener(this);
		
		// button if person hits list
		btnUserInput = new JButton("Get Item");
		btnUserInput.setBounds(0, 0, 0, 0);
		btnUserInput.addActionListener(this);
		panel.add(btnUserInput);
		
		// scroll in list
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 61, 181, 430);
		panel.add(scrollPane);
		
		// Label above list
		lblNewLabel = new JLabel("Shapes");
		lblNewLabel.setBounds(35, 11, 113, 26);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		int value = list.getSelectedIndex(); // gets the string value that the user selected
		
		String firstW = listModel.getElementAt(value); // gets the whole string and displays it as firstW. Also, I used a string ID because
		// I had to use it as a way to find elements in the string arrayList listModel. 
		String arr[] = firstW.split(" ", 2);  // gets the first word of the string
		System.out.println(firstW);  // Used this to dtermine if the strings were selecting correctly
		labelLogo.setText(""); // deletes the words that were there before
		if(check == arr[0].compareTo("circle")) {   // This would check if the first word is circle before cycling throught the circleList
			for (int i = 0; i < circleList.size(); i++) { 
				if (check == firstW.compareTo(circleList.get(i).toString())) { // if the full word matches the toString example "circle  (34)"
					textAreaDisplay.setText(circleList.get(i).getDetailString()); // This will dispaly the getDetailString and the icon.
					labelLogo.setIcon(new ImageIcon("C:\\Users\\mcaird22\\Pictures\\src\\circle.jpg"));
				}
			}
		}
		else if(check == arr[0].compareTo("square")) {  // samething as above for circle
			for (int i = 0; i < circleList.size(); i++) {
				if (check == firstW.compareTo(squareList.get(i).toString())) {
					textAreaDisplay.setText(squareList.get(i).getDetailString());
					labelLogo.setIcon(new ImageIcon("C:\\Users\\mcaird22\\Pictures\\src\\square.png"));
					
				}
			}
		}
		else if(check == arr[0].compareTo("triangle")) { // samething as square and circle
			for (int i = 0; i < circleList.size(); i++) {
				if (check == firstW.compareTo(triangleList.get(i).toString())) {
					textAreaDisplay.setText(triangleList.get(i).getDetailString());
					labelLogo.setIcon(new ImageIcon("C:\\Users\\mcaird22\\Pictures\\src\\triangle1.png"));
				}
			}
		}
		else if(check == arr[0].compareTo("rectangle")) { // same thing as square, circle, and triangle
			for (int i = 0; i < circleList.size(); i++) {
				if (check == firstW.compareTo(rectangleList.get(i).toString())) {
					textAreaDisplay.setText(rectangleList.get(i).getDetailString());
					labelLogo.setIcon(new ImageIcon("C:\\Users\\mcaird22\\Pictures\\src\\rectangle.png"));
				}
			}
		}
		// if none of the shapes were displayed, this error statement will appear
		else { textAreaDisplay.setText("Error: No shapes were found");}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if the btnGetShapeInfo works.
		if (e.getSource() == btnGetShapeInfo) {
			
			Scanner scnr = null;
			
			final String dir = System.getProperty("user.dir");
			
			
			try {	// my pathway to file
				scnr = new Scanner(new File(dir + "/src/shapes.csv"));
			} catch (FileNotFoundException e1) {
				textArea.setText("Error finding the file.\n Please Check your file location");
				e1.printStackTrace();
			}
			
			// while loop and reads each line going down
			while(scnr.hasNextLine()) {
				Scanner dataScanner = new Scanner(scnr.nextLine()); // my scanner object
				dataScanner.useDelimiter(","); // use this to get information afte commas
				// the interfaceShapes class was made because I misunderstood the instructions and accidentally made a class not an interface
				// This class is used for just comparing type of shapes. The legit interface is now made after the mistake
				interfaceShape shapes = new interfaceShape();
				square Square = new square(); // my shape objects
				circle Circle = new circle();
				rectangle Rectangle = new rectangle();
				triangle Triangle = new triangle();
				
					String type = dataScanner.next(); // used this to get type and determine if its circle and so forth
						
						shapes.setType(type);
						// compareTo is easier to use and easy for the system to determine if its alike
						if (check == shapes.getKind().compareTo("circle")) { // if it is a circle, it will go to each line horiz after the comma
							// to get information
							String id = dataScanner.next();
							String radius = dataScanner.next();
							String color = dataScanner.next();
							Circle.circle(type, id, Integer.parseInt(radius), color);
							circleList.add(Circle);
						}
						// same as above
						else if (check == shapes.getKind().compareTo("square")) {
							String id1 = dataScanner.next();
							String side = dataScanner.next();
							String color1 = dataScanner.next();
							Square.square(type, id1,Integer.parseInt(side), color1);
							squareList.add(Square);
						}
						// same as above
						else if (check == shapes.getKind().compareTo("triangle")) {
							String id2 = dataScanner.next();
							String side1 = dataScanner.next();
							String side2 = dataScanner.next();
							String side3 = dataScanner.next();
							String color = dataScanner.next();
							Triangle.triangle(type, id2, Integer.parseInt(side1), Integer.parseInt(side2), Integer.parseInt(side3), color);
							triangleList.add(Triangle);
						}
						//same as above
						else if (check == shapes.getKind().compareTo("rectangle")) {
							String id3 = dataScanner.next();
							String length = dataScanner.next();
							String width = dataScanner.next();
							String color = dataScanner.next();
							Rectangle.rectangle(type, id3, Integer.parseInt(length), Integer.parseInt(width), color);
							rectangleList.add(Rectangle);
						} else 
							// prints if no data appears.
						{ textAreaDisplay.setText("Invalid Data"); }			
					
				dataScanner.close();
			}
			
			// I am adding string elements from my circleList, square list, trianglelist, and rectanglelist to listModel. Only strings exist. Also, this organizes the list chronolicaly. 
			for (int i = 0; i < circleList.size() ; i++) {
				((DefaultListModel<String>) listModel).addElement(circleList.get(i).getKind()+ "  (" + circleList.get(i).getID()+ ")  " + "\n");
			}
			for (int i = 0; i < squareList.size(); i++) {
				((DefaultListModel<String>) listModel).addElement(squareList.get(i).getKind()+ "  (" + squareList.get(i).getID()+ ")  " + "\n");
			}
			for (int i = 0; i< triangleList.size(); i++) {
				((DefaultListModel<String>) listModel).addElement(triangleList.get(i).getKind()+ "  (" + triangleList.get(i).getID()+ ")  " + "\n");
			}
			for (int i = 0; i < rectangleList.size(); i++) {
				((DefaultListModel<String>) listModel).addElement(rectangleList.get(i).getKind()+ "  (" + rectangleList.get(i).getID()+ ")  " + "\n");
			}
		}
	}
	
	// these are function I didnt have to use for my program. Since I implemented mouseListner, I needed them so the program wouldnt crash
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
