/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Persistencia.ClienteDAO;
import entidade.ClienteEmpresa;
import entidade.Empresa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitória
 */
public class ControleClientesTest {
    
    
    @Test
    public void inserirClienteControleClienteTest() {
        ControleClientes cc = new ControleClientes();
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);  
        ClienteEmpresa ce2 = cc.incluiNovoCliente(ce.getEmpresa(), ce.getCpf(), ce.getNome(), ce.getTelefone());
        ClienteDAO ceDAO = cc.getClienteDAO();
        ClienteEmpresa cliente = ceDAO.get(40168413824L);
        assertTrue(((cliente.getCpf() == ce2.getCpf()) && (cliente.getNome() == ce2.getNome()) && (cliente.getEmpresa() == ce2.getEmpresa()) && (cliente.getTelefone() == ce2.getTelefone())) && (cliente.getCodigo() == ce2.getCodigo()));
    }
    
}
