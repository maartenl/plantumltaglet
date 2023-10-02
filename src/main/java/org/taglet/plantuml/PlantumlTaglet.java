package org.taglet.plantuml;

import com.sun.source.doctree.DocTree;
import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Taglet;

import javax.lang.model.element.Element;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * A Taglet made by me to convert appropriate Plantuml codes into generated diagrams. Uses layout smetana instead
 * of GraphViz.
 * @plantuml
 * <!--
 * interface Taglet
 * class PlantumlTaglet
 * Taglet <|.. PlantumlTaglet
 * class Location
 * Taglet : +getAllowedLocations(): Set<Location>
 * Location o-left- Taglet
 * PlantumlImageDataFactory o-left- PlantumlTaglet
 * PlantumlImageDataFactory :  + {static} getImageData(plantuml: String): String
 * -->
 * @see <a href="https://mnlipp.github.io/jdrupes-taglets/plantuml-taglet/javadoc/index.html">PlantUML Taglet</a>
 */
public class PlantumlTaglet implements Taglet {

  private static final Logger LOGGER = Logger.getLogger(PlantumlTaglet.class.getCanonicalName());

  /**
   * Each implementation of a taglet must provide a public no-argument constructor to be used by doclets to instantiate the taglet.
   */
  public PlantumlTaglet() {
    LOGGER.fine("constructor");
  }

  @Override
  public void init(DocletEnvironment env, Doclet doclet) {
    LOGGER.fine("init");
    Taglet.super.init(env, doclet);
  }

  @Override
  public Set<Location> getAllowedLocations() {
    LOGGER.fine("getAllowedLocations");
    Set<Location> set = new HashSet<>();
    set.add(Location.MODULE);
    set.add(Location.PACKAGE);
    set.add(Location.TYPE);
    set.add(Location.CONSTRUCTOR);
    set.add(Location.METHOD);
    set.add(Location.OVERVIEW);
    return set;
  }

  @Override
  public boolean isInlineTag() {
    LOGGER.fine("isInlineTag");
    return false;
  }

  @Override
  public String getName() {
    LOGGER.fine("getName");
    return "plantuml";
  }

  @Override
  public String toString(List<? extends DocTree> tags, Element element) {
    return tags.stream()
        .map(this::writeTag)
        .map(img -> "<p><img alt=\"umldiagram\" src=\"data:image/png;base64," + img + "\" /></p>")
        .collect(Collectors.joining());
    // element is not that interesting, is basically this tag.
  }

  private String replaceLast(String string, String toReplace, String replacement) {
    int pos = string.lastIndexOf(toReplace);
    if (pos > -1) {
      return string.substring(0, pos)
          + replacement
          + string.substring(pos + toReplace.length());
    }
    else {
      return string;
    }
  }

  private String writeTag(DocTree tag) {
    // "@plantuml [stuff]"
    LOGGER.fine(tag.toString());
    String formatted = tag.toString()
        .replace("@plantuml ", "");
    if (formatted.contains("<!--")) {
      formatted = formatted.replace("<!--", "");
      formatted = replaceLast(formatted, "-->", "");
    }
    String plantuml = "@startuml\n"
        + "!pragma layout smetana\n"
        + formatted
        + "\n@enduml\n";
    LOGGER.fine(plantuml);
    return PlantumlImageDataFactory.getImageData(plantuml);
  }

}