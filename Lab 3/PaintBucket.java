import java.awt.Color;
//this class we mix together some colors for fun
public class PaintBucket
{
  private int r = 0;
  private int g = 0;
  private int b = 0;
  //this is were we add rgb values together to mix it all up
  public void addColor(int r, int g, int b)
  {
    this.r += r;
    this.g += g;
    this.b += b;
  }

  public Color getColor()
  {
    return new Color(r, g, b);
  }
}
