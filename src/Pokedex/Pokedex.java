package Pokedex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pokedex {
    private final ArrayList<Pokemon> playerPokedex;
    private final ArrayList<Pokemon> notDiscoveredPokedex;
    private final String path;

    public Pokedex(String path){
        this.playerPokedex = new ArrayList<>();
        this.notDiscoveredPokedex = new ArrayList<>();
        this.path = path;
    }

    private void loadPlayerPokedex(String path){
        File csvFile = new File(path);
        int lineCounter = 1;

        try(Scanner reader = new Scanner(csvFile)){
            reader.nextLine();
            while(reader.hasNextLine()){
                lineCounter++;
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException("File not found: " + path);
        } catch (Exception e) {
            throw new RuntimeException("Incompatible file: error at line " + lineCounter + " in file: " + csvFile.getAbsolutePath());
        }
    }

}
