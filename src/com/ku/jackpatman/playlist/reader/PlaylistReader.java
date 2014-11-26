package com.ku.jackpatman.playlist.reader;

import com.ku.jackpatman.playlist.Playlist;
import com.ku.jackpatman.playlist.Track;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

public class PlaylistReader
{

    private final List<Playlist> playlists;

    public PlaylistReader()
    {
        playlists = new ArrayList<>();
    }

    public void LoadPlaylist(String path)
    {
        String ext = FilenameUtils.getExtension(path);

        if (ext != null)
        {
            if (ext.equalsIgnoreCase("m3u"))
            {
                Playlist playlist = new Playlist(path, true);

                playlists.add(playlist);

                LoadPlaylistFile(path, playlist);
            } else

            {
                Playlist playlist = new Playlist(path, false);

                playlists.add(playlist);

                LoadFolder(path, playlist);
            }

        }
    }

    private void LoadPlaylistFile(String path, Playlist playlist)
    {
        final char COMMENT_PREFIX = '#';
        try
        {
            List<String> fileContents = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
            for (String line : fileContents)
            {
                if (line.charAt(0) != COMMENT_PREFIX)
                {
                    char a = line.charAt(0);
                    playlist.AddTrack(line);

                }
            }
        } catch (IOException ex)
        {
            Logger.getLogger(PlaylistReader.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void LoadFolder(String path, Playlist playlist)
    {
        File folder = new File(path);

        for (File file : folder.listFiles())
        {
            if (file.isDirectory())
            {
                LoadFolder(file.toString(), playlist);
                System.out.println("Encountered subfolder in selected folder, processing subfolder at " + file.getAbsolutePath());
            } else
            {
                String filename = file.toString();
                String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());

                if (extension.equalsIgnoreCase("mp3"))
                {
                    playlist.getTracks().add(new Track(file));
                }
            }
        }
    }

    public List<Playlist> getPlaylists()
    {
        return playlists;
    }

}
