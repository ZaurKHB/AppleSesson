import acm.graphics.GImage;
import java.util.Random;
import static acm.util.JTFTools.pause;

public class AppleGenerator extends Thread{
    public GImage appleImg;
    LockScreen lockScreen;
    int Low = 30;
    int High;
    static Random r;
    int resultY;

    public AppleGenerator(LockScreen lockScreen) {
        this.lockScreen=lockScreen;
        this.High=lockScreen.height-30;
        this.r=new Random();
        this.appleImg =lockScreen.ovalApple;
    }

    public void run() {

        for (int i=1;i<100;i++){
                generateApple();
            try {
                Thread.sleep(AppleGenerator.r.nextInt(500-2)+2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pause(200);
        Main.restart();
        GameOver game= new GameOver(lockScreen);
        game.end();
    }


     public void generateApple(){

         resultY=r.nextInt((High-Low)+Low);
         appleImg =new GImage("img/apple.png",resultY,60);
         appleImg.setSize(40,40);
         lockScreen.add(appleImg);
         AppleControl appleControl = new AppleControl(appleImg,lockScreen.appleBox,lockScreen.Save,lockScreen.Missed);
         appleControl.start();

    }

}
