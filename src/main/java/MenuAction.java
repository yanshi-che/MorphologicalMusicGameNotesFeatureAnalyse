import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class MenuAction extends AbstractAction {
    private final String LEVEL;
    private final JList<String> itemJList;
    private final List<MusicItem> musicList;
    private final Map<String, String> musicSentenceMap;

    MenuAction(int num, List<MusicItem> mlist, Map<String, String> map, JList<String> list) {
        LEVEL = "Lv" + num;
        musicList = mlist;
        itemJList = list;
        putValue(Action.NAME, "Lv" + num);
        musicSentenceMap = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel<String> model = (DefaultListModel<String>) itemJList.getModel();
        itemJList.clearSelection();
        model.removeAllElements();
        for (MusicItem item : musicList) {
            if (LEVEL.equals(item.getLevel())) {
                musicSentenceMap.put((item.getName() + item.getDifficulty()), item.getSentence());
                model.addElement((item.getName() + item.getDifficulty()));
                //System.out.println(item.getDifficulty() + item.getName());//
            }
        }
    }

}
