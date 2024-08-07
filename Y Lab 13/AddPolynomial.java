class Node {
    int coefficient;
    int exponent;
    Node link;

    Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.link = null;
    }
}
class Polynomial{
    Node first;
    public void term(int coefficient,int exponent){
        Node newNode = new Node(coefficient,exponent);
        if(first==null){
            first=newNode;
            return; 
        }

        Node save=first;
        while (save.link!=null) {
            save=save.link;
        }
        save.link=newNode;

    }

    public void display() {
        if (first == null) {
            System.out.println("Please first enter the term.");
            return;
        }

        Node temp = first;
        while (temp != null) {
            System.out.print(temp.coefficient + "x^"+ temp.exponent);
            if (temp.link != null) {
                System.out.print(" + ");
            }
            temp = temp.link;
        }
        System.out.println();
    }

    public Polynomial addPolynomial(Polynomial p1,Polynomial p2){
        Polynomial result=new Polynomial();

        Node t1=p1.first;
        Node t2=p2.first;

        while(t1!=null && t2!=null){
            if(t1.exponent==t2.exponent){
                result.term(t1.coefficient+t2.coefficient, t1.exponent);
                t1=t1.link;
                t2=t2.link;
            }else if(t1.exponent>t2.exponent){
                result.term(t1.coefficient,t1.exponent);
                t1=t1.link;
            }else{
                result.term(t2.coefficient,t2.exponent);
                t2=t2.link;
            }
        }

        while(t1!=null){
            result.term(t1.coefficient, t1.exponent);
            t1=t1.link;
        }

        while(t2!=null){
            result.term(t2.coefficient, t2.exponent);
            t2=t2.link;
        }

        return result;
    }
}
public class AddPolynomial{
    public static void main(String[] args) {
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();

        p1.term(3, 2);
        p1.term(5, 1);
        p1.term(6, 0);

        
        p2.term(5, 2);
        p2.term(9, 1);
        p2.term(11, 0);

        Polynomial ans=new Polynomial();
        Polynomial result=ans.addPolynomial(p1,p2);

        System.out.println("Polynomial Equation 1:");
        p1.display();
        
        System.out.println("Polynomial Equation 2:");
        p2.display();

        System.out.println("-------------------------------\nAnswer:");
        result.display();
    }
    
}