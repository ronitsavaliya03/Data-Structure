import java.util.ArrayList;
import java.util.Scanner;
class Song{
    String title;
    
    Song(String data){
        this.title=data;
    }

    public String getTitle(){
        return title;
    }
}
class MusicPlayer{
    ArrayList<Song> playlist;
    int currentSong;

    public MusicPlayer(){
        playlist=new ArrayList<>();
        currentSong=-1;
    }

    public void addSong(Song title){
        playlist.add(title);

        if(currentSong==-1){
            currentSong=0;
        }
    }

    public void removeSong(String title){
        for(int i=0; i<playlist.size(); i++){
            if(playlist.get(i).getTitle().equals(title)){
                playlist.remove(i);

                if(i==currentSong && currentSong>=playlist.size()){
                    currentSong--;
                }
                break;
            }
        }
    }

    public void play(){
        if (currentSong>=0 && currentSong<playlist.size()) {
            System.out.println("Playing: " + playlist.get(currentSong).title);
        }else{
            System.out.println("No song is currently selected to play.");
        }
    }

    public void pause(){
        if (currentSong>=0 && currentSong<playlist.size()) {
            System.out.println("Pause: " + playlist.get(currentSong).title);
        }else{
            System.out.println("No song is currently selected to pause.");
        }
    }

    public void next(){
        if (currentSong>=0 && currentSong<playlist.size()-1) {
            currentSong++;
            play();
        }else{
            System.out.println("You are at the end of the playlist.");
            play();
        }
    }

    public void previous(){
        if (currentSong>0) {
            currentSong--;
            play();
        }else{
            System.out.println("You are at the beginning of the playlist.");
            play();
        }
    }

    public void playlist(){
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        }else{
            System.out.println("---------Playlist---------");
            for (int i=0; i < playlist.size(); i++) {
                System.out.println((i+1) + ". " + playlist.get(i).title);
            }
        }
    }
}
public class MusicPlayerApp {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Music Player Options:");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Song");
            System.out.println("4. Pause Song");
            System.out.println("5. Next Song");
            System.out.println("6. Previous Song");
            System.out.println("7. Show Playlist");
            System.out.println("8. Exit");
            System.out.println("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.println("Enter song title: ");
                    String title = sc.nextLine();
                    player.addSong(new Song(title));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter song title to remove: ");
                    title = sc.nextLine();
                    player.removeSong(title);
                    System.out.println();
                    break;
                case 3:
                    player.play();
                    System.out.println();
                    break;
                case 4:
                    player.pause();
                    System.out.println();
                    break;
                case 5:
                    player.next();
                    System.out.println();
                    break;
                case 6:
                    player.previous();
                    System.out.println();
                    break;
                case 7:
                    player.playlist();
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    System.out.println();
            }
        }
    }
}
