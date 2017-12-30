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

		try (BufferedReader br = new BufferedReader(
			new InputStreamReader(new FileInputStream(
				new File("読み込むファイルのパス")), "MS932"))) {

			br.lines().map(line -> line.split(",", -1))
				.forEach(commaSeparated -> Arrays.asList(commaSeparated).forEach(letter -> {
				try {
					System.out.println(new String(letter.getBytes(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}));
		}
	}

}
