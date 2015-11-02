package Services;


public class ReaderFactory {
    public static AbstractReader create(String path) {
        if (path.startsWith("http://") || path.startsWith("www"))
            return new PageReader(path);
        return new FileReader(path);
    }


}