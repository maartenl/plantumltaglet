package org.doclet.plantuml;

import com.sun.source.doctree.DocTree;
import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Taglet;

import javax.lang.model.element.Element;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class PlantumlTag implements Taglet {

  private static final Logger LOGGER = Logger.getLogger("org.doclet.plantuml.PlantumlTag");

  private static final String HEADER = "WOAH";

  public PlantumlTag() {
    // Each implementation of a taglet must provide a public no-argument constructor to be used by doclets to instantiate the taglet.
    LOGGER.severe("constructor");
  }

  @Override
  public void init(DocletEnvironment env, Doclet doclet) {
    LOGGER.severe("init");
    Taglet.super.init(env, doclet);
    System.out.println("init");
  }

  @Override
  public Set<Location> getAllowedLocations() {
    LOGGER.severe("getAllowedLocations");
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
    LOGGER.severe("isInlineTag");
    return false;
  }

  @Override
  public String getName() {
    LOGGER.severe("getName");
    return "plantuml";
  }

  @Override
  public String toString(List<? extends DocTree> tags, Element element) {
    LOGGER.severe("toString");
    return "Woah nelly";
  }
}