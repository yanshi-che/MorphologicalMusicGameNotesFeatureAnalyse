import org.w3c.dom.Document;
import javax.xml.xpath.XPath;

public class FeedItem {
    private final Document document;
    private final XPath xPath;
    FeedItem(Document d,XPath p){
        document=d;
        xPath=p;
    }
    public Document getDocument(){
        return document;
    }

    public XPath getXPath(){
        return xPath;
    }
}
