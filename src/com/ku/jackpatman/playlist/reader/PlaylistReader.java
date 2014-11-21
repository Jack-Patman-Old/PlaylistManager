package com.ku.jackpatman.playlist.reader;

import com.ku.jackpatman.playlist.Playlist;
import com.ku.jackpatman.playlist.Track;
import java.io.File;

public class PlaylistReader
{

    private final Playlist playlist;

    public PlaylistReader()
    {
        playlist = new Playlist();
    }
    
    public void LoadPlaylist(String path)
    {
        String extension = path.substring(path.lastIndexOf(".") + 1, path.length());
        if (extension != null)
        {
            if (extension.equalsIgnoreCase("mp3u"))
            {
              //  LoadPlaylistFile(path);
            } else
            {
                LoadFolder(path);
            }

        }       
    }
    
    private void LoadFolder(String path)
    {
        File folder = new File(path);

        for (File file : folder.listFiles())
        {
            if (file.isDirectory())
            {
                LoadFolder(file.toString());
                System.out.println("Encountered subfolder in selected folder, processing subfolder at " + file.getAbsolutePath());
            }
            else
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

    public Playlist getPlaylist()
    {
        return playlist;
    }

}
