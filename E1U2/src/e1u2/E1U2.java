/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1u2;
import javax.swing.JOptionPane;
/**
 *
 * @author Kenneth Stoney Wilson Herrera
 */
public class E1U2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Object menu[] = {"1. Iniciar Bomba","2. Vender Gasolina","3. Verificar Inventario","4. Calcular Venta Total","5. Salir"};
        Object tipo[] = {"Tipo 1", "Tipo 2", "Tipo 3"};
        int numero = 0, tipoGasolina = 0, cantidad = 0;
        float precio =  0.0f, costo =  0.0f;
        String marca = "";
        Bomba bomba = new Bomba();
        Gasolina gasolina = new Gasolina();
        String opcMenu = "", menuTipo = "";
        do{
            opcMenu = (String) JOptionPane.showInputDialog(null, "Elige una opción","Menu",JOptionPane.QUESTION_MESSAGE,
                    null, menu, menu[0]);
            
            switch(opcMenu){
                case "1. Iniciar Bomba":
                    marca = JOptionPane.showInputDialog(null,"Ingresa la marca de Gasolina","Iniciar Bomba",JOptionPane.QUESTION_MESSAGE);
                    
                    menuTipo  = (String) JOptionPane.showInputDialog(null, "Elige el tipo de gasolina","Iniciar bomba",JOptionPane.QUESTION_MESSAGE,
                            null, tipo, tipo[0]);
                    
                    precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa el Precio Base por litro", "Iniciar Bomba",
                            JOptionPane.QUESTION_MESSAGE));

                    numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el Número de la bomba","Iniciar Bomba",
                            JOptionPane.QUESTION_MESSAGE));
                    
                    if(menuTipo.equals("Tipo 1")){
                        tipoGasolina = 1;
                    }else if(menuTipo.equals("Tipo 2")){
                        tipoGasolina = 2;
                    }else if(menuTipo.equals("Tipo 3")){
                        tipoGasolina = 3;
                    }
                    gasolina.setMarca(marca);
                    gasolina.setTipo(tipoGasolina);
                    gasolina.setPrecioBase(precio);
                    bomba.setNumBomba(numero);
                    bomba.setTipoGasolina(gasolina);
                    //bomba.setCapacidad(1000);
                    //bomba.setContador(0);
                    break;
                
                case "2. Vender Gasolina":
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la cantidad a vender",
                            "Vender Gasolina",JOptionPane.QUESTION_MESSAGE));
                    costo = bomba.vender(cantidad);
                    if(costo > 0){
                        JOptionPane.showMessageDialog(null, "Venta realizada \n El total de la venta es de: $" + costo,
                        "Vender Gasolina", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No hay suficientes litros disponibles para realizar la venta",
                        "Vender Gasolina", JOptionPane.WARNING_MESSAGE);
                    }  
                    break;
                case "3. Verificar Inventario":
                    JOptionPane.showMessageDialog(null, "Hay " + bomba.revisarInventario() + " Litros Disponibles",
                            "Verificar Inventario", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "4. Calcular Venta Total":
                    JOptionPane.showMessageDialog(null, "La venta total es de: $" + bomba.calcularVentaTotal(),
                        "Calcular Venta Total", JOptionPane.INFORMATION_MESSAGE);
                    break;  
                case "5. Salir":
                    JOptionPane.showMessageDialog(null, "Gracias, adiós");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No es una opcion válida", null, JOptionPane.WARNING_MESSAGE );
            }
        }while(!opcMenu.equals("5. Salir"));
    }
    
}
