package Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Core {

    private String serverHost;
    private int serverPort;
    private ArrayList<String> consoleTags;

    public Core(String propertiesFile) throws IOException {
        loadCoreProperties();
        loadConfigProperties(propertiesFile);
    }

    private void loadCoreProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("src/main/java/resources/core.properties");
        properties.load(inputStream);

        setConsoleTags(properties);
    }

    private void loadConfigProperties(String propertiesFile) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(propertiesFile);
        properties.load(inputStream);

        setServerHost(properties);
        setServerPort(properties);
    }

    private void setServerHost(Properties properties) {
        this.serverHost = properties.getProperty("serverHost");
    }

    public String getServerHost() {
        return serverHost;
    }

    private void setServerPort(Properties properties) {
        this.serverPort = Integer.parseInt(properties.getProperty("serverPort"));
    }

    public int getServerPort() {
        return serverPort;
    }

    private void setConsoleTags(Properties properties) {
        consoleTags = new ArrayList<>();
        consoleTags.add(properties.getProperty("consoleServerInfo"));
        consoleTags.add(properties.getProperty("consoleServerWarning"));
        consoleTags.add(properties.getProperty("consoleServerError"));
    }

    public ArrayList<String> getConsoleTags() {
        return consoleTags;
    }
}
