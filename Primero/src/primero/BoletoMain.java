/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primero;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Kennyswh
 */
public class BoletoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         Object menu[] = {"1. Crear Boleto","2. Imprimir Boleto","3. Calcular Impuesto",
            "4. Calcular Descuento","5. Calcular Total a Pagar","6. Modificar Datos","7. Salir"};
         Object subMenu[] = {"1. Modificar Número","2. Modificar Nombre del Cliente",
            "3. Modificar Edad","4. Modificar Destino","5. Modificar Tipo de viaje",
            "6. Modificar Precio Sencillo","7. Modificar Fecha","8. Regresar"};
         Object menuTipo[] = {"1: Sencillo", "2: Premium"};
         int numero = 0, edad = 0, tipoN = 0;
         float precio =  0.0f, total =  0.0f;
         String cliente, destino, fecha, tipo = "";
         Boleto boleto = new Boleto();
         String opcMenu = "";
         do{
             opcMenu = (String) JOptionPane.showInputDialog(null,"Elige una opción","Menú",
                    JOptionPane.QUESTION_MESSAGE, null, menu,menu[0]);
            switch(opcMenu){
                case "1. Crear Boleto":
                    numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el número de boleto",
                            "Crear Boleto",JOptionPane.QUESTION_MESSAGE));

                    cliente = JOptionPane.showInputDialog(null,"Ingresa el nombre del cliente",
                            "Crear Boleto",JOptionPane.QUESTION_MESSAGE);

                    destino = JOptionPane.showInputDialog(null,"Ingresa el destino",
                            "Crear Boleto",JOptionPane.QUESTION_MESSAGE);

                    precio = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa el precio sencillo",
                            "Crear Boleto",JOptionPane.QUESTION_MESSAGE));
                    
                    tipo = (String) JOptionPane.showInputDialog(null,"Elige una opción","Tipo de Viaje",
                            JOptionPane.QUESTION_MESSAGE, null, menuTipo,menuTipo[0]);
                    if(tipo == (String)menuTipo[0]){
                        tipoN = 1;
                    }
                    else{
                        tipoN = 2;
                    }
                    fecha = JOptionPane.showInputDialog(null,"Ingresa la fecha",
                            "Crear Boleto",JOptionPane.QUESTION_MESSAGE);
                    edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la edad del cliente",
                            "Crear Boleto",JOptionPane.QUESTION_MESSAGE));
                    boleto.definirTipoBoleto(tipoN, precio);
                    boleto.setNumero(numero);
                    boleto.setNombreCliente(cliente);
                    boleto.setDestino(destino);
                    boleto.setFecha(fecha);
                    break;
                case "2. Imprimir Boleto":
                    JOptionPane.showMessageDialog(null, boleto.imprimirBoleto(),"Imprimir Boleto",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "3. Calcular Impuesto":
                    JOptionPane.showMessageDialog(null, "El Impuesto de 16% es: " + boleto.calcularImpuesto(),
                            "Calcular Impuesto",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "4. Calcular Descuento":
                    JOptionPane.showMessageDialog(null, "El descuento es de: " + boleto.calcularDescuento(edad),
                            "Calcular Descuento",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "5. Calcular Total a Pagar":
                    total = boleto.getPrecio()+boleto.calcularImpuesto()- boleto.calcularDescuento(edad);
                    JOptionPane.showMessageDialog(null, "El total a pagar es: " + total,
                            "Calcular Total a Pagar",JOptionPane.INFORMATION_MESSAGE);
                    break;    
                case "6. Modificar Datos":
                    String opcSubMenu = "";
                    do{
                        opcSubMenu = (String) JOptionPane.showInputDialog(null, "Elige una opción", 
                                "Menú Modificar Datos", JOptionPane.QUESTION_MESSAGE,null, subMenu,subMenu[0]);
                        
                        switch(opcSubMenu){
                            case "1. Modificar Número":
                                numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el nuevo número de boleto",
                                        "Modificar Número",JOptionPane.QUESTION_MESSAGE));
                                boleto.setNumero(numero);
                                break;
                            case "2. Modificar Nombre del Cliente":
                                cliente = JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre del cliente",
                                        "Modificar Nombre del Cliente",JOptionPane.QUESTION_MESSAGE);
                                boleto.setNombreCliente(cliente);
                                break;
                            case "3. Modificar Edad":
                                System.out.println("Ingresa la edad del cliente");
                                edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la nueca edad del cliente",
                                        "Modificar Edad",JOptionPane.QUESTION_MESSAGE));
                                break;
                            case "4. Modificar Destino":
                                destino = JOptionPane.showInputDialog(null,"Ingresa el nuevo destino",
                                        "Modificar Destino",JOptionPane.QUESTION_MESSAGE);
                                boleto.setDestino(destino);
                                break;
                            case "5. Modificar Tipo de viaje":
                                tipo = (String) JOptionPane.showInputDialog(null,"Elige una opción","Tipo de Viaje",
                                        JOptionPane.QUESTION_MESSAGE, null, menuTipo,menuTipo[0]);
                                if(tipo == (String)menuTipo[0]){
                                    tipoN = 1;
                                }
                                else{
                                    tipoN = 2;
                                }
                                boleto.definirTipoBoleto(tipoN, precio);
                                break;
                            case "6. Modificar Precio Sencillo":
                                precio = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa el nuevo precio sencillo",
                                        "Modificar Precio Sencillo",JOptionPane.QUESTION_MESSAGE));
                                if(tipoN > 0){
                                   boleto.definirTipoBoleto(tipoN, precio); 
                                }
                                break;
                            case "7. Modificar Fecha":
                                fecha = JOptionPane.showInputDialog(null,"Ingresa la nueva fecha",
                                        "Modificar Fecha",JOptionPane.QUESTION_MESSAGE);
                                boleto.setFecha(fecha);
                                break;
                            case "8. Regresar":
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "No es una opcion válida", null, JOptionPane.WARNING_MESSAGE );
                        }
                    }while(!opcSubMenu.equals("8. Regresar"));
                    break;
                case "7. Salir":
                    JOptionPane.showMessageDialog(null, "Gracias, hasta pronto" );
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No es una opcion válida", null, JOptionPane.WARNING_MESSAGE );
            }
        } while(!opcMenu.equals("7. Salir"));
    }
    
}
