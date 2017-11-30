/**
 * Created by Brendan on 30/11/2017.
 */
public class Main {

    CPU cpu = new CPU();

    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

    private void run(){
        setupGraphics();
        setupInput();

        cpu.initialize();
        cpu.loadGame("pong");

        while(true){
            cpu.emulateCycle();

            if(cpu.drawFlag){
                drawGraphics();
            }

            cpu.setKeys();
        }
    }


    public void setupGraphics(){

    }
    public void setupInput(){

    }

    public void drawGraphics(){

    }
}
