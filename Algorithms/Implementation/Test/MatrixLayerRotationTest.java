package Implementation.Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import Implementation.MatrixLayerRotation;

public class MatrixLayerRotationTest {
	
	BufferedReader in = null;
	BufferedReader out = null;
	
	@Test
	public void testRotateMatrix0() throws IOException {
		in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/MatrixLayerRotation/TestCase0Input.txt")));
		out = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/MatrixLayerRotation/TestCase0Output.txt")));
		
		String[] line1 = in.readLine().split(" ");
		
		int rows = Integer.parseInt(line1[0]);
		assertEquals(4, rows);
		
		int columns = Integer.parseInt(line1[1]);
		assertEquals(4, columns);
		
		int rotations = Integer.parseInt(line1[2]);
		assertEquals(1, rotations);
		
		int[][] grid = new int[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			String[] line = in.readLine().split(" ");
			for(int j = 0; j < columns; j++) {
				grid[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		grid = MatrixLayerRotation.rotateMatrix(grid, rotations);
		
		for(int i = 0; i < rows; i++) {
			String[] line = out.readLine().split(" ");
			for(int j = 0; j < columns; j++) {
				assertEquals(Integer.parseInt(line[j]), grid[i][j]);
			}
		}
	}
	
	@Test
	public void testRotateMatrix3() throws IOException {
		in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/MatrixLayerRotation/TestCase3Input.txt")));
		out = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/MatrixLayerRotation/TestCase3Output.txt")));
		
		String[] line1 = in.readLine().split(" ");
		
		int rows = Integer.parseInt(line1[0]);
		assertEquals(50, rows);
		
		int columns = Integer.parseInt(line1[1]);
		assertEquals(75, columns);
		
		int rotations = Integer.parseInt(line1[2]);
		assertEquals(100, rotations);
		
		int[][] grid = new int[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			String[] line = in.readLine().split(" ");
			for(int j = 0; j < columns; j++) {
				grid[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		grid = MatrixLayerRotation.rotateMatrix(grid, rotations);
		
		for(int i = 0; i < rows; i++) {
			String[] line = out.readLine().split(" ");
			for(int j = 0; j < columns; j++) {
				assertEquals(Integer.parseInt(line[j]), grid[i][j]);
			}
		}
	}
	
	@Test
	public void testRotateMatrix8() throws IOException {
		in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/MatrixLayerRotation/TestCase8Input.txt")));
		out = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("data/MatrixLayerRotation/TestCase8Output.txt")));
		
		String[] line1 = in.readLine().split(" ");
		
		int rows = Integer.parseInt(line1[0]);
		assertEquals(250, rows);
		
		int columns = Integer.parseInt(line1[1]);
		assertEquals(289, columns);
		
		int rotations = Integer.parseInt(line1[2]);
		assertEquals(42971434, rotations);
		
		int[][] grid = new int[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			String[] line = in.readLine().split(" ");
			for(int j = 0; j < columns; j++) {
				grid[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		grid = MatrixLayerRotation.rotateMatrix(grid, rotations);
		
		for(int i = 0; i < rows; i++) {
			String[] line = out.readLine().split(" ");
			for(int j = 0; j < columns; j++) {
				assertEquals(Integer.parseInt(line[j]) + " ("+i+","+j+")", grid[i][j]+ " ("+i+","+j+")");
			}
		}
	}

}
