package com.dushi.designpatterns.behavioural;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Example {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger(Example.class.getName());
        logger.setLevel(Level.FINE);

        logger.log(Level.INFO,"This is info");
        logger.log(Level.WARNING,"This is warning");
        logger.log(Level.FINE,"This is fine");
        logger.log(Level.SEVERE,"This is severe");

    }
}
