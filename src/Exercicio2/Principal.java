package Exercicio2;

import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n--- MENU DE OPÇÕES ---");
            System.out.println("1. Listar Usuários");
            System.out.println("2. Inserir Usuário");
            System.out.println("3. Atualizar Usuário");
            System.out.println("4. Excluir Usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    // Listar
                    System.out.println("\n--- LISTA DE USUÁRIOS ---");
                    List<Usuario> usuarios = usuarioDAO.listarUsuarios();
                    for (Usuario u : usuarios) {
                        System.out.println(u); // Usa o método toString() da classe Usuario
                    }
                    break;

                case 2:
                    // Inserir
                    System.out.println("\n--- INSERIR NOVO USUÁRIO ---");
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    System.out.print("Sexo (M/F): ");
                    String sexo = scanner.nextLine();

                    Usuario novoUsuario = new Usuario(login, senha, sexo);
                    usuarioDAO.inserirUsuario(novoUsuario);
                    break;

                case 3:
                    // Atualizar
                    System.out.println("\n--- ATUALIZAR USUÁRIO ---");
                    System.out.print("Digite o código do usuário a ser atualizado: ");
                    int codigoAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    System.out.print("Novo Login: ");
                    String novoLogin = scanner.nextLine();
                    System.out.print("Nova Senha: ");
                    String novaSenha = scanner.nextLine();
                    System.out.print("Novo Sexo (M/F): ");
                    String novoSexo = scanner.nextLine();
                    
                    Usuario usuarioAtualizado = new Usuario(novoLogin, novaSenha, novoSexo);
                    usuarioAtualizado.setCodigo(codigoAtualizar);
                    usuarioDAO.atualizarUsuario(usuarioAtualizado);
                    break;

                case 4:
                    // Excluir
                    System.out.println("\n--- EXCLUIR USUÁRIO ---");
                    System.out.print("Digite o código do usuário a ser excluído: ");
                    int codigoExcluir = scanner.nextInt();
                    usuarioDAO.excluirUsuario(codigoExcluir);
                    break;
                    
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}