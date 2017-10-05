import javax.swing.JFrame;

public class Tetris
{
  public static void main(String[] args)
  {
  //Creates the Frame needed to draw our blocks in
  JFrame frame = new JFrame();
  //frame size 400 x 600 (x,y)
  frame.setSize(400, 600);
  frame.setTitle("Tetris");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //calls our block class
  Block component = new Block();
  frame.add(component);
  frame.setVisible(true);
  }
}
