package com.cc.game.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cc.game.main.LivingSpace;

/**
 * @author Silas
 *
 */

public class GameOfLife {
	
	final static Log logger = LogFactory.getLog(GameOfLife.class);
	
	public static void main(String[] args) {
		
		int rows = Integer.parseInt(args[0]);
		int columns = Integer.parseInt(args[1]);
		int numberOfGenerations = (args != null && args.length > 2) 
				? Integer.parseInt(args[2]) : 1; 
		int i = 0;
		
		LivingSpace gameOfLife = new LivingSpace(rows,columns);
		
		char[][] livingSpace = gameOfLife.getLivingSpace();
		logger.info("Input Matrix \n============ \n");
		gameOfLife.printLivingSpaceMatrix(livingSpace);
		logger.info("=============================\nMatrix After next computation \n=============================\n");
		
		while(i < numberOfGenerations) {
			livingSpace = gameOfLife.getLivingSpace();
			gameOfLife.setLivingSpace(gameOfLife.nextLife(livingSpace));
			gameOfLife.printLivingSpaceMatrix(gameOfLife.getLivingSpace());
			
			i++;
		}		
		logger.info("=========================\nEnd of GameOfLife program\n=========================");
		
	}
	
}