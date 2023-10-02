# plantumltaglet

A taglet @plantuml that generated in-place images (png). in the html javadoc files.

= For example: =

This generates javadoc for class PlantumlTaglet.

javadoc -taglet org.taglet.plantuml.PlantumlTaglet -tagletpath /Users/m.vanleunen/git/plantumltaglet/target/plantumltaglet-1.0-SNAPSHOT-jar-with-dependencies.jar  /Users/m.vanleunen/git/plantumltaglet/src/main/java/org/taglet/plantuml/PlantumlTaglet.java

= With maven integration =

mvn javadoc:javadoc

Generates javadoc into the usual place: target/site/apidocs. Access it by opening target/site/apidocs/index.html

Attention: it means you should have this artifact in your maven .m2/repository map somewhere, otherwise it cannot find 
the custom taglet.

Just add the custom taglet to your maven-javadoc-plugin in your pom.xml, like so:
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <version>3.6.0</version>
        <configuration>
          <taglet>org.taglet.plantuml.PlantumlTaglet</taglet>
          <!-- <tagletpath>/path/to/taglet.jar</tagletpath> -->
          <tagletArtifact>
            <groupId>org.taglet.plantuml</groupId>
            <artifactId>plantumltaglet</artifactId>
            <version>1.0-SNAPSHOT</version>
          </tagletArtifact>
        </configuration>
      </plugin>
