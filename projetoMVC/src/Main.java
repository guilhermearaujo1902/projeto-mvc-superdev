import controller.ProdutoController;
import model.Produto;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        ProdutoController controller = new ProdutoController();

        StringBuilder menu = new StringBuilder();
        menu.append("*** Menu do Sistema ***");
        menu.append("\n[1] Cadastrar");
        menu.append("\n[2] Listar todos");
        menu.append("\n[3] Buscar por ID");
        menu.append("\n[0] Sair");
        menu.append("\n\nSelecione uma opção");

        int opcao = -1;

        while (opcao != 0) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    String descricao = JOptionPane.showInputDialog("Descrição do produto");
                    Double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do produto"));

                    Produto novoProduto = new Produto();
                    novoProduto.setDescricao(descricao);
                    novoProduto.setPreco(preco);
                    novoProduto.setStatus(true);

                    String mensagemInsert = controller.insert(novoProduto);
                    JOptionPane.showMessageDialog(null, mensagemInsert);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, controller.getFormatedList());
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema ...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }

    }
}
