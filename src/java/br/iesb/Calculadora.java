
package br.iesb;

public class Calculadora {
    
    double valor;
    
    public Calculadora(double valor){
        this.valor = Math.pow(valor, 2);
    }

    public double getCalculadora() {
        return valor;
    }
      
}
