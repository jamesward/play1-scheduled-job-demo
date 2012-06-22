package jobs;

import play.Logger;
import play.Play;
import play.jobs.Job;

import java.io.File;

public class HelloJob extends Job {

    @Override
    public void doJob() throws Exception {
        Logger.info("Hello from the HelloJob");
    }

    public static void main(String[] args) {
        File root = new File(System.getProperty("application.path"));

        if (System.getProperty("precompiled", "false").equals("true")) {
            Play.usePrecompiled = true;
        }

        try {
            Play.init(root, System.getProperty("play.id", ""));

            HelloJob helloJob = new HelloJob();
            helloJob.now().get();
        }
        catch (Exception e) {
            Logger.error(e, e.getMessage());
        }
        finally {
            Play.stop();
        }
    }
}