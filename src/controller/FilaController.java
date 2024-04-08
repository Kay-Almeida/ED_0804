package controller;

import br.edu.fateczl.filaobj.Fila;

public class FilaController {
    public void inserirFila(Fila fila, Object senha) {
        fila.insert(senha);
    }
    
    public Object chamarProximo(Fila fila) throws Exception {
        if (!fila.isEmpty()) {
            return fila.remove();
        } else {
            throw new Exception("Fila Vazia");
        }
    }
}
