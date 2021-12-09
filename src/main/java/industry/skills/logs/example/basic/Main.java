package industry.skills.logs.example.basic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.trace("Main: This is a trace message");
        logger.debug("Main: This is a debug message");
        logger.info("Main: This is a info message");
        logger.warn("Main: This is a warn message");
        logger.error("Main: This is a error message");
        logger.fatal("Main: This is a fatal message");

        AClassThatDoesSomething.foo();

    }
}
