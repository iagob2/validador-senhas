import static org.junit.Assert.*; // Importa métodos estáticos da classe Assert do JUnit para fazer asserções.
import org.junit.Test; // Importa a anotação @Test para marcar métodos de teste.

// Classe de teste para a classe Validador.
public class ValidadorTest {

    // Método de teste para a função senhaValida.
    @Test
    public void testSenhaValida() {
        // Caso positivo: testa uma senha válida (diferente da data de nascimento).
        assertTrue("A senha deve ser considerada válida quando diferente da data de nascimento.", Validador.senhaValida("SenhaForte123!"));

        // Caso negativo: testa uma senha inválida (igual à data de nascimento).
        assertFalse("A senha deve ser considerada inválida quando igual à data de nascimento.", Validador.senhaValida("21021999"));
    }

    // Método de teste para a função temTamanhoMinimo.
    @Test
    public void testTemTamanhoMinimo() {
        // Caso positivo: testa uma senha com tamanho maior ou igual ao mínimo.
        assertTrue("A senha deve ter tamanho mínimo de 8 caracteres.", Validador.temTamanhoMinimo("SenhaForte123!", 8));
        // Caso negativo: testa uma senha com tamanho menor que o mínimo.
        assertFalse("A senha não deve ter tamanho mínimo de 8 caracteres.", Validador.temTamanhoMinimo("abc", 8));
    }

    // Método de teste para a função senhaForte.
    @Test
    public void testSenhaForte() {
        // Caso positivo: testa uma senha que atende a todos os critérios de força.
        assertTrue("A senha deve ser considerada forte.", Validador.senhaForte("SenhaForte123!"));

        // Caso negativo – sem caractere especial: testa uma senha que não atende a um critério (falta caractere especial).
        assertFalse("A senha não deve ser considerada forte sem caractere especial.", Validador.senhaForte("SenhaForte123"));

         // Adicionando mais casos negativos para melhor cobertura:

        assertFalse("A senha não deve ser considerada forte sem letra maiúscula.", Validador.senhaForte("senhaforte123!"));

        assertFalse("A senha não deve ser considerada forte sem letra minúscula.", Validador.senhaForte("SENHAFORTE123!"));

        assertFalse("A senha não deve ser considerada forte sem número.", Validador.senhaForte("SenhaForte!!"));
    }
    
 // Método de teste para a função contemPalavraProibida.
    @Test
    public void testContemPalavraProibida() {
    // Casos positivos (contém palavra proibida)
    assertTrue(Validador.contemPalavraProibida("minhasenha123"));
    assertTrue(Validador.contemPalavraProibida("MYPASSWORD"));
    assertTrue(Validador.contemPalavraProibida("test123456test"));

    // Casos negativos (não contém palavra proibida)
    assertFalse(Validador.contemPalavraProibida("Segur4Pass!"));         // sem "senha", "password", etc.
    assertFalse(Validador.contemPalavraProibida("OutraForte@789"));     // sem palavras proibidas
}
}
