package polynomialtester;
import java.util.Scanner;
/**
 * This program is intended to output polynomials based on the degree input and value input. It also should be able to evaluate the polynomials at a value k, and also the compositions of functions at value k.
 * @author Lora Elliott
 * <pre>
 * Date: 3/22/2023
 * Course: CSC 1350 Section 1
 * Lab: 6
 * Instructor: Dr. Duncan
 * </pre>
 */
public class PolynomialTester {

    /**
     * @param v the array representation of the function
     * @param degree the degree of the function
     * @return the string version of the input values as a function
     */
 public static String toString(double[] v, int degree) {
     String str="";
     if(degree>0)
     { str += ""+v[0]+"x^"+degree;
    for (int i = degree-1; i >1; i--)
      str+=(" + "+v[i]+"x^"+i);
    str+=" + " + v[degree-1]+"x";
    str +=" + "+v[degree];}
     else
     { str+= v[0];}
   return str+"";
    }
    public static double eval(double[] coeffs, double mult, int degree){
    double sum=0;
    double degreeD=degree;
    for(int i=0; i<coeffs.length; i++){
		sum+=coeffs[i]*Math.pow(mult, degreeD);
    degreeD--;}
    return sum;
    }
    public static void main(String[] args) {
        int x=0;
        System.out.println("Enter the degree of the polynomial f(x) ->");
        Scanner cin= new Scanner(System.in);
        int degree1 = cin.nextInt();
        System.out.println("Enter the coefficients of f(x) in orders of descending powers ->");
        double[] poly1= new double[degree1+1];
        while(x<=degree1){
            
            poly1[x]=cin.nextInt();
            x++;
        }
        System.out.println("Enter the degree of the polynomial g(x) ->");
        int degree2 = cin.nextInt();
        System.out.println("Enter the coefficients of g(x) in orders of descending powers ->");
        double[] poly2= new double[degree2+1];
        int y=0;
        while(y<=degree2){
            
            poly2[y]=cin.nextInt();
            y++;
        }
        System.out.println("Enter the degree of the polynomial h(x) ->");
        int degree3 = cin.nextInt();
        System.out.println("Enter the coefficients of g(x) in orders of descending powers ->");
        double[] poly3= new double[degree3+1];
        int z=0;
        while(z<=degree3){
            
            poly3[z]=cin.nextInt();
            z++;
        }

        System.out.println("Enter the value k at which to evaluate the polynomials ->");
        double k = cin.nextDouble();
        double f=eval(poly1, k, degree1) ;
        double g=eval(poly2, k, degree2) ;
        double h=eval(poly3,k,degree3);
        double gcomph = eval(poly2, h, degree2);
        double fcompgcomph= eval(poly1, gcomph, degree1); 
        double gcompf= eval(poly2, f, degree2);
        double fcompg= eval(poly1, g, degree1);
        double hcompgcompf = eval(poly3, gcompf, degree3);
        System.out.println("f(x)= "+toString(poly1, degree1));
        System.out.println("h(x)= "+toString(poly2, degree2));
        System.out.println("h(x)= "+toString(poly3, degree3));
        System.out.printf("f(%f)= %f", k, eval(poly1, k, degree1));
        System.out.printf("\ng(%f)= %f", k, eval(poly2, k, degree2));
        System.out.printf("\nh(%f)= %f", k, eval(poly3, k, degree3));
        System.out.printf("\nf(g(%f))= %f", k, fcompg);
        System.out.printf("\ng(f(%f))= %f", k, gcompf);
        System.out.printf("\nf(g(h(%f))= %f", k, fcompgcomph);
        System.out.printf("\nh(g(f(%f))= %f", k, hcompgcompf);
        
        
    }
    
}