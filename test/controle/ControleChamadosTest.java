/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Persistencia.ChamadoDAO;
import entidade.Chamado;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import entidade.RegistroChamado;
import entidade.Status;
import entidade.Tecnico;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitória
 */
public class ControleChamadosTest {
    
    @Test
    public void alterarChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        ControleChamados ctCham = new ControleChamados();
        Chamado chamado = ctCham.InserirChamadoDesempenho(chamDesemp.getTitulo(), chamDesemp.getDescricao(), chamDesemp.getPrioridade(), chamDesemp.getTecnico(), chamDesemp.getCliente(), chamDesemp.getSistemaOperacional(), chamDesemp.getVersaoSO(), chamDesemp.getOperacao(), chamDesemp.getDuracaoOperacao());
        ctCham.alterarChamado(chamado, ""+Status.sem_solucao , "Não é suportado pela versão atual", "Não existe solução");
        assertEquals(chamado.getStatus(),"sem_solucao" );
        assertEquals(chamado.getCausaProblema(),"Não é suportado pela versão atual");
        assertEquals(chamado.getSolucaoProblema(),"Não existe solução");
    }
    
    @Test
    public void inserirChamadoRedeControleChamadosTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamRede = new Chamado(01, "Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "CaboModen", "172.16.0.0");
        ControleChamados ctCham = new ControleChamados();
        Chamado chamado = ctCham.InserirChamadoRede(chamRede.getTitulo(), chamRede.getDescricao(), chamRede.getPrioridade(), chamRede.getTecnico(), chamRede.getCliente(), chamRede.getSistemaOperacional(), chamRede.getVersaoSO(), chamRede.getTipoConexao(), chamRede.getEnderecoRede());
        Chamado chamado2 = ctCham.buscaPeloCodigo(chamado.getCodigo());
        assertTrue((chamado.getTitulo().equals(chamado2.getTitulo())) && (chamado.getDescricao().equals(chamado2.getDescricao())) && (chamado.getPrioridade() == chamado2.getPrioridade()) && ((chamado.getTecnico().getNome().equals(chamado2.getTecnico().getNome())) && (chamado.getTecnico().getTelefone() == chamado2.getTecnico().getTelefone())) && (chamado.getCliente().getCpf() == chamado2.getCliente().getCpf()) && (chamado.getSistemaOperacional().equals(chamado2.getSistemaOperacional())) && (chamado.getVersaoSO().equals(chamado2.getVersaoSO())) && (chamado.getTipoConexao().equals(chamado2.getTipoConexao())) && (chamado.getEnderecoRede().equals(chamado2.getEnderecoRede())));
    }

    @Test
    public void inserirChamadoBancoDeDadosTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamBd = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "MySql");
        ControleChamados ctCham = new ControleChamados();
        Chamado chamado = ctCham.InserirChamadoBancoDeDados(chamBd.getTitulo(), chamBd.getDescricao(), chamBd.getPrioridade(), chamBd.getTecnico(), chamBd.getCliente(), chamBd.getSistemaOperacional(), chamBd.getVersaoSO(), chamBd.getBancoDeDados());
        Chamado chamado2 = ctCham.buscaPeloCodigo(chamado.getCodigo());
        assertTrue((chamado.getTitulo().equals(chamado2.getTitulo())) && (chamado.getDescricao().equals(chamado2.getDescricao())) && (chamado.getPrioridade() == chamado2.getPrioridade()) && ((chamado.getTecnico().getNome().equals(chamado2.getTecnico().getNome())) && (chamado.getTecnico().getTelefone() == chamado2.getTecnico().getTelefone())) && (chamado.getCliente().getCpf() == chamado2.getCliente().getCpf()) && (chamado.getSistemaOperacional().equals(chamado2.getSistemaOperacional())) && (chamado.getVersaoSO().equals(chamado2.getVersaoSO())) && (chamado.getBancoDeDados().equals(chamado2.getBancoDeDados())));
    }

    @Test
    public void inserirChamadoDesempenhoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        ControleChamados ctCham = new ControleChamados();
        Chamado chamado = ctCham.InserirChamadoDesempenho(chamDesemp.getTitulo(), chamDesemp.getDescricao(), chamDesemp.getPrioridade(), chamDesemp.getTecnico(), chamDesemp.getCliente(), chamDesemp.getSistemaOperacional(), chamDesemp.getVersaoSO(), chamDesemp.getOperacao(), chamDesemp.getDuracaoOperacao());
        Chamado chamado2 = ctCham.buscaPeloCodigo(chamado.getCodigo());
        assertTrue((chamado.getTitulo().equals(chamado2.getTitulo())) && (chamado.getDescricao().equals(chamado2.getDescricao())) && (chamado.getPrioridade() == chamado2.getPrioridade()) && ((chamado.getTecnico().getNome().equals(chamado2.getTecnico().getNome())) && (chamado.getTecnico().getTelefone() == chamado2.getTecnico().getTelefone())) && (chamado.getCliente().getCpf() == chamado2.getCliente().getCpf()) && (chamado.getSistemaOperacional().equals(chamado2.getSistemaOperacional())) && (chamado.getVersaoSO().equals(chamado2.getVersaoSO())) && (chamado.getOperacao().equals(chamado2.getOperacao())) && (chamado.getDuracaoOperacao() == chamado2.getDuracaoOperacao()));
    }

    @Test
    public void inserirRegistroChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        ControleChamados ctCham = new ControleChamados();
        chamDesemp.setCodigo(1);
        RegistroChamado registro = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        RegistroChamado registro2 = ctCham.inserirRegistroChamado(registro.getAssunto(), registro.getChamado(), registro.getTecnico());
        assertTrue((registro.getAssunto().equals(registro2.getAssunto())) && (registro.getChamado().equals(registro2.getChamado())) && (registro.getChamado().equals(registro2.getChamado())) );
    }
    
    @Test
    public void contarQtdChamadosClienteControleChamados() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(004, emp, 401222824L, "Gilda", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado de desempenho", "Descrição do chamado 1", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        Chamado chamBd = new Chamado("Título do chamado de BD", "Descrição do chamado 2", 2, tec, clienteEmp, "WINDOWS", "Vista", "MySql");
        ControleChamados ctCham = new ControleChamados();
        ctCham.InserirChamadoDesempenho(chamDesemp.getTitulo(), chamDesemp.getDescricao(), chamDesemp.getPrioridade(), chamDesemp.getTecnico(), chamDesemp.getCliente(), chamDesemp.getSistemaOperacional(), chamDesemp.getVersaoSO(), chamDesemp.getOperacao(), chamDesemp.getDuracaoOperacao());
        ctCham.InserirChamadoBancoDeDados(chamBd.getTitulo(), chamBd.getDescricao(), chamBd.getPrioridade(), chamBd.getTecnico(), chamBd.getCliente(), chamBd.getSistemaOperacional(), chamBd.getVersaoSO(), chamBd.getBancoDeDados());
        assertEquals(2,ctCham.validarQtdChamados(clienteEmp));
    }
    
    @Test
    public void detalhesChamadoControleChamadosTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(004, emp, 401222824L, "Gilda", 12123434);
        Chamado c = new Chamado("Título do chamado de desempenho", "Descrição do chamado 1", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        
        String detalhes = "\n" + "--------" + "\n" + "Data de abertura do chamado: "
                + c.getData() + "\n" + "Hororio de abertura do chamado: " + c.getHora() + "\n"
                + "Titulo do chamado: " + "Título do chamado de desempenho" + "\n" + "Descri??o do chamado: " + "Descrição do chamado 1" + "\n"
                + "Prioridade do chamado" + "2" + "\n" + "Status do chamado: " + "Iniciado" + "\n"
                + "Tipo de problema do chamado: " + "Problema de Desempenho" + "\n" + "Tecnico responsovel pelo chamado: "
                + "Lucas" + "\n" + "Cliente requisitor do chamado: " + "Contrato: " + "123"
                + " - Nome Empresa:" + "Google" + " - Cliente: "
                + "401222824" + " - " + "Gilda" + "\n";
        ControleChamados ctCham = new ControleChamados();
        assertEquals(detalhes, ctCham.retornaDetalhesChamado(c));
        System.out.println(ctCham.retornaDetalhesChamado(c));

    }
    
    
    
    
}
