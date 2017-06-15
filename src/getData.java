import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by anmol on 15/6/17.
 */
public class getData {

    String data(String num) throws IOException {
        Document doc = Jsoup.connect("http://www.espncricinfo.com/ci/engine/match/index.html").get();
        Elements section = doc.getElementsByTag("section");
        for (Element a : section) {

            if (a.attr("id").equals("live-match-data")) {
                // System.out.println("OK");

                Element section1 = a.getElementsByClass("matches-day-block").first();
                Element section2 = section1.getElementsByClass("default-match-block ").first();
                Elements div = section2.getElementsByTag("div");
                for (Element b : div) {
                    if (b.hasClass("innings-info-"+num)) {
                        //System.out.println(b.text());
                        return b.text();
                    }
                }

            }

        }

        return null;
    }

}
