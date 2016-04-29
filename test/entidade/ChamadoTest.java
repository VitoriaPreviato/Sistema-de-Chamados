package entidade;

import java.text.DateFormat;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class ChamadoTest {

    //teste dá erro pois o código não é setado no Chamado, apesar de dar a entender que é. 
    //Ele nem sequer é usado no corpo do método
    @Test
    public void cadastrarChamadoProblemaRedeTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamRede = new Chamado(01, "Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "CaboModen", "172.16.0.0");
        assertEquals(01, chamRede.getCodigo());
        assertEquals("Título do chamado", chamRede.getTitulo());
        assertEquals("Descrição do chamado", chamRede.getDescricao());
        assertEquals(2, chamRede.getPrioridade());
        assertEquals(tec, chamRede.getTecnico());
        assertEquals(clienteEmp, chamRede.getCliente());
        assertEquals("WINDOWS", chamRede.getSistemaOperacional());
        assertEquals("Vista", chamRede.getVersaoSO());
        assertEquals("CaboModen", chamRede.getTipoConexao());
        assertEquals("172.16.0.0", chamRede.getEnderecoRede());
        assertNotNull(chamRede.getData());
        assertNotNull(chamRede.getHora());
        assertEquals("Iniciado", chamRede.getStatus());
        assertEquals("Problema de Rede", chamRede.getTipoProblema());
    }

    @Test
    public void cadastrarChamadoProblemaBancoDeDadosTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamBd = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "MySql");
        assertEquals("Título do chamado", chamBd.getTitulo());
        assertEquals("Descrição do chamado", chamBd.getDescricao());
        assertEquals(2, chamBd.getPrioridade());
        assertEquals(tec, chamBd.getTecnico());
        assertEquals(clienteEmp, chamBd.getCliente());
        assertEquals("WINDOWS", chamBd.getSistemaOperacional());
        assertEquals("Vista", chamBd.getVersaoSO());
        assertEquals("MySql", chamBd.getBancoDeDados());
        assertNotNull(chamBd.getData());
        assertNotNull(chamBd.getHora());
        assertEquals("iniciado", chamBd.getStatus());
        assertEquals("Banco de Dados", chamBd.getTipoProblema());
    }

    @Test
    public void cadastrarChamadoProblemaDesempenhoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        assertEquals("Título do chamado", chamDesemp.getTitulo());
        assertEquals("Descrição do chamado", chamDesemp.getDescricao());
        assertEquals(2, chamDesemp.getPrioridade());
        assertEquals(tec, chamDesemp.getTecnico());
        assertEquals(clienteEmp, chamDesemp.getCliente());
        assertEquals("WINDOWS", chamDesemp.getSistemaOperacional());
        assertEquals("Vista", chamDesemp.getVersaoSO());
        assertEquals("Operação realizada", chamDesemp.getOperacao());
        assertEquals(20.0, chamDesemp.getDuracaoOperacao(), 0);
        assertNotNull(chamDesemp.getData());
        assertNotNull(chamDesemp.getHora());
        assertEquals("Iniciado", chamDesemp.getStatus());
        assertEquals("Problema de Desempenho", chamDesemp.getTipoProblema());
    }

    @Test
    public void alterarCodigoChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setCodigo(1);
        assertEquals(1, chamado.getCodigo());
    }

    @Test
    public void alterarTecnicoChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        Tecnico tec2 = new Tecnico("Bruno", 11122233);
        chamado.setTecnico(tec2);
        assertEquals(tec2, chamado.getTecnico());
    }

    @Test
    public void alterarClienteChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        ClienteEmpresa clienteEmp2 = new ClienteEmpresa(002, emp, 78936925677L, "Ricardo", 96320578);
        chamado.setCliente(clienteEmp2);
        assertEquals(clienteEmp2, chamado.getCliente());
    }

    @Test
    public void alterarStatusChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setStatus("em_atendimento");
        assertEquals("em_atendimento", chamado.getStatus());
    }

    @Test
    public void alterarTipoProblemaChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setTipoProblema("Banco de Dados");
        assertEquals("Banco de Dados", chamado.getTipoProblema());
    }

    @Test
    public void alterarDataChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setData("02/01/2016");
        assertEquals("02/01/2016", chamado.getData());
    }

    @Test
    public void alterarHoraChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setHora("17:10:12");
        assertEquals("17:10:12", chamado.getHora());
    }

    @Test
    public void alterarTituloChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setTitulo("Titulo do chamado 2");
        assertEquals("Titulo do chamado 2", chamado.getTitulo());
    }

    @Test
    public void alterarDescricaoChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setDescricao("Descrição do chamado 2");
        assertEquals("Descrição do chamado 2", chamado.getDescricao());
    }

    @Test
    public void alterarPrioridadeChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setPrioridade(1);
        assertEquals(1, chamado.getPrioridade());
    }

    @Test
    public void alterarSistemaOperacionalChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setSistemaOperacional("Linux");
        assertEquals("Linux", chamado.getSistemaOperacional());
    }

    @Test
    public void alterarVersaoSOChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setVersaoSO("XP");
        assertEquals("XP", chamado.getVersaoSO());
    }

    @Test
    public void alterarBancoDeDadosChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamBd = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "MySql");
        chamBd.setBancoDeDados("Oracle");
        assertEquals("Oracle", chamBd.getBancoDeDados());
    }

    @Test
    public void alterarCausaProblemaChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setCausaProblema("Mau uso");
        assertEquals("Mau uso", chamado.getCausaProblema());
    }

    @Test
    public void alterarSolucaoProblemaChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado.setSolucaoProblema("Desligar e ligar o computador");
        assertEquals("Desligar e ligar o computador", chamado.getSolucaoProblema());
    }

    @Test
    public void alterarTipoConexaoChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamRede = new Chamado(01, "Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "CaboModen", "172.16.0.0");
        chamRede.setTipoConexao("Radio");
        assertEquals("Radio", chamRede.getTipoConexao());
    }

    @Test
    public void alterarEnderecoRedeChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamRede = new Chamado(01, "Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "CaboModen", "172.16.0.0");
        chamRede.setEnderecoRede("123.36.23.5");
        assertEquals("123.36.23.5", chamRede.getEnderecoRede());
    }

    @Test
    public void alterarOperacaoChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setOperacao("Operação a ser realizada");
        assertEquals("Operação a ser realizada", chamDesemp.getOperacao());
    }
    
    @Test
    public void alterarDuracaoOperacaoChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setDuracaoOperacao(30.0);
        assertEquals(30.0, chamDesemp.getDuracaoOperacao(),0);
    }

    @Test
    public void verificarChamadosIguaisPorCodigoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado1 = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        Chamado chamado2 = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado1.setCodigo(1);
        chamado2.setCodigo(1);
        assertEquals(true, chamado1.equals(chamado2));
        chamado2.setCodigo(2);
        assertEquals(false, chamado1.equals(chamado2));
    }

    @Test
    public void verificarChamadosIguaisPorDataTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado1 = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        Chamado chamado2 = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado1.setCodigo(1);
        chamado2.setCodigo(1);
        assertEquals(true, chamado1.equals(chamado2));
        chamado2.setData("01/01/2016");
        assertEquals(false, chamado1.equals(chamado2));
    }

    @Test
    public void verificarChamadosIguaisPorTituloTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamado1 = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        Chamado chamado2 = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamado1.setCodigo(1);
        chamado2.setCodigo(1);
        assertEquals(true, chamado1.equals(chamado2));
        chamado2.setTitulo("Titulo do chamado 2");
        assertEquals(false, chamado1.equals(chamado2));
    }

}
