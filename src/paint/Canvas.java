package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private BrushListener listener;
	private Color color;

	public Canvas(int width, int height) {

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
		color = Color.BLACK;

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public BufferedImage getImage() {
		return image;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		drawPreview(g);
	}

	private void drawPreview(Graphics g) {
		
	}

	public BrushListener getListener() {
		return listener;
	}

	public void setListener(BrushListener listener) {
		this.removeMouseListener(this.listener);
		this.removeMouseMotionListener(this.listener);
		this.listener = listener;
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

}
