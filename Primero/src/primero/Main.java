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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Object menu[] = {"1. Iniciar Objeto","2. Consultar Fecha","3. Cuantos dias tiene el mes",
        "4. Es año bisiesto","5. Modificar Fecha","6. Salir"};
        Object subMenu[] = {"1. Modificar Dia","2. Modificar Mes","3. Modificar Año","4. Regresar"};
        int dia = 0, mes = 0, año = 0;
        Fecha hoy = new Fecha();
        String opcMenu = "";
        do{
            opcMenu = (String) JOptionPane.showInputDialog(null,"Elige una opción","Menú",
                    JOptionPane.QUESTION_MESSAGE, null, menu,menu[0]);
            switch(opcMenu){
                case (String) "1. Iniciar Objeto":
                    dia = Integer.parseInt(JOptionPane.showInputDialog(null,"Dame el dia",
                            "Fecha",JOptionPane.QUESTION_MESSAGE));
                    
                    mes = Integer.parseInt(JOptionPane.showInputDialog(null,"Dame el mes",
                            "Fecha",JOptionPane.QUESTION_MESSAGE));
                    
                    año = Integer.parseInt(JOptionPane.showInputDialog(null,"Dame el año",
                            "Fecha",JOptionPane.QUESTION_MESSAGE));
                    hoy.setDia(dia);
                    hoy.setMes(mes);
                    hoy.setAño(año);
                    break;
                case (String) "2. Consultar Fecha":
                    
                    JOptionPane.showMessageDialog(null, "La fecha de hoy es:" + hoy.fechaConFormato() );
                    
                    break;
                case (String) "3. Cuantos dias tiene el mes":
                    
                    JOptionPane.showMessageDialog(null, "El mes tiene "+ hoy.diasMes() + " dias");
                   
                    break;
                case (String) "4. Es año bisiesto":
                    if(hoy.isBisiesto()){
                        JOptionPane.showMessageDialog(null, "El año " +hoy.getAño() + " es bisiesto");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "El año " +hoy.getAño() + " no es bisiesto");
                    }
                    break;
                    
                case (String) "5. Modificar Fecha":
                    String opcSubMenu = "";
                    do{
                        opcSubMenu = (String)JOptionPane.showInputDialog(null, "Elige una opción", 
                                "Modificar Fecha", JOptionPane.QUESTION_MESSAGE, null, subMenu, subMenu[0]);
                        
                        switch(opcSubMenu){
                            case (String) "1. Modificar Dia":
                                dia = Integer.parseInt(JOptionPane.showInputDialog(null,"Dame el dia",
                                "Fecha",JOptionPane.QUESTION_MESSAGE));
                                hoy.setDia(dia);
                                break;
                            case (String)"2. Modificar Mes":
                                mes = Integer.parseInt(JOptionPane.showInputDialog(null,"Dame el mes",
                                "Fecha",JOptionPane.QUESTION_MESSAGE));
                                hoy.setMes(mes);
                                break;
                            case (String)"3. Modificar Año":
                                año = Integer.parseInt(JOptionPane.showInputDialog(null,"Dame el año",
                                "Fecha",JOptionPane.QUESTION_MESSAGE));
                                hoy.setAño(año);
                                break;
                            case (String)"4. Regresar":
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "No es una opción válida");
                        }
                    }while(!opcSubMenu.equals("4. Regresar"));
                    break;
                case (String) "6. Salir":
                    JOptionPane.showMessageDialog(null, "Gracias, hasta la vista");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No es una opción válida");
            }
        } while(!opcMenu.equals("6. Salir"));
    }
}
