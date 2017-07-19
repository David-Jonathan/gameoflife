package com.cc.game.client;

import org.junit.Assert;
import org.junit.Test;

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
	public void testMainMethodWithNoInputs() {
		String[] args = {};
		GameOfLife.main(args);
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
	public void testMainMethodWithInvalidInputForMultipleGenerations() {
		String[] args = {"4","4","-3"};
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
	
	@Test
    public final void testMainMethodWhenNaNIsPassedAsOneOrBothArguments() {
		String[] args = {"4","4d"};
		GameOfLife.main(args);
    }

	@Test
    public final void testMainMethodWhenNegativeValueIsPassedAsOneOrBothArguments() {
		String[] args = {"4","-4"};
		GameOfLife.main(args);
    }

	@Test
    public final void testMainMethodWithZeroValueForOneOrBothArguments() {
		String[] args = {"4","0"};
		GameOfLife.main(args);
    }

}
