// created our Sudoku class
public class Sudoku
{
  // private instance variables
  private String start;
  private char[] table;
    // constructor w/out parameters
    public Sudoku()
    {

    }
    // constructor with starting paramater
    public Sudoku(String starting_configuration)
    {
      // removed given configuration \ns
      starting_configuration = starting_configuration.replace("\n", "");
      // set the starting_configuration to a private instance
      this.start = starting_configuration;
      // created a 1d dimensional array
      table = this.start.toCharArray();


    }
    // created getSquare method
    public char getSquare(int row, int col)
    {
      // did math to work through array
      int indexvalue = row * 9;
      indexvalue += col;
      char value = table[indexvalue];
      return value;

    }
    // created setSquare method
    public void setSquare(int row, int col, char value)
    {
      // math to work through array
      int indexvalue = row * 9;
      indexvalue += col;
      this.table[indexvalue] = value;

    }
    private boolean rowDuplicate(){
      // checks rows
      for(int row = 0;row < 81;row += 9){
        // check values in those rows by column
        for(int column = row + 1; column < row + 9; column++){
          // if it reaches a space skip
          if(this.table[column] == ' '){continue;}
          // returns false if any values are equal
          if(this.table[row] == this.table[column]){ return false;}
          for (int j = column + 1;j < row + 9;j++){
            if(this.table[j] == this.table[column]){ return false;}
          }
        }
      }
      // returns true if no duplicates occur
      return true;
    }
    private boolean columnDuplicate(){
      // checks columns
      for (int column = 0;column<9 ;column++ ) {
        for(int row = column + 9;row < 81; row += 9){
          // if it reaches a space skip
          if(this.table[row]==' '){continue;}
          // returns false if any values are equal
          if(this.table[column]==this.table[row]){return false;}
          for(int j = row + 9; j < 81; j += 9){
            if(this.table[j]==this.table[row]){return false;}

          }
        }
      }
      // returns true if no duplicates occur
      return true;
    }
    // checks one square
    private boolean checkSquare(int start){
      // sets are variables to use for iteration
      int i = 0;
      int end = start+3;
      // creates an array
      int[] testarray = new int[9];
      // iterates through the square with a counter outside of the loop to append values to an array
      for(; start<end;start++){
        for(int rows = start; rows <= start + 18; rows += 9){
          testarray[i] = this.table[rows];
          i++;
        }
      }
      // iterates through the array for comparison
      for(int c = 0; c<9;c++){
        for(int j = c+ 1; j<9;j++){
          // skips at a space
          if(testarray[c] == ' '){continue;}
          // returns false if any values are equal
          if(testarray[c] == testarray[j]){return false;}
        }
      }
      // returns true if no values are equal
      return true;
    }
    private boolean checkAllSquares(){
      // iterates through the board to each index at the start of the Square to run checkSquare at
      for (int start = 0; start <= 6; start +=3 ) {
        for(int index = start; index <= 60; index += 27){
          // if the checkSquare method returns false it returns false
          if(checkSquare(index) == false){return false;}
        }
      }
      // if it doesn't return false returns true
      return true;
    }
    public boolean isValid()
    {
      // checks the private methods to se if any returns false
      if(rowDuplicate() == false){return false;}
      if(columnDuplicate()== false){return false;}
      if(checkAllSquares() == false){return false;}
      // if all the methods don't return false isValid returns true
      return true;
    }
    public boolean isSolved()
    {
      // checks if is valid is false and returns false if it is
      if(isValid() == false){return false;}
      // iterates through tje entire array to check for spaces if so returns false
      for(int i = 0; i < 81; i++){
        if(table[i] == ' '){return false;}
      }
      // returns true if board isValid and there is no spaces
      return true;
    }
}
