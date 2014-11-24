package com.ku.jackpatman.playlist;

import com.ku.jackpatman.playlist.reader.PlaylistReader;
import junit.framework.Assert;
import org.junit.Test;

public class PlaylistTest
{
    final String testDir = "C:\\Users\\Jack\\Downloads\\test-data\\test-data\\";

    @Test
    public void testSortTracksByName()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylist();

        playlist.sortTracksByName();
        
        Assert.assertEquals("Cannibal Eyes", playlist.getTracks().get(0).getTrackFile().getId3v2Tag().getTitle());
    }

    @Test
    public void testSortTracksByAlbum()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylist();

        playlist.sortTracksByAlbum();
        
        Assert.assertEquals("Cannibal Eyes", playlist.getTracks().get(0).getTrackFile().getId3v2Tag().getTitle());        
    }


    @Test
    public void testSortTracksByPath()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylist();

        playlist.sortTracksByPath();
        
        Assert.assertEquals(directory+"After Many Days\\Cannibal Eyes.mp3", playlist.getTracks().get(0).getFile().getPath());       
    }

    @Test
    public void testReverseTracklist()
    {
         String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylist();

        playlist.reversePlaylistOrder();
        
        Assert.assertEquals("fuster meets guevara", playlist.getTracks().get(0).getTrackFile().getId3v2Tag().getTitle());      
    }
    
}
