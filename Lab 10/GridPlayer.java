import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.border.*;

public class GridPlayer extends JFrame{
  private GridPlayable game; //TicTacToe, minesweeper, connectFour
  private GridPlayable.GameState currentGameState;
  private JMenuItem statusLabel; //game state is shown in menu bar of GUI
  private int width; //game width
  private int height; //game height
  private JButton[][] gameGrid; //size of the grid
  private JPanel gameLayout;

  //sets the game to the parameters of the game that was called
  public GridPlayer(String title, GridPlayable game){
    super(title);
    this.game = game;
    width = game.getGridWidth();
    height = game.getGridHeight();

    startGame();
  }

  private void startGame(){ //creates a game window
    gameLayout = new JPanel();
    gameLayout.setLayout(new GridLayout(height, width)); //sets heigth and width
    add(gameLayout, BorderLayout.CENTER); //adds game layout to the center panel
    setResizable(false); //to prevent the user from having a poor GUI
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JMenuBar menuBar = new JMenuBar(); //menu bar allows players to see the current state of the game
    statusLabel = new JMenuItem();
    menuBar.add(statusLabel);
    setJMenuBar(menuBar);
    setVisible(true);

    gameGrid = new JButton[height][width];
    for(int col = 0; col < height; col++){ //adds ActionListener to each button
      for(int row = 0; row < width; row++){
        JButton button = new JButton(game.getLabelAt(col, row));
        button.addActionListener(new buttonListener(col, row));
        gameGrid[col][row] = button;
        gameLayout.add(button);
      }
    }
    pack(); //gets ride of whit space
    setSize(width * 50, height * 50);
    gameState();
  }

  public void gameState(){ //tells players who's turn it currently is in menu bar
    currentGameState = game.getGameState();
    System.out.println(currentGameState.toString());
    if(currentGameState == GridPlayable.GameState.TURN_P1){
      statusLabel.setText("Player 1's Turn");
    }
    if(currentGameState == GridPlayable.GameState.TURN_P2){
      statusLabel.setText("Player 2's Turn");
    }
    if(currentGameState == GridPlayable.GameState.WIN_P1){
      statusLabel.setText("Player 1 wins.");
    }
    if(currentGameState == GridPlayable.GameState.WIN_P2){
      statusLabel.setText("Player 2 wins");
    }
    if(currentGameState == GridPlayable.GameState.LOSE){
      statusLabel.setText("No one wins");
    }
  }

private class buttonListener implements ActionListener{
  private int row,column;

  public buttonListener(int row, int column){
    this.row = row;
    this.column = column;
  }

  public void actionPerformed(ActionEvent e){ //the action performed by each press
    game.press(row,column);
    for(int col = 0; col < height; col++){
      for(int row = 0; row < width; row++){
          JButton updateButton = gameGrid[col][row];
          if(updateButton.isEnabled()){
            updateButton.setText(game.getLabelAt(col, row));
            updateButton.setEnabled(game.getPressableAt(col, row));
          }
      }
    }
    gameState();
  }
}
}
