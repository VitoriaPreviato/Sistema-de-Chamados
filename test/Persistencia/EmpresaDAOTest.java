
package Persistencia;

import entidade.Empresa;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitória
 */
public class EmpresaDAOTest {
    
    // testa se uma empresa é inserida, verificando se ela já existia antes (nesse caso não deve ser inserida) 
    @Test
    public void inserirVerificandoAmbiguidadesEmpresaDAOTest() {
        EmpresaDAO empDAO = new EmpresaDAO();
        Empresa emp = new Empresa(123, "Google");
        boolean achou = false;
        if (!empDAO.voltaEmpresa().isEmpty()) {
            for (long key : empDAO.voltaEmpresa().keySet()) {
                if (empDAO.voltaEmpresa().get(key)!= null) {
                    if (empDAO.voltaEmpresa().get(key).getNumeroContrato() == 123 || empDAO.voltaEmpresa().get(key).getNomeEmpresa() == "Google") {
                        achou = true;
                        break;
                    }
                }
            }
        }
        int tamanhoAntes = empDAO.voltaEmpresa().size();
        empDAO.put(emp);
        if (achou) {
            assertEquals(tamanhoAntes, empDAO.voltaEmpresa().size());
        } else {
            assertTrue(empDAO.getEmpresas().contains(emp));
        }

    }
    
    @Test (expected = Exception.class)
    public void inserirEmpresaDAONulaTest() throws Exception {
        EmpresaDAO empDAO = new EmpresaDAO();
        empDAO.put(null);
    }    
    
    /* 
     O teste a seguir é adequado, mas não ideal. 
     Idealmente, para testar a persistencia o arquivo seria lido e convertido
     em um HashMap com os objetos, e então a verificação da persistência
     seria feita de acordo com o nome da empresa e seu contrato.
     Após tentativas frustradas de conversão do arquivo .dat em um objeto HashMap,
     o teste foi implementado desse forma para que pudesse ao menos passar por uma validação básica.
     O teste abaixo testa se é possivel adicionar uma empresa com nome ou contrato já existentes, 
     e falha porque é feita uma tentativa de inserir uma empresa com nome diferente mas contrato já existente, 
     e a inserção é permitida.
     */
    @Test
    public void persistirVerificandoAmbiguidadesNoArquivoEmpresaDAOTest() throws FileNotFoundException, IOException {
        EmpresaDAO empDAO1 = new EmpresaDAO();
        Empresa emp1 = new Empresa(123, "Google");
        empDAO1.put(emp1);
        
        EmpresaDAO empDAO = new EmpresaDAO();
        Empresa emp = new Empresa(123, "IBM");
        
        FileInputStream fis = new FileInputStream("empresas.dat");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        
        boolean achou=false;
        if(sb.toString().contains("IBM") || empDAO.voltaEmpresa().containsKey((long)123)){
           achou=true;
        }
        
        empDAO.put(emp);
        
        FileInputStream fis2 = new FileInputStream("empresas.dat");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));
        StringBuilder sb2 = new StringBuilder();
        String line2;
        while ((line2 = br2.readLine()) != null) {
            sb2.append(line2);
        }
        
        if (achou) {
            assertEquals(sb.toString(), sb2.toString());
        } else {
            assertTrue(sb2.toString().contains("IBM"));
        }
    }
    
     @Test
    public void buscarPorCodigoEmpresaDAOTest() {
        EmpresaDAO empDAO = new EmpresaDAO();
        Empresa emp = new Empresa(123, "IBM");
        empDAO.put(emp);
        Empresa emp2 = empDAO.voltaEmpresa().get((long)123);
        assertEquals(emp, emp2);
    }
    
}
