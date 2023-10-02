import jdk.javadoc.doclet.StandardDoclet;

/**
 * A Doclet made by me to convert appropriate Plantuml codes into generated diagrams.
 *
 */
public class PlantumlDoclet extends StandardDoclet {
  @Override
  public String getName() {
    return "PlantumlDoclet";
  }
}
