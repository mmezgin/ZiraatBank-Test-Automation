package common.framework;

import java.util.Properties;

public class BaseConfiguration {
    private Properties configFile;

    public BaseConfiguration()
    {
        configFile = new Properties();

        try {
            configFile.load(this.getClass().getClassLoader().getResourceAsStream("base.properties"));
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public String getProperty(String key)
    {
        return this.configFile.getProperty(key);
    }
}
