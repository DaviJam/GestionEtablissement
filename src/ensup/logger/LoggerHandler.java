package ensup.logger;

import ensup.dao.PersonDao;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

import static java.lang.String.format;
import static org.apache.log4j.Priority.toPriority;

public class LoggerHandler {
    private File propertiesFile;
    LoggerHandler() {
        if (propertiesFile == null) {
            propertiesFile = new File("Properties/log4j.properties");
            PropertyConfigurator.configure(propertiesFile.toString());
        }
    }
}
