/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ku.jackpatman.playlist.gui;

import com.ku.jackpatman.playlist.Playlist;
import com.ku.jackpatman.playlist.Track;
import com.ku.jackpatman.playlist.reader.PlaylistReader;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jack
 */
public class PlaylistManagerGui extends javax.swing.JFrame
{

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListPlaylists = new javax.swing.JList();
        btnAddPlaylist = new javax.swing.JButton();
        btnRemovePlaylist = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTracks = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSearch = new javax.swing.JTextPane();
        btnAddTrack = new javax.swing.JButton();
        btnRemoveTrack = new javax.swing.JToggleButton();
        BtnSaveChanges = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuToolbar = new javax.swing.JMenuBar();
        jBtnFile = new javax.swing.JMenu();
        BtnLoadPlaylist = new javax.swing.JMenuItem();
        BtnMenuRemovePlaylist = new javax.swing.JMenuItem();
        btnSaveChanges = new javax.swing.JMenu();
        BtnGeneratePlaylist = new javax.swing.JMenuItem();
        btnSavePlaylistChanges = new javax.swing.JMenuItem();
        BtnTrackMenu = new javax.swing.JMenu();
        BtnAddTrack = new javax.swing.JMenuItem();
        BtnRemoveTrack = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Playlist Manager");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("MainFrame"); // NOI18N

        jScrollPane1.setName("jListPlaylists"); // NOI18N

        jListPlaylists.setName("jListPlaylists"); // NOI18N
        jScrollPane1.setViewportView(jListPlaylists);

        btnAddPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/music200.png"))); // NOI18N
        btnAddPlaylist.setToolTipText("Add Playlist(s)/Folder(s)");
        btnAddPlaylist.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddPlaylistActionPerformed(evt);
            }
        });

        btnRemovePlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/music250.png"))); // NOI18N
        btnRemovePlaylist.setToolTipText("Remove Playlist(s)/Folder(s)");
        btnRemovePlaylist.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemovePlaylistActionPerformed(evt);
            }
        });

        jTableTracks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Album", "Title", "Artist", "Genre", "Length", "Year"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                true, true, true, false, false, true
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableTracks);

        jScrollPane3.setToolTipText("");

        txtSearch.setForeground(new java.awt.Color(204, 204, 204));
        txtSearch.setText("Search...");
        jScrollPane3.setViewportView(txtSearch);

        btnAddTrack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/itunes.png"))); // NOI18N
        btnAddTrack.setToolTipText("Add new track(s)");
        btnAddTrack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddTrackActionPerformed(evt);
            }
        });

        btnRemoveTrack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/itunesRemove.png"))); // NOI18N
        btnRemoveTrack.setToolTipText("Remove selected track(s)");
        btnRemoveTrack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveTrackActionPerformed(evt);
            }
        });

        BtnSaveChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/floppy1.png"))); // NOI18N
        BtnSaveChanges.setToolTipText("Save changes made to track(s)");
        BtnSaveChanges.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnSaveChangesActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/actualize.png"))); // NOI18N
        jButton1.setToolTipText("Refresh Tracks");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jMenuToolbar.setName("TlbrMainMenu"); // NOI18N

        jBtnFile.setText("File");
        jBtnFile.setName("BtnFile"); // NOI18N

        BtnLoadPlaylist.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        BtnLoadPlaylist.setBackground(new java.awt.Color(249, 240, 240));
        BtnLoadPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/music200.png"))); // NOI18N
        BtnLoadPlaylist.setText("Load Folders/Playlists");
        BtnLoadPlaylist.setToolTipText("");
        BtnLoadPlaylist.setName("BtnLoad"); // NOI18N
        BtnLoadPlaylist.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnLoadPlaylistActionPerformed(evt);
            }
        });
        jBtnFile.add(BtnLoadPlaylist);
        BtnLoadPlaylist.getAccessibleContext().setAccessibleName("loadPlaylistBtn");

        BtnMenuRemovePlaylist.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        BtnMenuRemovePlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/music250.png"))); // NOI18N
        BtnMenuRemovePlaylist.setText("Remove Folders/Playlists");
        BtnMenuRemovePlaylist.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnMenuRemovePlaylistActionPerformed(evt);
            }
        });
        jBtnFile.add(BtnMenuRemovePlaylist);

        jMenuToolbar.add(jBtnFile);

        btnSaveChanges.setText("Playlist");

        BtnGeneratePlaylist.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        BtnGeneratePlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/list31.png"))); // NOI18N
        BtnGeneratePlaylist.setText("Generate Playlist File");
        BtnGeneratePlaylist.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnGeneratePlaylistActionPerformed(evt);
            }
        });
        btnSaveChanges.add(BtnGeneratePlaylist);

        btnSavePlaylistChanges.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        btnSavePlaylistChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/floppy1.png"))); // NOI18N
        btnSavePlaylistChanges.setText("Save Playlist Changes");
        btnSavePlaylistChanges.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSavePlaylistChangesActionPerformed(evt);
            }
        });
        btnSaveChanges.add(btnSavePlaylistChanges);

        jMenuToolbar.add(btnSaveChanges);

        BtnTrackMenu.setText("Track");

        BtnAddTrack.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        BtnAddTrack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/itunes.png"))); // NOI18N
        BtnAddTrack.setText("Add Tracks");
        BtnAddTrack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnAddTrackActionPerformed(evt);
            }
        });
        BtnTrackMenu.add(BtnAddTrack);

        BtnRemoveTrack.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK));
        BtnRemoveTrack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/itunesRemove.png"))); // NOI18N
        BtnRemoveTrack.setText("Remove Tracks");
        BtnRemoveTrack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnRemoveTrackActionPerformed(evt);
            }
        });
        BtnTrackMenu.add(BtnRemoveTrack);

        jMenuToolbar.add(BtnTrackMenu);

        setJMenuBar(jMenuToolbar);
        jMenuToolbar.getAccessibleContext().setAccessibleName("MenuToolbar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemovePlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAddPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemovePlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddTrack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemoveTrack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnSaveChanges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("MainMenu");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    static PlaylistReader reader;
    int lastColumnClicked = 0;

    public PlaylistManagerGui()
    {
        initComponents();

        jTableTracks.getTableHeader().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int col = jTableTracks.columnAtPoint(e.getPoint());
                if (lastColumnClicked == col)
                {
                    sortTracks(col, true);
                } else
                {
                    lastColumnClicked = col;
                    sortTracks(col, false);
                }
            }
        });

        // Clear text field when mouse focuses on it.
        txtSearch.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (txtSearch.getText().equalsIgnoreCase("Search...") && reader != null)
                {
                    txtSearch.setText("");
                }
            }
        });

        jListPlaylists.setModel(new DefaultListModel()
        {
            Object[] playlist = reader.getPlaylists().toArray();

            public int getSize()
            {
                return playlist.length;
            }

            public Object getElementAt(int i)
            {
                return playlist[i];
            }
        });

        //Call appropriate methods to search when search box changes
        txtSearch.getDocument().addDocumentListener(new DocumentListener()
        {
            public void changedUpdate(DocumentEvent e)
            {
                searchTracks(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e)
            {
                searchTracks(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                searchTracks(e);
            }
        });

    }

    private void searchTracks(DocumentEvent evt)
    {
        int playlist = jListPlaylists.getSelectedIndex();
        String searchTerm = txtSearch.getText();
        if (searchTerm.isEmpty())
        {
            // In the event that there is no search term, display all tracks.
            UpdateTable(playlist);
        } else
        {
            List<Track> matches = reader.getPlaylists().get(playlist).searchTracks(searchTerm);
            UpdateTable(matches);
        }
    }

    private void sortTracks(int columnIndex, boolean reverseOrder)
    {
        if (reader != null)
        {
            int playlist = jListPlaylists.getSelectedIndex();
            if (reverseOrder)
            {
                reader.getPlaylists().get(playlist).reversePlaylistOrder();
                UpdateTable(playlist);
            } else
            {

                switch (columnIndex)
                {
                    case 0:
                        reader.getPlaylists().get(playlist).sortTracksByAlbum();
                        UpdateTable(playlist);
                        break;
                    case 1:
                        reader.getPlaylists().get(playlist).sortTracksByName();
                        UpdateTable(playlist);
                        break;
                    case 2:
                        reader.getPlaylists().get(playlist).sortTracksByArtist();
                        UpdateTable(playlist);
                        break;
                    case 3:
                        reader.getPlaylists().get(playlist).sortTracksByGenre();
                        UpdateTable(playlist);
                        break;
                    case 4:
                        reader.getPlaylists().get(playlist).sortTracksByLength();
                        break;
                    case 5:
                        reader.getPlaylists().get(playlist).sortTracksByYear();
                        UpdateTable(playlist);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void BtnLoadPlaylistActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnLoadPlaylistActionPerformed
    {//GEN-HEADEREND:event_BtnLoadPlaylistActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.showOpenDialog(this);

        File[] files = fc.getSelectedFiles();

        for (File file : files)
        {
            reader.LoadPlaylist(file.getPath());
        }

        jListPlaylists.setModel(new DefaultListModel()
        {
            Object[] playlist = reader.getPlaylists().toArray();

            @Override
            public int getSize()
            {
                return playlist.length;
            }

            public Object getElementAt(int i)
            {
                return playlist[i];
            }
        });

        jListPlaylists.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                if (!event.getValueIsAdjusting())
                {
                    JList source = (JList) event.getSource();
                    UpdateTable(source.getSelectedIndex());
                }
            }
        });
        jListPlaylists.setSelectedIndex(0);
        jScrollPane1.setViewportView(jListPlaylists);
    }//GEN-LAST:event_BtnLoadPlaylistActionPerformed

    private void btnAddPlaylistActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddPlaylistActionPerformed
    {//GEN-HEADEREND:event_btnAddPlaylistActionPerformed
        BtnLoadPlaylistActionPerformed(evt);
    }//GEN-LAST:event_btnAddPlaylistActionPerformed

    private void btnRemovePlaylistActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemovePlaylistActionPerformed
    {//GEN-HEADEREND:event_btnRemovePlaylistActionPerformed
        BtnMenuRemovePlaylistActionPerformed(evt);
    }//GEN-LAST:event_btnRemovePlaylistActionPerformed

    private void BtnMenuRemovePlaylistActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnMenuRemovePlaylistActionPerformed
    {//GEN-HEADEREND:event_BtnMenuRemovePlaylistActionPerformed
        DefaultListModel listModel = (DefaultListModel) jListPlaylists.getModel();
        int[] selectedIndice = jListPlaylists.getSelectedIndices();

        // Counter to keep track of indexes removed due to Arraylist automatically resizing
        int removalCount = 0;

        for (int selectedIndex : selectedIndice)
        {
            reader.getPlaylists().remove(selectedIndex - removalCount);
            removalCount++;
        }

        // Either change to next playlist and display, or clear display.
        if (reader.getPlaylists().size() > 0)
        {
            UpdateTable(reader.getPlaylists().size() - 1);
        } else
        {
            DefaultTableModel tableModel = (DefaultTableModel) jTableTracks.getModel();
            tableModel.setRowCount(0);
            tableModel.fireTableDataChanged();
            jTableTracks.setModel(tableModel);
        }


            jScrollPane1.setViewportView(jListPlaylists);    }//GEN-LAST:event_BtnMenuRemovePlaylistActionPerformed

    private void BtnRemoveTrackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnRemoveTrackActionPerformed
    {//GEN-HEADEREND:event_BtnRemoveTrackActionPerformed
        if (reader != null)
        {
            int playlist = jListPlaylists.getSelectedIndex();
            int tracks[] = jTableTracks.getSelectedRows();

            // Counter to maintain correct removal index, since Arraylist will automatically resize list as items are removed. 
            int removalCount = 0;

            for (int track : tracks)
            {
                reader.getPlaylists().get(playlist).RemoveTrack(track - removalCount);
                removalCount++;
            }

            UpdateTable(playlist);
        }
    }//GEN-LAST:event_BtnRemoveTrackActionPerformed

    private void BtnAddTrackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnAddTrackActionPerformed
    {//GEN-HEADEREND:event_BtnAddTrackActionPerformed
        if (reader != null)
        {
            final JFileChooser fc = new JFileChooser();
            fc.setMultiSelectionEnabled(true);
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.showOpenDialog(this);

            File[] files = fc.getSelectedFiles();
            int playlist = jListPlaylists.getSelectedIndex();

            for (File file : files)
            {
                reader.getPlaylists().get(playlist).AddTrack(file.getPath());
            }

            UpdateTable(playlist);
        }
    }//GEN-LAST:event_BtnAddTrackActionPerformed

    private void BtnGeneratePlaylistActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnGeneratePlaylistActionPerformed
    {//GEN-HEADEREND:event_BtnGeneratePlaylistActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.showSaveDialog(this);

        File file = fc.getSelectedFile();

        int playlist = jListPlaylists.getSelectedIndex();
        reader.getPlaylists().get(playlist).GeneratePlaylist(file);
    }//GEN-LAST:event_BtnGeneratePlaylistActionPerformed

    private void btnAddTrackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddTrackActionPerformed
    {//GEN-HEADEREND:event_btnAddTrackActionPerformed
        BtnAddTrackActionPerformed(evt);
    }//GEN-LAST:event_btnAddTrackActionPerformed

    private void btnRemoveTrackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemoveTrackActionPerformed
    {//GEN-HEADEREND:event_btnRemoveTrackActionPerformed
        BtnRemoveTrackActionPerformed(evt);
    }//GEN-LAST:event_btnRemoveTrackActionPerformed

    private void btnSavePlaylistChangesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSavePlaylistChangesActionPerformed
    {//GEN-HEADEREND:event_btnSavePlaylistChangesActionPerformed
        int playlist = jListPlaylists.getSelectedIndex();

        int rowcount = jTableTracks.getModel().getRowCount();
        int columnCount = jTableTracks.getModel().getColumnCount();

        String[][] trackData = new String[rowcount][columnCount];

        for (int i = 0; i < rowcount; i++)
        {
            for (int x = 0; x < columnCount; x++)
            {
                trackData[i][x] = (String) jTableTracks.getModel().getValueAt(i, x);
            }
        }

        reader.getPlaylists().get(playlist).SaveAllTracks(trackData);

        if (reader.getPlaylists().get(playlist).isPlaylistFile())
        {
            // If changes are made to a playlist, regenerate playlist file.
            String path = reader.getPlaylists().get(playlist).getPlaylistPath();
            reader.getPlaylists().get(playlist).GeneratePlaylist(new File(path));
        }
    }//GEN-LAST:event_btnSavePlaylistChangesActionPerformed

    private void BtnSaveChangesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BtnSaveChangesActionPerformed
    {//GEN-HEADEREND:event_BtnSaveChangesActionPerformed
        btnSavePlaylistChangesActionPerformed(evt);
    }//GEN-LAST:event_BtnSaveChangesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        int playlist = jListPlaylists.getSelectedIndex();
        String path = reader.getPlaylists().get(playlist).getPlaylistPath();

        BtnMenuRemovePlaylistActionPerformed(evt);
        reader.LoadPlaylist(path);
        UpdateTable(playlist);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void UpdateTable(List<Track> searchMatches)
    {
        DefaultTableModel model = (DefaultTableModel) jTableTracks.getModel();
        model.setRowCount(0);

        for (Track track : searchMatches)
        {
            String album = null;
            String name = null;
            String artist = null;
            String year = null;
            String genre = null;
            String length = null;

            if (track.getTrackFile().hasId3v1Tag())
            {
                ID3v1 tag = track.getTrackFile().getId3v1Tag();
                album = tag.getAlbum();
                name = tag.getTitle();
                artist = tag.getArtist();
                year = tag.getYear();
                genre = tag.getGenreDescription();
                // Length cannot be retrieved from ID3V1 tag
            } else
            {
                ID3v2 tag = track.getTrackFile().getId3v2Tag();
                album = tag.getAlbum();
                name = tag.getTitle();
                artist = tag.getArtist();
                year = tag.getYear();
                genre = tag.getGenreDescription();
                double actualLength = track.getTrackFile().getLengthInSeconds() / 60.0;
                DecimalFormat df = new DecimalFormat("#.00");
                length = df.format(actualLength);
            }

            Object[] row =
            {
                album, name, artist, genre, length, year
            };
            model.addRow(row);
            model.fireTableDataChanged();
            jTableTracks.setModel(model);
        }

    }

    private void UpdateTable(int playlistIndex)
    {
        Playlist playlist = reader.getPlaylists().get(playlistIndex);
        DefaultTableModel model = (DefaultTableModel) jTableTracks.getModel();
        model.setRowCount(0);

        for (Track track : playlist.getTracks())
        {
            String album = null;
            String name = null;
            String artist = null;
            String year = null;
            String genre = null;
            String length = null;

            if (track.getTrackFile().hasId3v1Tag())
            {
                ID3v1 tag = track.getTrackFile().getId3v1Tag();
                album = tag.getAlbum();
                name = tag.getTitle();
                artist = tag.getArtist();
                year = tag.getYear();
                genre = tag.getGenreDescription();
                // Length cannot be retrieved from ID3V1 tag
            } else
            {
                ID3v2 tag = track.getTrackFile().getId3v2Tag();
                album = tag.getAlbum();
                name = tag.getTitle();
                artist = tag.getArtist();
                year = tag.getYear();
                genre = tag.getGenreDescription();
                double actualLength = track.getTrackFile().getLengthInSeconds() / 60.0;
                DecimalFormat df = new DecimalFormat("#.00");
                length = df.format(actualLength);
            }

            Object[] row =
            {
                album, name, artist, genre, length, year
            };
            model.addRow(row);
            model.fireTableDataChanged();
            jTableTracks.setModel(model);
        }

    }

    public static void main(String args[])
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(PlaylistManagerGui.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                reader = new PlaylistReader();
                JFrame window = new PlaylistManagerGui();
                window.setLocationRelativeTo(null); // Center window
                window.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BtnAddTrack;
    private javax.swing.JMenuItem BtnGeneratePlaylist;
    private javax.swing.JMenuItem BtnLoadPlaylist;
    private javax.swing.JMenuItem BtnMenuRemovePlaylist;
    private javax.swing.JMenuItem BtnRemoveTrack;
    private javax.swing.JButton BtnSaveChanges;
    private javax.swing.JMenu BtnTrackMenu;
    private javax.swing.JButton btnAddPlaylist;
    private javax.swing.JButton btnAddTrack;
    private javax.swing.JButton btnRemovePlaylist;
    private javax.swing.JToggleButton btnRemoveTrack;
    private javax.swing.JMenu btnSaveChanges;
    private javax.swing.JMenuItem btnSavePlaylistChanges;
    private javax.swing.JMenu jBtnFile;
    private javax.swing.JButton jButton1;
    private javax.swing.JList jListPlaylists;
    private javax.swing.JMenuBar jMenuToolbar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableTracks;
    private javax.swing.JTextPane txtSearch;
    // End of variables declaration//GEN-END:variables
}
