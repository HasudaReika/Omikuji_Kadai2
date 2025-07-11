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
import java.util.List;
import java.util.Random;

public class OmikujiProgram {
	//OmikujiReaderオブジェクトを作成し、コンストラクタを呼び出す
	static OmikujiReader omikujiReader = new OmikujiReader();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputDateString;

		//おみくじの結果が出たらまた誕生日入力に戻る
		while (true) {

			//誕生日を入力してもらう
			System.out.println("誕生日を入力してください　例:20011009");
			//入力された日付をinputDateStringに代入
			inputDateString = br.readLine();
			if (!isValidDate(inputDateString)) {
				continue;
			}
			fortuneTelling(inputDateString);

			System.out.println("\n" + "おみくじを続けますか？　yes/no");
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String answer = br2.readLine();
			if (answer.equals("yes")) {
				continue;
			} else {
				System.out.println("おみくじプログラムを終了します");
				break;
			}
		}
	}

	//日付の妥当性チェック
	private static boolean isValidDate(String inputDateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//日時解析を厳密に行う
		sdf.setLenient(false);
		//入力された日付が正しいかチェック
		try {
			sdf.parse(inputDateString);
			//正しかったらおみくじを出す
			return true;

		} catch (ParseException e) {
			//存在しない日付の場合、メッセージを出力
			System.out.println("正しい日付を入力してください");
			return false;

		}

	}

	//おみくじを出すメソッド
	public static void fortuneTelling(String birthday) {
		//今日の日付を取得
		LocalDateTime now = LocalDateTime.now();
		LocalDate today = now.toLocalDate();
		//日付変わって結果も変わるかチェック
		//				LocalDate today = LocalDate.parse("2025-07-09");
		//全てのおみくじを取得しリストに格納
		List<Omikuji> list = omikujiReader.getAllOmikuji();
		//誕生日から得られるシード
		long baseSeed = Long.parseLong(birthday);
		//今日の日付から得られるシード 日付を数値に変換
		long dateSeed = today.toEpochDay();
		//誕生日と今日の日付を組み合わせたシード
		Long combinedSeed = baseSeed + dateSeed;
		//シード値を作成
		Random random = new Random(combinedSeed);
		//全てのおみくじをランダムにリストを取り出す変数を作成
		int kuji = random.nextInt(list.size());
		//おみくじをランダムに取得
		Omikuji fortuneResult = list.get(kuji);
		//取得したおみくじを出力
		System.out.println(fortuneResult.disp());

		//結果をファイルに追記する
		try {
			FileWriter file = new FileWriter("file.txt", true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(file));
			//			System.out.println("結果をファイルに追記しました");
			pw.println(birthday + "\n" + fortuneResult.disp());
			pw.close();

		} catch (IOException e) {
			//			System.out.println("ファイルに追記できませんでした");
			e.printStackTrace();

		}
	}

}