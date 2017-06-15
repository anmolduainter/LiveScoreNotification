import com.sun.speech.freetts.VoiceManager;

/**
 * Created by anmol on 15/6/17.
 */
public class Voice {

    String name;
    com.sun.speech.freetts.Voice voice;

    public Voice(String name) {
        this.name = name;
        this.voice= VoiceManager.getInstance().getVoice(this.name);
        this.voice.allocate();
    }

    public void say(String something){
        this.voice.speak(something);
    }
}
