package Services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;


public class FileReader extends AbstractReader {

    private String path;

    public FileReader(String path){
        this.path=path;
    }


    @Override
    public Document setDocument() {
        Document document;
        try{
            File in=new File(path);
            return document= Jsoup.parse(in,"US-ASCII") ;
        }catch(IOException | NullPointerException e){

        }
        return null;
    }


}
