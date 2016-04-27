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
    public void criarPessoaTest(){
        Pessoa p = new Pessoa("Vitoria",123456789);
        assertEquals("Vitoria", p.getNome());
        assertEquals(123456789, p.getTelefone());
    }
    
    @Test
    public void alterarTelefonePessoaTest(){
        Pessoa p = new Pessoa("Vitoria",123456789);
        p.setTelefone(987654321);
        assertEquals("Vitoria", p.getNome());
        assertEquals(987654321, p.getTelefone());
    }
    
}
