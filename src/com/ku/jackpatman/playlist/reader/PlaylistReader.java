package com.ku.jackpatman.playlist.reader;

import com.ku.jackpatman.playlist.Track;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlaylistReader
{

    private final List<Track> tracks;

    public PlaylistReader()
    {
        tracks = new ArrayList<>();
    }
    
    public void DeleteTrack(File file)
    {
        for(Track track: tracks)
        {
            if (track.getFile().getPath().equals(file.getPath()))
            {
                tracks.remove(track);
                track.deleteFile();
            }
        }
    }

    public void LoadFolder(String path)
    {
        File folder = new File(path);

        for (File file : folder.listFiles())
        {
            if (file.isDirectory())
            {
                LoadFolder(file.toString());
                System.out.println("Encountered subfolder in selected folder, processing subfolder at " + file.getAbsolutePath());
            } else
            {
                String filename = file.toString();
                String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());

                if (extension.equalsIgnoreCase("mp3"))
                {
                    getTracks().add(new Track(file));
                }
            }
        }
    }

    public List<Track> getTracks()
    {
        return tracks;
    }

}
