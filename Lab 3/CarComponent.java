import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
//this class gives our Car class values to make our cars
public class CarComponent extends JComponent{

  public void paintComponent(Graphics g){

    Graphics2D g2 = (Graphics2D) g;
    //This is our colors that we used to paint our cars with
    PaintBucket color = new PaintBucket();
    color.addColor(200, 200, 0);
    color.addColor(0, 0, 200);
    PaintBucket color2 = new PaintBucket();
    color2.addColor(200, 50, 0);
    color2.addColor(0, 50, 200);
    PaintBucket color3 = new PaintBucket();
    color3.addColor(50, 200, 45);
    color3.addColor(45, 0, 200);
    //this is what dimmensions our cars will have
    Car car1 = new Car(10, 0, 80, 10, 10, 10, color.getColor());
    Car car2 = new Car(10, 40, 100, 10, 10, 10, color2.getColor());
    Car car3 = new Car(10, 80, 60, 10, 10, 10, color3.getColor());
    Car car4 = new Car(10, 120, 100, 10, 10, 10, color2.getColor());
    Car car5 = new Car(10, 160, 80, 10, 10, 10, color3.getColor());
    Car car6 = new Car(10, 200, 60, 10, 10, 10, color.getColor());
    //we tell it to draw!
    car1.draw(g2);
    car2.draw(g2);
    car3.draw(g2);
    car4.draw(g2);
    car5.draw(g2);
    car6.draw(g2);

  }

}
