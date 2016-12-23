package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *	Algorithms -> Recursion -> Simplified Chess Engine 
 *	Medium
 */
public class SimplifiedChessEngine {

	public static void main(String[] args) throws CloneNotSupportedException {
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
				ce.addPiece(type, col, row, 'W');
			}
			
			for(int i = 0; i < blackNumPieces; i++) {
				String type = in.next();
				String col  = in.next();
				int row 	= in.nextInt();
				ce.addPiece(type, col, row, 'B');
			}
			
			ce.solve();
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
		
		private int moves;
		private GameBoard gb;
		
		/**
		 * Constructor to create a new Chess Engine.
		 * @param moves
		 */
		public ChessEngine(int moves)
		{
			this.moves = moves;
			this.gb = new GameBoard(boardSize);
		} // end ChessEngine
		
		public void solve() throws CloneNotSupportedException
		{
			char winner = solve('W', this.gb, this.moves);
			if(winner == 'W')
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		private char solve(char colorToMove, GameBoard gameBoard, int remainingMoves) throws CloneNotSupportedException
		{
			if(remainingMoves == 0) {
				return 'B';
			}
			
			System.out.println("Solving for: " + colorToMove);
			gb.print();
			
			ArrayList<Piece> pieces = new ArrayList(gameBoard.getPieces(colorToMove));
			
			for(Piece piece : pieces) {
				System.out.println("Getting Moves for: " + piece.symbol);
				gb.printMoves(piece);
				ArrayList<int[]> moves = new ArrayList(piece.getMoves(gameBoard.board));
				for(int[] move : moves) {
					System.out.println("Moving to: " + move[0] + " : " + move[1]);
					//Capture Queen?
					if(gameBoard.board[move[0]][move[1]] != null && gameBoard.board[move[0]][move[1]].symbol.equals(Piece.queenSymbol))
						return colorToMove;
					
					//Move to Empty field or capture a regular piece
					GameBoard newGB = new GameBoard(gameBoard);
					newGB.board[piece.row][piece.col] = null;
					newGB.board[move[0]][move[1]] = (gameBoard.board[piece.row][piece.col] == null) 
							? null : (Piece) gameBoard.board[piece.row][piece.col].clone();
					if(newGB.board[move[0]][move[1]] != null) {
						newGB.board[move[0]][move[1]].row = move[0];
						newGB.board[move[0]][move[1]].col = move[1];
					}
					char tmp = solve((colorToMove == 'W') ? 'B' : 'W', newGB, --remainingMoves);
					if(tmp == colorToMove) return colorToMove;
					
				} // end for moves
			}// end for pieces
			return (colorToMove == 'W') ? 'B' : 'W';
		}
		
		/**
		 * Adds a new Piece to the game board.
		 * And draws it
		 * @param symbol
		 * @param col
		 * @param row
		 * @param player
		 */
		public Piece addPiece(String symbol, String col, int row, char player)
		{
			Piece pieceToAdd;
			if(symbol.equals(Piece.queenSymbol)) {
				pieceToAdd = new Queen(symbol, col, row, player);
			} else if(symbol.equals(Piece.bishopSymbol)) {
				pieceToAdd = new Bishop(symbol, col, row, player);
			} else if(symbol.equals(Piece.rockSymbol)) {
				pieceToAdd = new Rook(symbol, col, row, player);
			} else if(symbol.equals(Piece.knightSymbol)) {
				pieceToAdd = new Knight(symbol, col, row, player);
			} else {
				pieceToAdd = new Piece(symbol, col, row, player);
			}
			gb.addPiece(pieceToAdd);
			return pieceToAdd;
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
			Piece pieceToAdd = this.addPiece(symbol, col, row, player);
			gb.print();
			gb.printMoves(pieceToAdd);
		} // end addPieceAndDraw
		
		/**
		 * Class for a Chess Piece
		 * @author tmosest
		 *
		 */
		private class Piece implements Cloneable
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
			 * Creates a possible move piece
			 */
			public Piece()
			{
				this.symbol = "X";
			}// end Piece Possible Move
			
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
			public ArrayList<int[]> getMoves(Piece[][] board)
			{
				ArrayList<int[]> moves = new ArrayList<int[]> ();
				
				//Assume Pawn just for fun
				int[] move = {this.row + 1, this.col};
				
				if(this.player == 'W'){
					move[0] -= 2;
				}
				
				if(validMove(move, board))
					moves.add(move);
				
				return moves;
			} // end getMoves
			
			/**
			 * Determines if the move is within the board or not.
			 * @param move
			 * @param boardSize
			 * @return
			 */
			private boolean validMove(int[] move, Piece[][] board)
			{
				boolean isValidMove = false;
				if(move[0] < boardSize && 
				   move[1] < boardSize && 
				   move[0] >= 0 &&
				   move[1] >= 0) {
					isValidMove = true;
					Piece piece = board[move[0]][move[1]];
					if(piece != null) {
						if(this.player == piece.player)
							isValidMove = false;
					}
				}
				return isValidMove;
			} // end validMove
			
			/**
			 * Determines all of the straight moves for a piece.
			 * @param boardSize
			 * @return
			 */
			private ArrayList<int[]> getStraightMoves(Piece[][] board)
			{
				ArrayList<int[]> moves = new ArrayList<int[]> ();
				
				//System.out.println("start: " + this.row + " : " + this.col);
				
				//Move Forwards
				for(int i = 1; i <= this.row; i++) {
					int[] move = {this.row - i, this.col};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, board)) break;
					moves.add(move);
				}
				
				//Move Backwards
				for(int i = 1; i <= boardSize - this.row; i++) {
					int[] move = {this.row + i, this.col};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, board)) break;
					moves.add(move);
				}
				
				//Move Right
				for(int i = 1; i <= boardSize - this.col; i++) {
					int[] move = {this.row, this.col + i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, board)) break;
					moves.add(move);
				}
				
				//Move Left
				for(int i = 1; i <= this.col; i++) {
					int[] move = {this.row, this.col - i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, board)) break;
					moves.add(move);
				}
				
				return moves;
			} // end getStraightMoves
			
			/**
			 * Determines all of the diagnol moves for a piece.
			 * @param boardSize
			 * @return
			 */
			private ArrayList<int[]> getDiagnoltMoves(Piece[][] board)
			{
				ArrayList<int[]> moves = new ArrayList<int[]> ();
				
				//System.out.println("start: " + this.row + " : " + this.col);
				
				//Move Forwards and right
				for(int i = 1; i <= boardSize; i++) {
					int[] move = {this.row - i, this.col + i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, board)) break;
					moves.add(move);
				}
				
				//Move Backwards and left
				for(int i = 1; i <= boardSize; i++) {
					int[] move = {this.row + i, this.col - i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, board)) break;
					moves.add(move);
				}
				
				//Move Right and backwards
				for(int i = 1; i <= boardSize; i++) {
					int[] move = {this.row + i, this.col + i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, board)) break;
					moves.add(move);
				}
				
				//Move Left and forwards
				for(int i = 1; i <= boardSize; i++) {
					int[] move = {this.row - i, this.col - i};
					//System.out.println("row: " + move[0] + " col: " + move[1]);
					if(!validMove(move, board)) break;
					moves.add(move);
				}
				
				return moves;
			} // end getDiagnoltMoves
			
			protected Object clone() throws CloneNotSupportedException {
		        return super.clone();
		    }
			
		}// end Piece
		
		/**
		 * Class for a Rook
		 * @author tmosest
		 *
		 */
		private class Rook extends Piece
		{

			public Rook(String symbol, String col, int row, char player) {
				super(symbol, col, row, player);
			}
			
			/**
			 * This function returns an array list of the possible moves for a piece.
			 * @return
			 */
			@Override
			public ArrayList<int[]> getMoves(Piece[][] board)
			{
				return super.getStraightMoves(board);
			} // end getMoves
			
		} //end class Rook
		
		/**
		 * Class for a Bishop
		 * @author tmosest
		 *
		 */
		private class Bishop extends Piece
		{

			public Bishop(String symbol, String col, int row, char player) {
				super(symbol, col, row, player);
			}
			
			/**
			 * This function returns an array list of the possible moves for a piece.
			 * @return
			 */
			@Override
			public ArrayList<int[]> getMoves(Piece[][] board)
			{
				return super.getDiagnoltMoves(board);
			} // end getMoves
			
		} // end class Bishop
		
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
			public ArrayList<int[]> getMoves(Piece[][] board)
			{
				ArrayList<int[]> moves = new ArrayList<int[]> ();
				
				moves.addAll(super.getStraightMoves(board));
				moves.addAll(super.getDiagnoltMoves(board));
				
				return moves;
			} // end getMoves
			
		} // end class Queen
		
		private class Knight extends Piece 
		{

			public Knight(String symbol, String col, int row, char player) {
				super(symbol, col, row, player);
			}
			
			/**
			 * This function returns an array list of the possible moves for a piece.
			 * @return
			 */
			@Override
			public ArrayList<int[]> getMoves(Piece[][] board)
			{
				ArrayList<int[]> moves = new ArrayList<int[]> ();
				
				int rs[] = {1,2,2,1,-1,-2,-2,-1};
			    int cs[] = {-2,-1,1,2,2,1,-1,-2};
			    
			    int r, c;
			    for(int i = 0; i < rs.length; i++) {
			    	r = this.row + rs[i];
			        c = this.col + cs[i];
			        int[] move = {r, c};
			        if(super.validMove(move, board)) moves.add(move);
			    }
				
				return moves;
			} // end getMoves
			
		} // end class Knight
		
		/**
		 * Class that represents a chess Game Board of various sizes;
		 * @author tmosest
		 *
		 */
		private class GameBoard
		{
			private int boardSize;
			private Piece[][] board;
			
			private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
			/**
			 * Create a new chess board of various sizes
			 * @param size
			 */
			public GameBoard(int size)
			{
				this.boardSize = size;
				this.board = new Piece[size][size];
			}
			
			/**
			 * Create a new chess board from a copy.
			 * @param size
			 * @throws CloneNotSupportedException 
			 */
			public GameBoard(GameBoard gb) throws CloneNotSupportedException
			{
				this.boardSize = gb.boardSize;
				this.board = new Piece[gb.boardSize][gb.boardSize];
				for(int i = 0; i < this.boardSize; i++) {
					for(int j = 0; j < this.boardSize; j++) {
						if(gb.board[i][j] == null)
							this.board[i][j] = gb.board[i][j];
						else 
							this.board[i][j] = (Piece) gb.board[i][j].clone();
					}
				}
			}
			
			/**
			 * Print out the chess board
			 */
			public void print()
			{
				for(int i = 0; i < boardSize; i++) {
					System.out.print(boardSize - i + "\t");
					for(int j = 0; j < boardSize; j++) {
						Piece piece = board[i][j];
						String symbol = "";
						if(piece != null) {
							if(!piece.symbol.equals("X"))
								symbol =  piece.player + piece.symbol;
							else
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
			public void printMoves(Piece piece) {
				ArrayList<int[]> moves = piece.getMoves(this.board);
				System.out.println("Print moves for: " + piece.player + " : " + piece.symbol);
				for(int[] move : moves) {
					System.out.print("("+ move[0] + ", " + move[1] + ")");
					if(board[move[0]][move[1]] == null)
						board[move[0]][move[1]] = new Piece();
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
						if(board[i][j] != null && board[i][j].symbol.equals("X"))
							board[i][j] = null;
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
				board[piece.row][piece.col] = piece;
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
			
			public ArrayList<Piece> getPieces(char colorToMove)
			{
				ArrayList<Piece> pieces = new ArrayList<Piece> ();
				//Grab Pieces
				for(int i = 0; i < boardSize; i++) {
					for(int j = 0; j < boardSize; j++) {
						if(gb.board[i][j] != null && gb.board[i][j].player == colorToMove) {
							gb.board[i][j].row = i;
							gb.board[i][j].col = j;
							pieces.add(gb.board[i][j]);
						}
					}
				}
				return pieces;
			}
			
		}// end GameBoard
		
	}// end ChessEngine
	
}// end SimplifiedChessEngine
