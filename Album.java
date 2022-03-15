package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<>();
    }

    public boolean addSong(String title,double duration){
        if(findSong(title)==null){
            this.songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;

            }
        }
        return null;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> songs){
        Song checkedSong=findSong(title);
        if(checkedSong!=null){
            songs.add(checkedSong);
            System.out.println("Song "+title+" added successfully!!");
            return true;
        }
        System.out.println("Song "+title+" cannot be added!! ");
        return false;
    }
}
