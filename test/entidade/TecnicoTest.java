package entidade;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class TecnicoTest {    

    @Test
    public void cadastrarTecnicoTest() {
        Tecnico t = new Tecnico("Lucas",12345678);
        assertEquals("Lucas", t.getNome());
        assertEquals(12345678, t.getTelefone());
    }    
    
    @Test (expected = Exception.class)
    public void cadastrarTecnicoTelefoneInvalidoTest() throws Exception{
        Tecnico t = new Tecnico("Lucas",-12345678);   
    }
    
    @Test (expected = Exception.class)
    public void cadastrarTecnicoSemNomeTest() throws Exception{
        Tecnico t = new Tecnico(null,12345678);              
    }
    
    @Test
    public void alterarNomeTecnicoTest(){
        Tecnico t = new Tecnico("Lucas",12345678);       
        t.setNome("João");              
        assertEquals("João", t.getNome());
    }
    
    @Test (expected = Exception.class)
    public void alterarNomeInvalidoTecnicoTest() throws Exception{
        Tecnico t = new Tecnico("Lucas",12345678);
        t.setNome(null);
    }
    
    @Test
    public void alterarTelefoneTecnicoTest(){
        Tecnico t = new Tecnico("Lucas",12345678);        
        t.setTelefone(876543212);              
        assertEquals(876543212, t.getTelefone());
    }
    
    @Test (expected = Exception.class)
    public void alterarTelefoneInvalidoTecnicoTest() throws Exception{
        Tecnico t = new Tecnico("Lucas",12345678);
        t.setTelefone(-12345678);
    }
    
}
