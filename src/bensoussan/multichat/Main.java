package bensoussan.multichat;

public class Main {

	public static void main(String[] args) {

		new Server().start();
		new ClientFrame("Rachel").setVisible(true);
		new ClientFrame("Gabi").setVisible(true);
		new ClientFrame("Nechama").setVisible(true);


	}

}
