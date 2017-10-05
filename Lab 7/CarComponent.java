/*
Lab 7 - Control panel
by: Brandon Kindrick, Jose Mireles and Daniel Williamson

This code displays a control panel from which you can determine the size and length of the car,
you can re-size the diameter of the front and rear tires, you can select which color the car
should be, and you can place it wherever you would like on the panel.

The customizer class holds the main method.
*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.util.*;
import java.awt.Dimension;

//this class gives our Car class values to make our cars
public class CarComponent extends JComponent{
  List<Car> cars = new ArrayList<Car>();

  public void addCar(Car car){
    cars.add(car);
    repaint();
  }

  public Dimension getPreferredSize(){
    return new Dimension(300, 300);
  }

  public void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    setBackground(Color.WHITE);

    for(int i = 0; i < cars.size(); i++){
      Car car = cars.get(i);
      car.draw(g2);
    }
  }
}
