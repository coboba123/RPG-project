import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javax.swing.JPanel;

public class TranslucentPanel extends JPanel
{

	private Image i;
	private int opacity;

	public TranslucentPanel()
	{
		this(null);
	}

	public TranslucentPanel(Image i)
	{
		this.i = i;
		opacity = 255;
	}

	public Image getImage()
	{
		return i;
	}

	public void setImage(Image i)
	{
		this.i = i;
		repaint();
	}

	public void setOpacity(int opacity)
	{
		if (i != null)
		{
			this.opacity = opacity;
			int width = i.getWidth(this);
			int height = i.getHeight(this);
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			bi.getGraphics().drawImage(i, 0, 0, this);
			WritableRaster pixels = bi.getAlphaRaster();
			int[] o = new int[width * height];
			for (int i = 0; i < o.length; i++)
			{
				o[i] = opacity;
			}
			for (int x = 0; x < pixels.getWidth(); x++)
			{
				for (int y = 0; y < pixels.getHeight(); y++)
				{
					pixels.setPixel(x, y, o);
				}
			}
			i = bi;
		}
		repaint();
	}

	public int getOpacity()
	{
		return opacity;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (i != null)
		{
			int w = getWidth();
			int h = getHeight();
			int iw = i.getWidth(this);
			int ih = i.getHeight(this);
			int x = (w - iw) / 2;
			int y = (h - ih) / 2;
			g.drawImage(i, x, y, this);
		}
	}
}