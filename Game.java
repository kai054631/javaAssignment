//Backend for the 15 puzzle game

import java.util.*;

public class Game {
    int[][] map;
    int move;
    
    //Constructor to start a game
    public Game() {
        map = new int[4][4];
        move = 0;
        //randomly assign 16 number into map
        Random rand = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < 16) {
            set.add(rand.nextInt(16) + 1);
        }
        
        Integer[] setArray = new Integer[set.size()];
        set.toArray(setArray);
        for (int i = 0; i < 4; i++) {
            for (int y = 0; y < 4; y++) {
                map[i][y] = setArray[i * 4 + y];
            }
        }
    }
    //Try to move a number in the map return if the move is valid
    public boolean move(int y, int x) {
        int toX = -1, toY = -1;
        if (y > 0 && map[y - 1][x] == 16) {
            toX = x;
            toY = y - 1;
        }
        else if (y < 3 && map[y + 1][x] == 16) {
            toX = x;
            toY = y + 1;
        } 
        else if (x > 0 && map[y][x - 1] == 16) {
            toX = x - 1;
            toY = y;
        }
        else if (x < 3 && map[y][x + 1] == 16) {
            toX = x + 1;
            toY = y;
        }

        if (toX == -1 && toY == -1) {
            return false;
        }
        
        int temp = map[y][x];
        map[y][x] = map[toY][toX];
        map[toY][toX] = temp;

        return true;
    }
    public boolean checkWin(){
        int k=0;
        for(int i=0;i<4;i++)//checkWin() just loop through the map arr by row and col return if in order or not
        {
            for(int j=0;j<4;j++)
            {
               k++;
               if(map[i][j]==k+1)
			   {
                   return true;
               }else
               {
                   return false;
               }
            }
			j=0;
            
        }
    }
    public int[][] getMap(){
        return map;//getMap just return the map 2d arr
    }
    public int getMove(){
        return move;//getMove just return the move
    } 
}