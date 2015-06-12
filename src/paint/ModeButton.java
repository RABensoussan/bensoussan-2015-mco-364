package paint;

import javax.swing.JButton;

public class ModeButton extends JButton{
	
	private static final long serialVersionUID = 1L;
	private BrushListener listener;
	
	public ModeButton(BrushListener listener){
		this.listener = listener;
	}
	
	public BrushListener getListener(){
		return listener;
	}

}
