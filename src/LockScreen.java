import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class LockScreen extends GraphicsProgram {

    public GImage startButton;
    public GLabel scoreLabel;
    public GLabel Save;
    public GLabel Missed;
    public GLabel Total;
    public GImage appleBox;
    public GImage ovalApple;
    public GImage background;
    public GImage gameover;
    public GRect rect2;
    public static int Score;
    public final int width =400;
    public final int height=700;

    public void run() {

            setSize(width, height);
            setTitle("AppleControl Game");
            background=new GImage("img/start.png");
            background.setSize(getWidth(),getHeight());
            startButton=new GImage("img/apple.png",150,420);
            startButton.setSize(70,70);
            add(background);
            add(startButton);
             startButton.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                         startButton.setVisible(false);
                         startGame();
                    }
          });
    }


    public void startGame(){
        System.out.println("startGame method");
        rect2=new GRect(0,50,1500,1000);
        background=new GImage("img/bg.png");
        appleBox =new GImage("img/applebox.png",60,550);
        appleBox.setSize(100,100);
        Save = new GLabel("Saved: "+LockScreen.Score,40,25);
        Missed = new GLabel("Missed: 0",300,25);
        Missed.setColor(Color.yellow);
        Save.setColor(Color.yellow);
        background.setImage("img/bg.png");
        add(background);
        add(Save);
        add(Missed);
        add(rect2);
        add(appleBox);
        ovalApple =new GImage("img/apple.png",60,60);
        ovalApple.setSize(40,40);
        AppleGenerator appleGenerator = new AppleGenerator(this);
        appleGenerator.start();//Start Create AppleControl Models
        gameover=new GImage("img/end.png");
        gameover.setSize(getWidth(),getHeight());
        rect2.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public  void mouseMoved(MouseEvent e){
                appleBox.setLocation(e.getX()-45, appleBox.getY());
            }
        });
    }



}
