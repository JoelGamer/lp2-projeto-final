package Core;

import java.util.List;

public class Core {

    private final CoreConstants coreConstants;
    private String serverHost;
    private int serverPort;
    private List<String> consoleTags;

    public Core() {
        this.coreConstants = new CoreConstants();
        loadCoreProperties();
        loadConfigProperties();
    }

    private void loadCoreProperties() {
        setConsoleTags();
    }

    private void loadConfigProperties() {
        setServerHost();
        setServerPort();
    }

    private void setServerHost() {
        this.serverHost = coreConstants.SERVER_HOST;
    }

    public String getServerHost() {
        return serverHost;
    }

    private void setServerPort() {
        this.serverPort = coreConstants.SERVER_PORT;
    }

    public int getServerPort() {
        return serverPort;
    }

    private void setConsoleTags() {
        this.consoleTags = coreConstants.CONSOLE_TAGS;
    }

    public List<String> getConsoleTags() {
        return consoleTags;
    }
}
