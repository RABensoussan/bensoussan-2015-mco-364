package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ColorsPanel(final Canvas canvas) {
		setLayout(new GridLayout(6, 2));

		Color[] colors = new Color[] { Color.BLACK, Color.DARK_GRAY,
				Color.LIGHT_GRAY, Color.WHITE, Color.RED, Color.ORANGE,
				Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.PINK,
				Color.MAGENTA };

		int nextColor = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				JButton temp = new JButton();
				temp.setPreferredSize(new Dimension(20, 20));
				temp.setBackground(colors[nextColor++]);
				temp.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						JButton buttonClicked = (JButton) event.getSource();
						canvas.setColor(buttonClicked.getBackground());
					}

				});
				add(temp);
			}
		}

	}

}
