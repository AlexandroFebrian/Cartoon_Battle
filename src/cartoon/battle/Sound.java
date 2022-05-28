/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartoon.battle;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author User
 */
public class Sound {
    private Clip clip;
    private float volume;
    private FloatControl fc;

    public Sound(File music) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(music);
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            fc.setValue(-15.0f);
            volume = -15.0f;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void changeVolume(float volume) {
        if (volume > -80.0f && volume < 6.0f) {
            if (volume == -30.0f) {
                volume = -80.0f;
            }
            this.volume = volume;
            this.fc.setValue(volume);
        }
    }

    public float getVolume() {
        return volume;
    }
}
