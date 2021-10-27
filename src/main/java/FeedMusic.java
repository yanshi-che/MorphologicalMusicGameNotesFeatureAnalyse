import java.util.List;
import java.util.regex.Pattern;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FeedMusic {

    public void getMusicFeed(FeedItem item, List<MusicItem> list) {
        try {
            Node infoNode;
            String headLevel = "";
            String[] tempLevelName;
            String level;
            String difficulty;
            String name;
            String sentence;
            MusicItem music;
            Pattern pattern = Pattern.compile("to");

            NodeList infoList = (NodeList) item.getXPath().evaluate("//h:div[@id='body']/h:h3|//h:div[@id='body']/h:ul", item.getDocument(),
                    XPathConstants.NODESET);
            // System.out.println("Number of tracks: " + infoList.getLength());
            for (int i = 0; i < infoList.getLength(); i++) {
                infoNode = infoList.item(i);
                if (!item.getXPath().evaluate("h:a/@id", infoNode).equals("")) {
                    headLevel = item.getXPath().evaluate("h:a/@id", infoNode);
                }
                if (pattern.matcher(headLevel).find()) {
                    try{
                        tempLevelName = item.getXPath().evaluate("h:li/h:span[1]", infoNode).split("\s", 2);
                        level = tempLevelName[0];
                        name = tempLevelName[1];
                    }catch(ArrayIndexOutOfBoundsException e){
                        continue;
                    }
                } else {
                    level = headLevel;
                    name = item.getXPath().evaluate("h:li/h:span[1]", infoNode);
                }
                difficulty = item.getXPath().evaluate("h:li/h:span[2]", infoNode);
                if (difficulty.equals(""))
                    continue;
                sentence = item.getXPath().evaluate("h:li/h:ul", infoNode);
                if (sentence.equals(""))
                    continue;
                music = new MusicItem(level, difficulty, name, sentence);
                list.add(music);
            }

        } catch (XPathException e) {
            System.out.println(e);
        }
    }

}
