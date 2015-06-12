package paint;

import java.awt.Graphics;

public class RectangleListener extends BrushListener{
	

	public RectangleListener(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(canvas.getColor());
		int x = Math.min(startX, currX);
		int y = Math.min(startY, currY);
		int width = Math.abs(startX - currX);
		int height = Math.abs(startY - currY);
		g.drawRect(x, y, width, height);
		g.drawRect(x, y, width, height);
	}

}
