import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JList;
import javax.swing.JTextArea;

public class ButtonAction extends AbstractAction {
    private final Map<String, String> musicSentenceMap;
    private List<String> list;
    private final JList<String> itemJList;
    private final JTextArea textArea;
    private final MorphologicalAnalysis mAnalysis;

    ButtonAction(Map<String, String> map, JList<String> li, JTextArea ta) {
        putValue(Action.NAME, "Analyse");
        musicSentenceMap = map;
        itemJList = li;
        textArea = ta;
        mAnalysis = new MorphologicalAnalysis();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String select = itemJList.getSelectedValue();
        try{
            list =new ArrayList<>(new HashSet<>(mAnalysis.AnalyseSentence(musicSentenceMap.get(select))));
        }catch(NullPointerException ignored){
        }
        textArea.setText("");
        if (list != null&&list.size()!=0) {
            for (String s : list) {
                textArea.append(s+"\n");
            }
        }else{
            textArea.append("譜面要素を抽出できませんでした");
        }
    }
}
