/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import entidade.Tecnico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitória
 */
public class TecnicoDAOTest {

    @Test
    public void inserirTecnicoDAOTest() {
        TecnicoDAO tecDAO = new TecnicoDAO();
        Tecnico tec = new Tecnico("Lucas", 12345678);
        tecDAO.put(tec);
        assertEquals(tec, tecDAO.get(tecDAO.gerarCodigo() - 1));
    }

    /* 
    
     O teste a seguir é adequado, mas não ideal. 
     Idealmente, o arquivo seria lido e convertido em um HashMap com os objetos,
     e então a verificação da persistência seria feita de acordo com o nome
     do técnico e seu código, que se relaciona com a posição deste no HashMap.
     Após tentativas frustradas de conversão do arquivo .dat, o teste foi implementado 
     desse forma para que pudesse ao menos passar por uma validação básica.
     Caso não fosse permitido inserir técnicos com nomes iguais, esse teste não 
     seria um teste ruim, apesar de ainda assim ser recomendável que uma verificação
     completa do objeto fosse feita.
     */
    @Test
    public void persistirNoArquivoTecnicoDAOTest() throws FileNotFoundException, IOException {
        TecnicoDAO tecDAO = new TecnicoDAO();
        Tecnico tec = new Tecnico("Lucas", 12345678);
        tecDAO.put(tec);
        FileInputStream fis = new FileInputStream("tecnicos.dat");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        assertTrue(sb.toString().contains("Lucas"));
    }

    /* O teste abaixo considera como regra de negócio que não podem existir técnicos
    com nomes iguais, tornando o teste acima uma solução apropriada para a verificação */
    @Test
    public void leituraEVerificacaoAmbiguidadesArquivoTecnicoDAOTest() throws FileNotFoundException, IOException {
        TecnicoDAO tecDAO = new TecnicoDAO();
        Tecnico tec = new Tecnico("Lucas", 12345678);
        tecDAO.put(tec);
        FileInputStream fis = new FileInputStream("tecnicos.dat");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        String str = sb.toString();
        System.out.println(str);
        String findStr = "Lucas";
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }
        System.out.println(count);
        assertTrue(count <= 1);
    }

    @Test
    public void gerarCodigoTecnicoDAOTest() {
        TecnicoDAO tecDAO = new TecnicoDAO();
        assertEquals(tecDAO.voltaCashTecnico().size() + 1, tecDAO.gerarCodigo());
    }

    @Test
    public void buscarPorCodigoTecnicoDAOTest() {
        TecnicoDAO tecDAO = new TecnicoDAO();
        Tecnico tec = new Tecnico("Lucas", 12345678);
        tecDAO.put(tec);
        Tecnico tec2 = tecDAO.get(tecDAO.gerarCodigo() - 1);
        assertEquals(tec, tec2);
    }

}
