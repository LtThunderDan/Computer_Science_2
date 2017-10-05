import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.Color;


public class Block extends JComponent
{
  public void paintComponent(Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;
    //Making our IBlock and changing Color
    g2.setColor(Color.CYAN);
    Rectangle iblock = new Rectangle(0,400,40,160);
    g2.fill(iblock);
    g2.draw(iblock);
    //Making two rectangles for our JBlock
    g2.setColor(Color.BLUE);
    Rectangle jblock = new Rectangle(40,520,120,40);
    Rectangle jblock2 = new Rectangle(40,480,40,40);
    g2.fill(jblock2);
    g2.draw(jblock2);
    g2.fill(jblock);
    g2.draw(jblock);

    //Making our LBlock with two rectangles
    g2.setColor(Color.ORANGE);
    Rectangle lblock = new Rectangle(80, 480, 120, 40);
    Rectangle lblock2 = new Rectangle(160,520,40,40);
    g2.fill(lblock2);
    g2.draw(lblock2);
    g2.fill(lblock);
    g2.draw(lblock);

    //Making our OBlock
    g2.setColor(Color.MAGENTA);
    Rectangle oblock = new Rectangle(40,400,80,80);
    g2.fill(oblock);
    g2.draw(oblock);

    //Making our SBlock with two rectangles
    g2.setColor(Color.GREEN);
    Rectangle sblock = new Rectangle(200,480,80,40);
    Rectangle sblock2 = new Rectangle(240,520,80,40);
    g2.fill(sblock2);
    g2.draw(sblock2);
    g2.fill(sblock);
    g2.draw(sblock);

    //Making our ZBlock with two rectangles
    g2.setColor(Color.RED);
    Rectangle zblock = new Rectangle(280,440,40,80);
    Rectangle zblock2 = new Rectangle(320,480,40,80);
    g2.fill(zblock2);
    g2.draw(zblock2);
    g2.fill(zblock);
    g2.draw(zblock);

    //Making our TBlock
    g2.setColor(Color.PINK);
    Rectangle tblock = new Rectangle(360,400,40,120);
    Rectangle tblock2 = new Rectangle(320,440,40,40);
    g2.fill(tblock2);
    g2.draw(tblock2);
    g2.fill(tblock);
    g2.draw(tblock);

  }
}
