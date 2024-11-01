
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Biblioteca;
import modelo.CrudBiblioteca;
import vista.Vista_gestionBiblioteca;
import vista.Vista_principal;

public class CtrlPrincipal implements MouseListener{
    
    private final Vista_principal vistaPrincipal;

    public CtrlPrincipal(Vista_principal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        
        //Este escuchador no funciona
        this.vistaPrincipal.btn_biblio.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    /*    JOptionPane.showMessageDialog(null,"Hizo click al boton");
        if(e.getSource() == vistaPrincipal.btn_biblio){
            
            Biblioteca mod = new Biblioteca();
            CrudBiblioteca modCrud = new CrudBiblioteca();
            Vista_gestionBiblioteca vis = new Vista_gestionBiblioteca();
        
            CtrlBiblioteca ctrl = new CtrlBiblioteca(mod, modCrud, vis);
            ctrl.iniciar();
            vis.setVisible(true);
        }*/
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    //    JOptionPane.showMessageDialog(null,"Presiono el boton");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    //    JOptionPane.showMessageDialog(null,"Libero el boton");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    //    JOptionPane.showMessageDialog(null,"Entro en el boton");
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    //    JOptionPane.showMessageDialog(null,"Salio del boton");
    }
  
}
