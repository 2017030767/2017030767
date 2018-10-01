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
public class CuentaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Object menu[] = {"1. Crear Cuenta","2. Consultar Saldo","3. Depositar",
            "4. Retirar","5. Mostrar Datos de la Cuenta","6. Modificar Datos","7. Salir"};
        Object subMenu[] = {"1. Modificar Número de Cuenta","2. Modificar Nombre del Cliente",
            "3. Modificar Domicilio","4. Modificar Fecha de Nacimiento","5. Modificar Fecha de Apertura",
            "6. Modificar Nombre de la Sucursal","7. Regresar"};
        boolean verificar;
        int numero = 0, edad = 0;
        float saldo =  0.0f;
        String nombreCliente, domicilio, fechaNacimiento, fechaApertura, nombreSucursal;
        Cuenta cuenta = new Cuenta();
        String opcMenu = "";
        do{
            opcMenu = (String) JOptionPane.showInputDialog(null,"Elige una opción","Menú",
                    JOptionPane.QUESTION_MESSAGE, null, menu,menu[0]);

            switch(opcMenu){
                case "1. Crear Cuenta":
                    do{
                        edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la edad",
                            "Crear Cuenta",JOptionPane.QUESTION_MESSAGE));
                        
                        saldo = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa el saldo",
                            "Crear Cuenta",JOptionPane.QUESTION_MESSAGE));
                        
                        verificar = cuenta.crearCuenta(saldo, edad);
                        if(!verificar){
                            JOptionPane.showMessageDialog(null, "La persona tiene que ser mayor de edad y el saldo minimo es de 1000 MXN" );
                        }
                    }while(!verificar);
                    numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero de cuenta",
                            "Crear Cuenta",JOptionPane.QUESTION_MESSAGE));
                    
                    nombreCliente = JOptionPane.showInputDialog(null,"Ingresa el nombre del cliente",
                            "Crear Cuenta",JOptionPane.QUESTION_MESSAGE);
                    
                    domicilio = JOptionPane.showInputDialog(null,"Ingresa el domicilio",
                            "Crear Cuenta",JOptionPane.QUESTION_MESSAGE);
                    
                    fechaNacimiento = JOptionPane.showInputDialog(null,"Ingresa su fecha de nacimiento",
                            "Crear Cuenta",JOptionPane.QUESTION_MESSAGE);
                    
                    fechaApertura = JOptionPane.showInputDialog(null,"Ingresa la fecha de apertura",
                            "Crear Cuenta",JOptionPane.QUESTION_MESSAGE);
                    
                    nombreSucursal = JOptionPane.showInputDialog(null,"Ingresa el nombre de la sucursal",
                            "Crear Cuenta",JOptionPane.QUESTION_MESSAGE);
                    
                    
                    cuenta.setNumeroCuenta(numero);
                    cuenta.setNombreCliente(nombreCliente);
                    cuenta.setDomicilio(domicilio);
                    cuenta.setFechaNacimiento(fechaNacimiento);
                    cuenta.setSaldo(saldo);
                    cuenta.setFechaApertura(fechaApertura);
                    cuenta.setNombreSucursal(nombreSucursal);
                    break;
                case "2. Consultar Saldo":
                    JOptionPane.showMessageDialog(null, "El Saldo es: " + cuenta.consultarSaldo() + " MXN",
                            "Consultar Saldo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "3. Depositar":
                    saldo = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa la cantidad a depositar",
                            "Depositar",JOptionPane.QUESTION_MESSAGE));
                    cuenta.depositar(saldo);
                    break;
                case "4. Retirar":
                    do{
                        saldo = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingresa la cantidad a retirar",
                            "Retirar",JOptionPane.QUESTION_MESSAGE));
                        verificar = cuenta.retirar(saldo);
                        if(!verificar){
                            JOptionPane.showMessageDialog(null, "La cantidad retirada no puede superar el saldo de la cuenta", "Retirar", JOptionPane.WARNING_MESSAGE );
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Operación Exitosa", "Retirar",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }while(!verificar);
                    break;
                case "5. Mostrar Datos de la Cuenta":
                    JOptionPane.showMessageDialog(null, "Numero de Cuenta: " + cuenta.getNumeroCuenta() + "\nNombre del Cliente: " 
                            + cuenta.getNombreCliente() + "\nFecha de Nacimiento: " + cuenta.getFechaNacimiento()
                            + "\nDomicilio: " + cuenta.getDomicilio() + "\nFecha de Apertura: " + cuenta.getFechaApertura()
                            + "\nNombre de la Sucursal: " +cuenta.getNombreSucursal() );
                    break;    
                case "6. Modificar Datos":
                    String opcSubMenu = "";
                    do{
                        opcSubMenu = (String)JOptionPane.showInputDialog(null, "Elige una opción", 
                                "Modificar Datos", JOptionPane.QUESTION_MESSAGE, null, subMenu, subMenu[0]);
                        
                        switch(opcSubMenu){
                            case "1. Modificar Número de Cuenta":
                                numero = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Ingresa el  nuevo número de cuenta","Modificar Número de Cuenta",JOptionPane.QUESTION_MESSAGE));
                                cuenta.setNumeroCuenta(numero);
                                break;
                            case "2. Modificar Nombre del Cliente":
                                nombreCliente = JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre del cliente",
                                            "Modificar Nombre del Cliente",JOptionPane.QUESTION_MESSAGE);
                                cuenta.setNombreCliente(nombreCliente);
                                break;
                            case "3. Modificar Domicilio":
                                domicilio = JOptionPane.showInputDialog(null,"Ingresa el nuevo domicilio",
                                            "Modificar Domicilio",JOptionPane.QUESTION_MESSAGE);
                                cuenta.setDomicilio(domicilio);
                                break;
                            case "4. Modificar Fecha de Nacimiento":  
                                fechaNacimiento = JOptionPane.showInputDialog(null,"Ingresa la nueva fecha de nacimientp",
                                                    "Modificar Fecha de Nacimiento",JOptionPane.QUESTION_MESSAGE);
                                cuenta.setFechaNacimiento(fechaNacimiento);
                                break;
                            case "5. Modificar Fecha de Apertura":
                                fechaApertura = JOptionPane.showInputDialog(null,"Ingresa la nueva fecha de apertura",
                                                "Modificar Fecha de Apertura",JOptionPane.QUESTION_MESSAGE);
                                cuenta.setFechaApertura(fechaApertura);
                                break;
                            case "6. Modificar Nombre de la Sucursal":
                                nombreSucursal = JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre de la sucursal",
                                                 "Modificar Nombre de la Sucursal",JOptionPane.QUESTION_MESSAGE);
                                cuenta.setNombreSucursal(nombreSucursal);
                                break;
                            case "7. Regresar":
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "No es una opcion válida", null, JOptionPane.WARNING_MESSAGE );
                        }
                    }while(!opcSubMenu.equals("7. Regresar"));
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
