import java.util.Scanner;

public class TesteSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a senha para verificar:");
        String senha = scanner.nextLine();

        System.out.println("\nAnalisando a senha...");

        boolean isSegura = true;

        // 1. Verificar se não é uma data conhecida
        if (!Validador.senhaValida(senha)) {
            System.out.println("- A senha parece ser uma data conhecida. Por favor, escolha uma senha diferente.");
            isSegura = false;
        }

        // 2. Verificar tamanho mínimo (definindo um mínimo, por exemplo, 8)
        int tamanhoMinimo = 8;
        if (!Validador.temTamanhoMinimo(senha, tamanhoMinimo)) {
            System.out.println("- A senha não atende ao tamanho mínimo de " + tamanhoMinimo + " caracteres.");
            isSegura = false;
        }

        // 3. Verificar se é forte
        if (!Validador.senhaForte(senha)) {
            System.out.println("- A senha não é considerada forte pelos critérios de força.");
            // Detalhar o que falta para ser forte
            if (!senha.matches(".*[A-Z].*")) {
                System.out.println("  - Falta letra maiúscula.");
            }
            if (!senha.matches(".*[a-z].*")) {
                System.out.println("  - Falta letra minúscula.");
            }
            if (!senha.matches(".*[0-9].*")) {
                System.out.println("  - Falta número.");
            }
            if (!senha.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                System.out.println("  - Falta caractere especial.");
            }
            isSegura = false;
        }

        // 4. Verificar se contém palavra proibida
        if (Validador.contemPalavraProibida(senha)) {
             System.out.println("- A senha contém uma palavra proibida comum. Por favor, evite palavras como 'senha', 'password', '123456', etc.");
             isSegura = false;
        }


        if (isSegura) {
            System.out.println("\nParabéns! A senha é forte e segura de acordo com os critérios de validação.");
        } else {
            System.out.println("\nA senha não atende a todos os critérios de segurança. Por favor, escolha uma senha mais segura.");
        }

        scanner.close(); // Fechar o scanner
    }
}
