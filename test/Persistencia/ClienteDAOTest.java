/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidade.ClienteEmpresa;
import entidade.Empresa;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitória
 */
public class ClienteDAOTest {

    // testa se um cliente é inserido, verificando se ele já existia antes (nesse caso não deve ser inserido) 
    @Test
    public void inserirVerificandoAmbiguidadesClienteDAOTest() {
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        ClienteDAO ceDAO = new ClienteDAO();
        boolean achou = false;
        if (!ceDAO.voltaCashCliente().isEmpty()) {
            for (long key : ceDAO.voltaCashCliente().keySet()) {
                if (ceDAO.voltaCashCliente().get(key) != null) {
                    if (ceDAO.voltaCashCliente().get(key).getCpf() == 40168413824L) {
                        achou = true;
                        break;
                    }
                }
            }
        }
        int tamanhoAntes = ceDAO.voltaCashCliente().size();
        ceDAO.put(ce);
        if (achou) {
            assertEquals(tamanhoAntes, ceDAO.voltaCashCliente().size());
        } else {
            assertEquals(ce, ceDAO.get(40168413824L));
        }

    }

    @Test(expected = Exception.class)
    public void inserirClienteDAONuloTest() throws Exception {
        ClienteDAO ceDAO = new ClienteDAO();
        ceDAO.put(null);
    }

    /* 
     O teste a seguir é adequado, mas não ideal. 
     Idealmente, para testar a persistencia o arquivo seria lido e convertido
     em um HashMap com os objetos, e então a verificação da persistência
     seria feita de acordo com os atributos desse objeto.
     Após tentativas frustradas de conversão do arquivo .dat em um objeto HashMap,
     o teste foi implementado desse forma para que pudesse ao menos passar por uma validação básica,
     Como é permitido adicionar cliente de mesmo nome (desde que tenham CPF diferente), são contadas 
     as ocorrencia desse nome no arquivo para comparação.
     */
    @Test
    public void persistirVerificandoAmbiguidadesNoArquivoClienteDAOTest() throws FileNotFoundException, IOException {
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413827L, "Rafael", 12123434);
        ClienteDAO ceDAO = new ClienteDAO();
        
        boolean achou=false;
        if(ceDAO.voltaCashCliente().containsKey(40168413827L)){
            achou=true;
        }

        FileInputStream fis = new FileInputStream("clientes.dat");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        
        String str = sb.toString();
        String findStr = "Rafael";
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }
        
        ceDAO.put(ce);

        FileInputStream fis2 = new FileInputStream("clientes.dat");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));
        StringBuilder sb2 = new StringBuilder();
        String line2;
        while ((line2 = br2.readLine()) != null) {
            sb2.append(line2);
        }
        
        String str2 = sb2.toString();
        String findStr2 = "Rafael";
        int lastIndex2 = 0;
        int count2 = 0;
        while (lastIndex2 != -1) {
            lastIndex2 = str2.indexOf(findStr2, lastIndex2);
            if (lastIndex2 != -1) {
                count2++;
                lastIndex2 += findStr2.length();
            }
        }

        if (achou) {
            assertEquals(sb.toString(), sb2.toString());
        } else {
            assertTrue(count+1 == count2);
        }
    }

    @Test
    public void buscarPorCpfClienteDAOTest() {
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        ClienteDAO ceDAO = new ClienteDAO();
        ceDAO.put(ce);
        ClienteEmpresa ce2 = ceDAO.voltaCashCliente().get((long) 40168413824L);
        assertEquals(ce, ce2);
    }
    
    @Test
    public void gerarCodigoClienteDAOTest() {
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        ClienteDAO ceDAO = new ClienteDAO();
        ceDAO.put(ce);        
        assertEquals((long)ce.getCodigo(),(long)ceDAO.voltaCashCliente().size()+1);
    }
    

}
