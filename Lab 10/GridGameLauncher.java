import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.border.*;

public class GridGameLauncher extends JFrame implements MouseListener{
  public JButton b1, b2, b3; //b1 "TicTacToe", b2 "Minesweeper",b3 "ConnectFour"
  public JPanel forButtons;//panel to put our buttons inside

  public GridGameLauncher(String title){
    super(title);

    //adds text and a mouse listener to each button
    b1 = new JButton("TicTacToe");
    b1.addMouseListener(this);
    b2 = new JButton("Minesweeper");
    b2.addMouseListener(this);
    b3 = new JButton("Connect Four");
    b3.addMouseListener(this);

    //creates panel to hold the buttons
    forButtons = new JPanel();

    //adds the buttons to the button panel
    forButtons.add(b1);
    forButtons.add(b2);
    forButtons.add(b3);

    //sets the layout to a 1X3 grid
    setLayout(new GridLayout(1,3));
    //adds button panel to the center location
		add(forButtons, BorderLayout.CENTER);

    //drops extra white space
    pack();

    //allows GUI to be seen and close on exiting the window
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void mouseClicked(MouseEvent e) {
    JButton source = (JButton)e.getSource(); //gets the source of the click
    if(source.equals(this.b1)){ //if source equals b1 then create and launch a new tictactoe
      TicTacToe tic = new TicTacToe();
      GridPlayer g = new GridPlayer("TicTacToe", tic);
    }
    if(source.equals(this.b2)){//if source equals b2 then create and launch a new minesweeper
      Minesweeper mine = new Minesweeper();
      GridPlayer g = new GridPlayer("Minesweeper", mine);
    }
    if(source.equals(this.b3)){//if source equals b3 then create and launch a new ConnectFour
      ConnectFour four = new ConnectFour();
      GridPlayer g = new GridPlayer("Connect Four", four);
    }
  }
  //needed but not needed; need to impement all of the methods
  public void mousePressed(MouseEvent e)  {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}

  public static void main(String[] args) { //when GridGameLauncher runs prints text "choose a game"
    GridGameLauncher grid = new GridGameLauncher("Choose a game");
  }
}
