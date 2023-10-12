
package practicasjava;

import java.util.Scanner;

public class Vaca {
    //atributos de la vaca
    private String nombre;
    private int tipo;
    private float litros;
    private float precio;
    
// constructores
    public Vaca(){}
   
            
    
    

    public Vaca(String nombre, int tipo, float litros) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.litros = litros;
        calcularPrecio();
    }

    public Vaca(String nombre, int tipo, float litros, float precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.litros = litros;
        this.precio = precio;
    }
    
    
    
    
    
    // getters and setters
    
    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para tipo
    public int getTipo() {
        return tipo;
    }

    // Setter para tipo
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    // Getter para litros
    public float getLitros() {
        return litros;
    }

    // Setter para litros
    public void setLitros(float litros) {
        this.litros = litros;
    }

    // Getter para precio
    public float getPrecio() {
        return precio;
    }

    // Setter para precio
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    private void calcularPrecio() {
    // Constantes para los valores de precios
    final float PRECIO_POR_LITRO = 1500;
    final float PRECIO_MENOS_DE_50_LITROS_TIPO_1 = 500;
    final float PRECIO_MAS_DE_50_LITROS_TIPO_1 = 550;
    final float PRECIO_MENOS_DE_50_LITROS_TIPO_2 = 1000;
    final float PRECIO_MAS_DE_50_LITROS_TIPO_2 = 1100;

    if (tipo == 1) {
        if (litros < 50) {
            this.precio = (litros * PRECIO_POR_LITRO) + PRECIO_MENOS_DE_50_LITROS_TIPO_1;
        } else {
            this.precio = (litros * PRECIO_POR_LITRO) + PRECIO_MAS_DE_50_LITROS_TIPO_1;
        }
    } else {
        if (litros < 50) {
            this.precio = (litros * PRECIO_POR_LITRO) + PRECIO_MENOS_DE_50_LITROS_TIPO_2;
        } else {
            this.precio = (litros * PRECIO_POR_LITRO) + PRECIO_MAS_DE_50_LITROS_TIPO_2;
        }
    }
    // Puedes agregar un comentario que explique el resultado
    // this.precio ahora contiene el precio calculado.
}
}
