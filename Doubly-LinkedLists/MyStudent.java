package LE3Q1;

public class MyStudent {
    private String firstname;
    private Double score;

    public MyStudent(){
        firstname="Isra";
        score=89.55;
    }

    public MyStudent(String firstname,Double score){
        this.firstname=firstname;
        this.score=score;
    }
    @Override
    public String toString(){
        String St1= String.format(" %s",firstname);
        String St2=String.format("%.2f", score);
        return St1+" "+St2;


    }

}
