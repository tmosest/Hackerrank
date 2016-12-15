package GameTheory;

import java.util.Scanner;

/**
 *	Algorithms -> Game Theory -> Tower Breakers
 *	Easy
 */
public class AChessboardGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int games = in.nextInt();
		
		for(int g = 0; g < games; g++) {
			
			int x = in.nextInt();
			int y = in.nextInt();
					
			System.out.println(findWinner(x,y));
		}
		
		in.close();
	}
	
	public static String findWinner(int x, int y){
	    x=x%4; 
	    y=y%4;
	    if((y==0)||(y==3)||(x==0)||(x==3)) return "First";
	    return "Second";
	}    

	
	/*
	 * Mohmmed_jawad code to generate winning table
	public static void main(String[] args) {
	    for(int i=1;i<=15;i++)
	        for(int j=1;j<=15;j++)
	            tab[i][j]='x';                        

	    tab[1][1]=tab[1][2]=tab[2][1]=tab[2][2]='p';            

	    for(int i=1;i<=15;i++)
	        for(int j=1;j<=15;j++)
	            if(tab[i][j]=='x')tableCreate(i,j);

	    for(int i=1;i<=15;i++){
	        for(int j=1;j<=15;j++){
	            System.out.print(tab[i][j]+" ");
	        }
	        System.out.println();
	    }

	}


	public static void tableCreate(int y,int x){
	    int flag=0;

	    //if atleast one of the sqaure is p
	    if( (x-2>0 && y+1<16 && tab[y+1][x-2]=='p')||(x-2>0 && y-1>0 && tab[y-1][x-2]=='p')||(y-2>0 && x+1<16 && tab[y-2][x+1]=='p')||(y-2>0 && x-1>0 && tab[y-2][x-1]=='p') )
	       { tab[y][x]='n'; return;}

	    //if none of the sqaure is P and there are some unmarked sqaures reachable from current sqaure
	    if(x-2>0 && y+1<16 && tab[y+1][x-2]=='x'){
	        tableCreate(y+1,x-2);
	        if(tab[y+1][x-2]=='p'){ tab[y][x]='n'; return;}
	    } 
	    if(x-2>0 && y-1>0 && tab[y-1][x-2]=='x'){
	        tableCreate(y-1,x-2);
	        if(tab[y-1][x-2]=='p'){ tab[y][x]='n'; return;}
	    } 
	    if(y-2>0 && x+1<16 && tab[y-2][x+1]=='x'){
	        tableCreate(y-2,x+1);
	        if(tab[y-1][x+1]=='p'){ tab[y][x]='n'; return;}
	    } 
	    if(y-2>0 && x-1>0 && tab[y-2][x-1]=='x'){
	        tableCreate(y-2,x-1);
	        if(tab[y-2][x-1]=='p'){ tab[y][x]='n'; return;}
	    } 

	    //if all the sqaure reachable from here are n
	    tab[y][x]='p';
	}   
	*/ 
}
