import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
	char[][] grid;
	int rowSize;
	int colSize;
	int n;
	List<List<Integer>> rowClues = new ArrayList<>();
	List<List<Integer>> colClues = new ArrayList<>();
	
	public Board(int size){
		this.rowSize = size;
		this.colSize = size;
		this.grid = new char[rowSize][colSize];	
	}
	
	public void initializeBoard() {
		int k = 1;
		for(int i=0;i <this.rowSize;i++) {
			for(int j=0;j<this.colSize;j++) {
				this.grid[i][j] = (char)k;
				k += 1;
			}
		}
	}
	public void displayBoard() {
		for(int i=0;i <this.rowSize;i++) {
			for(int j=0;j<this.colSize;j++) {
				System.out.printf("%d ", this.grid[i][j]);
			}
			System.out.println();
		}
	}
	
	public void setCell(int cellNumber) {
		int row = (cellNumber - 1)% 5;
		int col = (cellNumber - 1)/5;
		this.grid[row][col] = 'b';
	}
	
	public char getCell(int cellNumber) {
		int row = (cellNumber - 1)% 5;
		int col = (cellNumber - 1)/5;
		return this.grid[row][col];
	}
	
	public void setClues() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the row wise clues :");
		for(int i=0;i<rowSize;i++) {
			System.out.printf("Rule no %d:\n", i+1);
			List<Integer> currentSublist = new ArrayList<>();
			boolean flag = true;
			while(flag) {
				n = scanner.nextInt();
				currentSublist.add(n);
			}
			rowClues.add(currentSublist);
			scanner.close();
			
		}
		
		System.out.println("Enter the column wise clues :");
		for(int i=0;i<colSize;i++) {
			System.out.printf("Rule no %d:\n", i+1);
			List<Integer> currentSublist = new ArrayList<>();
			boolean flag = true; 
			while(flag) {
				n = scanner.nextInt();
				currentSublist.add(n);
			}
			colClues.add(currentSublist);
		}
		
	}
		public boolean checkWinner() {
		int rowPointer = 0;
		for(List<Integer> clue:rowClues) {
			int i=0;
			for(int blockCount : clue) {
				while(this.grid[rowPointer][i] == ' ' && i<colSize) {
					i = i+1;
				}
				while(i<colSize && blockCount > 0 ) {
					if(this.grid[rowPointer][i] == 'b') {
						i = i+1;
						blockCount -= 1;
					}
					else {
						return false;
					}
				}
				if(blockCount != 0) {
					return false;
				}
				if(i<colSize) {
					i = i+1;
				}
			}
			rowPointer = rowPointer+1;
		}
		int colPointer = 0;
		for(List<Integer> clue:colClues) {
			int i=0;
			for(int blockCount : clue) {
				while(this.grid[i][colPointer] == ' ' && i<rowSize) {
					i = i+1;
				}
				while(i<rowSize && blockCount > 0) {
					if(this.grid[i][colPointer] == 'b') {
						i = i+1;
						blockCount -= 1;
					}
					else {
						return false;
					}
				}
				if(blockCount != 0) {
					return false;
				}
				if(i<rowSize) {
					i = i+1;
				}
			}
			colPointer = colPointer+1;
		}
		return true;
	}
	
}
