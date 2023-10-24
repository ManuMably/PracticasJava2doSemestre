package proyectoclasematriz;
import javax.swing.JOptionPane;
public class ProyectoClaseMatriz 
{
    public static void main(String[] args) 
    {
        int nf,nc;
        ClaseMatriz M1, M2,M3;
        nf=Integer.parseInt(JOptionPane.showInputDialog("Indique el número de filas de la matriz 1"));
        nc=Integer.parseInt(JOptionPane.showInputDialog("Indique el número de columnas de la matriz 1"));
        M1=new ClaseMatriz(nf,nc);
        M1.llenar();
        
        nf=Integer.parseInt(JOptionPane.showInputDialog("Indique el número de filas de la matriz 2"));
        nc=Integer.parseInt(JOptionPane.showInputDialog("Indique el número de columnas de la matriz 2"));
        M2=new ClaseMatriz(nf,nc);
        M2.llenar();
                
       // JOptionPane.showMessageDialog(null,"Datos de la matriz 1\n"+M1.mostrar()+
       //                              "\nDatos de la matriz 2\n"+M2.mostrar());
       boolean continuarEnMenu = true;
        while (continuarEnMenu) {
            
            // menu principal 
            int menu = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal:\n"
               + "escriba 1 para sumar.\n"
               + "escriba 2 para multiplicar.\n"
               + "escriba 3 para dividir\n"
               + "escriba 4 para trasponer\n"
               + "escriba 5 para Salir.\n"));
            switch (menu) {
            case 1:
                JOptionPane.showMessageDialog(null,"Has escogido sumar la matriz 1 con matriz 2.");
                    if(M1.getNfilas() == M2.getNfilas() && M1.getNcol() == M2.getNcol())
                        {
                            M3=M1.sumar(M2);
                            JOptionPane.showMessageDialog(null,"Datos de la matriz 1\n"+M1.mostrar()+
                                        "\nDatos de la matriz 2\n"+M2.mostrar()+
                                        "\nDatos de la matriz suma\n"+M3.mostrar());
 
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Las matrices deben tener la misma dimensión");
                        }
                break;
                
            case 2:
                JOptionPane.showMessageDialog(null,"Has escogido multiplicar la matriz 1 con matriz 2.");
                   if (M1.getNcol() == M2.getNfilas()){
                    M3 = M1.multiplicar(M2);
                    JOptionPane.showMessageDialog(null,"Datos de la matriz 1\n"+M1.mostrar()+
                                        "\nDatos de la matriz 2\n"+M2.mostrar()+
                                        "\nDatos de la matriz multiplicacion\n"+M3.mostrar());
         
                    }else
                    {
                        JOptionPane.showMessageDialog(null,"La matriz 1 debe tener el mismo numero de columnas como de filas tiene la matriz 2");
                    }
                break;
                
            case 3:
                JOptionPane.showMessageDialog(null,"Has escogido dividir la matriz 1 con matriz 2.");
                    if(M1.getNfilas() == M2.getNfilas() && M1.getNcol() == M2.getNcol())
                    {
                        M3=M1.dividir(M2);
                        JOptionPane.showMessageDialog(null,"Datos de la matriz 1\n"+M1.mostrar()+
                                        "\nDatos de la matriz 2\n"+M2.mostrar()+
                                        "\nDatos de la matriz division\n"+M3.mostrar());
 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Las matrices deben tener la misma dimensión");
                    }
                break;
                
            case 4:
                int menu2 = Integer.parseInt(JOptionPane.showInputDialog("Elige que matriz deseas trasponer:\n"
                        + "escribe 1 para trasponer la matriz 1\n"
                        + "escribe 2 para trasponer la matriz 2\n"));
                switch (menu2) {
                    case 1:
                        M1.trasponer();
                        JOptionPane.showMessageDialog(null,"se ha traspuesto matriz 1\n" + M1.mostrar());
                        
                        break;
                    case 2:
                        M2.trasponer();
                        JOptionPane.showMessageDialog(null,"se ha traspuesto matriz 1\n" + M2.mostrar());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"no has ingresado una opcion valida");
                    }                
                break;
                
            case 5:
                JOptionPane.showMessageDialog(null,"has seleccionado salir, hasta luego !!");
                continuarEnMenu = false;
                break;
            default:
                JOptionPane.showMessageDialog(null,"no has ingresado una opcion valida");
            }
            
            
        }
        
        
    }
}
