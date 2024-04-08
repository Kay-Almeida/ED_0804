package view;

import br.edu.fateczl.filaobj.Fila;
import controller.FilaController;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
    	
        Fila fila = new Fila();
        Fila filaPrioritarios = new Fila();
        FilaController filaController = new FilaController();
        
        for (int i = 0; i < 5; i++) {
            filaPrioritarios.insert("P" + (i + 1));
        }
        
        for (int i = 0; i < 5; i++) {
            fila.insert("N" + (i + 1));
        }
        
        int opcao = 0;
        do {
            String opcaoStr = JOptionPane.showInputDialog(
                    "Menu:\n" +
                    "1. Gerar nova senha\n" +
                    "2. Gerar nova senha prioritária\n" +
                    "3. Chamar próximo cliente\n" +
                    "0. Sair\n\n" +
                    "Escolha uma opção:"
            );
            
            try {
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                continue;
            }
            
            switch (opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome do cliente para gerar uma senha:");
                    if (nome != null && !nome.isEmpty()) {
                        filaController.inserirFila(fila, nome);
                    }
                    break;
                case 2:
                    String nomePrioritario = JOptionPane.showInputDialog("Digite o nome do cliente prioritário para gerar uma senha:");
                    if (nomePrioritario != null && !nomePrioritario.isEmpty()) {
                        filaController.inserirFila(filaPrioritarios, nomePrioritario);
                    }
                    break;
                case 3:
                    try {
                        for (int i = 0; i < 3; i++) {
                            JOptionPane.showMessageDialog(null, "Chamando senha prioritária: " + filaController.chamarProximo(filaPrioritarios));
                        }
                        JOptionPane.showMessageDialog(null, "Chamando senha não prioritária: " + filaController.chamarProximo(fila));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}
