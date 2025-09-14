import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List; // Importar List
import java.util.Arrays; // Importar Arrays

public class Validador {

    // 1. Não pode ser uma data conhecida (aniversário)
    // Este método verifica se a senha NÃO é uma data em formatos comuns.
    public static boolean senhaValida(String senha) {

        String[] dateFormats = {
            "ddMMyyyy", "MMddyyyy", "yyyyMMdd",
            "dd/MM/yyyy", "MM/dd/yyyy", "yyyy/MM/dd",
            "dd-MM-yyyy", "MM-dd-yyyy", "yyyy-MM-dd"
        };

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.setLenient(false); // Garante que a data seja estrita

        for (String format : dateFormats) {
            sdf.applyPattern(format);
            try {
                Date data = sdf.parse(senha);
                // Se conseguiu parsear sem erro, a senha parece uma data -> inválida
                return false;
            } catch (ParseException e) {
                // Não conseguiu parsear nesse formato, tenta o próximo
                continue;
            }
        }

        // Não é nenhuma data válida -> ok nesse critério
        return true;
    }

    // 2. Verifica tamanho mínimo da senha
    public static boolean temTamanhoMinimo(String senha, int minimo) {
        return senha.length() >= minimo;
    }

    // 3. Verifica se a senha é forte (maiúscula, minúscula, número e caractere especial)
    public static boolean senhaForte(String senha) {
        boolean temMaiuscula = senha.matches(".*[A-Z].*");
        boolean temMinuscula = senha.matches(".*[a-z].*");
        boolean temNumero = senha.matches(".*[0-9].*");
        boolean temEspecial = senha.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return temMaiuscula && temMinuscula && temNumero && temEspecial;
    }

     // Lista de palavras comuns e inseguras que não devem ser usadas como senha.
    private static final List<String> PALAVRAS_PROIBIDAS = Arrays.asList(
        "senha", "password", "123456", "qwerty", "abcdef", "admin", "root",
        "login", "usuario", "teste", "secreto", "master", "padrao", "default",
        "acesso", "online", "sistema", "computador", "internet", "digital",
        "seguranca", "protecao", "privacidade", "confidencial", "dados",
        "informacao", "conta", "perfil", "email", "telefone", "endereco",
        "nome", "sobrenome", "cidade", "estado", "pais", "brasil", "janeiro",
        "fevereiro", "marco", "abril", "maio", "junho", "julho", "agosto",
        "setembro", "outubro", "novembro", "dezembro", "domingo", "segunda",
        "terca", "quarta", "quinta", "sexta", "sabado", "verao", "outono",
        "inverno", "primavera"
    );

     // 4. Verifica se contém uma palavra proibida
    // Este método verifica se a senha contém uma palavra específica, ignorando maiúsculas/minúsculas.
     public static boolean contemPalavraProibida(String senha) {
        String senhaLowerCase = senha.toLowerCase();
        for (String palavraProibida : PALAVRAS_PROIBIDAS) {
            if (senhaLowerCase.contains(palavraProibida.toLowerCase())) {
                return true; // Encontrou uma palavra proibida
            }
        }
        return false; // Não encontrou nenhuma palavra proibida
    }
} // Added the missing closing brace for the class
