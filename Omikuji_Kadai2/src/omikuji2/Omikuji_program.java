package omikuji2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
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
	//キャッシュ
	private static Map<String, Omikuji> dailyCache = new HashMap<String, Omikuji>();
	//最後にキャッシュをクリアした日
	private static LocalDate lastCacheClear = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputDateString;
		//誕生日を入力してもらう
		do {
			System.out.println("誕生日を入力してください　例:20011009");
			//入力された日付をinputDateStringに代入
			inputDateString = br.readLine();
		} while (isIllegalDate(inputDateString));
		// fortuneTelling(inputDateString);
	}

	//日付の妥当性チェック
	private static boolean isIllegalDate(String inputDateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//日時解析を厳密に行う
		sdf.setLenient(false);
		//入力された日付が正しいかチェック
		try {
			sdf.parse(inputDateString);
			return fortuneTelling(inputDateString);
			
		} catch (ParseException e) {
			//存在しない日付の場合、メッセージを出力
			System.out.println("正しい日付を入力してください");
			return true;

		}
	}

	//おみくじを出すメソッド
	public static boolean fortuneTelling(String birthday) {
		//今日の日付を取得
		LocalDateTime now = LocalDateTime.now();
		LocalDate today = now.toLocalDate();
		System.out.println(now + "now");
		System.out.println(today + "today");
		
		//キャッシュクリア履歴がなし、または前回のクリアが今日でなかった場合
		if (lastCacheClear == null || !lastCacheClear.equals(today)) {

			//キャッシュクリア
			dailyCache.clear();
			System.out.println("キャッシュをクリアしました");
			//最後のキャッシュクリアを今日にする
			lastCacheClear = today;
			System.out.println("lastCacheClearが今日に更新されました");
		}

		Omikuji omikuji;
		//キャッシュに日付があった場合
		if (dailyCache.containsKey(birthday)) {
			//キャッシュからおみくじを取得
			omikuji = dailyCache.get(birthday);
			//おみくじを表示
			System.out.println(omikuji.disp());
			System.out.println("入力された日付はすでにキャッシュに存在します");
		} else {
			System.out.println("新しくおみくじを作成します");
			//キャッシュになかった場合はおみくじ作成メソッドを呼び出す
			omikuji = makeOmikuji(birthday);
			//おみくじを作成したら、
			if (omikuji != null) {
				//入力した日付とおみくじをキャッシュに保存
				dailyCache.put(birthday, omikuji);
				System.out.println("おみくじをキャッシュに保存しました");

				try (FileOutputStream fileOut = new FileOutputStream("cache.txt");
						ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
					out.writeObject(dailyCache);
					System.out.println("結果をキャッシュファイルに保存しました(fortuneTelling)");
				} catch (Exception i) {
					System.out.println("キャッシュファイルに追記できませんでした(fortuneTelling)");
					i.printStackTrace();
				}

			}

		}

		return false;

	}

	//おみくじ作成メソッド
	private static Omikuji makeOmikuji(String birthday) {
		//全てのおみくじを取得しリストに格納
		List<Omikuji> list = omikujiReader.getAllOmikuji();
		long seed;
		//シードに入力された誕生日を代入
		seed = Long.parseLong(birthday);
		//シード値を作成
		Random random = new Random(seed);
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
			System.out.println("結果をファイルに追記しました");
			pw.println(birthday + "\n" + fortuneResult.disp());
			pw.close();

		} catch (Exception e) {
			System.out.println("ファイルに追記できませんでした(makeOmikuji)");
			e.printStackTrace();

		}

		return fortuneResult;

	}

}