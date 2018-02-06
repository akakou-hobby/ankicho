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
    private List<AnkichoWord> rememberedWordList = null;                                // まだ覚えていない単語
    private List<AnkichoWord> unremenberedWordList = new ArrayList<AnkichoWord>();      // もう覚えた単語

    AnkichoWordFactory ankichoWordFactory = null;


    /**
     * コンストラクタ。Factoryを用意して、rememberedWordListに単語リストを詰める。
     */
    AnkichoController(){
        ankichoWordFactory = new AnkichoWordFactory();
        rememberedWordList = ankichoWordFactory.getWordList();
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
     */
    public void solveOne(){
        AnkichoWord rememveredWord = unremenberedWordList.get(0);
        rememberedWordList.add(rememveredWord);
        unremenberedWordList.remove(0);
    }
}
