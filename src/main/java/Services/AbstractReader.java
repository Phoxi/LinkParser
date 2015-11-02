package Services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractReader {

    public abstract Document setDocument() throws IOException;


    public void showSource(ArrayList<String> links, int ID, boolean showSource) {
        if (showSource) {
            Document doc = null;
            try {
                doc = Jsoup.connect(links.get(ID)).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(doc);
        }
    }


}
