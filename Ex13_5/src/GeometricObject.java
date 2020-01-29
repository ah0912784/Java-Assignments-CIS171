/*
 * 
 */

/**
 *
 * Alexander Hansen
 * 1/28/20
 * Java II
 */


//Implementation of GeometricObject class

public class GeometricObject implements Comparable{

     
    int radius, width,length;
    String shapeformat;
    double area;

   //Implement parameterized constructor

    public GeometricObject(int radius, int w, int l, String shape) {
        super();
        this.radius = radius;
        this.width = w;
        this.length = l;
        this.shapeformat = shape;
        //check radius is greater than 0
        if(radius > 0) {
        //calculate the area of circle
            area = Math.PI * radius * radius;
}
        else {
       //calculate the rectangle ares
            area = width * length;
        }

    }

    //Implementation of max method

    public static void max(GeometricObject object1, GeometricObject object2) {
   
        if( object1.compareTo(object2) > 0) {
        //Display statement
            System.out.println(object1.shapeformat + " is larger than " + object2.shapeformat);
}

        else if( object1.compareTo(object2) < 0)
        {
        //Display statement
            System.out.println(object2.shapeformat + " is larger than " + object1.shapeformat);
        }
        else
        {
        //Display statement
            System.out.println(object1.shapeformat + " is equal to " + object1.shapeformat);
        }
    }
    @Override

    //Implementation of compareTo method
    public int compareTo(Object requiredObject) {
    //check whether this.area is greater than the
    //(GeometricObject)requiredObject).area or not
        if(this.area > ((GeometricObject)requiredObject).area) {
            return 1;
        }

        //check whether this.area is less than the
    //(GeometricObject)requiredObject).area or not

        else if(this.area < ((GeometricObject)requiredObject).area)    {

            return -1;}
        else {
            return 0; }

    }//Overide 

    //Implementation of main method
    public static void main(String args[]) {

    
        GeometricObject circle1 = new GeometricObject(10, 20, 20, "circle 1");
    //Create an object for circle2
        GeometricObject circle2 = new GeometricObject(8, 16, 16, "circle 2");
    //Create an object for rectangle1
        GeometricObject rectangle1 = new GeometricObject(10, 20, 15, "rectangle 1");
    //Create an object for rectangle2
        GeometricObject rectangle2 = new GeometricObject(20, 15, 30, "rectangle 2");
        //call max method
        GeometricObject.max(circle1, circle2);
        //call max method
        GeometricObject.max(rectangle1, rectangle2);

    }

}