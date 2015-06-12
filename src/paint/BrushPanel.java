package paint;

import java.awt.Color;
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
		pencilButton.setBackground(Color.WHITE);
		pencilButton.setIcon(new ImageIcon("./pencil.jpg"));
		pencilButton.setPreferredSize(new Dimension(50, 50));

		JButton rectangleButton = new ModeButton(new RectangleListener(canvas));
		rectangleButton.setBackground(Color.WHITE);
		rectangleButton.setIcon(new ImageIcon("./rectangle.jpg"));
		rectangleButton.setPreferredSize(new Dimension(50, 50));

		ActionListener buttonClickListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				ModeButton clicked = (ModeButton) event.getSource();
				canvas.setListener(clicked.getListener());
			}

		};

		pencilButton.addActionListener(buttonClickListener);
		rectangleButton.addActionListener(buttonClickListener);

		add(pencilButton);
		add(rectangleButton);
	}

}
