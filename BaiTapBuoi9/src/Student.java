public class Student {
    private String Name;
    private int Age;
    private String ID;
    private double Point;
    public Student(String Name, int Age, String ID, double Point){
        this.Name = Name;
        this.Age = Age;
        this.ID = ID;
        this.Point = Point;
    }
    public String GetName(){
        return this.Name;
    }
    public int GetAge(){
        return this.Age;
    }
    public String GetID(){
        return this.ID;
    }
    public double GetPoint(){
        return this.Point;
    }
    @Override
    public String toString(){
        return "ID: " + ID + " Name: " + Name + " Age: " + Age + " Point: " + Point ;
    }
}

