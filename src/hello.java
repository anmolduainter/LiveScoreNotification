import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by anmol on 15/6/17.
 */
public class hello {

    public static void main(String[] args) throws IOException {

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                getData data=new getData();
                String score= null;
                try {
                    score = data.data("1");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(score);
                Voice voice=new Voice("kevin16");
                voice.say(score);
                try {
                    notification(score);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        },0,600000);


    }


    public static void notification(String score) throws IOException {

        String[] cmd = { "/usr/bin/notify-send",
                "-t",
                "10000",
                score};
        Runtime.getRuntime().exec(cmd);

    }

}
