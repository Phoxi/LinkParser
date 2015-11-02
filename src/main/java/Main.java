import Config.ConfigurationService;
import Config.Keys;
import Services.AbstractReader;
import Services.LinkService;
import Services.ReaderFactory;
import org.jsoup.nodes.Document;


import java.io.IOException;
import java.util.ArrayList;

import static Config.Keys.*;


public class Main {


    public static void main(String[] args) {

       Worker worker=new Worker();
        worker.work();

    }

}
