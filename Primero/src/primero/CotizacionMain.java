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
public class CotizacionMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object menu[] = {"1. Crear Cotización","2. Calcular Pago Inicial","3. Calcular Total a Financiar",
                        "4. Calcular Pago Mensual","5. Imprimir Cotizacion","6. Modificar Datos","7. Salir"};
        Object subMenu[] = {"1. Modificar Número de Cotización","2. Modificar Descripcion","3. Modificar Precio",
                        "4. Modificar Porcentaje de Pago Inicial","5. Modificar Plazo","6. Regresar"};
        Scanner in = new Scanner(System.in);
        int numero = 0, plazo = 0;
        float precio =  0.0f, porcentaje =  0.0f;
        String descripcion;
        Cotizacion cotizacion = new Cotizacion();
        String opcMenu = "";
        do{
            opcMenu = (String) JOptionPane.showInputDialog(null, "Elige una opción","Menu",JOptionPane.QUESTION_MESSAGE,
                    null, menu, menu[0]);
            
            switch(opcMenu){
                case "1. Crear Cotización":
                    numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el número de cotización",
                            "Crear Cotización",JOptionPane.QUESTION_MESSAGE));

                    descripcion = JOptionPane.showInputDialog(null,"Ingresa la descripción",
                            "Crear Cotización",JOptionPane.QUESTION_MESSAGE);

                    precio = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa el precio",
                            "Crear Cotización",JOptionPane.QUESTION_MESSAGE));

                    porcentaje = Float.parseFloat(JOptionPane.showInputDialog(null,
                            "Ingresa el porcentaje de pago inicial %", "Crear Cotización",JOptionPane.QUESTION_MESSAGE));

                    plazo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el plazo en meses",
                            "Crear Cotización",JOptionPane.QUESTION_MESSAGE));
                    cotizacion.setNumeroCotizacion(numero);
                    cotizacion.setDescripcion(descripcion);
                    cotizacion.setPrecio(precio);
                    cotizacion.setPorcentajePagoInicial(porcentaje);
                    cotizacion.setPlazo(plazo);
                    break;
                case "2. Calcular Pago Inicial":
                    JOptionPane.showMessageDialog(null, "El Pago Inicial es: $" + cotizacion.calcularPagoInicial(),
                            "Calcular Pago Inicial", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "3. Calcular Total a Financiar":
                    JOptionPane.showMessageDialog(null, "El Total a financiar es: $" + cotizacion.calcularTotalFinanciar(),
                            "Calcular Total a Financiar", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "4. Calcular Pago Mensual":
                    JOptionPane.showMessageDialog(null, "El Pago Mensual es de: $" + cotizacion.calcularPagoMensual(),
                            "Calcular Pago Mensual", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "5. Imprimir Cotizacion":
                    JOptionPane.showMessageDialog(null, "Numero de Cotizacion: " + cotizacion.getNumeroCotizacion() + 
                            "\nDescripcion: " + cotizacion.getDescripcion() + "\nPrecio: $" + cotizacion.getPrecio() + 
                            "\nPorcentaje de Pago Inicial: "+ cotizacion.getPorcentajePagoInicial() + "% \nPlazo: " + 
                            cotizacion.getPlazo() + " Meses" + "\nPago Inicial es: $" + cotizacion.calcularPagoInicial() +
                            "\nTotal a financiar: $" + cotizacion.calcularTotalFinanciar()+ "\nPago Mensual: $" +
                            cotizacion.calcularPagoMensual(),"Imprimir Cotizacion", JOptionPane.INFORMATION_MESSAGE);
                    break;    
                case "6. Modificar Datos":
                    String opcSubMenu = "";
                    do{
                        opcSubMenu = (String) JOptionPane.showInputDialog(null,"Elige una opción","Modificar Datos",
                                JOptionPane.QUESTION_MESSAGE,null,subMenu,subMenu[0]);
                        switch(opcSubMenu){
                            case "1. Modificar Número de Cotización":
                                numero = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Ingresa el nuevo número de cotización", "Modificar Número de Cotización",JOptionPane.QUESTION_MESSAGE));
                                cotizacion.setNumeroCotizacion(numero);
                                break;
                            case "2. Modificar Descripcion":
                                descripcion = JOptionPane.showInputDialog(null,"Ingresa la nueva descripción",
                                        "Modificar Descripcion",JOptionPane.QUESTION_MESSAGE);
                                cotizacion.setDescripcion(descripcion);
                                break;
                            case "3. Modificar Precio":
                                precio = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa el nuevo precio",
                                        "Modificar Precio",JOptionPane.QUESTION_MESSAGE));
                                cotizacion.setPrecio(precio);
                                break;
                            case "4. Modificar Porcentaje de Pago Inicial":  
                                porcentaje = Float.parseFloat(JOptionPane.showInputDialog(null,
                                        "Ingresa el nuevo porcentaje de pago inicial %", 
                                        "Modificar Porcentaje de Pago Inicial",JOptionPane.QUESTION_MESSAGE));
                                cotizacion.setPorcentajePagoInicial(porcentaje);
                                break;
                            case "5. Modificar Plazo":
                                plazo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el nuevo plazo en meses",
                                        "Modificar Plazo",JOptionPane.QUESTION_MESSAGE));
                                cotizacion.setPlazo(plazo);
                                break;
                            case "6. Regresar":
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "No es una opcion válida", null, JOptionPane.WARNING_MESSAGE );
                        }
                    }while(!opcSubMenu.equals("6. Regresar"));
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
