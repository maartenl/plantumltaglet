# plantumltaglet
 
A taglet @plantuml that generated in-place diagram images (png) in the html javadoc files.

## Javadoc example 

### Example 1
```
/**
 * Created PlantUML Diagrams based on a plantuml description.
 * @plantuml
 * PlantumlImageDataFactory : +getImageData(plantuml: String): String
 */
public class PlantumlImageDataFactory {
```
### Example 2 
```
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
```
## Creating javadoc example 

This generates javadoc for class PlantumlTaglet.

javadoc -taglet org.taglet.plantuml.PlantumlTaglet -tagletpath /Users/user/git/plantumltaglet/target/plantumltaglet-1.0-SNAPSHOT-jar-with-dependencies.jar  /Users/user/git/plantumltaglet/src/main/java/org/taglet/plantuml/PlantumlTaglet.java

## With maven integration 

mvn javadoc:javadoc

Generates javadoc into the usual place: target/site/apidocs. Access it by opening target/site/apidocs/index.html

Attention: it means you should have this artifact in your maven .m2/repository map somewhere, otherwise it cannot find 
the custom taglet.

Just add the custom taglet to your maven-javadoc-plugin in your pom.xml, like so:
```
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
```
## What it will look like

![Diagram Example](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj7JMkM5dYXzE70azDOl-ErHfhotaLgXoi4UenldFzFGUP4faYgtqWuObCaB_Z9_9EbpDEk44mOXDRDeaInjFLzVE0VnCVzeX88HVUuULAN7CXsjrSjhF2qKV67lAqNwuqn_HQsR2HzoOUuipyO9FVAgUK6g7Q0XrBZ9DBbRhuo5OztodFmMkNwJvItaaGd/s880/Screenshot%202023-10-03%20at%2009.08.33.png)

## HTML Source

In the generated JavaDocs, the image will be present as raw data.
```

<section class="class-description" id="class-description">
<dl class="notes">
<dt>All Implemented Interfaces:</dt>
<dd><code><a href="https://docs.oracle.com/en/java/javase/17/docs/api/jdk.javadoc/jdk/javadoc/doclet/Taglet.html" title="class or interface in jdk.javadoc.doclet" class="external-link">Taglet</a></code></dd>
</dl>
<hr>
<div class="type-signature"><span class="modifiers">public class </span><span class="element-name type-name-label">PlantumlTaglet</span>
<span class="extends-implements">extends <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html" title="class or interface in java.lang" class="external-link">Object</a>
implements <a href="https://docs.oracle.com/en/java/javase/17/docs/api/jdk.javadoc/jdk/javadoc/doclet/Taglet.html" title="class or interface in jdk.javadoc.doclet" class="external-link">Taglet</a></span></div>
<div class="block">A Taglet made by me to convert appropriate Plantuml codes into generated diagrams. Uses layout smetana instead
 of GraphViz.</div>
<dl class="notes">
<dt>See Also:</dt>
<dd>
<ul class="tag-list">
<li><a href="https://mnlipp.github.io/jdrupes-taglets/plantuml-taglet/javadoc/index.html">PlantUML Taglet</a></li>
</ul>
</dd>
<p><img alt="umldiagram" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAhMAAAC2CAIAAADsj5gHAAAAKnRFWHRjb3B5bGVmdABHZW5lcmF0ZWQgYnkgaHR0cHM6Ly9wbGFudHVtbC5jb212z..." /></p></dl>
</section>
```
## Notes 

Using &lt;!-- and --&gt; to circumvent javadoc barfing on strange characters in your @plantuml tag.

The plantuml graphics layout is "smetana", NOT "GraphViz". This package should work fine without installing GraphViz!
