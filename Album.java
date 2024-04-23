package song.com;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song>songs;
	
	
	public Album(String name, String artist) {
		super();
		this.setName(name);
		this.setArtist(artist);
		this.setSongs(new ArrayList<Song>());
	}
	
	public Album() {
		//best practices  of empty constructer  
	}


	public ArrayList<Song> getSongs() {
		return songs;
	}


	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public Song findsong (String title) {
		for(Song checkedsong : songs) {
			if(checkedsong.getTitle().equals(title))
			return checkedsong;
		    	
		}
		return null;
	}
	
	public boolean addSong (String title , double duration) {
		if (findsong(title) == null) {
			songs.add(new Song(title,duration));
			System.out.println(title+ " sucessfully added to the List");
			return true;
		}
		
		else {
			System.out.println("song with name "+title+"already exist in List");
			return false;
		}
	}	
	
	
	public boolean addToPlaylist(int tranknumber , LinkedList<Song>PlayList){
		int index= tranknumber - 1;
		if(index>0 && index<= this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		}
		System.out.println("this album does not have song with tranknumber = "+tranknumber);
		return false;
	}
	
	public boolean addToPlaylist( String title,LinkedList<Song>PlayList) {
		for (Song checkedsong: this.songs) {
			 if(checkedsong.getTitle().equals(title)) {
				 PlayList.add(checkedsong);
				 return true;
			 }
		
		}
		System.out.println("this is no such song in ablum :-" + title);	
		return false;
	}
	
	

}
