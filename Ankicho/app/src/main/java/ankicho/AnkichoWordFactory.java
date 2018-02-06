package ankicho;

import android.util.Log;
import android.widget.Toast;

import com.akakou.hobby.ankicho.ShowQuestionActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private InputStream inputStream = null;

    private AnkichoWordFactory(){}

    /**
     * シングルトン用メソッド。単一のインスタンスを返す。
     *
     * @return AnkichoWordFactoryのシングルトンインスタンス
     */
    public static AnkichoWordFactory getInstance(){
        return singleton;
    }

    public boolean setBody(InputStream inputstream){
        if (plain_text == null){

            BufferedReader reader = null;
            StringBuilder builder = new StringBuilder();
            try {
                reader = new BufferedReader(new InputStreamReader(inputstream));
                String line = "";

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append('\n');
                }
                plain_text = builder.toString();
                return true;

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
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
