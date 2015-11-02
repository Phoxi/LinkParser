package Services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;


public class PageReader extends AbstractReader {

    private String path;

    public PageReader(String path) {
        this.path = path;
    }

    @Override
    public Document setDocument() {
        Document document;
        try {
            return document = Jsoup.connect(path).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
