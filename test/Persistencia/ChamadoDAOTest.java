package Persistencia;

import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.Tecnico;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitória
 */
public class ChamadoDAOTest {

    // testa se um chamado é inserido, verificando se ele já existia antes (nesse caso não deve ser inserido) 
    @Test
    public void inserirVerificandoAmbiguidadesChamadoDAOTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamBd = new Chamado("Titulo do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "MySql");
        ChamadoDAO chamDAO = new ChamadoDAO();
        chamBd.setCodigo(chamDAO.gerarCodigo());
        boolean achou = false;
        if (!chamDAO.getChamados().isEmpty()) {
            Iterator itr = chamDAO.getChamados().iterator();
            while (itr.hasNext()) {
                Chamado cham = (Chamado) itr.next();
                if (cham.equals(chamBd)) {
                    achou = true;
                }
            }
        }
        int tamanhoAntes = chamDAO.getChamados().size();
        chamDAO.put(chamBd);
        if (achou) {
            assertEquals(tamanhoAntes, chamDAO.getChamados().size());
        } else {
            assertEquals(chamBd, chamDAO.get(chamDAO.getChamados().size()));
        }

    }

    @Test(expected = Exception.class)
    public void inserirChamadoDAONuloTest() throws Exception {
        ChamadoDAO chamDAO = new ChamadoDAO();
        chamDAO.put(null);
    }

    /* 
     O teste a seguir é adequado, mas não ideal. 
     Idealmente, para testar a persistencia o arquivo seria lido e convertido
     em um HashMap com os objetos, e então a verificação da persistência
     seria feita de acordo com os atributos do objeto Chamado.
     Após tentativas frustradas de conversão do arquivo .dat, em um objeto HashMap o 
     teste foi implementado desse forma para que pudesse ao menos passar por uma validação básica.
     Chamados podem ter vários atributos parecidos, mas aqui é feita uma verificação por titulos de 
     chamados (se já houver um chamado com um titulo especifico no arquivo, após a persistencia devem
     existir 2).
     */
    @Test
    public void persistirNoArquivoChamadoDAOTest() throws FileNotFoundException, IOException {

        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamBd = new Chamado("Titulo do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "MySql");
        ChamadoDAO chamDAO = new ChamadoDAO();

        FileInputStream fis = new FileInputStream("chamados.dat");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        String str = sb.toString();
        String findStr = "Titulo do chamado";
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }

        chamDAO.put(chamBd);

        FileInputStream fis2 = new FileInputStream("chamados.dat");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));
        StringBuilder sb2 = new StringBuilder();
        String line2;
        while ((line2 = br2.readLine()) != null) {
            sb2.append(line2);
        }

        String str2 = sb2.toString();
        String findStr2 = "Titulo do chamado";
        int lastIndex2 = 0;
        int count2 = 0;
        while (lastIndex2 != -1) {
            lastIndex2 = str2.indexOf(findStr2, lastIndex2);
            if (lastIndex2 != -1) {
                count2++;
                lastIndex2 += findStr2.length();
            }
        }
        assertTrue(count + 1 == count2);

    }

    @Test
    public void buscarPorCodigoChamadoDAOTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamBd = new Chamado("Titulo do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "MySql");
        ChamadoDAO chamDAO = new ChamadoDAO();
        chamDAO.put(chamBd);
        Chamado cham2 = null;
        Iterator itr = chamDAO.getChamados().iterator();
        while (itr.hasNext()) {
            Chamado cham = (Chamado) itr.next();
            if ((cham.getCodigo() == (chamDAO.gerarCodigo() - 1)) && (cham.getCodigo() == chamBd.getCodigo())) {
                cham2 = cham;
            }
        }
        assertEquals(cham2, chamBd);
    }

    // testa se um chamado é inserido, verificando se ele já existia antes (nesse caso não deve ser inserido) 
    @Test
    public void inserirVerificandoAmbiguidadesRegistroChamadoDAOTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Titulo do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        ChamadoDAO chamDAO = new ChamadoDAO();
        regCham.setCodigo(chamDAO.gerarCodigoRegistroChamado());
        boolean achou = false;
        if (!chamDAO.getRegistros().isEmpty()) {
            Iterator itr = chamDAO.getRegistros().iterator();
            while (itr.hasNext()) {
                RegistroChamado reg = (RegistroChamado) itr.next();
                if (reg.equals(regCham)) {
                    achou = true;
                }
            }
        }
        int tamanhoAntes = chamDAO.getRegistros().size();
        chamDAO.putRegistro(regCham);
        if (achou) {
            assertEquals(tamanhoAntes, chamDAO.getRegistros().size());
        } else {
            RegistroChamado reg2 = null;
            Iterator itr2 = chamDAO.getRegistros().iterator();
            while (itr2.hasNext()) {
                RegistroChamado regCham2 = (RegistroChamado) itr2.next();
                if (regCham2.getCodigo() == regCham.getCodigo()) {
                    reg2 = regCham2;
                }
            }
            assertEquals(regCham, reg2);
        }

    }

    @Test(expected = Exception.class)
    public void inserirRegistroChamadoDAONuloTest() throws Exception {
        ChamadoDAO chamDAO = new ChamadoDAO();
        chamDAO.putRegistro(null);
    }

    /* 
     O teste a seguir é adequado, mas não ideal. 
     Idealmente, para testar a persistencia o arquivo seria lido e convertido
     em um HashMap com os objetos, e então a verificação da persistência
     seria feita de acordo com os atributos do objeto RegistroChamado.
     Após tentativas frustradas de conversão do arquivo .dat, em um objeto HashMap o 
     teste foi implementado desse forma para que pudesse ao menos passar por uma validação básica.
     RegistroChamados podem ter vários atributos parecidos, mas aqui é feita uma verificação por assuntos de 
     RegistroChamados (se já houver um RegistroChamado com um assunto especifico no arquivo, após a persistencia devem
     existir 2).
     */
    @Test
    public void persistirNoArquivoRegistroChamadoDAOTest() throws FileNotFoundException, IOException {

        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Titulo do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        RegistroChamado regCham = new RegistroChamado("Assunto do registro", chamDesemp, tec);
        ChamadoDAO chamDAO = new ChamadoDAO();

        FileInputStream fis = new FileInputStream("registroChamados.dat");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        String str = sb.toString();
        String findStr = "Assunto do registro";
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }

        chamDAO.putRegistro(regCham);

        FileInputStream fis2 = new FileInputStream("registroChamados.dat");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));
        StringBuilder sb2 = new StringBuilder();
        String line2;
        while ((line2 = br2.readLine()) != null) {
            sb2.append(line2);
        }

        String str2 = sb2.toString();
        String findStr2 = "Assunto do registro";
        int lastIndex2 = 0;
        int count2 = 0;
        while (lastIndex2 != -1) {
            lastIndex2 = str2.indexOf(findStr2, lastIndex2);
            if (lastIndex2 != -1) {
                count2++;
                lastIndex2 += findStr2.length();
            }
        }
        assertTrue(count + 1 == count2);

    }

    @Test
    public void buscarPorCodigoRegistroChamadoDAOTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Titulo do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        ChamadoDAO chamDAO = new ChamadoDAO();

        chamDAO.putRegistro(regCham);

        RegistroChamado reg2 = null;
        Iterator itr2 = chamDAO.getRegistros().iterator();
        while (itr2.hasNext()) {
            RegistroChamado regCham2 = (RegistroChamado) itr2.next();
            if (regCham.getCodigo() == regCham2.getCodigo()) {
                reg2 = regCham2;
            }
        }
        assertEquals(regCham, reg2);
    }

    //teste dá erro porque o código do registro nunca é setado no metodo put
    @Test
    public void gerarCodigoRegistroChamadoDAOTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Titulo do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        ChamadoDAO chamDAO = new ChamadoDAO();

        chamDAO.putRegistro(regCham);
        boolean resultado = false;
        if (regCham.getCodigo() == chamDAO.gerarCodigoRegistroChamado() - 1) {
            resultado = true;
        }

        assertTrue(resultado);
    }

    @Test
    public void gerarCodigoChamadoDAOTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Titulo do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        ChamadoDAO chamDAO = new ChamadoDAO();

        chamDAO.put(chamDesemp);
        boolean resultado = false;
        if (chamDesemp.getCodigo() == chamDAO.gerarCodigo() - 1) {
            resultado = true;
        }
        assertTrue(resultado);
    }

}
