package livestreamerJGUI;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JLabel;

import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dimension;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JCheckBox;

public class LivestreamerJGUI extends javax.swing.JFrame {
    private static LivestreamerJGUI instance;
    private static final String DEFAULT_QUALITY_SETTING = "defaultQuality";
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    
    public static LivestreamerJGUI getInstance() {
        return instance;
    }

    private LivestreamerJGUI() {
    	setResizable(false);
        initComponents();
        String defaultQuality = "source";
        this.dropQuality.setSelectedItem(Quality.valueOf(defaultQuality));
        SwingUtilities.getRootPane(this).setDefaultButton(bGo);
        getContentPane().setLayout(null);
        getContentPane().add(jSeparator2);
        getContentPane().add(jSeparator1);
        getContentPane().add(jScrollPane1);
        getContentPane().add(bFile);
        getContentPane().add(labelFile);
        getContentPane().add(tfFile);
        getContentPane().add(labelOutput);
        getContentPane().add(rbRecord);
        getContentPane().add(dropFavorites);
        
        popupMenu = new JPopupMenu();
        
        mntmCut = new JMenuItem("Cut");
        mntmCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setClipboardContents(dropFavorites.getSelectedItem().toString());
                dropFavorites.setSelectedItem("");
            }
        });
        popupMenu.add(mntmCut);
        
        mntmCopy = new JMenuItem("Copy");
        mntmCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setClipboardContents(dropFavorites.getSelectedItem().toString());
            }
        });
        popupMenu.add(mntmCopy);
        
        mntmPaste = new JMenuItem("Paste");
        mntmPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropFavorites.setSelectedItem(getClipboardContents());
            }
        });
        popupMenu.add(mntmPaste);
        
        mntmEmpty = new JMenuItem("Empty");
        mntmEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	dropFavorites.setSelectedItem("");
            }
        });
        popupMenu.add(mntmEmpty);
        
        getContentPane().add(bOpenEditFavDialog);
        getContentPane().add(bBrowseTwitch);
        getContentPane().add(labelQuality);
        getContentPane().add(rbWatch);
        getContentPane().add(dropQuality);
        getContentPane().add(bGo);
        getContentPane().add(bStop);
        getContentPane().add(bChat);
        
        JLabel lblStreamer = new JLabel("Streamer:");
        lblStreamer.setBounds(10, 62, 64, 14);
        getContentPane().add(lblStreamer);
        
        chckbxSaveStreamer = new JCheckBox("Save streamer");
        chckbxSaveStreamer.setSelected(true);
        chckbxSaveStreamer.setBounds(87, 86, 136, 23);
        getContentPane().add(chckbxSaveStreamer);
        
        chckbxExitStream = new JCheckBox("Exit on Stream end");
        chckbxExitStream.setBounds(225, 86, 160, 23);
        getContentPane().add(chckbxExitStream);
        setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{dropFavorites, bOpenEditFavDialog, bBrowseTwitch, dropQuality, bGo, bStop, bChat, rbWatch, rbRecord}));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fd = new javax.swing.JFileChooser();
        selectGroup = new javax.swing.ButtonGroup();
        bFile = new javax.swing.JButton();
        bFile.setBounds(10, 196, 49, 23);
        labelFile = new javax.swing.JLabel();
        labelFile.setBounds(65, 176, 110, 14);
        rbRecord = new javax.swing.JRadioButton();
        rbRecord.setBounds(10, 151, 375, 23);
        rbWatch = new javax.swing.JRadioButton();
        rbWatch.setSelected(true);
        rbWatch.setBounds(10, 17, 375, 23);
        bGo = new javax.swing.JButton();
        bGo.setBounds(698, 11, 70, 35);
        bChat = new javax.swing.JButton();
        bChat.setBounds(698, 93, 70, 35);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(10, 286, 758, 211);
        taOutput = new javax.swing.JTextArea();
        labelOutput = new javax.swing.JLabel();
        labelOutput.setBounds(10, 266, 125, 14);
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator1.setBounds(0, 134, 778, 10);
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator2.setBounds(0, 245, 778, 10);
        bStop = new javax.swing.JButton();
        bStop.setBounds(698, 52, 70, 35);
        labelQuality = new javax.swing.JLabel();
        labelQuality.setBounds(515, 62, 49, 14);
        tfFile = new javax.swing.JTextField();
        tfFile.setBounds(65, 197, 320, 20);
        dropFavorites = new javax.swing.JComboBox<String>();
        dropFavorites.setBounds(87, 59, 298, 20);
        dropFavorites.setEditable(true);
        bOpenEditFavDialog = new javax.swing.JButton();
        bOpenEditFavDialog.setBounds(395, 58, 110, 23);
        bBrowseTwitch = new javax.swing.JButton();
        bBrowseTwitch.setBounds(395, 86, 110, 23);
        dropQuality = new javax.swing.JComboBox();
        dropQuality.setBounds(572, 59, 110, 20);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LivestreamerJGUI");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/icon.png")));
        setMinimumSize(new Dimension(785, 535));

        bFile.setText("File");
        bFile.setEnabled(false);
        bFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFileActionPerformed(evt);
            }
        });

        labelFile.setText("File name:");
        labelFile.setEnabled(false);

        selectGroup.add(rbRecord);
        rbRecord.setText("Record to file");
        rbRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRecordActionPerformed(evt);
            }
        });

        selectGroup.add(rbWatch);
        rbWatch.setText("Watch stream in player (Default: MPC-HC)");
        rbWatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbWatchActionPerformed(evt);
            }
        });

        bGo.setText("Start");
        bGo.setMaximumSize(new java.awt.Dimension(70, 35));
        bGo.setMinimumSize(new java.awt.Dimension(70, 35));
        bGo.setPreferredSize(new java.awt.Dimension(55, 23));
        bGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGoActionPerformed(evt);
            }
        });
        
        bChat.setText("Chat");
        bChat.setMaximumSize(new java.awt.Dimension(70, 35));
        bChat.setMinimumSize(new java.awt.Dimension(70, 35));
        bChat.setPreferredSize(new java.awt.Dimension(55, 23));
        bChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChatActionPerformed(evt);
            }
        });

        taOutput.setEditable(false);
        taOutput.setColumns(20);
        taOutput.setLineWrap(true);
        taOutput.setRows(5);
        taOutput.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taOutput);

        labelOutput.setText("Output:");

        bStop.setText("Stop");
        bStop.setEnabled(false);
        bStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStopActionPerformed(evt);
            }
        });

        labelQuality.setText("Quality:");

        tfFile.setEditable(false);
        tfFile.setEnabled(false);

        bOpenEditFavDialog.setText("Edit Streams");
        bOpenEditFavDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOpenEditFavDialogActionPerformed(evt);
            }
        });

        bBrowseTwitch.setText("Browse Twitch");
        bBrowseTwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBrowseTwitchActionPerformed(evt);
            }
        });

        dropQuality.setMaximumRowCount(16);
        dropQuality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DefaultComboBoxModel<Quality> aModel = new DefaultComboBoxModel<Quality>();
        for(Quality q : Quality.values()) {
            aModel.addElement(q);
        }
        dropQuality.setModel(aModel);
        dropQuality.setSelectedItem(Quality.source);
        dropQuality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropQualityActionPerformed(evt);
            }
        });
        
        refreshFavoriteList();
        Collections.sort(favoritesList);
        AutoCompleteDecorator.decorate(dropFavorites);
        pack();
        setLocationRelativeTo(null);
        dropFavorites.setMaximumRowCount(15);
        dropFavorites.requestFocus();
        
        for (Component component : dropFavorites.getComponents()) {
        	   component.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
            			popupMenu.show(e.getComponent(), e.getX(), e.getY() - popupMenu.getSize().height);
            		}
            	}
            });
        	}
        
    }// </editor-fold>//GEN-END:initComponents

    ArrayList<String> favoritesList = new ArrayList<String>();
    
    private void toggleRec(){
        if (rbWatch.isEnabled()){
            rbWatch.setEnabled(false);
            rbRecord.setEnabled(false);
            dropFavorites.setEnabled(false);
            bOpenEditFavDialog.setEnabled(false);
            bFile.setEnabled(false);
            tfFile.setEnabled(false);
            bBrowseTwitch.setEnabled(false);
            dropQuality.setEnabled(false);
        }
        else{
            rbWatch.setEnabled(true);
            rbRecord.setEnabled(true);
            dropFavorites.setEnabled(true);
            bOpenEditFavDialog.setEnabled(true);
            bFile.setEnabled(true);
            tfFile.setEnabled(true);
            bBrowseTwitch.setEnabled(true);
            dropQuality.setEnabled(true);
        } 
    }
    private void toggleWatch(){
        if (rbRecord.isEnabled()){
            rbWatch.setEnabled(false);
            rbRecord.setEnabled(false);
            dropFavorites.setEnabled(false);
            bOpenEditFavDialog.setEnabled(false);
            bFile.setEnabled(false);
            tfFile.setEnabled(false);
            bBrowseTwitch.setEnabled(false);
            dropQuality.setEnabled(false);
        }
        else{
            rbWatch.setEnabled(true);
            rbRecord.setEnabled(true);
            dropFavorites.setEnabled(true);
            bOpenEditFavDialog.setEnabled(true);
            bBrowseTwitch.setEnabled(true);
            dropQuality.setEnabled(true);
            dropFavorites.requestFocus();
            setTitle("LivestreamerJGUI");
            if(chckbxSaveStreamer.isSelected()){
            	if(!(taOutput.getText().contains(new String("No streams found")))){
    		        if(!(favoritesList.contains(dropFavorites.getSelectedItem().toString()))){
    		        	try {
    		                FileWriter writer = new FileWriter(System.getProperty("user.home") + "\\documents\\RadarisShorts\\LivestreamerJGUI\\favorites.txt", true);
    		                writer.write(dropFavorites.getSelectedItem().toString() + "\n");
    		                writer.close();
    		                refreshFavoriteList();
    		            } catch (IOException e) {
    		            }
    		        }
                }
            }
            if(chckbxExitStream.isSelected()){
            	System.exit(0);
            }
            dropFavorites.requestFocus();
        } 
    }
    
    private String addFileExtIfNecessary(String file,String ext) {
        if(file.lastIndexOf('.') == -1) {
            file = ext;
            return file;
        }
        return "";
    }
    private boolean filterCheck = false;
    private String fileName = "no";
    private void bFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFileActionPerformed
        if (!filterCheck) {
        FileFilter ft = new FileNameExtensionFilter("Transport Streams (*.ts)", "ts");
        fd.setAcceptAllFileFilterUsed(false);
        fd.addChoosableFileFilter( ft );
        filterCheck = true;
        }
        int returnVal = fd.showOpenDialog( this );
        String fileExt = ".ts";
        
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            String extCheck = fd.getSelectedFile().getPath() + addFileExtIfNecessary(fd.getSelectedFile().getName(),fileExt);
            tfFile.setText(extCheck);
            fileName = tfFile.getText();
        }
    }//GEN-LAST:event_bFileActionPerformed

    private void rbRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRecordActionPerformed
        bFile.setEnabled(true);
        tfFile.setEnabled(true);
        tfFile.setEnabled(true);
        labelFile.setEnabled(true);
    }//GEN-LAST:event_rbRecordActionPerformed

    private void rbWatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbWatchActionPerformed
        fileName = "no";
        tfFile.setText("");
        bFile.setEnabled(false);
        tfFile.setEnabled(false);
        labelFile.setEnabled(false);
    }//GEN-LAST:event_rbWatchActionPerformed
    
LivestreamerExe le = new LivestreamerExe();

    private void bGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGoActionPerformed
    	try{
    		if(dropFavorites.getSelectedItem().toString().equals("")){
    			if(lastWatched.equals("")){
    				return;
    			} else {
    				dropFavorites.setSelectedItem(lastWatched);
    			}
    		}
    	} catch(Exception ex){
    		return;
    	}
    	if(!(dropFavorites.getSelectedItem().toString().matches("\\p{javaLowerCase}*"))){
    		dropFavorites.setSelectedItem(dropFavorites.getSelectedItem().toString().toLowerCase());
    	}
    	lastWatched=dropFavorites.getSelectedItem().toString();
        bGo.setEnabled(false);
        taOutput.setText("");
        if (rbWatch.isSelected()) {
            String[] cl = { "livestreamer", "twitch.tv/" + dropFavorites.getSelectedItem().toString(), dropQuality.getSelectedItem().toString()};
            le.runLivestreamer(cl, taOutput);
            setTitle("LJGUI - " + dropFavorites.getSelectedItem().toString() + " - " + dropQuality.getSelectedItem().toString());
            bStop.setEnabled(true);
            toggleWatch();
            new Thread() {
                public void run() {
                    try{
                        le.getProc().waitFor();
                    }
                    catch (Exception err){
                    }
                    bGo.setEnabled(true);
                    bStop.setEnabled(false);
                    toggleWatch();
                }
            }.start();
            le.nullProc();
        }
        if (rbRecord.isSelected() && !"no".equals(fileName)) {
            String[] cl = { "livestreamer", "twitch.tv/" + dropFavorites.getSelectedItem().toString(), dropQuality.getSelectedItem().toString(), "-o", fileName};
            le.runLivestreamer(cl, taOutput);
            bStop.setEnabled(true);
            toggleRec();
            new Thread() {
                public void run() {
                    try{
                        le.getProc().waitFor();
                    }
                    catch (Exception err){
                    }
                    bGo.setEnabled(true);
                    bStop.setEnabled(false);
                    toggleRec();
                }
            }.start();
            le.nullProc();
        }
        if (rbRecord.isSelected() && "no".equals(fileName)) {
            JOptionPane.showMessageDialog(this,"Please choose a filename");
            bGo.setEnabled(true);
            bStop.setEnabled(false);
        }
    }//GEN-LAST:event_bGoActionPerformed

    private void bChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGoActionPerformed
        bChat.setEnabled(false);
        String url = "";
    	if(dropFavorites.getSelectedItem().toString().equals("")){
    		taOutput.setText(taOutput.getText()+ "\nCan't open empty url");
    	}
        url = "http://www.twitch.tv/" + dropFavorites.getSelectedItem().toString() + "/chat?popout=";
        le.openChat(url);
        bChat.setEnabled(true);
    }
    
    public JTextArea getTaOutput() {
        return taOutput;
    }

    private void bStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStopActionPerformed
        le.killLivestreamer();
        bGo.setEnabled(true);
        bStop.setEnabled(false);
    }//GEN-LAST:event_bStopActionPerformed

    private void bOpenEditFavDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenEditFavDialogActionPerformed
        AddFavoriteDialog.main(null);
        this.setEditDialogButtonEnabled(false);
    }//GEN-LAST:event_bOpenEditFavDialogActionPerformed

    private void bBrowseTwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBrowseTwitchActionPerformed
    	le.browseTwitch();
    }//GEN-LAST:event_bBrowseTwitchActionPerformed

    private void dropQualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropQualityActionPerformed
        Quality q = ((DefaultComboBoxModel<Quality>)dropQuality.getModel()).getElementAt(dropQuality.getSelectedIndex());
    }//GEN-LAST:event_dropQualityActionPerformed

    public void setEditDialogButtonEnabled(boolean b) {
        bOpenEditFavDialog.setEnabled(b);
    }
    
    public void setBrowseTwitchButtonEnabled(boolean b) {
        bBrowseTwitch.setEnabled(b);
    }
    
    public void refreshFavoriteList() {
        favoritesList.clear();
        dropFavorites.removeAllItems();
        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "\\documents\\RadarisShorts\\LivestreamerJGUI\\favorites.txt"));
            while (br.ready()) {
                favoritesList.add(br.readLine());
            }
            Collections.sort(favoritesList);
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LivestreamerJGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LivestreamerJGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int x = 0; x < favoritesList.size(); x++) {
            dropFavorites.insertItemAt(favoritesList.get(x), x);
        }
    }
    
    private void setClipboardContents(String s){
    	StringSelection stringSelection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, (ClipboardOwner) null);
    }
    
	public String getClipboardContents() {
		String result = "";
		Transferable contents = clipboard.getContents(null);
		boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
		if (hasTransferableText) {
			try {
				result = (String) contents.getTransferData(DataFlavor.stringFlavor);
			} catch (UnsupportedFlavorException | IOException ex) {
				System.out.println(ex);
				ex.printStackTrace();
			}
		}
		return result;
	}
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                } 
                catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                }
                instance = new LivestreamerJGUI();
                instance.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBrowseTwitch;
    private javax.swing.JButton bFile;
    private javax.swing.JButton bGo;
    private javax.swing.JButton bOpenEditFavDialog;
    private javax.swing.JButton bStop;
    private javax.swing.JButton bChat;
    private javax.swing.JComboBox<String> dropFavorites;
    private javax.swing.JComboBox<Quality> dropQuality;
    private javax.swing.JFileChooser fd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelFile;
    private javax.swing.JLabel labelOutput;
    private javax.swing.JLabel labelQuality;
    private javax.swing.JRadioButton rbRecord;
    private javax.swing.JRadioButton rbWatch;
    private javax.swing.ButtonGroup selectGroup;
    private javax.swing.JTextArea taOutput;
    private javax.swing.JTextField tfFile;
    private JPopupMenu popupMenu;
    private JMenuItem mntmCut;
    private JMenuItem mntmCopy;
    private JMenuItem mntmPaste;
    private JMenuItem mntmEmpty;
    private JCheckBox chckbxSaveStreamer;
    private JCheckBox chckbxExitStream;
    private String lastWatched = "";
}


