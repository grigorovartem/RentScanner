import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.List;

public class Crawler {

    private static List<String> links = new ArrayList<>();
    private static Document htmlDocument;

    public static boolean crawl(String url) throws URISyntaxException {
        try {
            Connection connection = Jsoup.connect(url);
            htmlDocument = connection.get();
            if (connection.response().statusCode() == 200)

            {
                System.out.println("\n**Visiting** Received web page at " + url);
            }
            if (!connection.response().contentType().contains("text/html")) {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            ArrayList<Element> linksOnPage = htmlDocument.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            if (links.size() == 0) {
                for (Element link : linksOnPage) {
                    links.add(link.absUrl("href"));
                }
            }

            for (Element link : linksOnPage) {
                if (!links.contains(link.absUrl("href"))) {
                    System.out.println(link.absUrl("href"));
                    links.add(link.absUrl("href"));
                    Desktop d = Desktop.getDesktop();
                    //d.browse(new URI(link.absUrl("href")));
                }
            }

            return true;
        } catch (IOException ioe) {

            return false;
        }
    }

}

