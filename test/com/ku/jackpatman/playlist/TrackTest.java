package com.ku.jackpatman.playlist;

import com.ku.jackpatman.playlist.reader.PlaylistReader;
import java.io.File;
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
        instance.LoadFolder(directory);

        List<Track> tracks = instance.getTracks();

        tracks.get(0).renameFile("Vegetarian Eyes.mp3");
        String trackName = tracks.get(0).getFile().getName();

        List<Track> newTracks = instance.getTracks();
        newTracks.get(0).renameFile("Cannibal Eyes.mp3");

        Assert.assertEquals("Vegetarian Eyes.mp3", trackName);
    }

    @Test
    public void testMoveFile()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadFolder(directory);

        List<Track> tracks = instance.getTracks();
        tracks.get(0).moveFile(testDir + "collection-B\\After Many Days\\");
        File newFile = new File(testDir + "collection-B\\After Many Days\\Cannibal Eyes.mp3");
        File oldFile = new File(testDir + "collection-A\\After Many Days\\Cannibal Eyes.mp3");
        Assert.assertTrue(newFile.exists());
        Assert.assertFalse(oldFile.exists());

        instance.LoadFolder(testDir + "collection-B\\");
        tracks = instance.getTracks();
        tracks.get(0).moveFile(testDir + "collection-A\\After Many Days\\");
    }

    @Test
    public void testDeleteFile()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadFolder(directory);
        List<Track> tracks = instance.getTracks();
        File file = tracks.get(0).getFile();
        
    //    tracks.get(0).deleteFile();
    //    File oldFile = new File(testDir + "collection-A\\After Many Days\\Cannibal Eyes.mp3");
    //    Assert.assertFalse(oldFile.exists());
    }

    @Test
    public void testSaveChanges()
    {

    }
}
