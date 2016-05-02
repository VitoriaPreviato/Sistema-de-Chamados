/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Tecnico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitória
 */
public class ControleTecnicosTest {
    
    @Test
    public void inserirTecnicoControleTecnicoTest() {
        ControleTecnicos ct = new ControleTecnicos();
        Tecnico tec = new Tecnico("Lucas",12345678);
        Tecnico tec2 = ct.inserir(tec.getTelefone(), tec.getNome());
        assertTrue(((tec.getTelefone() == tec2.getTelefone())) && (tec.getNome().equals(tec2.getNome())));
    }  
    
}
