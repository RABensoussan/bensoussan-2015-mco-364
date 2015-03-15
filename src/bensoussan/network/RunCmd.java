package bensoussan.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunCmd {

	public static void main(String arg[]) {

		Runtime rt = Runtime.getRuntime();
		try {

			Process p1 = rt.exec("java -cp ./bin bensoussan.network.Server");
			Process p2 = rt.exec("java -cp ./bin bensoussan.network.Client");
			InputStream in1 = p1.getInputStream();
			InputStream in2 = p2.getInputStream();
			BufferedReader reader1 = new BufferedReader(
					new InputStreamReader(in1));
			BufferedReader reader2 = new BufferedReader(
					new InputStreamReader(in2));
			String line;
			while ((line = reader1.readLine()) != null) {
				System.out.println(line);
			}
			while ((line = reader2.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
