package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *	Algorithms -> Recursion -> Simplified Chess Engine 
 *	Medium
 */
public class SimplifiedChessEngine {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int games = in.nextInt();
		
		for(int g = 0; g < games; g++) {
			int whiteNumPieces = in.nextInt();
			int blackNumPieces = in.nextInt();
			int movesAllowed = in.nextInt();
			
			ChessEngine ce = new ChessEngine(movesAllowed);
			
			for(int i = 0; i < whiteNumPieces; i++) {
				String type = in.next();
				String col  = in.next();
				int row 	= in.nextInt();
				ce.addPieceAndDraw(type, col, row, 'W');
			}
			
			for(int i = 0; i < blackNumPieces; i++) {
				String type = in.next();
				String col  = in.next();
				int row 	= in.nextInt();
				ce.addPieceAndDraw(type, col, row, 'B');
			}
		}
		
		in.close();
	}

	/**
	 * A class to represent a Chess Engine.
	 * Uses a game tree to try to determine if white can win in <= k moves
	 * @author tmosest
	 *
	 */
	private static class ChessEngine
	{
		private int boardSize = 4;
		
		private int maxMoves;
		private GameBoard gb;
		
		/**
		 * Constructor to create a new Chess Engine.
		 * @param moves
		 */
		public ChessEngine(int moves)
		{
			maxMoves = moves;
			gb = new GameBoard(boardSize);
			gb.print();
		} // end ChessEngine
		
		/**
		 * Adds a new Piece to the game board.
		 * And draws it
		 * @param symbol
		 * @param col
		 * @param row
		 * @param player
		 */
		public void addPiece(String symbol, String col, int row, char player)
		{
			Piece pieceToAdd;
			if(symbol.equals(Piece.queenSymbol)) {
				pieceToAdd = new Queen(symbol, col, row, player);
			} else {
				pieceToAdd = new Piece(symbol, col, row, player);
			}
			gb.addPiece(pieceToAdd);
		} // end addPieceAndDraw
		
		/**
		 * Adds a new Piece to the game board.
		 * And draws it
		 * @param symbol
		 * @param col
		 * @param row
		 * @param player
		 */
		public void addPieceAndDraw(String symbol, String col, int row, char player)
		{
			this.addPiece(symbol, col, row, player);
			gb.print();
			gb.printMoves(gb.numberPieces - 1);
		} // end addPieceAndDraw
		
		/**
		 * Class for a Chess Piece
		 * @author tmosest
		 *
		 */
		private class Piece
		{
			//Pieces Symbols
			public static final String queenSymbol = "Q";
			public static final String knightSymbol = "N";
			public static final String bishopSymbol = "B";
			public static final String rockSymbol = "R";
			
			public String symbol;
			public String colLetter;
			public int rowIndex;
			public char player;
			
			public int row;
			public int col;
			
			/**
			 * Create a new Piece
			 * @param symbol
			 * @param col
			 * @param row
			 * @param player
			 */
			public Piece(String symbol, String col, int row, char player)
			{
				this.symbol = symbol;
				this.colLetter = col;
				this.rowIndex = row;
				this.player = player;
			} // end Piece
			
			/**
			 * Returns the opposite color of the piece.
			 * @return
			 */
			public char getOpponentColor()
			{
				return (this.player == 'B') ? 'W' : 'B';
			} // end getOpponentColor;
			
			/**
			 * This function returns an array list of the possible moves for a piece.
			 * @return
			 */
			public ArrayList<int[]> getMoves(int[][] board)
			{
				int boardSize = board.length;
				ArrayList<int[]> moves = new ArrayList<int[]> ();
				
				//Assume Pawn just for fun
				int[] move = {this.row + 1, this.col};
				
				if(this.player == 'W'){
					move[0] -= 2;
				}
				
				if(validMove(move, boardSize) && board[move[0]][move[1]] == 0)
					moves.add(move);
				
				return moves;
			} // end getMoves
			
			/**
			 * Determines if the move is within the board or not.
			 * @param move
			 * @param boardSize
			 * @return
			 */
			private boolean validMove(int[] move, int boardSize)
			{
				boolean isValidMove = false;
				if(move[0] < boardSize && 
				   move[1] < boardSize && 
				   move[0] >= 0 &&
				   move[1] >= 0)
					isValidMove = true;
				return isValidMove;
			} // end validMove
			
			/**
			 * Determines all of the straight moves for a piece.
			 * @param boardSize
			 * @return
			 */
			private ArrayList<int[]> getStraightMoves(int[][] board)
			{
				int boardSize = board.length;
				ArrayList<int[]> moves = new ArrayList<int[]> ();
				
				//System.out.println("start: " + this.row + " : " + this.col);
				
				//Move Forwards
				for(int i = 1; i <= this.row; i++) {
					int[] move = {this.row - i, this.col};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, boardSize) || board[move[0]][move[1]] > 0) break;
					moves.add(move);
				}
				
				//Move Backwards
				for(int i = 1; i <= boardSize - this.row; i++) {
					int[] move = {this.row + i, this.col};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, boardSize) || board[move[0]][move[1]] > 0) break;
					moves.add(move);
				}
				
				//Move Right
				for(int i = 1; i <= boardSize - this.col; i++) {
					int[] move = {this.row, this.col + i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, boardSize) || board[move[0]][move[1]] > 0) break;
					moves.add(move);
				}
				
				//Move Left
				for(int i = 1; i <= this.col; i++) {
					int[] move = {this.row, this.col - i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, boardSize) || board[move[0]][move[1]] > 0) break;
					moves.add(move);
				}
				
				return moves;
			} // end getStraightMoves
			
			/**
			 * Determines all of the straight moves for a piece.
			 * @param boardSize
			 * @return
			 */
			private ArrayList<int[]> getDiagnoltMoves(int[][] board)
			{
				int boardSize = board.length;
				ArrayList<int[]> moves = new ArrayList<int[]> ();
				
				//System.out.println("start: " + this.row + " : " + this.col);
				
				//Move Forwards and right
				for(int i = 1; i <= boardSize; i++) {
					int[] move = {this.row - i, this.col + i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, boardSize) || board[move[0]][move[1]] > 0) break;
					moves.add(move);
				}
				
				//Move Backwards and left
				for(int i = 1; i <= boardSize; i++) {
					int[] move = {this.row + i, this.col - i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, boardSize) || board[move[0]][move[1]] > 0) break;
					moves.add(move);
				}
				
				//Move Right and backwards
				for(int i = 1; i <= boardSize; i++) {
					int[] move = {this.row + i, this.col + i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, boardSize) || board[move[0]][move[1]] > 0) break;
					moves.add(move);
				}
				
				//Move Left and forwards
				for(int i = 1; i <= boardSize; i++) {
					int[] move = {this.row - i, this.col - i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, boardSize) || board[move[0]][move[1]] > 0) break;
					moves.add(move);
				}
				
				return moves;
			} // end getDiagnoltMoves
			
		}// end Piece
		
		/**
		 * Class for a Queen
		 * @author tmosest
		 *
		 */
		private class Queen extends Piece
		{
			/**
			 * Creates a Queen.
			 * @param symbol
			 * @param col
			 * @param row
			 * @param player
			 */
			public Queen(String symbol, String col, int row, char player) {
				super(symbol, col, row, player);
			} // end Queen
			
			/**
			 * This function returns an array list of the possible moves for a piece.
			 * @return
			 */
			@Override
			public ArrayList<int[]> getMoves(int[][] board)
			{
				ArrayList<int[]> moves = new ArrayList<int[]> ();
				
				moves.addAll(super.getStraightMoves(board));
				moves.addAll(super.getDiagnoltMoves(board));
				
				return moves;
			} // end getMoves
			
		} // end class Queen
		
		/**
		 * Class that represents a chess Game Board of various sizes;
		 * @author tmosest
		 *
		 */
		private class GameBoard
		{
			private int boardSize;
			private int[][] board;
			private ArrayList<Piece> pieces;
			private int numberPieces;
			
			private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
			/**
			 * Create a new chess board of various sizes
			 * @param size
			 */
			public GameBoard(int size)
			{
				this.boardSize = size;
				this.board = new int[size][size];
				this.numberPieces = 0;
				this.pieces = new ArrayList<Piece>();
			}
			
			/**
			 * Print out the chess board
			 */
			public void print()
			{
				for(int i = 0; i < boardSize; i++) {
					System.out.print(boardSize - i + "\t");
					for(int j = 0; j < boardSize; j++) {
						int temp = board[i][j];
						String symbol = "";
						if(temp > 0) {
							Piece piece = pieces.get(--temp);
							symbol =  piece.player + piece.symbol;
						} else if(temp < 0) {
							symbol = "X";
						}
						System.out.print(symbol + "\t");
					}
					System.out.println("");
				}
				System.out.print("\t");
				for(int j = 0; j < boardSize; j++) {
					System.out.print(alphabet.charAt(j % alphabet.length()) + "\t");
				}
				System.out.print("\n\n");
			} // end print()
			
			/**
			 * Print all of the moves for a piece
			 * @param pieceIndex
			 */
			public void printMoves(int pieceIndex) {
				//Don't draw if out of range!
				if(pieceIndex > pieces.size()) return;
				
				Piece piece = pieces.get(pieceIndex);
				ArrayList<int[]> moves = piece.getMoves(board);
				System.out.println("Print moves for: " + piece.player + " : " + piece.symbol);
				for(int[] move : moves) {
					System.out.print("("+ move[0] + ", " + move[1] + ")");
					if(move[0] < 0) move[0] = 0;
					if(move[1] < 0) move[1] = 0;
					board[move[0]][move[1]] = -1;
				}
				System.out.println("");
				this.print();
				this.clearMoves();
			} // end printMoves
			
			/**
			 * Clears all of the moves from the array.
			 */
			public void clearMoves()
			{
				for(int i = 0; i < boardSize; i++) {
					for(int j = 0; j < boardSize; j++) {
						if(board[i][j] == -1)
							board[i][j] = 0;
					}
				}
			}// end clearMoves
			
			/**
			 * A function to add a piece to a game board.
			 * @param piece
			 */
			public void addPiece(Piece piece)
			{
				piece.row = boardSize - piece.rowIndex;
				piece.col = convertLetterToRow(piece.colLetter);
				pieces.add(piece);
				board[piece.row][piece.col] = ++this.numberPieces;
			} // end addPiece
			
			/**
			 * Converts a letter to a column number.
			 * Like A = 0;
			 * @param col
			 * @return
			 */
			private int convertLetterToRow(String col)
			{
				int index = -1;
				for(char c : alphabet.toCharArray()) {
					index++;
					if(c == col.charAt(0)) break;
				}
				return index;
			} // end convertLetterToRow 
			
		}// end GameBoard
		
	}// end ChessEngine
	
}// end SimplifiedChessEngine
