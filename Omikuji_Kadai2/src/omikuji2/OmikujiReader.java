package omikuji2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OmikujiReader {

	//全てのおみくじオブジェクトを格納するリストを作成　Omikuji_programでランダムに取得
	private List<Omikuji> allOmikuji = new ArrayList<Omikuji>();

	//おみくじリーダーのコンストラクタ
	public OmikujiReader() {
		System.out.println("おみくじリーダーのコンストラクタを呼び出しました");
		//おみくじオブジェクトを作成しリストに追加するメソッドを呼び出す
		loadOmikuji();
	}

	//おみくじオブジェクトを作成しリストに追加
	public void loadOmikuji() {
		//csvを読み込む
		String csv = "omikuji.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
			String line;

			while ((line = br.readLine()) != null) {
				//「,」で区切る
				String[] values = line.split(",");
				String unsei = values[0];
				String negaigoto = values[1];
				String akinai = values[2];
				String gakumon = values[3];

				//読み込んだデータをオブジェクトにする　
				Omikuji omikujiObject = makeOmikujiObject(unsei, negaigoto, akinai, gakumon);
				//作成したオブジェクトをリストに追加
				if (omikujiObject != null) {
					allOmikuji.add(omikujiObject);
				}

			}

		} catch (IOException e) {
			System.out.println("読み込めませんでした");
			e.printStackTrace();
		}

		//csvの読み込み終了

	}

	//unseiに応じてオブジェクトを作成
	//unseiが"大吉"の場合、Daikitiオブジェクトを作る　"中吉"の場合はtyuukiti...
	private Omikuji makeOmikujiObject(String unsei, String negaigoto, String akinai, String gakumon) {
		switch (unsei) {
		case "大吉":
			return new Daikiti(negaigoto, akinai, gakumon);
		case "中吉":
			return new Tyuukiti(negaigoto, akinai, gakumon);
		case "小吉":
			return new Shoukiti(negaigoto, akinai, gakumon);
		case "末吉":
			return new Suekiti(negaigoto, akinai, gakumon);
		case "吉":
			return new Kiti(negaigoto, akinai, gakumon);
		case "凶":
			return new Kyou(negaigoto, akinai, gakumon);
		default:
			return null;

		}

	}

	//全てのおみくじをOmikuji_programで返す
	public List<Omikuji> getAllOmikuji() {
		return allOmikuji;

	}

}
