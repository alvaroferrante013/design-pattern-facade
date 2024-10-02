import java.util.ArrayList;
import java.util.List;

class Produto {
    String descricao;
    double preco;

    public Produto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String toString() {
        return descricao + " - R$ " + preco;
    }
}

class Sobremesa extends Produto {
    String tamanho;

    public Sobremesa(String descricao, double preco, String tamanho) {
        super(descricao, preco);
        this.tamanho = tamanho;
    }

    public String toString() {
        return super.toString() + " (Tamanho: " + tamanho + ")";
    }
}

class Burguer extends Produto {
    int gramas;

    public Burguer(String descricao, double preco, int gramas) {
        super(descricao, preco);
        this.gramas = gramas;
    }

    public String toString() {
        return super.toString() + " (Peso: " + gramas + "g)";
    }
}

class Bebida extends Produto {
    int ml;

    public Bebida(String descricao, double preco, int ml) {
        super(descricao, preco);
        this.ml = ml;
    }

    public String toString() {
        return super.toString() + " (Volume: " + ml + "ml)";
    }
}

class Combo {
    private List<Produto> itens = new ArrayList<>();

    public void CriarCombo(int tipo) {
        switch (tipo) {
            case 1:
                itens.add(new Burguer("Burguer Master", 25.00, 200));
                itens.add(new Sobremesa("Torta de Limão", 10.00, "Médio"));
                itens.add(new Bebida("Refrigerante", 5.00, 500));
                break;
            case 2:
                itens.add(new Burguer("Super Burguer", 30.00, 250));
                itens.add(new Sobremesa("Brownie", 12.00, "Pequeno"));
                itens.add(new Bebida("Suco Natural", 7.00, 400));
                break;
            default:
                System.out.println("Combo não disponível.");
                break;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Itens do Combo:\n");
        for (Produto produto : itens) {
            sb.append(produto.toString()).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Selecione seu combo");
        System.out.println("1. Combo Master");
        System.out.println("2. Super Combo");
        System.out.print("Sua escolha: ");
        Scanner input = new Scanner(System.in);
        int tipo = input.nextInt();
        Combo combo = new Combo();
        combo.CriarCombo(tipo);
        System.out.println(combo);
    }
}