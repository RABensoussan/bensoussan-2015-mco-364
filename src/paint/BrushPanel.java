package paint;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BrushPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public BrushPanel(BrushListener listener) {
		setLayout(new GridLayout());

		final Canvas canvas = listener.getCanvas();

		JButton pencilButton = new ModeButton(new PencilListener(canvas));
		pencilButton.setIcon(new ImageIcon(
				"C:\\Users\\Rachel Aziza\\workspace\\Paint\\pencil.jpg"));
		pencilButton.setPreferredSize(new Dimension(50, 50));

		JButton rectangleButton = new ModeButton(new RectangleListener(canvas));
		rectangleButton.setIcon(new ImageIcon(
				"C:\\Users\\Rachel Aziza\\workspace\\Paint\\rectangle.jpg"));
		rectangleButton.setPreferredSize(new Dimension(50, 50));

		ActionListener buttonClickListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				ModeButton clicked = (ModeButton) event.getSource();
				canvas.removeMouseListener(canvas.getMouseListeners()[0]);
				canvas.removeMouseMotionListener(canvas
						.getMouseMotionListeners()[0]);
				canvas.addMouseListener(clicked.getListener());
				canvas.addMouseMotionListener(clicked.getListener());
			}

		};

		pencilButton.addActionListener(buttonClickListener);
		rectangleButton.addActionListener(buttonClickListener);

		add(pencilButton);
		add(rectangleButton);
	}

}
