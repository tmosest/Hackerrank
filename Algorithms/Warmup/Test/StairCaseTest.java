package Warmup.Test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Warmup.Staircase;

public class StairCaseTest {

	@Test
	public void testBuildStairCase() {
		/*
		 * 	     #
    		    ##
   			   ###
  			  ####
 			 #####
			######
		 * */
		String[] test = {
			"     #",
			"    ##",
			"   ###",
			"  ####",
			" #####",
			"######"
		};
		String[] r = Staircase.buildStairCase(6);
		Assert.assertArrayEquals(test, r);
	}

}
