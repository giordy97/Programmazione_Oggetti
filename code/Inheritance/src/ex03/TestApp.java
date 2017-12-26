package ex03;

/**
 * Sviluppare due classi ArrayPoly e ListPoly per trattare polinomi. Le due classi
 * svolgono le stesse funzionalità ma utilizzano meccanismi interni diversi.
 * ListPoly memorizza il polinomio come lista di monomi (da definire in una classe
 * separate, vedi sotto), mentre ArrayPoly sfrutta un vettore di double per
 * memorizzare i soli coefficienti. Per garantire l’equivalenza sintattica delle
 * due classi, entrambe implementano l’interfaccia Poly (vedi codice).
 * 
 * Le classi create completano il main seguente
 *   
 * @author Nicola Bicocchi
 *
 */
public class TestApp { 
    public static void main(String[] args) { 
    
    Poly ap = new ArrayPoly(new double[]{1,3,4});
    Poly lp = new ListPoly(new double[]{1,3,6,8});

    System.out.println("ap = " + ap.toString());
    System.out.println("lp = " + lp.toString());

    if (ap.equals(lp) && lp.equals(ap)) 
        System.out.println("ap == lp");
    else 
        System.out.println("ap != lp");

    ap = ap.derivative(); 
    System.out.println("ap' = " + ap.toString());

    ap = ap.derivative(); 
    System.out.println("ap'' = " + ap.toString());

    lp = lp.derivative(); 
    System.out.println("lp' = " + lp.toString());

    lp = lp.derivative(); 
    System.out.println("lp'' = " + lp.toString());

    }
}
