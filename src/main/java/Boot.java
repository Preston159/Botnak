import gui.GUIMain;
import gui.GUIUpdate;
import util.Utils;
import util.settings.Settings;

import javax.swing.*;

import java.awt.*;

public class Boot {
    public static void main(final String[] args) {

        /* Thread-safe initialization */
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*
                NativeLibrary.addSearchPath(
                        RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
                Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
                LibXUtil.initialise();
                *//*JFrame frame = new JFrame("vlcj Tutorial");


                frame.setLocation(100, 100);
                frame.setSize(1050, 600);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
                final EmbeddedMediaPlayerComponent player = new EmbeddedMediaPlayerComponent();
                frame.setContentPane(player);

                player.getMediaPlayer().playMedia(video, "network-caching=5000");*//*
                try {
                    AudioMediaPlayerComponent audio = new AudioMediaPlayerComponent();
                    MediaPlayerFactory factory = new MediaPlayerFactory();
                    Prototype for VLC playing sounds:
                    audio.getMediaPlayerFactory().newEmbeddedMediaPlayer().playMedia("C:\\Users\\Nick\\Documents\\Dropbox\\Botnak\\sounds\\frustrated.mp3");
                    Thread.sleep(500);
                    //audio.getMediaPlayerFactory().newEmbeddedMediaPlayer().playMedia("C:\\Users\\Nick\\Documents\\Dropbox\\Botnak\\sounds\\azorae.wav");
                    //audio.release(true);
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }*/

                setLookAndFeel();
                GUIMain g = new GUIMain();
                g.setVisible(true);
                if (GUIUpdate.checkForUpdate()) {
                    GUIUpdate gu = new GUIUpdate();
                    gu.setVisible(true);
                }
            }

            /**
             * Tries to set the swing look and feel.
             * All relevant exceptions are caught.
             */
            private void setLookAndFeel() {
                try {
                    Settings.loadLAF();
                    UIManager.setLookAndFeel(Settings.lookAndFeel);
                } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
