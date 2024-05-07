package main.java.tank_task.map;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

public class map {
    private List<List<Character>> grid;

    public Map(List<List<Character>> grid) {
        this.grid = grid;
    }

    public List<List<Integer>> calculateMapHeight(){
        List<List<Integer>> heightMap = new ArrayList<>();
        for(List<Character> row : grid){
            List<Integer> heightRow = new ArrayList<>();
            for(char c : row){
                heightRow.add(c);
            }
            heightMap.add(new ArrayList<>(heightRow));
        }
        return heightMap;
    }

    private int toHeight(char c){
        switch(c){
            case 'X':
                return 10;
            case ' ':
                return 0;
            default:
                return 0;
        }
    }

    
    public List<List<Integer>> smoothMap(){
        List<List<Integer>> heightMap = calculateMapHeight();
        int smoothingValue = 3;

        for(int y=0;heightMap.size();y++){
            for(int x=0;heightMap.get(y).size();x++){
                int sum = 0;
                int count = 0; 
                for(int dy = -smoothingValue; dy <= smoothingValue; dy++){
                    for(int dx = -smoothingValue; dx <= smoothingValue; dx++){
                        int nx = x + dx;
                        int ny = y + dy;
                        if(nx >= 0 && nx < heightMap.get(y).size() && ny >= 0 && ny < heightMap.size()){
                            sum += heightMap.get(ny).get(nx);
                            count++;
                        }
                    }
                }
                heightMap.get(y).set(x, sum/count);
            }
        }
        return heightMap;
    }

    // get the position of the tank player A
    public Position getPosition(){
        for(List<Character> row : grid){
            for(int x=0;x < grid.get(0).size();x++){
                if(row.get(x)== 'A'){
                    return new Position(x, grid.indexOf(row)+1);
                }
            }
        }
        return null;
    }


    public void addTrees(){
        List<List<Integer>> heightMap = calculateMapHeight();
        List<List<Character>> treeMap = new ArrayList<>();
        

        for(List<Character> row : heightMap){
            List<Character> treeRow = new ArrayList<>();
            if()
        }
        
    }


}
