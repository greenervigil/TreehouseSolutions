import com.teamtreehouse.KaraokeMachine;
import com.teamtreehouse.model.*;

public class Karaoke {

  public static void main (String[] args) {

  Song song = new Song(
    "Michael Jackson",
    "Beat It",
    "https://www.youtube.com/watch?v=SaEC9i9QOvk");

  SongBook songBook = new SongBook();
  KaraokeMachine machine = new KaraokeMachine(songBook);
  machine.run();
  }
}
