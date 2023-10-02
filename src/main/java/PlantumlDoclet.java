import jdk.javadoc.doclet.StandardDoclet;
import jdk.javadoc.doclet.Taglet;

import java.util.Map;

/**
 * A Doclet made by me to convert appropriate Plantuml codes into generated diagrams.
 * @plantuml This is plantuml.
 */
public class PlantumlDoclet extends StandardDoclet {
  @Override
  public String getName() {
    return "PlantumlDoclet";
  }

  public static void register(Map tagletMap) {
    PlantumlDoclet tag = new PlantumlDoclet();
    Taglet t = (Taglet) tagletMap.get(tag.getName());
    if (t != null) {
      tagletMap.remove(tag.getName());
    }
    tagletMap.put(tag.getName(), tag);
  }

}
