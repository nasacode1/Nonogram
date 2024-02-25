import java.util.*;
public class nonogram {
	public static void main(String args[]) {
		Scanner scanner= new Scanner(System.in);
		nonogram game = new nonogram();
		
	}
	
	private Board board;
	
	public nonogram() {
		board = new Board(5); 	
	}
	public void startgame(Scanner scanner) {
		System.out.println("Welcome to nonogram game. Enter the size of grid.");
		int size = scanner.nextInt();
		board = new Board(size);
		board.initializeBoard();
		board.setClues();
		
		while(true) {
			board.displayBoard();
			System.out.println("Enter a cell you want to mark");
			int cellNumber = scanner.nextInt();
			while(board.getCell(cellNumber) == 'b') {
				System.out.println("Cell already occupied. Enter a different cell.");
				cellNumber = scanner.nextInt();
			}
			board.setCell(cellNumber);
			System.out.println("Press any number to continue. Else 0.");
			int x = scanner.nextInt();
			if(x==0) {
				break;
			}
			if(board.checkWinner()) {
				System.out.println("You won the game.");
				break;
			}
			
		}
	}
	
	

}
