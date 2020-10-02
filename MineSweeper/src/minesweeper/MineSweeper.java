package minesweeper;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Marcelo Augusto Mertz
 */
public class MineSweeper extends JFrame {

    public MineSweeper (){ 
        this.setLayout(null);//seta o layout como nulo
        this.setTitle("Mine Sweeper"); //titulo da janela
        this.setSize(640,480);
        this.setResizable(false);//tamanho da janela
        this.setLocationRelativeTo(null);// após referenciar o tamanho, centraliza a janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ao fechar a janela encerra o app
        MineField field = new MineField();
        
        field.setBackground(Color.red);
        field.setLocation((this.getWidth()-field.getWidth())/2, ((this.getHeight()-35)-field.getHeight())/2);
        this.add(field);

    }
    public static void main(String[] args) {
        MineSweeper x = new MineSweeper();
        x.setVisible(true);
    }
    
}
