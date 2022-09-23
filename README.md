# Java-Game

A simple game engine in java from a guy that barely knows how to code.
kind of an experiment.

# Before exporting JAR

IMPORTANT: If you want to read an external launch config file, set the isPlayTest boolean to FALSE.

The main class is com.tom00s.Engine.Main, and you must add the org.json lib, which is in src/assets/libs

# Important - how to run exported jar.

The sytax for running is "java -jar [Location of launch configurations file].json".
In the case the file is missing, an error will be returned.
the config file is explained below.

# The launch config file

Must be a JSON file with the strings "ver", "width", "height" and "gamename". 
