import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Converter {

	public static void main(String[] args) throws IOException {
		String target = "髙橋";
		System.out.println("準備");
		System.out.println(target + "\n");

		target = new String(target.getBytes("UTF-8"), "SJIS");
		System.out.println("SJIS変換");
		System.out.println(target + "\n" + "\n");

		String sjisTargetUTF8 = new String(target.getBytes("SJIS"), "UTF-8");
		System.out.println("SJIS⇒UTF-8変換");
		System.out.println(sjisTargetUTF8 + "\n");

		String sjisTargetMs = new String(target.getBytes("SJIS"), "MS932");
		System.out.println("SJIS⇒MS932変換");
		System.out.println(sjisTargetMs + "\n");

		String utf8TargetMs = new String(sjisTargetUTF8.getBytes("UTF-8"), "MS932");
		System.out.println("UTF-8⇒MS932変換");
		System.out.println(utf8TargetMs + "\n");

		File f = new File("読み込むファイルのパス");
		FileInputStream input = new FileInputStream(f);
		InputStreamReader stream = new InputStreamReader(input,"MS932");
		BufferedReader br = new BufferedReader(stream);

		String line;
		// 1行ずつCSVファイルを読み込む
		while ((line = br.readLine()) != null) {
			byte[] b = line.getBytes();
           line = new String(b, "UTF-8");
           String[] columns = line.split(",",-1);

           for (int j = 0; j < columns.length; j++) {
				System.out.println("ファイル読み込みSJIS⇒UTF8");
				System.out.println(columns[j] + "\n");
			}
		}
		br.close();

	}

}
