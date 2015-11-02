package Services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class LinkService {

    private String path;

    public LinkService(String path) {
        this.path = path;
    }


    public ArrayList<String> getLinks(Document doc) {
        Elements e;
        ArrayList<String> links = new ArrayList<>();
        e = doc.select("a[href]");
        for (int i = 0; i < e.size(); i++) {
            links.add(e.get(i).attr("abs:href"));
        }

        return links;
    }

    private int getNumberOfLinks(ArrayList<String> links) {
        return links.size();
    }

    public void showLinks(ArrayList<String> list, boolean showLink, boolean externalLinks) {
        if (externalLinks)
            getLinksFromInternalSite(list);
        if (showLink) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }

    }

    public void showNumberOfLinks(ArrayList<String> links) {
        System.out.println("Ilość znalezionych linków " + getNumberOfLinks(links));
    }


    public void getLinksFromInternalSite(ArrayList<String> links) {
        ArrayList<String> linkList = new ArrayList<String>();
        for (int i = 0; i < getNumberOfLinks(links); i++) {
            if (links.get(i).startsWith(path)) {
                linkList.add(links.get(i));
            }
        }
        clearAndFillList(links, linkList);
    }

    private void clearAndFillList(ArrayList<String> links, ArrayList<String> linkList) {
        links.clear();
        for (int i = 0; i < getNumberOfLinks(linkList); i++) {
            links.add(linkList.get(i));
        }
    }

}
