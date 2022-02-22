package com.example.demo.eo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EOLayer {
	
	 String EOLayer() {
		 Logger logger = LogManager.getLogger(EOLayer.class);

		 logger.info("passing EO Layer");
	        return "Hello! This is pass through Layer";
	    }

}
