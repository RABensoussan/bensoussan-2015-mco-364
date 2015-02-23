package bensoussan.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private boolean wink;
	
	public SmileComponent(){
		wink = true;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int w = getWidth();
		int h = getHeight();
		g.setColor(Color.YELLOW);
		g.fillOval(0, 0, w, getHeight()); // face
		if (wink) {
			g.setColor(Color.BLUE);
			g.fillOval(w / 3, h / 6, w / 12, h / 12); // left eye
			wink = false;
		} else {
			g.setColor(Color.BLACK);
			g.drawArc(w / 3 , h / 6 , w / 12, h / 12, 0, 125);// wink
			wink = true;
		}
		g.setColor(Color.BLUE);
		g.fillOval(w / 3 * 2, h / 6, w / 12, h / 12); // right eye
		g.setColor(Color.RED);
		g.drawArc(w / 3, h / 2, w / 3, h / 3, -150, 125); // smile

	}

}