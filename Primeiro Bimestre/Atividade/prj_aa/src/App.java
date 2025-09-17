import model.Pessoa;
import service.PessoaService;

public class App {
    public static void main(String[] args) throws Exception {
        PessoaService ps = new PessoaService(10);
        Pessoa p1 = new Pessoa(1, "Alice", "alice@email.com", 30, "123456789");
        ps.inserir(p1);
        Pessoa p2 = new Pessoa(2, "Beatriz", "beatriz@email.com", 25, "987654321");
        ps.inserir(p2);
        Pessoa p3 = new Pessoa(3, "Carlos", "carlos@email.com", 35, "456789123");
        ps.inserir(p3);

        System.out.println("Lista de Pessoas:");
        for (Pessoa p : ps.listar()) {
            if (p != null) {
                System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Email: " + p.getEmail() + ", Idade: " + p.getIdade() + ", Telefone: " + p.getTelefone());
            }
        }
        System.out.println();
        
    }
}
