# plantumltaglet

A taglet @plantuml that generated in-place images (png). in the html javadoc files.

= For example: =

This generates javadoc for itself.

javadoc -taglet org.taglet.plantuml.PlantumlTaglet -tagletpath /Users/m.vanleunen/git/plantumltaglet/target/classes  /Users/m.vanleunen/git/plantumltaglet/src/main/java/PlantumlTaglet.java

javadoc -taglet org.taglet.plantuml.PlantumlTaglet -tagletpath /Users/m.vanleunen/git/plantumltaglet/target/plantumltaglet-1.0-SNAPSHOT-jar-with-dependencies.jar  /Users/m.vanleunen/git/plantumltaglet/src/main/java/org/taglet/plantuml/PlantumlTaglet.java
