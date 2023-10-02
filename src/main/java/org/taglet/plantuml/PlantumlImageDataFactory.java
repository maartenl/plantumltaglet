package org.taglet.plantuml;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Logger;

/**
 * Created PlantUML Diagrams based on a plantuml description.
 */
public class PlantumlImageDataFactory {

  private static final Logger LOGGER = Logger.getLogger(PlantumlImageDataFactory.class.getCanonicalName());

  private PlantumlImageDataFactory() {

  }

  /**
   * Creates images data of a plant uml diagram.
   * @param plantuml the plant uml description for generating the diagrma
   * @return base64 encoded image data (png format).
   */
  public static String getImageData(String plantuml) {
    final SourceStringReader sourceStringReader =
        new SourceStringReader(plantuml);
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      sourceStringReader.outputImage(baos, new FileFormatOption(FileFormat.PNG));
      byte[] encodedBytes = Base64.getEncoder().encode(baos.toByteArray());
      LOGGER.fine("encodedBytes " + new String(encodedBytes));
      return new String(encodedBytes);
    }
    catch (IOException e) {
      LOGGER.throwing("PlantumlTag", "writeTag", e);
      throw new RuntimeException(e);
    }
  }
}
