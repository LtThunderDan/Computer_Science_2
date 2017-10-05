import javax.swing.JFrame;
//this is the class we run, has our main method.
public class CarFrame{

  public static void main(String[] args){
    JFrame frame = new JFrame();
    //makes our frame, sizes it, names it, and allows it to close.
    frame.setSize(300, 400);
    frame.setTitle("Car Viewer");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //calls our car class to do it thing in the frame.
    CarComponent component = new CarComponent();
    frame.add(component);
    //makes it so we can actually see the frame. pretty helpful.
    frame.setVisible(true);
  }

}
