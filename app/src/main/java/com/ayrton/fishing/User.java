package com.ayrton.fishing;

/**
 * Created by ayrton on 06/12/17.
 */

public class User {
    private String nickname;
    private int score;

    public User(String nickname, int score){
        this.nickname = nickname;
        this.score = score;
    }

    public void addScore(int score){
        this.score = this.score + score;
    }

    public String getNickname() {
        return nickname;
    }

    public int getScore() {
        return score;
    }
}
