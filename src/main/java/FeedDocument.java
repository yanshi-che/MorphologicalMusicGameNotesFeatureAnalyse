import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import nu.validator.htmlparser.dom.HtmlDocumentBuilder;

public class FeedDocument {
	private FeedItem item;
	private final long SLEEPLENGTH;

	public FeedDocument() {
		SLEEPLENGTH = 10000;
	}

	public FeedItem getDocumentInfo(String ust) {
		try {
			Thread.sleep(SLEEPLENGTH); //sleepLengthミリ秒sleep
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			URL url = new URL(ust);
			URLConnection connection = url.openConnection();
			connection.connect();

			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "EUC-JP");
			BufferedReader reader = new BufferedReader(inputStreamReader);
			// DOMツリーの構築
			HtmlDocumentBuilder builder = new HtmlDocumentBuilder();
			Document document = builder.parse(new InputSource(reader));
			// XPath の表現を扱う XPath オブジェクトを生成
			XPath xPath = XPathFactory.newInstance().newXPath();
			// XPath 式内で接頭辞 h がついている要素を HTML の要素として認識
			xPath.setNamespaceContext(new NamespaceContextHTML());

			item=new FeedItem(document,xPath);
			
			reader.close();
			
		} catch (IOException e) {
			System.out.println(e);
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		return item;
	}
}
