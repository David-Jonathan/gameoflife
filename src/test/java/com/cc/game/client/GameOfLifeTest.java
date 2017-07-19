package com.cc.game.client;

import org.junit.Assert;
import org.junit.Test;

import com.cc.game.client.GameOfLife;

/**
 * @author Silas
 *
 */

public class GameOfLifeTest {
	
	@Test
	public void testGameOfLife() {
		GameOfLife game = new GameOfLife();
		Assert.assertNotNull(game);
	}
	
	@Test
	public void testMainMethodWithProperInputs() {
		String[] args = {"4","4"};
		GameOfLife.main(args);
	}

	@Test
	public void testMainMethodWithProperInputsForMultipleGenerations() {
		String[] args = {"4","4","3"};
		GameOfLife.main(args);
	}

	@Test
	public void testMainMethodWithExtraArguments() {
		String[] args = {"4","4","3","extra"};
		GameOfLife.main(args);
	}
	
	@Test(expected = NullPointerException.class)
    public final void testMainMethodWhenNullIsPassedAsArgument() {
		GameOfLife.main(null);
    }
	
	
	@Test(expected = NumberFormatException.class)
    public final void testMainMethodWhenNaNIsPassedAsOneOrBothArguments() {
		String[] args = {"4","4d"};
		GameOfLife.main(args);
    }

	@Test(expected = NegativeArraySizeException.class)
    public final void testMainMethodWhenNegativeValueIsPassedAsOneOrBothArguments() {
		String[] args = {"4","-4"};
		GameOfLife.main(args);
    }

}
