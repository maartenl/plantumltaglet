# plantumldoclet

A doclet that does the same as the standard doclet, but retrieves special tag "@plantuml" and generates diagrams
with it, and refers to them in the html javadoc files.

= For example: =

This generates javadoc for itself.

% javadoc -doclet PlantumlDoclet -docletpath .  PlantumlDoclet.java


