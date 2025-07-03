package omikuji2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Omikuji_program {
	//OmikujiReaderオブジェクトを作成し、コンストラクタを呼び出す
	static OmikujiReader omikujiReader = new OmikujiReader();

	private static Map<String, Omikuji> dailyCache = new HashMap<String, Omikuji>();
	private static LocalDate lastCacheClear = null;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputDateString;
		//誕生日を入力してもらう
		do {
			System.out.println("誕生日を入力してください　例:20011009");

			inputDateString = br.readLine();
		} while (isIllegalDate(inputDateString));
		showFortune(inputDateString);

	}

	//日付の妥当性チェック
	private static boolean isIllegalDate(String inputDateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//日時解析を厳密に行う
		sdf.setLenient(false);

		//入力された日付が正しいかチェック
		try {
			sdf.parse(inputDateString);
			return fortuneTelling();
		} catch (ParseException e) {
			//存在しない日付の場合、メッセージを出力
			System.out.println("正しい日付を入力してください");
			return true;

		}

	}

	public static void showFortune(String birthday) {
		//今日の日付を取得
		LocalDateTime now = LocalDateTime.now();
		LocalDate today = now.toLocalDate();
		//途中
		if (lastCacheClear == null || !lastCacheClear.equals(today)) {

		}

	}

	public static boolean fortuneTelling() {

		List<Omikuji> list = omikujiReader.getAllOmikuji();
		//全てのおみくじを取得し、ランダムにリストを取り出す変数を作成
		int kuji = new Random().nextInt(list.size());
		//おみくじを表示する変数
		Omikuji fortuneResult = list.get(kuji);
		System.out.println(fortuneResult.disp());

		//結果をファイルに追記する
		try {
			FileWriter file = new FileWriter("file.txt", true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(file));

			pw.println(fortuneResult.disp());
			pw.close();
		} catch (Exception e) {
			System.out.println("ファイルに追記できませんでした");
			e.printStackTrace();

		}
		return false;

	}

}
