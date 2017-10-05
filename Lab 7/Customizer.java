/*
Lab 7 - Control panel
by: Brandon Kindrick, Jose Mireles and Daniel Williamson

This code displays a control panel from which you can determine the size and length of the car,
you can re-size the diameter of the front and rear tires, you can select which color the car
should be, and you can place it wherever you would like on the panel.

The customizer class holds the main method.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class Customizer extends JFrame implements MouseListener{

  //declaring of needed variables.
  public JSlider s1, s2, s3;
  public JButton b1, b2;
  public JPanel bGroup;
  public CarComponent cars;
  public JTextField t1, t2;
  public int carWidth = 100;
  public int fWheelDiameter = 25;
  public int rWheelDiameter = 25;
  public Color carColor = Color.blue;
  public int carHeight = 10;

  public Customizer(String title){
    super(title);
    //labels
    JLabel l1 = new JLabel("Car Width: ", JLabel.RIGHT);
    JLabel l2 = new JLabel("Front Tire: ", JLabel.RIGHT);
    JLabel l3 = new JLabel("Rear Tire: ", JLabel.RIGHT);
    JLabel l4 = new JLabel("Color: ", JLabel.RIGHT);
    JLabel l5 = new JLabel("X: ", JLabel.RIGHT);
    JLabel l6 = new JLabel("Y: ", JLabel.RIGHT);
    JLabel l7 = new JLabel(" ", JLabel.RIGHT);

    //bottons
    b1 = new JButton("Add");
    b1.addMouseListener(this);
    b2 = new JButton("Choose Color");
    b2.addMouseListener(this);

    //slider
    s1 = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
    s2 = new JSlider(JSlider.HORIZONTAL, 0, 50, 20);
    s3 = new JSlider(JSlider.HORIZONTAL, 0, 50, 20);


    //panel
    bGroup = new JPanel();
    bGroup.setLayout(new GridLayout(12, 2));

    //textFeild
    t1 = new JTextField(10);
    t2 = new JTextField(10);

    //adds all the stuff to the panel
    bGroup.add(l1);
    bGroup.add(s1);
    bGroup.add(l2);
    bGroup.add(s2);
    bGroup.add(l3);
    bGroup.add(s3);
    bGroup.add(l4);
    bGroup.add(b2);
    bGroup.add(l5);
    bGroup.add(t1);
    bGroup.add(l6);
    bGroup.add(t2);
    bGroup.add(l7);
    bGroup.add(b1);


    setLayout(new GridLayout(1,2));
		add(bGroup,  BorderLayout.WEST);

    cars = new CarComponent();
    add(cars, BorderLayout.EAST);

    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
 }

 //Determines which button is clicked and executes the nessacary code
 public void mouseClicked(MouseEvent e) {
   JButton source = (JButton)e.getSource();
   if(source.equals(this.b1)){
     int x = 10;
     int y = 10;
     x = Integer.parseInt(t1.getText());
     y = Integer.parseInt(t2.getText());

     cars.addCar(new Car(x, y, s1.getValue(), this.carHeight, s2.getValue(), s3.getValue(), this.carColor));
   }
   else if(source.equals(this.b2)){
     Color color = JColorChooser.showDialog(b2, "Car Color", Color.BLACK);
     this.carColor = color;
   }
 }
 //needed but not needed.
 public void mousePressed(MouseEvent e)  {}
 public void mouseReleased(MouseEvent e) {}
 public void mouseEntered(MouseEvent e) {}
 public void mouseExited(MouseEvent e) {}

  public static void main(String[] args) {
    Customizer custom = new Customizer("Car");
  }
}
