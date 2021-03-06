package com.cc.game.util;

/**
 * @author Silas
 *
 */

public enum GameOfLifeEnum {

	SEED(20),
	ALIVE('X'),
	DEAD('-'),
	
	BLOCK_PATTERN("XX"),
	BOAT_PATTERN_ROW_ONE("XX-"),
	BOAT_PATTERN_ROW_TWO("X-X"),
	BOAT_PATTERN_ROW_THREE("-X-"),

    BLINKER_PATTERN_ROW_ONE("-X-"),
    BLINKER_PATTERN_ROW_TWO("-X-"),
    BLINKER_PATTERN_ROW_THREE("-X-"),

    BLINKER_PATTERN_RESULT_ROW_ONE("---"),
    BLINKER_PATTERN_RESULT_ROW_TWO("XXX"),
    BLINKER_PATTERN_RESULT_ROW_THREE("---"),
    
    TOAD_PATTERN_ROW_ONE("----"),
    TOAD_PATTERN_ROW_TWO("-XXX"),
    TOAD_PATTERN_ROW_THREE("XXX-"),
    TOAD_PATTERN_ROW_FOUR("----"),

    TOAD_PATTERN_RESULT_ROW_ONE("--X-"),
    TOAD_PATTERN_RESULT_ROW_TWO("X--X"),
    TOAD_PATTERN_RESULT_ROW_THREE("X--X"),
    TOAD_PATTERN_RESULT_ROW_FOUR("-X--"),
	
    STARTOFPROGRAM_MARKER("Input Matrix \n============ \n"),
    INTERMEDIATE_MARKER("=============================\nMatrix After next computation \n=============================\n"),
    ENDOFPROGRAM_MARKER("=========================\nEnd of GameOfLife program\n========================="),
    
    RECOMMENDED_USAGE_MESSAGE("Please pass the recommended input parameters."),
	RECOMMENDED_USAGE("Inputs to GameOfLife program : \n\nInput-1: numberOfRows(non-zero positive integer) \n"
			+ "Input-2: numberOfColumns(non-zero positive integer) \n"
			+ "Input-3(optional): numberOfGenerations \n\n" 
			+ "Example: \"java -jar application.jar 2 3 4\" \n"),
	
	NEGATIVE_INPUT("The input value for the rows/columns has negative value(s)."),
	NEGATIVE_INPUT_GENERATIONS("The third input has negative values."),
	NAN_INPUT("One of the given inputs is not a number."),
	ZERO_VALUE_INPUTS("The input value for the rows/columns range is 0.");

    private String textValue;
	private int intValue;
	private char charValue;

	GameOfLifeEnum(char c) {
		this.charValue = c;
	}
	
	GameOfLifeEnum(int num) {
		this.intValue = num;
	}
	
    GameOfLifeEnum(String s) {
    	this.textValue = s;
    }
    
    public char getCharValue() {
        return charValue;
    }
    
    public int getIntValue() {
    	return intValue;
    }
    
    public String getTextValue() {
    	return textValue;
    }
}
