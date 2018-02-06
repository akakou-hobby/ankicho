package ankicho;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akakou on 2018/02/06.
 *
 * 暗記帳の単語をGoogle Driveから取得する
 */

public class AnkichoWordFactory {
    String plain_text = null;

    public AnkichoWordFactory(){
        plain_text = "a,b\nc,d";    // デバッグ用の結果
    }

    /**
     * 単語リストファイルを読み込んで、AnkichoWordのリストにして返す
     *
     * @return 読み込んでパースしたAnkichoWordのリスト
     */
    public List<AnkichoWord> getWordList(){

        String[] lineDivideWordList = plain_text.split("\n", 0);
        List<AnkichoWord> wordList = new ArrayList<AnkichoWord>();

        for(String line: lineDivideWordList){
            String[] questionAndAnswer = line.split(",", 0);
            AnkichoWord ankichoWord = new AnkichoWord(questionAndAnswer[0], questionAndAnswer[1]);
            wordList.add(ankichoWord);
        }

        return wordList;
    }
}
