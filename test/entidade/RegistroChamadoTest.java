package entidade;

import java.text.DateFormat;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class RegistroChamadoTest {

    @Test
    public void cadastrarRegistroChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        assertNotNull(regCham.getData());
        assertNotNull(regCham.getHora());
        assertEquals("Cliente reclama de problema de desempenho.", regCham.getAssunto());
        assertEquals(tec, regCham.getTecnico());
        assertEquals(chamDesemp, regCham.getChamado());
    }

    @Test(expected = Exception.class)
    public void cadastrarRegistroChamadoAssuntoInvalidoTest() throws Exception {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado(null, chamDesemp, tec);
    }

    @Test(expected = Exception.class)
    public void cadastrarRegistroChamadoChamInvalidoTest() throws Exception {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", null, tec);
    }

    @Test(expected = Exception.class)
    public void cadastrarRegistroChamadoTecnicoInvalidoTest() throws Exception {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, null);
    }

    @Test
    public void alterarCodigoRegistroChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setCodigo(0001);
        assertEquals((Integer) 0001, regCham.getCodigo());
    }

    @Test(expected = Exception.class)
    public void alterarCodigoInvalidoRegistroChamadoTest() throws Exception {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setCodigo(-0001);
    }

    @Test(expected = Exception.class)
    public void alterarCodigoNuloRegistroChamadoTest() throws Exception {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setCodigo(null);
    }

    @Test
    public void alterarChamadoRegistroChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        Chamado chamBd = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "MySql");
        chamBd.setCodigo(2);
        regCham.setChamado(chamBd);
        assertEquals(chamBd, regCham.getChamado());
    }

    @Test(expected = Exception.class)
    public void alterarChamadoInvalidoRegistroChamadoTest() throws Exception {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setChamado(null);
    }

    @Test
    public void alterarTecnicoRegistroChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        Tecnico tec2 = new Tecnico("Bruno", 87654321);
        regCham.setTecnico(tec2);
        assertEquals(tec2, regCham.getTecnico());
    }

    @Test(expected = Exception.class)
    public void alterarTecnicoInvalidoRegistroChamadoTest() throws Exception {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setTecnico(null);
    }

    @Test
    public void alterarDataRegistroChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setData("01/02/2016");
        assertEquals("01/02/2016", regCham.getData());
    }

    @Test(expected = Exception.class)
    public void alterarDataInvalidaRegistroChamadoTest() throws Exception {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setData(null);
    }

    @Test
    public void alterarHoraRegistroChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setHora("08:00:00");
        assertEquals("08:00:00", regCham.getHora());
    }

    @Test(expected = Exception.class)
    public void alterarHoraInvalidaRegistroChamadoTest() throws Exception {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setHora(null);
    }

    @Test
    public void alterarAssuntoRegistroChamadoTest() {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setAssunto("Cliente está insatisfeito com o serviço");
        assertEquals("Cliente está insatisfeito com o serviço", regCham.getAssunto());
    }

    @Test(expected = Exception.class)
    public void alterarAssuntoInvalidoRegistroChamadoTest() throws Exception {
        Tecnico tec = new Tecnico("Lucas", 12345678);
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa clienteEmp = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);
        Chamado chamDesemp = new Chamado("Título do chamado", "Descrição do chamado", 2, tec, clienteEmp, "WINDOWS", "Vista", "Operação realizada", 20.0);
        chamDesemp.setCodigo(1);
        RegistroChamado regCham = new RegistroChamado("Cliente reclama de problema de desempenho.", chamDesemp, tec);
        regCham.setAssunto(null);
    }

}
