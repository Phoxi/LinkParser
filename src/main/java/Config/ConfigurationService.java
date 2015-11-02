package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigurationService {

    private Properties p = new Properties();

        public ConfigurationService(String path) {
        try {
            p.load(new FileInputStream(path));
        } catch (IOException e) {
            System.out.println("File not found due to: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return p.getProperty(key);
    }

}
