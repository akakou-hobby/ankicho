package ankicho;

import android.util.Log;
import android.widget.Toast;

import com.akakou.hobby.ankicho.ShowQuestionActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akakou on 2018/02/06.
 *
 * 暗記帳の単語をGoogle Driveから取得する
 */

public class AnkichoWordFactory {
    private static AnkichoWordFactory singleton = new AnkichoWordFactory();
    private String plain_text = null;

    private AnkichoWordFactory(){}

    /**
     * シングルトン用メソッド。単一のインスタンスを返す。
     *
     * @return AnkichoWordFactoryのシングルトンインスタンス
     */
    public static AnkichoWordFactory getInstance(){
        return singleton;
    }

    public void setBody(String text){
        if (this.plain_text == null){
            this.plain_text = text;
        }
    }

    /**
     * 単語リストファイルを読み込んで、AnkichoWordのリストにして返す
     *
     * @return 読み込んでパースしたAnkichoWordのリスト
     */
    public List<AnkichoWord> getWordList(){
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
