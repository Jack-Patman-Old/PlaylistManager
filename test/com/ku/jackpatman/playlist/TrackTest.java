package com.ku.jackpatman.playlist;

import com.ku.jackpatman.playlist.reader.PlaylistReader;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrackTest
{

    final String testDir = "C:\\Users\\Jack\\Downloads\\test-data\\test-data\\";

    @Test
    public void testRenameFile()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadFolder(directory);

        List<Track> tracks = instance.getTracks();
                
        tracks.get(0).renameFile("Vegetarian Eyes.mp3");
        
        Assert.assertEquals("Vegetarian Eyes.mp3", tracks.get(0).getFile().getName());
       
        tracks.get(0).renameFile("Cannibal Eyes.mp3");
    }

    @Test
    public void testMoveFile()
    {
        // Todo - can we actually test this? Short of having to add folder deletion to test
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadFolder(directory);

        List<Track> tracks = instance.getTracks();
    }


    @Test
    public void testDeleteFile()
    {
        
    }

    @Test
    public void testSaveChanges()
    {
      
    }
}
