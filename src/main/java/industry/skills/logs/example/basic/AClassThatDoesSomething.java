package industry.skills.logs.example.basic;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AClassThatDoesSomething {

    private static Logger logger = LogManager.getLogger(AClassThatDoesSomething.class);

    public static void foo() {
        logger.log(Level.TRACE, "AClassThatDoesSomething: This is a TRACE message from foo");
        logger.log(Level.DEBUG, "AClassThatDoesSomething: This is a DEBUG message from foo");
        logger.log(Level.INFO, "AClassThatDoesSomething: This is a INFO message from foo");
        logger.log(Level.WARN, "AClassThatDoesSomething: This is a WARN message from foo");
        logger.log(Level.ERROR, "AClassThatDoesSomething: This is a ERROR message from foo");
        logger.log(Level.FATAL, "AClassThatDoesSomething: This is a FATAL message from foo");
    }
}
