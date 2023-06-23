package proyectotercercliclo;

import Controlador.Control_Login;
import Controlador.ControladorMenuPrincipal;
import Vista.Login;
import Vista.MenuPrincipal;

public class ProyectoTercerCliclo {

    public static void main(String[] args) {

//////MENU************************************************
//        MenuPrincipal menu = new MenuPrincipal ();
//        ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(menu);
//        controlador.inciar();
//        menu.setVisible(true);
////        
///////////////////////////// LOGIN
////
        Login LoginPri = new Login();
        Control_Login controlador = new Control_Login(LoginPri);
        controlador.inciar();
        LoginPri.setVisible(true);
    }

}
