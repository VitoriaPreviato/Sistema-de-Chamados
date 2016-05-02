/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Empresa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitória
 */
public class ControleEmpresasTest {

    @Test
    public void inserirEmpresaControleEmpresasTest() {
        ControleEmpresas ce = new ControleEmpresas();
        Empresa e = new Empresa(111, "Semp Toshiba");
        Empresa e2 = ce.inserir(e.getNumeroContrato(), e.getNomeEmpresa());
        assertTrue(e2.getNomeEmpresa().equals(e.getNomeEmpresa()) && (e2.getNumeroContrato() == e.getNumeroContrato()));
    }
    
    @Test
    public void buscarEmpresaControleEmpresasTest() {
        ControleEmpresas ce = new ControleEmpresas();
        Empresa e = new Empresa(123, "Google");
        ce.inserir(e.getNumeroContrato(), e.getNomeEmpresa());
        Empresa e2 = ce.retorna(123, "Google");
        assertTrue(e2.getNomeEmpresa().equals(e.getNomeEmpresa()) && (e2.getNumeroContrato() == e.getNumeroContrato()));
    }

    @Test
    public void validarEmpresaControleEmpresasTest() {
        ControleEmpresas ce = new ControleEmpresas();
        Empresa e = new Empresa(444, "LG");
        ce.inserir(e.getNumeroContrato(), e.getNomeEmpresa());
        
        //1 o contrato e o nome da empresa ja estao em uso        
        assertEquals(1, ce.validar(444,"LG"));
        //2 o nome da empresa ja esta em uso
        assertEquals(2, ce.validar(111,"LG"));
        //3 o numero de contrato da empresa ja esta em uso
        assertEquals(3, ce.validar(444,"Nokia"));
        //4 nenhum atributo da empresa esta em uso
        assertEquals(4, ce.validar(222,"Bovespa"));
    }
    
    @Test
    public void checarEmpresaExisteControleEmpresaTest() {
        ControleEmpresas ce = new ControleEmpresas();
        Empresa e = new Empresa(123, "Google");
        ce.inserir(e.getNumeroContrato(), e.getNomeEmpresa());
        
        assertTrue(ce.checar(e.getNumeroContrato(), e.getNomeEmpresa()));
    }


}
