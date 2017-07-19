package com.cc.game.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cc.game.main.LivingSpaceImpl;
import com.cc.game.util.GameOfLifeEnum;
import com.cc.game.util.InvalidInputException;

/**
 * @author Silas
 *
 */

public class GameOfLife {
	
	final static Log logger = LogFactory.getLog(GameOfLife.class);
	
	public static void main(String[] args) {
		
		try {
			
			int rows = 0;
			int columns = 0;
			int numberOfGenerations = 0;
			
			try {
				rows = Integer.parseInt(args[0]);
				columns = Integer.parseInt(args[1]);
				numberOfGenerations = (args != null && args.length > 2) 
						? Integer.parseInt(args[2]) : 1; 
			} catch (NumberFormatException nfe) {
				throw new InvalidInputException(GameOfLifeEnum.NAN_INPUT.getTextValue());
			} catch (ArrayIndexOutOfBoundsException aiob) {
				throw new InvalidInputException(GameOfLifeEnum.RECOMMENDED_USAGE_MESSAGE.getTextValue());
			} 
			int i = 0;
			if(rows == 0 || columns == 0) {
				throw new InvalidInputException(GameOfLifeEnum.ZERO_VALUE_INPUTS.getTextValue());
			}
			if(numberOfGenerations < 0) {
				throw new InvalidInputException(GameOfLifeEnum.NEGATIVE_INPUT_GENERATIONS.getTextValue());
			}
			LivingSpaceImpl gameOfLife = new LivingSpaceImpl(rows,columns);
			
			char[][] livingSpace = gameOfLife.getLivingSpace();
			logger.info(GameOfLifeEnum.STARTOFPROGRAM_MARKER.getTextValue());
			gameOfLife.printLivingSpaceMatrix(livingSpace);
			logger.info(GameOfLifeEnum.INTERMEDIATE_MARKER.getTextValue());
			
			while(i < numberOfGenerations) {
				livingSpace = gameOfLife.getLivingSpace();
				gameOfLife.setLivingSpace(gameOfLife.nextLife(livingSpace));
				gameOfLife.printLivingSpaceMatrix(gameOfLife.getLivingSpace());
				
				i++;
			}		
			logger.info(GameOfLifeEnum.ENDOFPROGRAM_MARKER.getTextValue());
			
		} catch (InvalidInputException invalidException) {
			logger.error(invalidException.getMessage() + "\n\n"
					+ GameOfLifeEnum.RECOMMENDED_USAGE.getTextValue());
		} 
	}
	
}