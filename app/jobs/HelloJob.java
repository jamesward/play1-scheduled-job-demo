package jobs;

import models.Bar;
import play.Logger;
import play.Play;
import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.jobs.Job;

import javax.persistence.EntityManager;
import java.io.File;
import java.util.Date;
import java.util.List;

public class HelloJob extends Job {

    @Override
    public void doJob() throws Exception {
        Bar bar = new Bar();
        bar.name = "Hello From Job " + new Date();
        bar.save();
    }
    
    public static void main(String[] args) {
        File root = new File(System.getProperty("application.path"));
        
        if (System.getProperty("precompiled", "false").equals("true")) {
            Play.usePrecompiled = true;
        }

        try {
            Play.init(root, System.getProperty("play.id", ""));

            Class c = Play.classloader.loadClass("jobs.HelloJob");
            Job s = (Job) c.newInstance();
            s.run();

            Logger.info("Hello from the HelloJob");
        }
        catch (Exception e) {
            Logger.error(e, e.getMessage());
        }
        finally {
            Play.stop();
        }
    }
}