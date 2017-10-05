/* By Daniel Williamson
Brandon Billington */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LightsOutFileLoader
{
  //This function accepts an existing lights out game and focres its lights to match the configuration of a speciic file.
  //Takes in a file and reads for 'X's and '_'s to determine if a tile should be toggled on or off.
  //If it reads an unknown character it will state it is an invalid file and throw a UnsupportedLightsOutFileException.
  public void load(LightsOut game, File inputfile) throws UnsupportedLightsOutFileException, FileNotFoundException
  {
    Scanner scanner = new Scanner(inputfile);
    int row = 0;
    while(scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      for(int col = 0; col < game.getSize(); col++)
      {
        if(line.charAt(col) == 'X')
        {
          game.forceLit(row, col, false);
        }
        else if(line.charAt(col) == '_')
        {
          game.forceLit(row, col, true);
        }
        else
        {
          throw new UnsupportedLightsOutFileException();
        }
      }
      row++;
    }
  }
}
