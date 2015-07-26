#!/bin/sh

mvn exec:java --offline -Dexec.mainClass="com.sbo.loggenerator.LogGenerator" -Dexec.classpathScope=runtime -Dexec.args="250 y -1 -1 -1"

