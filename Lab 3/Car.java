import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Color;
//this class is our 'stamp' for our Car, so we can use it multple times
public class Car{

  private int xLeft;
  private int yTop;
  private int carWidth;
  private int carHeight;
  private int fWheelDiameter;
  private int rWheelDiameter;
  private Color color;

  //this is where we pass in all our parameters for our Car
  public Car(int x, int y, int carWidth, int carHeight, int fWheelDiameter, int rWheelDiameter, Color color)
  {
    xLeft = x;
    yTop = y;
    this.carHeight = carHeight;
    this.carWidth = carWidth;
    this.fWheelDiameter = fWheelDiameter;
    this.rWheelDiameter = rWheelDiameter;
    this.color = color;
  }
  //this is where our car is designed/modeled and colored
  public void draw(Graphics2D g2)
  {
    //a Rectangle for the body
    Rectangle body = new Rectangle(xLeft, yTop + 10, carWidth, carHeight);
    //two Ellipse for the wheels, one front, one rear
    Ellipse2D.Double frontTire = new Ellipse2D.Double(xLeft + 10, yTop + 20 - fWheelDiameter/2 , fWheelDiameter, fWheelDiameter);
    Ellipse2D.Double rearTire = new Ellipse2D.Double(xLeft + (carWidth - 20), yTop + 20 - fWheelDiameter/2, rWheelDiameter, rWheelDiameter);
    //we plot points to make our roof of the Car
    Point2D.Double r1 = new Point2D.Double(xLeft + 10, yTop + 10);
    Point2D.Double r2 = new Point2D.Double(xLeft + 20, yTop);
    Point2D.Double r3 = new Point2D.Double(xLeft + (carWidth - 20), yTop);
    Point2D.Double r4 = new Point2D.Double(xLeft + (carWidth - 10), yTop + 10);
    //this is where we connect those points with lines to make our roof
    Line2D.Double frontWindsheild = new Line2D.Double(r1, r2);
    Line2D.Double roofTop = new Line2D.Double(r2, r3);
    Line2D.Double rearWindsheild = new Line2D.Double(r3, r4);
    //this is where we draw/fill/setColor for our Car
    g2.setColor(color);
    g2.draw(body);
    g2.fill(body);
    g2.setColor(Color.BLACK);
    g2.draw(frontTire);
    g2.fill(frontTire);
    g2.draw(rearTire);
    g2.fill(rearTire);
    g2.setColor(color);
    g2.draw(frontWindsheild);
    g2.draw(roofTop);
    g2.draw(rearWindsheild);
  }
}
