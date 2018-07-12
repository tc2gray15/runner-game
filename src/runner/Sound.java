package runner;

import sun.audio.*;
import java.io.*;

public class Sound {
    
    AudioStream as;
    AudioData ad;
    ContinuousAudioDataStream cads;
    
    public Sound()
    {       
    }
    
    public void gameMusic()
    {
        try
        {
            as = new AudioStream(new FileInputStream("GameMusic.wav"));
            AudioPlayer.player.start(as);
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        } 
    }
    
    public void hitMarker()
    {
        try
        {
            as = new AudioStream(new FileInputStream("hitmarker.wav"));
            AudioPlayer.player.start(as);
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        } 
    }
    
}
