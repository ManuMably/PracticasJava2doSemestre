  
package proyectoclasematriz;
import javax.swing.JOptionPane;
public class ClaseMatriz 
{
   private int nfilas;
   private int ncol;
   private float matiz[][];
   //Método constructor

    public ClaseMatriz(int nfilas, int ncol) {
        this.nfilas = nfilas;
        this.ncol = ncol;
        matiz=new float[nfilas][ncol];
    }
    //Método para obtener el número de filas
    public int getNfilas() {
        return nfilas;
    }
     //Método para obtener el número de columnas
    public int getNcol() {
        return ncol;
    }
   //Método para llenar
    public void llenar()
    {
        for(int k=0;k<nfilas;k++)
        {
            for(int j=0;j<ncol;j++)
            {
               // mat[k][j]=Integer.parseInt(JOptionPane.showInputDialog("ingrese dato"));
                matiz[k][j]=(float)Math.random()*9;
            }
        }
    }
    //Método para mostrar
    public String mostrar()
    {
        String salida="";
        for(int k=0;k<nfilas;k++)
        {
            for(int j=0;j<ncol;j++)
            {
                salida=salida+String.format("%.2f",matiz[k][j])+"     ";
            }
            salida=salida+"\n";
        }
        return salida;
    }
    //Método para obtener un dato de una posicón de la matriz
    public float getDato(int f, int c)
    {
        return matiz[f][c];
    }
     //Método para asignar un dato a una posicón de la matriz
    public void setDato(float dato,int f, int c)
    {
        matiz[f][c]= dato;
    }
    //Mpétodo para sumar dos matrices
    public ClaseMatriz sumar(ClaseMatriz B)
    {
        int k,j;
        ClaseMatriz R = new ClaseMatriz(nfilas, ncol);
         for(k = 0; k < nfilas; k++)  
         {
             for(j=0;j<ncol;j++)
             {
                 R.setDato(matiz[k][j] + B.getDato(k,j), k, j);
             }
         }
         return R;
    }
    public ClaseMatriz multiplicar(ClaseMatriz b) {
        //                deben ser iguales
        // matiz Filas (matiz Columnas b filas)       b columnas 
        //       filas de la matriz resultado           columnas de la matriz resultado

        ClaseMatriz resultado = new ClaseMatriz(nfilas, b.getNcol());

        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < b.getNcol(); j++) {
                for (int k = 0; k < ncol; k++) {
                    resultado.setDato(resultado.getDato(i, j) + (matiz[i][j] * b.getDato(i, j)), i, j);
                }
            }
        }

        return resultado;
    }
    
    public ClaseMatriz dividir(ClaseMatriz B)
    {
        int k,j;
        ClaseMatriz R = new ClaseMatriz(nfilas, ncol);
         for(k = 0; k < nfilas; k++)  
         {
             for(j=0;j<ncol;j++)
             {
                 R.setDato(matiz[k][j] / B.getDato(k,j), k, j);
             }
         }
         return R;
    }
    
    public void trasponer(){
        ClaseMatriz traspuesta = new ClaseMatriz(nfilas, ncol);

        for (int i = 0; i < nfilas; i++) {
            for (int j = 0; j < ncol; j++) {
                traspuesta.setDato(matiz[j][i], i, j);
            }
        }

        // Imprimir la matriz traspuesta
        JOptionPane.showMessageDialog(null,"Datos de la matriz:\n" + traspuesta.mostrar());
    }
}
