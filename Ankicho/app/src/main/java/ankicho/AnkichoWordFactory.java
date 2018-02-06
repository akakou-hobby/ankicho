package ankicho;

import android.util.Log;
import android.widget.Toast;

import com.akakou.hobby.ankicho.ShowQuestionActivity;

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
    }

    /**
     * 単語リストファイルを読み込んで、AnkichoWordのリストにして返す
     *
     * @return 読み込んでパースしたAnkichoWordのリスト
     */
    public List<AnkichoWord> getWordList(){
        plain_text = "a,b\nc,d";    // デバッグ用の結果

        Log.d("MyApp", plain_text);
        String[] lineDivideWordList = plain_text.split("\n");
        List<AnkichoWord> wordList = new ArrayList<AnkichoWord>();

        for(String line : lineDivideWordList){
            String[] questionAndAnswer = line.split(",");
            AnkichoWord ankichoWord = new AnkichoWord(questionAndAnswer[0], questionAndAnswer[1]);
            wordList.add(ankichoWord);
        }

        return wordList;
    }
}
