package minesweeper;


import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Marcelo Augusto Mertz 
 */
public class MineField extends JPanel implements MouseListener{
    //Cria o vetor bidirecional de campos que poderão ter minas
    public Field field[][];
    //Define o tamanho padrão do campo
    private int colunas = 10;
    private int linhas = 10;
    //Guarda o tamanho padrão em uma variável de dimensão
    Dimension minefield = new Dimension(linhas, colunas);
    //Define o total de minas
    private int totalDeMinas = 7;
    //Cria variáveis para o contador e condição de vitória
    private int winCount, winCond;
    //um painel (oculto) para mensagens 
    private JPanel glassPanel;
    //mensagem a ser exibida
    private JLabel message;
    
    
    /** Invocador da Classe principal 
    * @param MineField Cria o campo minado 
    * Serão utilizados valores padrões
    */
    public MineField(){
        field = new Field[linhas][colunas];
        plantMines();
        this.setLayout(null);
        this.setSize(45*colunas, 35*linhas);
        trace("all done");
    }
    /** Invocador da Classe principal com parametros
    * @param MineField Cria um campo minado
    * @param linhas Número de linhas do campo 
    * @param colunas Número de colunas do campo
    * @param minas Número de minas que estarão ocultas no campo
    
    public MineField(int linhas, int colunas, int minas){
        this.linhas = linhas;
        this.colunas = colunas;
        this.totalDeMinas = minas;
        field = new Field[this.linhas][this.colunas];
        plantMines();        
    }
    * */
    private void plantMines(){
        //creating and planting fields
        for (int lin = 0; lin < linhas; lin++){
            for (int col = 0; col < colunas; col++){
                field[lin][col] = new Field();
                field[lin][col].setLocation(lin*45, col*35);
                this.add(field[lin][col]);
            }
        }
        //planting mines on fields
        for (int plantedMines = 0; plantedMines < totalDeMinas; plantedMines++){
            int pmLin = (int)(Math.random()*linhas);
            int pmCol = (int)(Math.random()*colunas);
            if (!field[pmLin][pmCol].isMined()){
                field[pmLin][pmCol].installMine();
                trace("Mina plantada em: linha: "+pmLin+" coluna: "+pmCol);
            } else {
                plantedMines--;
            }
        }
        //setting danger
        for (int lin = 0; lin < linhas; lin++){
            for (int col = 0; col < colunas; col++){
                int perigo = 0;
                try { if (field[lin-1][col-1].isMined()){ perigo++;} } catch (Exception ex){}
                try { if (field[lin-1][col].isMined()){ perigo++;} } catch (Exception ex){}
                try { if (field[lin-1][col+1].isMined()){ perigo++;} } catch (Exception ex){}
                
                try { if (field[lin][col-1].isMined()){ perigo++;} } catch (Exception ex){}
                try { if (field[lin][col+1].isMined()){ perigo++;} } catch (Exception ex){}

                try { if (field[lin+1][col-1].isMined()){ perigo++;} } catch (Exception ex){}
                try { if (field[lin+1][col].isMined()){ perigo++;} } catch (Exception ex){}
                try { if (field[lin+1][col+1].isMined()){ perigo++;} } catch (Exception ex){}

                field[lin][col].setPerigo(perigo);
                field[lin][col].setText(""+perigo);
                if (field[lin][col].isMined()){ field[lin][col].setText(""+9);}
                
     
            }
        }
        
        
    }
    
    
    /** Recria o campo minado com outras dimensões
    * @param linhas Número de linhas do campo
    * @param colunas Número de colunas do campo
    */
    public void setMineFieldSize(int linhas, int colunas){
        this.linhas = linhas;
        this.colunas = colunas;        
        trace("Criando novo campo com tamanho alterado...");
        field = new Field[this.linhas][this.colunas];
        plantMines();
        
    }
    
    /** Recria o campo minado com outro número de minas
    * @param minas Número de minas que estarão ocultas no campo
    */
    public void setAmountOfMines(int minas){
        //this.totalDeMinas = minas;
        //trace("Criando novo campo com quantidade de minas alterada...");
        //field = new Field[this.linhas][this.colunas];
        //plantMines();
    }
    public int getAmountOfMines(){
        return totalDeMinas;
    }
    /** Apenas um atalho para imprimir no console dados durante execução do app
     * Syntaxe inspirada no AS3
     * @param obj Objeto que será inspecionado e exibido no console
     */
    private void trace(Object obj){
        System.out.println(obj);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        Field min = (Field)e.getComponent();
        if (min.getPerigo()==9){
            //game over
        }else if (min.getPerigo()==0){
            //look for more clear fields
        } else {
            //just clear this one field
        }     

    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
