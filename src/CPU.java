/**
 * Created by Brendan on 30/11/2017.
 */
public class CPU {

    //todo chars and shorts need to be unsigned?
    short opcode;//stores current opcode
    char memory[] = new char[4096]; //has 4K memory
    char V[] = new char[16]; //15 8-bit registers
    short I;
    short PC;
    /*0x000-0x1FF - Chip 8 interpreter (contains font set in emu)
      0x050-0x0A0 - Used for the built in 4x5 pixel font set (0-F)
      0x200-0xFFF - Program ROM and work RAM*/

    //graphics stuff
    //has 64 by 32 pixels
    char gfx[] = new char[64*32];
    char delayTimer;
    char soundTimer;

    short stack[] = new short[16];//call stack
    short sp;

    char key[] = new char[16];
    public boolean drawFlag;

    public void initialize(){

    }

    public void emulateCycle(){

    }



    public void loadGame(String name){

    }

    public void setKeys(){

    }

}
