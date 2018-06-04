import acm.graphics.*;
import static acm.util.JTFTools.pause;

public class AppleControl extends Thread {
    GImage apple;
    GImage appleBox;
    GLabel score;
    GLabel Missed;
    static int numOfFall;


    public AppleControl(GImage apple, GImage appleBox, GLabel score, GLabel Missed) {
        this.apple = apple;
        this.appleBox = appleBox;
        this.score=score;
        this.Missed=Missed;
        numOfFall++;

    }

    @Override
    public void run() {
        gathering();
    }


    public void gathering(){
        while (apple.getHeight() != 1000) {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (appleBox.getBounds().intersects(apple.getBounds())
                    && appleBox.getY() > apple.getY()) {

                apple.setVisible(false);
                LockScreen.Score++;
                score.setLabel("Saved: "+LockScreen.Score);
                appleBox.move(0, -7);
                pause(100);
                appleBox.move(0, 7);
                break;
            }else { Missed.setLabel("Missed: "+(numOfFall-LockScreen.Score)); }
            apple.move(0, 10);
        }

    }
}
