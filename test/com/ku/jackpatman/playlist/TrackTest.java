package com.ku.jackpatman.playlist;

import com.ku.jackpatman.playlist.reader.PlaylistReader;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TrackTest
{

    final String testDir = "C:\\Users\\Jack\\Downloads\\test-data\\test-data\\";

    @Test
    public void testRenameFile()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);

        List<Track> tracks = instance.getPlaylist().getTracks();

        tracks.get(0).renameFile("Vegetarian Eyes.mp3");
        String trackName = tracks.get(0).getFile().getName();

        List<Track> newTracks = instance.getPlaylist().getTracks();
        newTracks.get(0).renameFile("Cannibal Eyes.mp3");

        Assert.assertEquals("Vegetarian Eyes.mp3", trackName);
    }

    @Test
    public void testMoveFile()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);

        List<Track> tracks = instance.getPlaylist().getTracks();
        tracks.get(0).moveFile(testDir + "collection-B\\After Many Days\\");
        File newFile = new File(testDir + "collection-B\\After Many Days\\Cannibal Eyes.mp3");
        File oldFile = new File(testDir + "collection-A\\After Many Days\\Cannibal Eyes.mp3");
        Assert.assertTrue(newFile.exists());
        Assert.assertFalse(oldFile.exists());

        instance.LoadPlaylist(testDir + "collection-B\\");
        tracks = instance.getPlaylist().getTracks();
        tracks.get(0).moveFile(testDir + "collection-A\\After Many Days\\");
    }

    @Test
    public void testDeleteFile()
    {
        String directory = testDir + "collection-A\\";

        try (PrintWriter writer = new PrintWriter(directory + "test_file.mp3", "UTF-8"))
        {
            writer.println("Test Line");
        } 
        catch (FileNotFoundException | UnsupportedEncodingException e)
        {
            Assert.fail();
        }

        PlaylistReader instance = new PlaylistReader();
        
        instance.LoadPlaylist(directory);
        File file = instance.getPlaylist().getTracks().get(9).getFile();
        instance.getPlaylist().DeleteTrack(file);
        
        Assert.assertFalse(file.exists());
        Assert.assertEquals(9, instance.getPlaylist().getTracks().size());
    }

    @Test
    public void testSaveChanges()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);

        Track track = instance.getPlaylist().getTracks().get(0);
        
        ID3v2 id3v2Tag = track.getTrackFile().getId3v2Tag();
        id3v2Tag.setAlbum("Gluten free eyes");
        track.SaveChanges();
        
        PlaylistReader newInstance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        
        Track newTrack = instance.getPlaylist().getTracks().get(0);
        String album = track.getTrackFile().getId3v2Tag().getAlbum();
        track.getTrackFile().getId3v2Tag().setAlbum("After Many Days");
        track.SaveChanges();
        
        Assert.assertEquals("Gluten free eyes", album); 
    }
}
