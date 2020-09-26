/**
 * This class is calling from BufferedImageLoader, Game and
 * other classes, where are try-catch (e.g. in opening
 * or writing file).
 * The main idea is to save .log file, where will be exception.
 */

package Main;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class SetLogger {

    public void writeLogger(String class_name, Exception e){
        // initialize logger.
        java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(class_name);
        // Specify whether or not this logger should send its output to its parent Logger.
        LOG.setUseParentHandlers(false);
        FileHandler handler = null;
        try {
            // create .log file
            handler = new FileHandler(new File("").getAbsolutePath()+ "/"+class_name+".log");
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        LOG.addHandler(handler);
        LOG.log(Level.WARNING, "NO FILE", e);
    }

}
