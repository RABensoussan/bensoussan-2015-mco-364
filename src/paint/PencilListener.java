package paint;

import java.awt.Graphics;

public class PencilListener extends BrushListener{
	
	public PencilListener(Canvas canvas){
		super(canvas);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(canvas.getColor());
		g.drawLine(lastX, lastY, currX, currY);
	}


}
