package com.ku.jackpatman.playlist.reader;

import com.mpatric.mp3agic.Mp3File;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

public class PlaylistReaderTest
{

    //TODO: Test files path will needed to be altered prior to sumittal

    final String testDir = "C:\\Users\\Jack\\Downloads\\test-data\\test-data\\";

    @Test
    public void testLoadFolder_ValidFolder_ReturnsExpectedList()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadFolder(directory);

        List<Mp3File> tracks = instance.getTracks();
        Assert.assertEquals(9, tracks.size());
    }

    @Test
    public void testLoadFolder_ValidFolder_CreatesExpectedPlaylist()
    {
        String directory = testDir + "collection-A\\";
        PlaylistReader instance = new PlaylistReader();
        instance.LoadFolder(directory);

        List<Mp3File> tracks = instance.getTracks();

        Assert.assertEquals(365, tracks.get(0).getLengthInSeconds());
        Assert.assertEquals("After Many Days", tracks.get(0).getId3v2Tag().getAlbum());
        Assert.assertEquals("Cannibal Eyes", tracks.get(0).getId3v2Tag().getTitle());
        Assert.assertEquals("1", tracks.get(0).getId3v2Tag().getTrack());

        Assert.assertEquals("Free download from http://www.last.fm/music/After+Many+Days and http://MP3.com"
                           , tracks.get(0).getId3v2Tag().getComment());

    }
}
