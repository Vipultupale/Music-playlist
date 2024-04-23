package song.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	private static ArrayList <Album> albums=new  ArrayList<>();
			
	public static void main(String[] args) {

		
		
		Album album = new Album("album1","sonu nigam");
		
		album.addSong("abcd 1Song", 5.1);
		album.addSong("efgh 2Song", 4.1);
		album.addSong("ijkl 3Song", 3.1);
		album.addSong("mnop 4Song", 7.1);
		  albums.add(album);

		album = new Album("album2","VP");
		
		album.addSong("qrst 21Song", 1.1);
		album.addSong("uvw 22Song", 2.1);
		album.addSong("xyz 23Song", 6.1);
		album.addSong("last 424Song", 9.1);
			albums.add(album);
			
		LinkedList<Song> Playlist1= new LinkedList<>();	
		albums.get(0).addToPlaylist("abcd 1Song",Playlist1);
		albums.get(0).addToPlaylist("efgh 2Song",Playlist1);
		albums.get(0).addToPlaylist("ijkl 3Song",Playlist1);
		albums.get(0).addToPlaylist("mnop 4Song",Playlist1);
		albums.get(1).addToPlaylist("qrst 21Song",Playlist1);
		albums.get(1).addToPlaylist("uvw 22Song",Playlist1);
		albums.get(1).addToPlaylist("xyz 23Song",Playlist1);
		albums.get(1).addToPlaylist("last 24Song",Playlist1);
			play(Playlist1);

		
		
	}

	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Song> listIterator= playList.listIterator();
		
		if(playList.size()==0) {
			System.out.println("this play list is empty");
		}
		else {
			System.out.println("now playing"+ listIterator.next().toString());
			printMenu();
		}
		
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch (action){
				case 0:
					System.out.println("playlist completed");
					quit=true;
					break;
					
				case 1:
					if(!forward) {
						listIterator.hasNext();
						listIterator.next();
						}
					forward=true;
					
					if(listIterator.hasNext()) {
						System.out.println("now playing"+listIterator.next().toString());	
					}
					else {
						System.out.println("no song availble, reached to the end of list");
						forward=false;
						
					}
					break;
					
				case 2:
					if(forward) {
						if(listIterator.hasPrevious()) {
						listIterator.previous();
					  }
					forward=false;	
					
					}
					
					if(listIterator.hasPrevious()) {
						System.out.println("now playing "+listIterator.previous().toString());
					}
					else {
						System.out.println("we are the first song");
						forward= false;
						}
					break;
					
				case 3:
					if(forward) {
							if(listIterator.hasPrevious()) {
								System.out.println("now playing "+ listIterator.previous().toString());
								forward=false;
							}else {
								System.out.println("we are at the start of the list");
								  }
						}
					else {
								if(listIterator.hasNext()) {
									System.out.println("now playing " +listIterator.next().toString());
									forward = true;
								}else {
									System.out.println("we are reached in end of the list");
								}
						}
					
					break;
					
				case 4:
					printlist(playList);
					break;
					
				case 5:
					printMenu();
					break;
					
				case 6:
					if(playList.size()>0) {
					listIterator.remove();
					  if(listIterator.hasNext()) {
						  System.out.println("now playing"+ listIterator.next().toString());
						  forward=true;
						  }
					  else {
						  if(listIterator.hasPrevious())
						  System.out.println("now playing "+ listIterator.previous().toString());
					  }
					}
			}
					
		}
		
	}
	
	private static void printMenu() {
		System.out.println("Available option  \n  Press ");
		System.out.println("0= quit\n"+
		" 1=play the next song \n"+
		" 2=previous song \n"+
		" 3= replay the current song \n"+
		" 4= List the all song \n"+
		" 5= back to options \n"+
		" 6= delete the song\n"
		);
	}
	
	
	private static void printlist (LinkedList<Song> playList) {
		Iterator<Song> iterator= playList.iterator();
		System.out.println("____________________________");
		
		while(iterator.hasNext()) {
				System.out.println( iterator.next());
		}
		
		System.out.println("____________________________");

	}
	

}
