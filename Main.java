package com.company;
import java.util.*;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Album> albums =new ArrayList<>();
        Album album=new Album("New","Justin ");
        albums.add(album);
        album.addSong("Intentions",3.55);
        album.addSong("Yummy",3.34);
        Album album1=new Album("New1","Shawn ");
        albums.add(album1);
        album1.addSong("Stitches",4.00);
        album1.addSong("If I can't have You",3.11);
        LinkedList<Song> playlist=new LinkedList<>();
        album.addToPlaylist("Intentions",playlist);
        album.addToPlaylist("Yum",playlist);
        album1.addToPlaylist("Stitches",playlist);
        album1.addToPlaylist("If I can't have You",playlist);
        play(playlist);

    }
    public static void play(LinkedList<Song> playlist){
        Scanner scanner =new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator=playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("NO songs in the playlist!!");
        }else {
            System.out.println("Now playing "+listIterator.next());
            printMenu();
        }
        while(!quit){
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Closing application!!");
                    quit=true;
                    break;
                case 2:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next());

                    }
                    else{
                        System.out.println("You have reached the end of the list!!");
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous());
                    }
                    else{
                        System.out.println("You have reached to the beginning of the list!!");
                    }
                    break;
                case 4:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying "+listIterator.previous());
                            forward=false;
                        }
                        else{
                            System.out.println("You have reached the beginning of the list!!");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying "+ listIterator.next());
                            forward=true;
                        }
                        else{
                            System.out.println("You have reached the end of the list!!");
                        }
                    }
                    break;
                case 5:
                    printList(playlist);
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    if(playlist.size()>0){
                        listIterator.remove();
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next());
                    }
                    else if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous());
                    }

            }




        }


    }

    private static void printMenu() {
        System.out.println("1) To quit\n"+
                            "2) To go to the next song\n"+
                            "3) To go to the previous song\n"+
                            "4) To replay the song\n"+
                            "5) To print the songs in the playlist\n"+
                            "6) To print the menu\n");
    }

    public static void printList(LinkedList<Song> playlist){
        System.out.println("=====================================");
        Iterator<Song> songIterator=playlist.iterator();
        while(songIterator.hasNext()){
            System.out.println(songIterator.next());
        }
        System.out.println("======================================");

    }


}
