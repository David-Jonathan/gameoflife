package com.cc.game.util;

/**
 * @author Silas
 *
 */

public enum GameOfLifeEnum {

	SEED(20),
	ALIVE('X'),
	DEAD('-');
    
	private int intValue;
	private char charValue;

	GameOfLifeEnum(char c) {
		this.charValue = c;
	}
	
	GameOfLifeEnum(int num) {
		this.intValue = num;
	}
	
    public char getCharValue() {
        return charValue;
    }
    
    public int getIntValue() {
    	return intValue;
    }
}
