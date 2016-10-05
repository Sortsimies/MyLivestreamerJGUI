package livestreamerJGUI;

import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;


public class LivestreamerExe {
    private Process proc;
    
    LivestreamerExe (){
    }
    
    public void runLivestreamer(String[] cmd, final javax.swing.JTextArea ta){
        ProcessBuilder pb = new ProcessBuilder(cmd);
        try {
            proc = pb.start();
            final Scanner in = new Scanner(proc.getInputStream());
            new Thread() {
                public void run() {
                    while (in.hasNextLine())
                        ta.append(in.nextLine() +"\n");
                }
            }.start();
            final Scanner in2 = new Scanner(proc.getErrorStream());
            new Thread() {
                public void run() {
                    while (in2.hasNextLine())
                        ta.setText(in2.nextLine());
                }
            }.start();
        }
        catch (Exception err){
        }
    }
    public void killLivestreamer(){
        proc.destroy();
    }
    
    public void openChat(String url){
    	try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (Exception e) {
			System.out.println("Error opening url:");
			System.out.println(url);
		}
    }
    
    public void browseTwitch(){
    	try {
			Desktop.getDesktop().browse(new URI("http://www.twitch.tv/directory"));
		} catch (Exception e) {
			System.out.println("Error opening url: http://www.twitch.tv/directory");
		}
    }
    
    public void nullProc(){
        new Thread() {
            public void run() {
                try{
                    proc.waitFor();
                }
                catch (Exception err){
                }
                proc = null;
            }
        }.start();
    }
    
    public Process getProc(){
        return proc;
    }
}
