package com.sbo.loggenerator;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogGenerator {

	static final Logger logger =  LogManager.getLogger(LogGenerator.class);
	
	public static void main(String[] args) {
	// arg[0]: delay in ms between logs
	// arg[1]: log error y/n
	// arg[2]: extra time for service1-a
	// arg[3]: extra time for service1-b
	// arg[4]: extra time for service2
		
		
		int frequency = 1000; //Integer.parseInt(args[0]);
		boolean isErrorLogged = false;
		String[] service = {"ERROR", "service1-a", "service1-b", "service2"};
		int[] base_ms = {0, 100, 110, 300};
		int[] extra_ms = {0,0,0,0};
		Random randomGenerator = new Random();
		int rand = 0;
		
		try {
			logger.info("**** starting Log Generator ****");

			if (args.length >= 2) {
				frequency = Integer.parseInt(args[0]);
				isErrorLogged = (args[1].equals("y"));
			}
			if (args.length >= 5) {
				extra_ms[1] = Integer.parseInt(args[2]);
				extra_ms[2] = Integer.parseInt(args[3]);
				extra_ms[3] = Integer.parseInt(args[4]);
			}
			
			while (true) {
				Thread.sleep(frequency);
				logger.info("exec-" + frequency);
				if (isErrorLogged) {
					logger.error("A dummy error occured");
				}
				for (int i=1 ; i<4 ; i++) {
					if (extra_ms[i] >= 0) {
						rand = base_ms[i] + extra_ms[i] + randomGenerator.nextInt(25);
						logger.info("PERF: " + service[i] + " executed in " + rand);
					}
				}
			}
				
		} catch (InterruptedException e) {
			logger.error("Exception : " + e.toString());
			e.printStackTrace();
		}		
	}

}
