/*package Main;

import WebSites.OLXProcessor;
import org.apache.http.ParseException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Crawler {


    private static Document htmlDocument;

    private static Processor processor=new OLXProcessor();


    public static Document crawl() throws IOException, ParseException {
        Connection connection = Jsoup.connect(processor.getUrlBuilder().build(MainFrame.properties));
            htmlDocument = connection.get();

        return htmlDocument;
    }

}*/

