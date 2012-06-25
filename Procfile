web: play run --http.port=$PORT $PLAY_OPTS
hello: java -Dapplication.path=. -Dplay.id=prod -Dprecompiled=true -DlogLevel=INFO -cp "precompiled/java:lib/*:conf:.play/framework/play-1.2.4.jar:.play/framework/lib/*" jobs.HelloJob .
