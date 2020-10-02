package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
* @author Marcelo Augusto Mertz
 */
public class Field extends JButton {
    public boolean Mina = false;
    private int nivelPerigo = 0;
    public int alt = 35;
    public int lar = 45;
    public int lin, col;
    
    /*
    * Cria um campo que pode ou não ter uma mina escondida
    * Utiliza valores padrões na criação do campo
    */


    public Field (){
        this.setSize(lar, alt);
        this.setText("");
    }

    
    public int getPerigo(){
        return nivelPerigo;
    }
    public void setPerigo(int perigo){
        nivelPerigo = perigo;
    }
    public void installMine(){
        Mina = true;
    }
    public void removeMine(){
        Mina = false;
    }
    public boolean isMined(){
        return Mina;
    }
   
}
