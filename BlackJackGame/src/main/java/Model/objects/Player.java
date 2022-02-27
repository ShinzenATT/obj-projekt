package main.java.Model.objects;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String username;
    private int chips;

    public Player(String username, int chips){
        this.username = username;
        this.chips = chips;
    }

    public String getUsername(){
        return username;
    }

    public int getChips(){
        return chips;
    }

    public int transactChips(int delta){
        chips += delta;
        return chips;
    }
}