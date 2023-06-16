package CollectionFiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'show' command
 */
public class Show extends Command {

    @Override
    public ArrayList execute(CommandData data) throws SQLException {
        String username;
        String id;
        String name;
        String x;
        String y;
        String date;
        String numberOfParticipants;
        String singlesCount;
        String albumsCount;
        String genre;
        String albumName;
        String albumSales;
        ArrayList<String> messages = new ArrayList<>();
        ArrayList<String> messagesMy = new ArrayList<>();
        ArrayList<String> messagesOthers = new ArrayList<>();
        String query;
        ResultSet rsBands;
        ResultSet rsAlbum;
        query = "SELECT * FROM MusicBands";
        rsBands = CommandData.stm.executeQuery(query);
        query = "SELECT * FROM Albums";
        rsAlbum = CommandData.stm1.executeQuery(query);

        while (rsBands.next() && rsAlbum.next()){
            username = rsBands.getString(1);
            id = rsBands.getString(2);
            name = rsBands.getString(3);
            x = rsBands.getString(4);
            y = rsBands.getString(5);
            date = rsBands.getString(6);
            numberOfParticipants = rsBands.getString(7);
            singlesCount = rsBands.getString(8);
            albumsCount = rsBands.getString(9);
            genre = MusicGenre.getGenreName(rsBands.getString(10));
            albumName = rsAlbum.getString(2);
            albumSales = rsAlbum.getString(3);



            ArrayList<String> listToAdd;
            if (username.equals(data.getUserName())){
                listToAdd = messagesMy;
            } else  {
                listToAdd = messagesOthers;
            }
        listToAdd.add(id +", " +name +", " +x +", " +y +", " +date  +", " + numberOfParticipants  +", " + singlesCount +", " +albumsCount +", " +genre +", " +albumName +", " +albumSales);
        }
        messages.add("YOUR BANDS");
        messagesMy.stream().forEach(a -> messages.add(a));
        messages.add("OTHERS BANDS");
        messagesOthers.stream().forEach(a -> messages.add(a));
        return messages;
    }
}
