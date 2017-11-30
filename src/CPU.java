/**
 * Created by Brendan on 30/11/2017.
 */
public class CPU {

    //todo chars and shorts need to be unsigned?
    int opcode;//stores current opcode
    int memory[]; //has 4K memory
    char V[]; //15 8-bit registers
    short I;
    short PC;
    /*0x000-0x1FF - Chip 8 interpreter (contains font set in emu)
      0x050-0x0A0 - Used for the built in 4x5 pixel font set (0-F)
      0x200-0xFFF - Program ROM and work RAM*/

    //graphics stuff
    //has 64 by 32 pixels
    char gfx[];
    char delayTimer;
    char soundTimer;

    short stack[];//call stack
    short sp;

    char key[] = new char[16];

    public boolean drawFlag;
    private int[] buffer; //stores the program before its loaded into memory

    public void initialize(){
        //init registers and memory
        memory = new int[4096];
        V = new char[16];
        gfx = new char[64*32];
        stack = new short[16];

        PC = 0x200;
        opcode = 0;
        I = 0;
        sp = 0;
        delayTimer = 0;
        soundTimer = 0;

        //load fontset
        int fontset[] = new int[]{0xF0, 0x90, 0x90, 0x90, 0xF0, 0x20, 0x60, 0x20, 0x20, 0x70, 0xF0, 0x10, 0xF0, 0x80,
                0xF0, 0xF0, 0x10, 0xF0, 0x10, 0xF0, 0x90, 0x90, 0xF0, 0x10, 0x10, 0xF0, 0x80, 0xF0, 0x10, 0xF0, 0xF0,
                0x80, 0xF0, 0x90, 0xF0, 0xF0, 0x10, 0x20, 0x40, 0x40, 0xF0, 0x90, 0xF0, 0x90, 0xF0, 0xF0, 0x90, 0xF0,
                0x10, 0xF0, 0xF0, 0x90, 0xF0, 0x90, 0x90, 0xE0, 0x90, 0xE0, 0x90, 0xE0, 0xF0, 0x80, 0x80, 0x80, 0xF0,
                0xE0, 0x90, 0x90, 0x90, 0xE0, 0xF0, 0x80, 0xF0, 0x80, 0xF0, 0xF0, 0x80, 0xF0, 0x80, 0x80};
        for (int i = 0; i < 80; i++) {
            memory[i] = fontset[i];
        }

        for (int i = 0; i < buffer.length; i++) {
            memory[i+512] = buffer[i]; //load program into memery
        }

    }

    public void emulateCycle(){
        memory[PC] = 0xA2;
        memory[PC + 1] = 0xF0;

        opcode = memory[PC] << 8 | memory[PC+1];
    }



    public void loadGame(String name){

    }

    public void setKeys(){

    }

}
