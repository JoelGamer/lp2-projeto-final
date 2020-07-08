package Core;

import java.util.List;

/**
 * The class {@code CoreConstants} serves to store fixed values for later use
 * in the Core classes.
 *
 * @author JoelGamer
 * @since 0.0.1
 */
public class CoreConstants {

    //Core Constants
    public final String CONSOLE_INFO = "[INFO]";
    public final String CONSOLE_WARNING = "[WARNING]";
    public final String CONSOLE_ERROR = "[ERROR]";
    public final List<String> CONSOLE_TAGS = consoleTags();

    //Configuration Constants
    public final String SERVER_HOST = "localhost";
    public final int SERVER_PORT = 42069;

    private List<String> consoleTags() {
        return List.of(CONSOLE_INFO, CONSOLE_WARNING, CONSOLE_ERROR);
    }
}
