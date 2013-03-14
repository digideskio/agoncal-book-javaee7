package org.agoncal.book.javaee7.chapter02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 */
@EightDigits
public class IssnGenerator implements NumberGenerator {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private Logger logger;

  private Random suffix;

  // ======================================
  // =          Lifecycle methods         =
  // ======================================

  @PostConstruct
  private void init() {
    suffix = new Random();
    logger.info("Generated suffix = "+ suffix.nextInt());
  }

  // ======================================
  // =          Business methods          =
  // ======================================

  @Loggable
  public String generateNumber() {
    return "8-" + Math.abs(new Random().nextInt());
  }
}