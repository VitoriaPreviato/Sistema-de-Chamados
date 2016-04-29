/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31320600
 */
public class PessoaTest {
    
    
    public PessoaTest() {
    }
    
    @Test
    public void cadastrarPessoaTest(){
        Pessoa p = new Pessoa("Vitoria",123456789);
        assertEquals("Vitoria", p.getNome());
        assertEquals(123456789, p.getTelefone());
    }
    
    
    @Test (expected = Exception.class)
    public void cadastrarPessoaTelefoneInvalidoTest() throws Exception{
        Pessoa p = new Pessoa("Vitoria",-123456789);    
    }
    
    @Test (expected = Exception.class)
    public void cadastrarPessoaSemNomeTest() throws Exception{
        Pessoa p = new Pessoa(null,123456789);              
    }
    
    @Test
    public void alterarNomePessoaTest(){
        Pessoa p = new Pessoa("Vitoria",123456789);        
        p.setNome("Maria");              
        assertEquals("Maria", p.getNome());
    }
    
    @Test (expected = Exception.class)
    public void alterarNomeInvalidoPessoaTest() throws Exception{
        Pessoa p = new Pessoa("Vitoria",123456789);
        p.setNome(null);
    }
    
    @Test
    public void alterarTelefonePessoaTest(){
        Pessoa p = new Pessoa("Vitoria",123456789);
        p.setTelefone(987654321);
        assertEquals("Vitoria", p.getNome());
        assertEquals(987654321, p.getTelefone());
    }
    
    
    @Test (expected = Exception.class)
    public void alterarTelefoneInvalidoPessoaTest() throws Exception{
        Pessoa p = new Pessoa("Vitoria",123456789);
        p.setTelefone(-12345678);
    }
    
}
