package ankicho;

/**
 * Created by akakou on 2018/02/06.
 *
 * 暗記帳における単語自体について実装するクラス
 */

public class AnkichoWord {
    public String question = null;
    public String answer = null;

    public AnkichoWord(String question, String answer){
        this.question = question;
        this.answer = answer;
    }
}
