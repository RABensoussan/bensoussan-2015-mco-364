package paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class BrushListener implements MouseListener,
		MouseMotionListener {

	protected Canvas canvas;
	protected int startX;
	protected int startY;
	protected int currX;
	protected int currY;
	protected int lastX;
	protected int lastY;

	public BrushListener(Canvas canvas) {
		this.canvas = canvas;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		currX = event.getX();
		currY = event.getY();
		draw(canvas.getImage().getGraphics());
		canvas.repaint();
		lastX = currX;
		lastY = currY;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent event) {
		startX = event.getX();
		startY = event.getY();
		currX = startX;
		currY = startY;
		lastX = startX;
		lastY = startY;
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		draw(canvas.getImage().getGraphics());
		canvas.repaint();
	}

	abstract public void draw(Graphics g);

}
