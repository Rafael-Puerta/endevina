package com.example.endevina;

public class Record {
    public String user;
    public int score;

    public Record(String nombrecito, int resultado) {
        this.user=nombrecito;
        this.score=resultado;
    }

    public void setUser(String us){
        user=us;
    }
    public void setScore(int scor){
        score=scor;
    }
    public String getUser(){return user;}
    public int getScore(){return score;}
    //getters
}
