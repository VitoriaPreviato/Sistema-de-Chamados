/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidade.Tecnico;
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
public class TecnicoDAOTest {

    // testa se um técnico é inserido, verificando se ele já existia antes (nesse caso não deve ser inserido) 
    @Test
    public void inserirVerificandoAmbiguidadesTecnicoDAOTest() {
        TecnicoDAO tecDAO = new TecnicoDAO();
        Tecnico tec = new Tecnico("Lucas", 12345678);
        boolean achou = false;
        if (!tecDAO.voltaCashTecnico().isEmpty()) {
            for (int key : tecDAO.voltaCashTecnico().keySet()) {
                if (tecDAO.voltaCashTecnico().get(key)!= null) {
                    if (tecDAO.voltaCashTecnico().get(key).getNome().equalsIgnoreCase("Lucas")) {
                        achou = true;
                        break;
                    }
                }
            }
        }
        int tamanhoAntes = tecDAO.voltaCashTecnico().size();
        tecDAO.put(tec);
        if (achou) {
            assertEquals(tamanhoAntes, tecDAO.voltaCashTecnico().size());
        } else {
            assertEquals(tec, tecDAO.get(tecDAO.voltaCashTecnico().size() + 1));
        }

    }

    @Test(expected = Exception.class)
    public void inserirTecnicoDAONuloTest() throws Exception {
        TecnicoDAO tecDAO = new TecnicoDAO();
        tecDAO.put(null);
    }

    /* 
     O teste a seguir é adequado, mas não ideal. 
     Idealmente, para testar a persistencia o arquivo seria lido e convertido
     em um HashMap com os objetos, e então a verificação da persistência
     seria feita de acordo com o nome do técnico e seu código, que se relaciona
    com a posição deste no HashMap.
     Após tentativas frustradas de conversão do arquivo .dat, em um objeto HashMap o 
     teste foi implementado desse forma para que pudesse ao menos passar por uma validação básica.
     Caso não fosse permitido inserir técnicos com nomes iguais, assim como não é 
     permitido inserir empresas com nomes iguais por exemplo, esse teste não 
     seria um teste ruim, apesar de ainda assim não ser ideal (para que fosse, uma verificação
     completa do objeto deveria ser feita).
     */
    @Test
    public void persistirVerificandoAmbiguidadesNoArquivoTecnicoDAOTest() throws FileNotFoundException, IOException {
        TecnicoDAO tecDAO = new TecnicoDAO();
        Tecnico tec = new Tecnico("Lucas", 12345678);
        
        FileInputStream fis = new FileInputStream("tecnicos.dat");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        
        boolean achou=false;
        if(sb.toString().contains("Lucas")){
           achou=true;
        }
        
        tecDAO.put(tec);
        
        FileInputStream fis2 = new FileInputStream("tecnicos.dat");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));
        StringBuilder sb2 = new StringBuilder();
        String line2;
        while ((line2 = br2.readLine()) != null) {
            sb2.append(line2);
        }
        
        if (achou) {
            assertEquals(sb.toString(), sb2.toString());
        } else {
            assertTrue(sb2.toString().contains("Lucas"));
        }
    }

    @Test
    public void gerarCodigoTecnicoDAOTest() {
        TecnicoDAO tecDAO = new TecnicoDAO();
        assertEquals(tecDAO.voltaCashTecnico().size() + 1, tecDAO.gerarCodigo());
    }

    @Test
    public void buscarPorCodigoTecnicoDAOTest() {
        TecnicoDAO tecDAO = new TecnicoDAO();
        Tecnico tec = new Tecnico("Lucas", 12345678);
        tecDAO.put(tec);
        Tecnico tec2 = tecDAO.get(tecDAO.gerarCodigo() - 1);
        assertEquals(tec, tec2);
    }

}
