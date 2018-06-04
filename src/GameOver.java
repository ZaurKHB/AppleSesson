import acm.graphics.GImage;
import acm.graphics.GLabel;

public class GameOver {
LockScreen lockScreen;

    public GameOver(LockScreen lockScreen) {
        this.lockScreen = lockScreen;
    }

    public void end(){

        lockScreen.gameover=new GImage("img/end.png");
        lockScreen.gameover.setSize(lockScreen.getWidth(),lockScreen.getHeight());
        lockScreen.gameover.sendBackward();
        lockScreen.gameover.sendToBack();

        lockScreen.  Total=new GLabel("Total: 100",lockScreen.width/2-30,lockScreen.height/2+20);
        lockScreen.Missed = new GLabel("Missed: "+(100-lockScreen.Score),lockScreen.width/2-30,lockScreen.height/2+40);
        lockScreen.  scoreLabel=new GLabel("---------------",lockScreen.width/2-30,lockScreen.height/2+60);
        lockScreen.  Save = new GLabel("Saved: "+lockScreen.Score,lockScreen.width/2-30,lockScreen.height/2+80);

        lockScreen.add(lockScreen.gameover);
        lockScreen.add(lockScreen.Total);
        lockScreen.add(lockScreen.Save);
        lockScreen.add(lockScreen.Missed);
        lockScreen.add(lockScreen.scoreLabel);

    }
}
