import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		char[][] board0 ={{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        PrBoard(board0);
        char[][] board ={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        Scanner scanner = new Scanner(System.in);
        while(true) {
        PlTurn(board,scanner);
        if(IsGameFinished(board)){
        	break;
        }
        PrBoard(board);        
        PcTurn(board);
        if(IsGameFinished(board)){
        	break;
        }
        PrBoard(board);
        }
        scanner.close();        
	}
	private static boolean HasAnyOneWon(char[][] board,char symbol) {
		if((board[0][0]==symbol&&board[0][1]==symbol&&board[0][2]==symbol) ||
				(board[1][0]==symbol&&board[1][1]==symbol&&board[1][2]==symbol)||
				(board[2][0]==symbol&&board[2][1]==symbol&&board[2][2]==symbol)||
				
				(board[0][0]==symbol&&board[1][0]==symbol&&board[2][0]==symbol)||
				(board[0][1]==symbol&&board[1][1]==symbol&&board[2][1]==symbol)||
				(board[0][2]==symbol&&board[1][2]==symbol&&board[2][2]==symbol)||
				
				(board[0][0]==symbol&&board[1][1]==symbol&&board[2][2]==symbol)||
				(board[0][2]==symbol&&board[1][1]==symbol&&board[2][0]==symbol)) {
				return true;
			}
		return false;
	}
	private static boolean IsGameFinished(char[][] board) {
		if(HasAnyOneWon(board,'X')){
		     PrBoard(board);
		     System.out.println("Players Wins!");
		     return true;
		}
		if(HasAnyOneWon(board,'O')){
		     PrBoard(board);
		     System.out.println("Pc Wins!");
		     return true;
		}
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
			
		}
		PrBoard(board);
		System.out.print("Nobody Won :(");
		return true;
	}
	private static void PrBoard(char[][] board) {
		System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
	}
	private static void PlTurn(char[][] board,Scanner scanner) {
		int plposition = 0;
        while(true) {        
        	System.out.print("Enter a number (1-9) to play (it has to be a valid move or u well need to choose again): ");
        	try {   	 
        	plposition = scanner.nextInt();
        	if(IsValidMove(board,plposition)) {
        		break;
        	}else if(plposition<=9 && plposition>=0 ) {
        		
        	}else {
        		System.out.println(plposition+" is not even a move :(");
        	}
        	}catch(InputMismatchException e) {
        		System.out.println("Pls enter a valide Integer");
        		scanner.next();
        	}
        }
        PlaceMove(board,plposition,'X');
	}
	private static boolean IsValidMove(char[][] board,int position) {
		switch(position){
    	case 1 :return (board[0][0]==' ');
    	case 2 :return (board[0][1]==' ');
    	case 3 :return (board[0][2]==' ');
    	case 4 :return (board[1][0]==' ');
    	case 5 :return (board[1][1]==' ');
    	case 6 :return (board[1][2]==' ');
    	case 7 :return (board[2][0]==' ');
    	case 8 :return (board[2][1]==' ');
    	case 9 :return (board[2][2]==' ');
    	default:return false;}
	}
	private static void PcTurn(char[][] board) {
		Random rand =new Random();
        int pcposition;
        while(true) {
        	pcposition=rand.nextInt(9)+1;
        	if(IsValidMove(board,pcposition)) {
        		break;
        	}
        }
        System.out.println("Pc move is: "+pcposition);
        PlaceMove(board,pcposition,'O');
	}
	private static void PlaceMove(char[][] board,int position,char symbol) {
		switch(position){
    	case 1 :board[0][0]=symbol;break;
    	case 2 :board[0][1]=symbol;break;
    	case 3 :board[0][2]=symbol;break;
    	case 4 :board[1][0]=symbol;break;
    	case 5 :board[1][1]=symbol;break;
    	case 6 :board[1][2]=symbol;break;
    	case 7 :board[2][0]=symbol;break;
    	case 8 :board[2][1]=symbol;break;
    	case 9 :board[2][2]=symbol;break;
    	default:System.out.println("That's not even a move :(");}
	}
}
