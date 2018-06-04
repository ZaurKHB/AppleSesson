import acm.graphics.*;
import acm.program.*;

public class Main extends GraphicsProgram {

    static LockScreen game=new LockScreen();


    public static void main(String args[]){
        game.start();
    }

    public static void restart(){
        game.removeAll();
    }
}