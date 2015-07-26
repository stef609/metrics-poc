#!/bin/sh

!java -cp target/log-generator-1.0-SNAPSHOT.jar com.sbo.loggenerator.LogGenerator

mvn exec:java --offline -Dexec.mainClass="com.sbo.loggenerator.LogGenerator" -Dexec.classpathScope=runtime -Dexec.args="500 n"

