package ankicho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by akakou on 2018/02/06.
 *
 * 暗記帳の中央処理をやる。
 */

public class AnkichoController {
    private static AnkichoController singleton = new AnkichoController();                 // シングルトン

    private List<AnkichoWord> rememberedWordList = new ArrayList<AnkichoWord>();        // まだ覚えていない単語
    private List<AnkichoWord> unremenberedWordList = null;                              // もう覚えた単語

    public boolean has_more_word = true;

    AnkichoWordFactory ankichoWordFactory = new AnkichoWordFactory();


    /**
     * コンストラクタ。rememberedWordListに単語リストを詰める。
     */
    private AnkichoController(){
        unremenberedWordList = ankichoWordFactory.getWordList();
    }

    /**
     * シングルトン用メソッド。単一のインスタンスを返す。
     *
     * @return AnkichoControllerのシングルトンインスタンス
     */
    public static AnkichoController getInstance(){
        return singleton;
    }

    /**
     * unremenberedWordListをシャッフルする
     */
    private void sortUnrememberedWordListRandom(){
        Collections.shuffle(unremenberedWordList);
    }

    /**
     * 問題を一つ出す。
     *
     * @return ランダムに取得された問題。
     */
    public AnkichoWord giveOne(){
        sortUnrememberedWordListRandom();
        return unremenberedWordList.get(0);
    }

    /**
     * 問題を一つ解けたことにする。実際には、解けた問題をrememberedWordListに移動している。
     *
     * @return この問題を解いた後、これ以上解けてない単語があればtrueそれ以外はfalse
     */
    public boolean solveOne(){

        AnkichoWord rememveredWord = unremenberedWordList.get(0);
        rememberedWordList.add(rememveredWord);
        unremenberedWordList.remove(0);

        has_more_word = true;

        if(unremenberedWordList.size() > 0){
            has_more_word = true;
            return true;
        } else {
            has_more_word = false;
            return false;
        }
    }
}
