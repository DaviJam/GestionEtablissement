package ensup.logger;

import org.apache.log4j.PropertyConfigurator;
import java.io.File;

public class LoggerHandler {
    public File propertiesFile;
    public LoggerHandler() {
        if (propertiesFile == null) {
            propertiesFile = new File("Properties/log4j.properties");
            PropertyConfigurator.configure(propertiesFile.toString());
        }
    }
}
