import Config.ConfigurationService;
import Services.AbstractReader;
import Services.LinkService;
import Services.ReaderFactory;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import static Config.Keys.*;
import static Config.Keys.NUMBER_OF_LINK;
import static Config.Keys.SHOW_SOURCE;

/**
 * Created by mpawlowski on 02.11.15.
 */
public class Worker {

    private ArrayList<String> links;
    private ConfigurationService configurationService;
    private LinkService linkService ;
    private Document doc = null;
    private AbstractReader reader;

    public Worker(){

    }

    public void work(){
        setServices();
        try {
            doc = reader.setDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
        links = linkService.getLinks(doc);
        linkService.showNumberOfLinks(links);
        linkService.showLinks(links, Boolean.parseBoolean(configurationService.getProperty(SHOW_LINKS)), Boolean.parseBoolean(configurationService.getProperty(EXTERNAL_LINK)));
        reader.showSource(links, Integer.parseInt(configurationService.getProperty(NUMBER_OF_LINK)), Boolean.parseBoolean(configurationService.getProperty(SHOW_SOURCE)));
    }

    private void setServices() {
        configurationService = new ConfigurationService(PROPERTIES_FILE);
        linkService = new LinkService(configurationService.getProperty(SITE));
        reader = ReaderFactory.create(configurationService.getProperty(SITE));
    }

}
