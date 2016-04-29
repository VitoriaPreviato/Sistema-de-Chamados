package entidade;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class EmpresaTest {

    @Test
    public void cadastrarEmpresaTest() {
        Empresa e = new Empresa(123, "Google");
        assertEquals("Google", e.getNomeEmpresa());
        assertEquals(123, e.getNumeroContrato());
    }
    
    @Test (expected = Exception.class)
    public void cadastrarEmpresaNumeroContratoInvalidoTest() throws Exception{
         Empresa e = new Empresa(-123, "Google");  
    }
    
    @Test (expected = Exception.class)
    public void cadastrarEmpresaNomeInvalidoTest() throws Exception{
         Empresa e = new Empresa(123, null);  
    }

    @Test
    public void alterarNomeEmpresaTest() {
        Empresa e = new Empresa(123, "Google");
        e.setNomeEmpresa("Intel");
        assertEquals("Intel", e.getNomeEmpresa());
    }
    
    @Test (expected = Exception.class)
    public void alterarNomeInvalidoEmpresaTest() throws Exception{
        Empresa e = new Empresa(123, "Google");
        e.setNomeEmpresa(null);
    }

    @Test
    public void alterarNumeroContratoEmpresaTest() {
        Empresa e = new Empresa(123, "Google");
        e.setNumeroContrato(456);
        assertEquals(456, e.getNumeroContrato());
    }
    
    @Test (expected = Exception.class)
    public void alterarNumeroContratoInvalidoEmpresaTest() throws Exception{
        Empresa e = new Empresa(123, "Google");
        e.setNumeroContrato(-123);        
    }

}
