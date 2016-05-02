/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitória
 */
public class ControladorPrincipalTest {
    
    public ControladorPrincipalTest() {
    }

    @Test
    public void iniciarControladorPrincipalTest() {
        ControladorPrincipal controlador = new ControladorPrincipal();
        assertNotNull(controlador.getCtrChamados());
        assertNotNull(controlador.getCtrClientes());
        assertNotNull(controlador.getCtrEmpresa());
        assertNotNull(controlador.getCtrTecnicos());
        
    }
    
}
