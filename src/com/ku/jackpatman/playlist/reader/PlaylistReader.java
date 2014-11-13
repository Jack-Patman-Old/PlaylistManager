package com.ku.jackpatman.playlist.reader;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistReader
{

    private final List<Mp3File> tracks;

    public PlaylistReader()
    {
        tracks = new ArrayList<>();
    }

    public void LoadFolder(String path)
    {
        File folder = new File(path);

        for (File file : folder.listFiles())
        {
            if (file.isDirectory())
            {
                LoadFolder(file.toString());
                System.out.println("Encountered subfolder in selected folder, processing subfolder at "+file.getAbsolutePath());
            } else
            {
                String filename = file.toString();
                String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());

                if (extension.equalsIgnoreCase("mp3"))
                {
                    try
                    {
                        getTracks().add(new Mp3File(file.getAbsolutePath()));
                    } catch (IOException | UnsupportedTagException | InvalidDataException ex)
                    {
                        System.out.println("Exception encountered attempting to read file "
                                + filename
                                + "Exception was "
                                + ex.toString());
                    }
                }
            }
        }
    }

    public List<Mp3File> getTracks()
    {
        return tracks;
    }

}
