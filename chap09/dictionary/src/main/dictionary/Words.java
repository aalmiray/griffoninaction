package dictionary;
import net.miginfocom.swing.MigLayout;

import java.util.Map;
import java.util.LinkedHashMap;

public final class Words {
    public static final Map<String, String>words = new LinkedHashMap<String, String>();
    
    static {
        words.put("groovy", "An agile and dynamic language for the Java platform.");
        words.put("grails", "A full stack web application development framework");
        words.put("griffon", "Grails inspired desktop application development framework.");
    }
}
