#!/bin/sh

mvn exec:java --offline -Dexec.mainClass="com.sbo.loggenerator.LogGenerator" -Dexec.classpathScope=runtime -Dexec.args="900 n 1000 500 100"

