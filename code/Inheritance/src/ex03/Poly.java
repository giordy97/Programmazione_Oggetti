package ex03;

public interface Poly 
{ 
    /** 
     * Restituisce il grado del polinomio 
     */        
    public int degree(); 

    /** 
     *  Costruisce un nuovo polinomio ottenuto come derivata del 
     *  polinomio "this". Ricordiamo che la derivata del polinomio
     *       c0 + c_1 * x + c_2 * x^2 + ... + c_n * x^n 
     *  e' il polinomio 
     *       c1 + 2c_2 * x + ... + nc_n * x^(n-1)
     */        
    public Poly derivative();
    

    /** 
     *  True se q e' uguale al polinomio corrente
     */        
    public boolean equals(Poly q);


    /** 
     *  Restituisce il coefficiente del polinomio associato al 
     *  termine di grado degree; 
     */        
    double coefficient(int degree);
}

