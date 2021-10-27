import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class GUImain extends JFrame {
    public static void main(String[] args) {
        System.out.println("GUI表示まで30秒ほどかかります。");
        List<MusicItem> list = new ArrayList<>();
        new FeedMusic().getMusicFeed(new FeedDocument().getDocumentInfo(
        "https://bemaniwiki.com/index.php?SOUND%20VOLTEX%20EXCEED%20GEAR/%BA%BE%BE%CE%A1%A6%B5%D5%BA%BE%BE%CE%A1%A6%B8%C4%BF%CD%BA%B9%C9%E8%CC%CC%A5%EA%A5%B9%A5%C8/Lv1%A1%C113"),list);
        new FeedMusic().getMusicFeed(new FeedDocument().getDocumentInfo(
        "https://bemaniwiki.com/index.php?SOUND%20VOLTEX%20EXCEED%20GEAR/%BA%BE%BE%CE%A1%A6%B5%D5%BA%BE%BE%CE%A1%A6%B8%C4%BF%CD%BA%B9%C9%E8%CC%CC%A5%EA%A5%B9%A5%C8/Lv14%A1%C116"),list);
        new FeedMusic().getMusicFeed(new FeedDocument().getDocumentInfo(
        "https://bemaniwiki.com/index.php?SOUND%20VOLTEX%20EXCEED%20GEAR/%BA%BE%BE%CE%A1%A6%B5%D5%BA%BE%BE%CE%A1%A6%B8%C4%BF%CD%BA%B9%C9%E8%CC%CC%A5%EA%A5%B9%A5%C8/Lv17%A1%C118"),list);
        new FeedMusic().getMusicFeed(new FeedDocument().getDocumentInfo(
        "https://bemaniwiki.com/index.php?SOUND%20VOLTEX%20EXCEED%20GEAR/%BA%BE%BE%CE%A1%A6%B5%D5%BA%BE%BE%CE%A1%A6%B8%C4%BF%CD%BA%B9%C9%E8%CC%CC%A5%EA%A5%B9%A5%C8/Lv19%A1%C120"),list);
        GUImain m = new GUImain("GUI",list);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        m.setVisible(true);
    }

    private static final int WINDOW_WIDTH = 720;
    private static final int WINDOW_HEIGHT = 450;
    private static final int[] MENUID =new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

    GUImain(String title,List<MusicItem> musicList) {
        // ウィンドウ処理等
        super(title);
        
        // メニューバー処理
        JMenuBar levelMenuBar = new JMenuBar();
        setJMenuBar(levelMenuBar);
        
        // メニュー処理
        JMenu levelMenuOneToFive = new JMenu("Lv1~5");
        levelMenuBar.add(levelMenuOneToFive);
        JMenu levelMenuSixToTen = new JMenu("Lv6~10");
        levelMenuBar.add(levelMenuSixToTen);
        JMenu levelMenuElevenToFifteen = new JMenu("Lv11~15");
        levelMenuBar.add(levelMenuElevenToFifteen);
        JMenu levelMenuSixteenToTwenty = new JMenu("Lv16~20");
        levelMenuBar.add(levelMenuSixteenToTwenty);
        
        //テキストフィールド処理
        JTextArea itemTextArea = new JTextArea();
        itemTextArea.setEditable(false);
        itemTextArea.setBorder(new TitledBorder( "譜面属性" ));
        JScrollPane scrItemTextArea=new JScrollPane(itemTextArea);
        scrItemTextArea.setBounds(401,1,320,320);
        
        //リスト処理
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> itemJList = new JList<>(model);
        JScrollPane scrItemJList = new JScrollPane(itemJList);
        scrItemJList.setBounds(1, 1, 400, 400);
        scrItemJList.setBorder(new TitledBorder( "楽曲リスト" ));
        
        //ボタン処理
        Map<String, String> musicSentenceMap = new HashMap<>();
        JButton displayButton = new JButton(new ButtonAction(musicSentenceMap, itemJList, itemTextArea));
        displayButton.setBounds(540, 330, 60, 60);

        // メニューアイテム処理
        for(int i=0;i<MENUID.length;i++){
            if(i<MENUID[4]){
                levelMenuOneToFive.add(new MenuAction(MENUID[i],musicList, musicSentenceMap, itemJList));
            }
            if(MENUID[4]<=i&&i<MENUID[9]){
                levelMenuSixToTen.add(new MenuAction(MENUID[i],musicList, musicSentenceMap, itemJList));
            }
            if(MENUID[9]<=i&&i<MENUID[14]){
                levelMenuElevenToFifteen.add(new MenuAction(MENUID[i],musicList, musicSentenceMap, itemJList));
            }
            if(MENUID[14]<=i){
                levelMenuSixteenToTwenty.add(new MenuAction(MENUID[i],musicList, musicSentenceMap, itemJList));
            }
        }
        
        
        // パネル処理
        JPanel basePanel = (JPanel) getContentPane();
        basePanel.setLayout(null);
        basePanel.add(scrItemJList);
        basePanel.add(scrItemTextArea);
        basePanel.add(displayButton);
    }
}
