/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class ClienteEmpresaTest {

    @Test
    public void cadastrarClienteEmpresaTest() {
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);        
        Assert.assertEquals((Integer)001, ce.getCodigo());
        Assert.assertEquals(emp, ce.getEmpresa());
        Assert.assertEquals(40168413824L, ce.getCpf());
        Assert.assertEquals("Rafael", ce.getNome());
        Assert.assertEquals(12123434, ce.getTelefone());
    }
    
    @Test (expected = Exception.class)
    public void cadastrarClienteEmpresaCodigoInvalidoTest() throws Exception {   
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(-001,  emp, 40168413824L, "Rafael", 12123434);        
    }
    
    @Test (expected = Exception.class)
    public void cadastrarClienteEmpresaCodigoNuloTest() throws Exception {   
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(null,  emp, 40168413824L, "Rafael", 12123434);        
    }
    
    @Test (expected = Exception.class)
    public void cadastrarClienteEmpresaEmpInvalidaTest() throws Exception {
        ClienteEmpresa ce = new ClienteEmpresa(001,  null, 40168413824L, "Rafael", 12123434);        
    }
    
    @Test (expected = Exception.class)
    public void cadastrarClienteEmpresaCpfInvalidoTest() throws Exception {   
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001,  emp, -40168413824L, "Rafael", 12123434);        
    }
    
    @Test (expected = Exception.class)
    public void cadastrarClienteEmpresaNomeInvalidoTest() throws Exception {   
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001,  emp, 40168413824L, null, 12123434);        
    }
    
    @Test (expected = Exception.class)
    public void cadastrarClienteEmpresaTelefoneInvalidoTest() throws Exception {   
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001,  emp, 40168413824L, "Rafael", -12123434);        
    }
    
    @Test
    public void alterarCodigoClienteEmpresaTest(){
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);  
        ce.setCodigo(002); 
        Assert.assertEquals((Integer)002, ce.getCodigo());
    }
    
    @Test (expected = Exception.class)
    public void alterarCodigoInvalidoClienteEmpresaTest() throws Exception{
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);  
        ce.setCodigo(-002);
    }
    
    @Test (expected = Exception.class)
    public void alterarCodigoNuloClienteEmpresaTest() throws Exception{
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);  
        ce.setCodigo(null);
    }
    
    @Test
    public void alterarCpfClienteEmpresaTest(){
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);  
        ce.setCpf(40187578987L);
        Assert.assertEquals(40187578987L, ce.getCpf());       
    }
    
    @Test (expected = Exception.class)
    public void alterarCpfInvalidoClienteEmpresaTest() throws Exception{
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);  
        ce.setCpf(-40187578987L);       
    }
    
    @Test
    public void alterarNomeClienteEmpresaTest(){
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);  
        ce.setNome("João");
        Assert.assertEquals("João", ce.getNome());      
    }
    
    @Test (expected = Exception.class)
    public void alterarNomeInvalidoClienteEmpresaTest() throws Exception{
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);  
        ce.setNome(null);     
    }
    
    @Test
    public void alterarTelefoneClienteEmpresaTest(){
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);  
        ce.setTelefone(987654321);
        assertEquals(987654321, ce.getTelefone());      
    }
    
    @Test (expected = Exception.class)
    public void alterarTelefoneInvalidoClienteEmpresaTest() throws Exception{
        Empresa emp = new Empresa(123, "Google");
        ClienteEmpresa ce = new ClienteEmpresa(001, emp, 40168413824L, "Rafael", 12123434);  
        ce.setTelefone(-987654321);    
    }  
        
   
}

