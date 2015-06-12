package paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public PaintFrame() {
		setSize(800, 600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(10, 10);
		setResizable(false);

		setLayout(new BorderLayout());
		
		Canvas canvas = new Canvas(800, 600);
		add(canvas, BorderLayout.CENTER);
		BrushListener listener = new PencilListener(canvas);
		canvas.setListener(listener);

		ColorsPanel colorsPanel = new ColorsPanel(canvas);
		add(colorsPanel, BorderLayout.WEST);
		
		BrushPanel pencilPanel = new BrushPanel(listener);
		add(pencilPanel, BorderLayout.NORTH);

	}

}
