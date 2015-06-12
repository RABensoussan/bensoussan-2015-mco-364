package paint;

import java.awt.Graphics;

public class RectangleListener extends BrushListener{

	public RectangleListener(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.drawRect(startX, startY, lastX-startX, lastY-startY);
	}

}
