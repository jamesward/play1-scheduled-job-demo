Simple Play 1.2.4 App with a Job
================================

This little app shows how you can do simple one-off and scheduled jobs within Play 1.2.4 apps on Heroku.  These jobs run in separate processes from the Play 1 web server.


## Running Locally


    export DATABASE_URL=postgres://f:f@localhost/f
    java -Dapplication.path=. -Dplay.id=prod -DlogLevel=INFO -cp lib/*:conf:/home/jamesw/play-1.2.4/framework/play-1.2.4.jar:/home/jamesw/play-1.2.4/framework/lib/*:tmp/classes jobs.HelloJob .

## Running on Heroku

Clone this project locally:

    $ git clone git://github.com/jamesward/play1-scheduled-job-demo

In the `play1-scheduled-job-demo` directory, create a new app on Heroku (make sure you have the [Heroku Toolbelt](http://tool
belt.heroku.com) installed):

    $ heroku login
    $ heroku create -s cedar

Push the app to Heroku:

    git push heroku master

Verify that it works:

    heroku open

Run a one-off `HelloJob`:

    heroku run hello

Add the Scheduler add-on:

    heroku addons:add scheduler:standard

Open the Scheduler add-on console:

    heroku addons:open scheduler

Add a new scheduled task with `hello` as the command / task name.  Set the desired frequency.  Save the scheduled task and either wait for it to run or manually run it from the Scheduler add-on console.