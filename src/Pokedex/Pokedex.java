package Pokedex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pokedex {
    private final ArrayList<Pokemon> playerPokedex;
    private final ArrayList<Pokemon> undiscoveredPokedex;
    private final String path;

    public Pokedex(String path){
        this.playerPokedex = new ArrayList<>();
        this.undiscoveredPokedex = new ArrayList<>();
        this.path = path;
    }

    private void loadPlayerPokedex(String path){
        LoadPokedex(path, playerPokedex);
    }

    private void loadUndiscoveredPokedex(String path){
        LoadPokedex(path, undiscoveredPokedex);
    }

    private void LoadPokedex(String path, ArrayList<Pokemon> pokedex) {
        File csvFile = new File(path);
        int lineCounter = 1;

        try(Scanner reader = new Scanner(csvFile)){
            reader.nextLine();
            while(reader.hasNextLine()){
                lineCounter++;
                Pokemon pokemon = Pokemon.fromString(reader.nextLine());
                pokedex.add(pokemon);
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException("File not found: " + path);
        } catch (Exception e) {
            throw new RuntimeException("Incompatible file: error at line " + lineCounter + " in file: " + csvFile.getAbsolutePath());
        }
    }


}
