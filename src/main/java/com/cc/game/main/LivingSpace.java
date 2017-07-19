package com.cc.game.main;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cc.game.util.GameOfLifeEnum;

/**
 * @author Silas
 *
 */

public class LivingSpace {
	
	final static Log logger = LogFactory.getLog(LivingSpace.class);
	
	private int rows;
	private int columns;
	private char[][] livingSpace;
	
	/**
	 * Constructor to generate a livingspace matrix with random number of rows and columns within the "seed"
	 * value specified in the Enum. The livingspace matrix will be populated by random generated ALIVE/DEAD cells 
	 */
    public LivingSpace() {
    	Random randomObject = new Random();
    	
    	this.rows = randomObject.nextInt(GameOfLifeEnum.SEED.getIntValue());
    	this.columns = randomObject.nextInt(GameOfLifeEnum.SEED.getIntValue());
    	setLivingSpace(newLivingSpace());
    }
    
	/**
	 * Constructor to generate a livingspace matrix with specific number of rows and columns.
	 * The livingspace matrix will be populated by random generated ALIVE/DEAD cells 
	 * 
	 * @param row - number of rows in the livingspace matrix
	 * @param columns - number of columns in the livingspace matrix
	 */
    public LivingSpace(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		setLivingSpace(newLivingSpace());
	}

	/**
	 * Constructor to generate a livingspace matrix with specific number of rows and columns.
	 * The ALIVE/DEAD cells for the livingspace matrix will be provided as custom input 
	 * 
	 * @param row - number of rows in the livingspace matrix
	 * @param columns - number of columns in the livingspace matrix
	 * @param inputLivingSpace - ALIVE/DEAD cells to fit into the matrix
	 */
    public LivingSpace(int rows, int columns, char[][] inputLivingSpace) {
		this.rows = rows;
		this.columns = columns;
		setLivingSpace(inputLivingSpace);
	}

    /**
     * Method to create a new livingspace with the given number of rows and columns
     * The ALIVE/DEAD cells for the livingspace matrix will be randomly generated
     * 
     * @return char[][] livingspace matrix with auto generated cells
     */
	private char[][] newLivingSpace()
	{
		char[][] tempLivingSpace = new char[rows][columns];
		Random randomObject = new Random();
	      
		for(int row = 0; row < tempLivingSpace.length; row++ ){
			for(int col = 0; col < tempLivingSpace[row].length; col++ ){
				tempLivingSpace[row][col] = randomObject.nextBoolean() ? 'X' : '-';
			}
		}
		
		return tempLivingSpace;
	}

	/**
	 * Method to print a given livingspace matrix.
	 * 
	 * @param matrix
	 */
	public void printLivingSpaceMatrix(char[][] matrix) {
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[row].length; col++) {
				logger.info(String.valueOf(matrix[row][col]) + ' ');
			}
			logger.info("\n");
		}
		
		logger.debug("\n");		
	}
	
	/**
	 * Method to generate the next generation of a given livingspace matrix passed as an input.
	 * 
	 * @param inputLivingSpace
	 * @return
	 */
	public char[][] nextLife(char[][] inputLivingSpace)
	{
		char[][] newLivingSpace = new char[rows][columns];
		for(int row = 0; row < newLivingSpace.length; row++ ) {
			for(int col = 0; col < newLivingSpace[row].length; col++ ) {
				newLivingSpace[row][col] = isDeadOrAlive(row, col,inputLivingSpace);
			}
		}
		setLivingSpace(newLivingSpace);
		return newLivingSpace;
		
	}

	/**
	 * Method to compute the next state of a cell that resides in a given (row,column) index.
	 * 
	 * The following rules are applied to compute the next state of a cell
	 * 
	 * Any live cell with fewer than two live neighbours dies, as if by loneliness.
	 * Any live cell with more than three live neighbours dies, as if by overcrowding.
	 * Any live cell with two or three live neighbours lives, unchanged, to the next generation.
	 * Any dead cell with exactly three live neighbours comes to life.
	 *  
	 * @param row
	 * @param col
	 * @param inputLivingSpace
	 * @return
	 */
	public char isDeadOrAlive(int row, int col, char[][] inputLivingSpace) {
		
	    char isDeadOrAlive = inputLivingSpace[row][col];
	    int numbersAlive = 0;
	    for (int rowIndex = row-1; rowIndex <= row+1; rowIndex++) 
	    {
	        for (int colIndex = col-1; colIndex <= col+1; colIndex++) 
	        {
	            if ((rowIndex != row || colIndex != col) 
	            		&& (rowIndex != -1 && colIndex != -1)
	            			&& (rowIndex != rows && colIndex != columns))	            
	            {
	                if (inputLivingSpace[rowIndex][colIndex] == GameOfLifeEnum.ALIVE.getCharValue()) {
	                	numbersAlive ++;
	                }
	            }
	        }
	    }
	    if (numbersAlive > 3 || numbersAlive < 2)
	    	isDeadOrAlive = GameOfLifeEnum.DEAD.getCharValue();
	    else if(numbersAlive == 3)
	    	isDeadOrAlive = GameOfLifeEnum.ALIVE.getCharValue();
	    
	    return isDeadOrAlive;
	}

	public void setLivingSpace(char[][] newLivingSpace) {
		this.livingSpace = newLivingSpace;
	}
	
	public char[][] getLivingSpace() {
		return this.livingSpace;
	}
	
}