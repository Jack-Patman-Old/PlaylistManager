package com.ku.jackpatman.playlist;

import com.ku.jackpatman.playlist.reader.PlaylistReader;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

public class PlaylistTest
{
    //TODO: Test files path will needed to be altered prior to sumittal
    final String testDir = "C:\\Users\\Jack\\Downloads\\test-data\\test-data\\";

    @Test
    public void testSortTracksByName()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylists().get(0);

        playlist.sortTracksByName();

        Assert.assertEquals("als nous amos", playlist.getTracks().get(0).getTrackFile().getId3v2Tag().getTitle());
    }

    @Test
    public void testSortTracksByAlbum()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylists().get(0);

        playlist.sortTracksByAlbum();

        Assert.assertEquals("Cannibal Eyes", playlist.getTracks().get(0).getTrackFile().getId3v2Tag().getTitle());
    }

    @Test
    public void testSortTracksByPath()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylists().get(0);

        playlist.sortTracksByPath();

        Assert.assertEquals(directory + "After Many Days\\Cannibal Eyes.mp3", playlist.getTracks().get(0).getFile().getPath());
    }

    @Test
    public void testReverseTracklist()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylists().get(0);

        playlist.reversePlaylistOrder();

        Assert.assertEquals("fuster meets guevara", playlist.getTracks().get(0).getTrackFile().getId3v2Tag().getTitle());
    }

    @Test
    public void testSortByArtist()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylists().get(0);

        playlist.sortTracksByArtist();

        Assert.assertEquals("Cannibal Eyes", playlist.getTracks().get(0).getTrackFile().getId3v2Tag().getTitle());
    }

    @Test
    public void testSortByLength()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylists().get(0);

        playlist.sortTracksByLength();

        Assert.assertEquals("la chichonera", playlist.getTracks().get(0).getTrackFile().getId3v2Tag().getTitle());
    }

    @Test
    public void testsearchTracks()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadPlaylist(directory);
        Playlist playlist = instance.getPlaylists().get(0);

        List<Track> matches = playlist.searchTracks("Gem Reflection");

        Assert.assertEquals(1, matches.size());
    }

}
