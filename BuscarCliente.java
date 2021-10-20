public class BuscarCliente {

    private String[][] v;
    private int comparacoes;

    public int getComparacoes() {
        return comparacoes;
    }

    public BuscarCliente(String[][] v) {
        this.v = v;
    }

    public int pesquisaBinaria(String chave) {
        int inicio, meio, fim;

        inicio = 0;
        fim = v.length - 1;
        comparacoes = 0;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            comparacoes++;
            if (chave.equals(v[meio][0])) {
                return meio;
            }

            if (chave.compareTo(v[meio][0]) < 0) { 
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return -1; 

    }

}
