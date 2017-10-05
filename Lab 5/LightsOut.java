/* By Daniel Williamson
Brandon Billington */

public class LightsOut
{
  private int size;
  private boolean[][]gridValues;

  //constructor that initializes an empty puzzle.
  public LightsOut(int size)
  {
    this.size = size;
    gridValues = new boolean[size][size];
  }

  //Returns the size of the board as intialized in the constructor.
  public int getSize()
  {
    return this.size;
  }

  //determines if a spot is or isnt currently lit.
  public boolean isLit(int row, int col)
  {
    return gridValues[row][col];
  }

  //takes in a row, column and boolean value and sets the puzzle to store value at the given location.
  public void forceLit(int row, int col, boolean value)
  {
    gridValues[row][col] = value;
  }

  //Simulates a press of a light in the game. Uses ArrayIndexOutOfBoundsException try - catch blocks incase a light is pressed...
  //and their is nothing to the left, right, top or bottom of it.
  public void press(int row, int col)
  {
    if(gridValues[row][col] == false)
    {
      gridValues[row][col] = true;
    }
    else
    {
      gridValues[row][col] = false;
    }
    try
    {
      if(gridValues[row - 1][col] == false)
      {
        gridValues[row - 1][col] = true;
      }
      else
      {
        gridValues[row - 1][col] = false;
      }
    }
    catch(ArrayIndexOutOfBoundsException myException)
    {
    }
    try
    {
      if(gridValues[row + 1][col] == false)
      {
        gridValues[row + 1][col] = true;
      }
      else
      {
        gridValues[row + 1][col] = false;
      }
    }
    catch(ArrayIndexOutOfBoundsException myException)
    {
    }
    try
    {
      if(gridValues[row][col - 1] == false)
      {
        gridValues[row][col - 1] = true;
      }
      else
      {
        gridValues[row][col - 1] = false;
      }
    }
    catch(ArrayIndexOutOfBoundsException myException)
    {
    }
    try
    {
      if(gridValues[row][col + 1] == false)
      {
        gridValues[row][col + 1] = true;
      }
      else
      {
        gridValues[row][col + 1] = false;
      }
    }
    catch(ArrayIndexOutOfBoundsException myException)
    {
    }
  }
}
