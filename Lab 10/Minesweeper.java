import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.border.*;
import java.util.Random;

//Standard Minesweeper game

public class Minesweeper implements GridPlayable {

    private ButtonListener[][] minesweeperButtons; //the buttons that fill the board
    private String[][] updateButtonStrings; //will change the string on the button when applicable
    private GameState currentGameState; //checks for a win
    private int width; //number of columns
    private int height; //number of rows
    private int numOfBombs = 15; //determines how many bombs will be on the board


    //constructor for minesweeper, creates the board of buttons, adds ButtonListener, adds strings
    public Minesweeper(){
        width = getGridWidth(); //sets the width of the game
        height = getGridHeight(); //sets the height of the game
        minesweeperButtons = new ButtonListener[height][width];
        updateButtonStrings = new String[height][width];
        for (int i = 0; i < height; i++) { //adds a button listener and "" to each button
            for (int j = 0; j < width; j++) {
                ButtonListener button = new ButtonListener(i, j, "");
                minesweeperButtons[i][j] = button;
                updateButtonStrings[i][j] = "";
            }
        }
        createRandomBombs(); //gives the board bombs in random locations
        currentGameState = GameState.TURN_P1; //sets the first move to player 1
    }

    //returns the width of the board
    public int getGridWidth(){
      return 15;
    }
    //returns the height of the board
    public int getGridHeight(){
      return 10;
    }
    //is a standard press of the buttons on the board
    public void press(int row, int column) {
        ButtonListener clickedButton = minesweeperButtons[row][column]; //finds the button that was pressed
        if(updateButtonStrings[clickedButton.row][clickedButton.column].equals("B")//"if its a bomb"
            && !(currentGameState == GridPlayable.GameState.WIN_P1 //"and the game state does not equal WIN_P1"
             || currentGameState == GridPlayable.GameState.LOSE)){ //"or game state equals lose"
            lose(); //ends the game and determines a loss
            return;
        }

        clickedButton.setButtonState(false); //"turns off the button"
        if(currentGameState == GridPlayable.GameState.TURN_P1){
          if(updateButtonStrings[clickedButton.row][clickedButton.column].equals("")){
              checkSurrounding(clickedButton.row, clickedButton.column, "");
          }
        }
        checkGameState();
    }
    //creates bombs in random location within the board size
    private void createRandomBombs(){
        Random random = new Random(); //generates random number
        for(int b = 0; b < numOfBombs; b++){ //if iterator is less than the numOfBombs; iterate
            int rowPosition = random.nextInt(height - 1); //gives each iteration a random rowPosition
            int colPosition = random.nextInt(width - 1); //gives each iteration a random colPosition
            if(!updateButtonStrings[rowPosition][colPosition].equals("B")){
                updateButtonStrings[rowPosition][colPosition] = "B"; //updates string to a bomb
                for(int changeRow = -1; changeRow < 2; changeRow++){ //updates the surrounding buttons with the number "hints"
                    for(int changeColumn = -1; changeColumn < 2; changeColumn++){
                        try {
                            ButtonListener button = minesweeperButtons[rowPosition + changeRow][colPosition + changeColumn];
                            updateButton(button);
                        } catch (Exception e) {
                        }
                    }
                }
            }
            else{
                b--;
            }
        }
    }
    //updates the value of each button pressed
    private void updateButton(ButtonListener button){
        String buttonString = updateButtonStrings[button.row][button.column];

        if(buttonString.equals("B")){
          return;
        }
        if(buttonString.equals("")){
          updateButtonStrings[button.row][button.column] = String.valueOf(1);
          return;
        }

        try{
            int buttonNum = Integer.parseInt(updateButtonStrings[button.row][button.column]);
            updateButtonStrings[button.row][button.column] = String.valueOf(buttonNum + 1);
        }
        catch(Exception e){ //catches exceptions and printStackTrace
            e.printStackTrace();
        }
    }
    //called when the players "presses" a button with a bomb
    private void lose(){
        for(ButtonListener[] row: minesweeperButtons){ //for each row in minesweeperButtons
            for(ButtonListener button: row){ //for each button in each row
                if(!updateButtonStrings[button.row][button.column].equals("B")){ //if location is a bomb unviel its location
                    button.setButtonState(false); //"uncovers" bombs because the game is over
                } else if(updateButtonStrings[button.row][button.column].equals("B")){
                    button.setText(updateButtonStrings[button.row][button.column]);
                } else{
                }
            }
        }
        currentGameState = GameState.LOSE; //game over
    }

    private void checkSurrounding(int row, int column, String currentLocationString) {
        minesweeperButtons[row][column].setButtonState(false);

        for(int changeRow = -1; changeRow < 2; changeRow++){ //changes each iteration to the next row(after column checked)
            for(int changeColumns = -1; changeColumns < 2; changeColumns++){ //changes each iteration to the next column in the current row
                try {
                  //checks for bombs and updates neccessary strings
                  if (minesweeperButtons[row + changeRow][column + changeColumns].buttonState()){
                      if(updateButtonStrings[row + changeRow][column + changeColumns].equals(currentLocationString)){
                          checkSurrounding(row + changeRow, column + changeColumns, currentLocationString);
                      } else if (!updateButtonStrings[row + changeRow][column + changeColumns].equals("B")) {
                          minesweeperButtons[row + changeRow][column + changeColumns].setButtonState(false);
                      }
                  }
                }
                catch(ArrayIndexOutOfBoundsException e){//catches out of bounds exception to prevent game from breaking

                }
                catch (Exception e) {
                  e.printStackTrace();
                }
            }
        }

    }
    //checks to see if the game has a winner
    private void checkGameState() {
        int counter = 0; //# of bombs counted vs pressable "" locations
        for(ButtonListener[] row: minesweeperButtons) { //for each row in minesweeperButtons
            for (ButtonListener button : row) { //for each button in row
                if(button.buttonState()){
                    if(updateButtonStrings[button.row][button.column].equals("B"))
                        counter++;
                    else
                        return;
                }
            }
        }
        if(counter == numOfBombs)
            currentGameState = GameState.WIN_P1; //if no pressable locations left and bombs = counter; winner
    }
    //shows locations still availible to press
    public boolean getPressableAt(int row, int column){
      return minesweeperButtons[row][column].buttonState();
    }
    //shows the label at a location "" or "b"
    public String getLabelAt(int row, int column){
      if(!minesweeperButtons[row][column].buttonState()
          || currentGameState == GameState.LOSE || currentGameState == GameState.WIN_P1){
        return updateButtonStrings[row][column];
      }
      return " ";
    }

    public Color getColorAt(int row, int column) {
      return null;
    }
    //returns the current GameState
    public GameState getGameState(){
      return currentGameState;
    }

      //ButtonListener given to all buttons on the board
      private class ButtonListener extends JButton{
        private boolean isPressed; //checks button state
        public int row;
        public int column;

        public ButtonListener(String label){ //// ButtonListener to change the pressability of the button
            super(label);
            isPressed = true;
        }

        public ButtonListener(int row, int column, String label){//alternate constructor to provide use in the whole class
            this(label);
            this.row = row;
            this.column = column;
        }
        //returns true or false if the button "is pressed"
        public boolean buttonState(){
          return isPressed;
         }
        public void setButtonState(boolean updatedButtonState){
          isPressed = updatedButtonState;
        }
      }

    }
