import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.border.*;

//standard connectFour game

public class ConnectFour implements GridPlayable{
    private ButtonListener[][] connectFourButtons; //the buttons that will fill the board
    private GridPlayable.GameState currentGameState; //holds the current value for currentGameState
    private int width; //width of buttons
    private int height; //heigth of buttons

    //ConnectFour constructor
    public ConnectFour(){
        width = getGridWidth(); //sets game width
        height = getGridHeight(); //sets game height

        connectFourButtons = new ButtonListener[height][width]; //adds button listners to buttons

        for(int i = 0; i < height; i++){ //for loop to add listners to all of the buttons
            for(int j = 0; j < width; j++){
                ButtonListener button = new ButtonListener( i, j, " ");
                connectFourButtons[i][j] = button;
            }
        }
        currentGameState = GridPlayable.GameState.TURN_P1; //sets currentGameState to player 1 to start the game
    }
    //returns the width of the board
    public int getGridWidth(){
      return 7;
    }
    //returns the height of the board
    public int getGridHeight(){
      return 6;
    }
    //called when a button is pressed on the gameboard
    public void press(int row, int column) {
        ButtonListener buttonPressed;
        while(row < height - 1 && connectFourButtons[row + 1][column].buttonState()){//while the buttons below arent pressed or taken
            row++;
        }
        buttonPressed = connectFourButtons[row][column]; //press the button
        buttonPressed.setButtonState(false);//set the state of the button to false
        if(currentGameState == GridPlayable.GameState.TURN_P1){ //if player1 then update to X
          buttonPressed.setText("X");
        }
        if(currentGameState == GridPlayable.GameState.TURN_P2){ //if player2 then update to O
          buttonPressed.setText("O");
        }
        checkGameState(); //check for a winner
    }

    private void checkGameState(){ //checks for a winner
        String rowCheck = checkRows(); //check each row for winner
        String columnCheck = checkColumns(); //check each column for winner
        String diagonalCheck = checkDiagonals(); //check left and right diagonals for a winner

        if(rowCheck == "P1" || columnCheck == "P1" || diagonalCheck == "P1"){ //check for a winner
          currentGameState = GridPlayable.GameState.WIN_P2; //sets GameState to WIN_P2
          return;
        }
        else if(rowCheck == "P2" || columnCheck == "P2" || diagonalCheck == "P2"){ //checks for a winner
          currentGameState = GridPlayable.GameState.WIN_P1; //sets GameState to WIN_P1
          return;
        }
        else
            if(checkBoard()) { //checks for a tie
                currentGameState = GridPlayable.GameState.LOSE; //sets GameState to LOSE (no winner)
                return;
            }

        if(currentGameState == GridPlayable.GameState.TURN_P1)//changes gamestate after each press
            currentGameState = GridPlayable.GameState.TURN_P2;
        else if(currentGameState == GridPlayable.GameState.TURN_P2)
            currentGameState = GridPlayable.GameState.TURN_P1;
    }

    private String checkRows(){ //check the rows for a winner
        String character;
        int counter;
        for (ButtonListener[] row: connectFourButtons) { //for each row in rows
            counter = 0; //4 equals a win
            character = "";
            for(ButtonListener button: row){ //for each button in rows
                if(button.getText() == " ") { //checks if its location pressed is empty
                    counter = 0;
                    continue;
                }
                else if(button.getText() == character){
                    counter++;
                }
                else{
                    counter = 1;
                    character = button.getText();
                }

                if(counter == 4){ //if counter is at 4, decide a winner
                    if(character == "O") //O are player 2
                        return "P1";
                    else
                        return "P2";
                }
            }
        }
        return "";
    }

    private String checkColumns(){ //check each column for a winner
        String character;
        int counter;
        for(int j = 0; j < width; j++){ //for each column
            counter = 0;
            character = "";
            for(int i = 0; i < height; i++){ //for each button in column
                ButtonListener button = connectFourButtons[i][j];
                if(button.getText().equals(" ")) {
                    counter = 0;
                    continue;
                }
                else if(button.getText().equals(character)){
                    counter++;
                }
                else{
                    counter = 1;
                    character = button.getText();
                }
                if(counter == 4){ //decide a winner
                    if(character == "O")
                        return "P1";
                    else
                        return "P2";
                }
            }
        }
        return "";
    }

    private String checkDiagonals(){ //check each diagonal for a winner
        for(int i = getGridHeight() - 1; i >= 0; i--){//for each row
            for(int j = 0; j < getGridWidth(); j++){ //for each button in row
                ButtonListener button = connectFourButtons[i][j];
                if(!button.getText().equals(" ")){ //if a tile is found check current diagonal
                    String leftDiagonalWin = checkDiagonal(i, j, button.getText(), 1, -1), //check left diagonal
                           rightDiagonalWin = checkDiagonal(i, j, button.getText(), 1,  1); //check right diagonal
                    if(leftDiagonalWin == "P1" || rightDiagonalWin == "P1"){ //if left or right diagonal is player 1
                        return "P1";
                    } else if(leftDiagonalWin == "P2" || rightDiagonalWin == "P2"){ //if left of right diagonal is player 2
                        return "P2";
                    }
                }
            }
        }
        return "";
    }

    private String checkDiagonal(int row, int column, String currentLocationString, int counter, int changeInHeight){ //helps check diagonal check current diagonal
        if(counter == 4){
            if(currentLocationString == "X")
                return "P2";
            else
                return "P1";
        }
        try{
            if(connectFourButtons[row - 1][column + changeInHeight].getText().equals(currentLocationString)){
                return checkDiagonal(row - 1, column + changeInHeight, currentLocationString, counter + 1, changeInHeight);
            }
        } catch(Exception e){ }
        return "";
    }

    private boolean checkBoard(){
        for(ButtonListener[] row: connectFourButtons){ //for each row in rows
            for(ButtonListener button: row){ //for each button in row
                if(button.getText().equals(" ")){ //if pressed show press
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getPressableAt(int row, int column){ //check to see if the button can be pressed
      return connectFourButtons[row][column].buttonState(); //if true button can be pressed
    }

    public String getLabelAt(int row, int column){ //get label at the current button press
      return connectFourButtons[row][column].getText();
    }

    public Color getColorAt(int row, int column) {
      return null;
    }

    public GridPlayable.GameState getGameState(){
      return currentGameState;
    }


  private class ButtonListener extends JButton{ //button listner to provide functionality to the game
    private boolean isPressed; //true: already pressed ; false: can be pressed
    public int row; //row button was pressed on
    public int column; //column button was pressed on

    public ButtonListener(String label){ // ButtonListener to change the pressability of the button
        super(label);
        isPressed = true;
    }

    public ButtonListener(int row, int column, String label){ //alternate constructor to provide use in the whole class
        this(label);
        this.row = row;
        this.column = column;
    }
    public boolean buttonState(){
      return isPressed;
     }
    public void setButtonState(boolean updatedButtonState){
      isPressed = updatedButtonState;
    }
  }
}
