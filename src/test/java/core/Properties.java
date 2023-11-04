package core;

public class Properties {

    public static boolean CLOSE_BROWSER = true;
    public static Browsers BROWSER = Browsers.CHROME;
    public static ExecutionType EXECUTION_TYPE = ExecutionType.LOCAL;
    public static final String URL = "https://seubarriga.wcaquino.me/login";

    public enum Browsers {
        CHROME,
        FIREFOX,
        IE
    }

    public enum ExecutionType {
        LOCAL,
        GRID,
        NUVEM
    }
}
