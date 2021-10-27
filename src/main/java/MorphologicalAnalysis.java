import java.util.ArrayList;
import java.util.List;

import com.worksap.nlp.sudachi.Dictionary;
import com.worksap.nlp.sudachi.DictionaryFactory;
import com.worksap.nlp.sudachi.Morpheme;
import com.worksap.nlp.sudachi.Tokenizer;

public class MorphologicalAnalysis {
    private final Tokenizer tokenizer;

    MorphologicalAnalysis(){
        Dictionary dictionary = null;
        try {
            // 設定ファイル sudachi.json を用意した場合にはそれを読み込む
            dictionary = new DictionaryFactory().create();

        } catch (Exception e) {
            System.err.println("辞書が読み込めません: " + e);
            System.exit(-1);
        }
        tokenizer = dictionary.create();
    }

    public List<String> AnalyseSentence(String sentence) {
        // 形態素解析
        List<String> li=new ArrayList<>();
        MorphologicalCondition mc=new MorphologicalCondition(li);
        for (List<Morpheme> list : tokenizer.tokenizeSentences(Tokenizer.SplitMode.C, sentence)) {
            for (Morpheme morpheme : list) {
                mc.ConditionJump(morpheme.surface());
            }
            // System.out.println("EOS"); // 文の終端 (End of Sentence)
        }
        return li;
    }

}
