# Parsing timestamps
Reproducing a problem with time parsing

If I run on my Linux desktop:
    mvn clean test 

I see this for all cases:

    Zone = Europe/Amsterdam
    Hour = 7

Then I start the docker environment using the start-docker.sh script.
Now if I run in docker
    mvn clean test 

I see this for all cases:

    Zone = Europe/London
    Hour = 6

Why?
