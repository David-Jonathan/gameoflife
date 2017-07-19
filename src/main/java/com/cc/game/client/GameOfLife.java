package com.cc.game.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cc.game.main.LivingSpaceImpl;
import com.cc.game.util.GameOfLifeEnum;

/**
 * @author Silas
 *
 */

public class GameOfLife {
	
	final static Log logger = LogFactory.getLog(GameOfLife.class);
	
	public static void main(String[] args) {
		
		try {
			int rows = Integer.parseInt(args[0]);
			int columns = Integer.parseInt(args[1]);
			int numberOfGenerations = (args != null && args.length > 2) 
					? Integer.parseInt(args[2]) : 1; 
			int i = 0;
			
			if(numberOfGenerations < 0) {
				throw new NegativeArraySizeException(GameOfLifeEnum.NEGATIVE_INPUT_GENERATIONS.getTextValue());
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
			
		} catch (ArrayIndexOutOfBoundsException aiob) {
			logger.error(GameOfLifeEnum.RECOMMENDED_USAGE_MESSAGE.getTextValue() + "\n\n"
					+ GameOfLifeEnum.RECOMMENDED_USAGE.getTextValue());
		} /*catch (NegativeArraySizeException nase) {
			logger.error(GameOfLifeEnum.NEGATIVE_INPUT.getTextValue() + "\n\n"
					+ GameOfLifeEnum.RECOMMENDED_USAGE.getTextValue());
		} catch (Exception e) {
			logger.error(GameOfLifeEnum.NEGATIVE_INPUT_GENERATIONS.getTextValue() + "\n\n"
					+ GameOfLifeEnum.RECOMMENDED_USAGE.getTextValue());
		}*/
	}
	
}