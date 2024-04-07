/*
Create a class AutonomousCar with the below attributes:
carld – int
brand – String noOfTestsConducted – int
noOfTestsPassed- int
environment – String
grade – String

Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence except 
grade.Create class Solution with main method. Implement two static methods – findTestPassedByEnv and updateCarGrade in Solution
 class.

findTestPassedByEnv method:
This method will take two input parameters -array of AutonomousCar objects and string parameter environment. The method 
will return the sum of the noOfTestsPassed attribute from autonomousCar objects for the environment passed as parameter. 
If no autonomousCar with the given environment is present in the array of AutonomousCar objects, then the method should 
return 0.

updateCarGrade method:
This method will take a String parameter brand, along with the array of AutonomousCar objects. The method will return the
autonomousCar object, if the input String parameter matches with the brand attribute of the autonomousCar object. Before
returning the object, the grade should be derived based on the rating calculation mentioned below. This grade value 
should be assigned to the object. If any of the above conditions are not met, then the method should return null. 
The grade attribute should be calculated as follows: rating .(noOfTestsPassed * 100)/noOfTestsConducted If the 
rating > = 80 then grade should be ‘A1’, otherwise the grade should be ‘B2’.

The above mentioned static methods should be called from the main method. For findTestPassedByEnv method – 
The main method should print the totalTestPassed as it is, if the returned value is greater than 0, or it should print 
“There are no tests passed in this particular environment”.

For updateCarGrade method – The main method should print the brand and grade of the returned autonomousCar object. 
The brand and grade should be concatinated with :: while printing. eg:- Tesla::A1, where Tesla is the brand and Al is 
the grade.

If the returned value is null then it should print “No Car is available with the specified brand”. Before calling these static methods in main, use Scanner object to read the values of four autonomousCar objects referring attributes in the above mentioned attribute sequence (except grade attribute). Next, read the value for environment and brand.
*/

//==============================================================================================================================================
//==============================================================================================================================================

package javacode;

import java.util.*;
public class myclass{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] arr = new AutonomousCar[4];

        for(int i=0;i<4;i++)
        {
            arr[i] = new AutonomousCar(sc.nextInt(),sc.nextLine(),sc.nextInt(),sc.nextInt(),sc.nextLine());
        }
        String inputenv = sc.nextLine();
        String inputbrand = sc.nextLine();
        sc.close();//always close with sc.close else it will show scanner sc is not closed error

        int result = findTestPassedByEnv(arr,inputenv);
        if(result!=0)
        {
            System.out.println(result);
        }
        else {
            System.out.println("0");
        }

        AutonomousCar result1 = updateCarGrade(arr,inputbrand);

        if(result1!=null)
        {
            System.out.println(result1.getBrand() + "::" + result1.getGrade());
        }
        else {
            System.out.println("No Car is available with the specified brand");
        }


    }
    public static  int  findTestPassedByEnv(AutonomousCar[] arr,String inputenv)
    {
        int sum=0;
        for(int i=0;i<4;i++)
        {
            if(arr[i].getEnvironment().equalsIgnoreCase(inputenv))
            {
                sum = sum + arr[i].getNoofTestPassed();
            }

        }
        return sum;

    }
    public static AutonomousCar updateCarGrade(AutonomousCar[] arr,String inputbrand)
    {
        int rating;
        for(int i=0;i<4;i++)
        {
            if(arr[i].getBrand().equalsIgnoreCase(inputbrand))
            {
                rating = /*(noOfTestsPassed * 100)/noOfTestsConducted*/ (arr[i].getNoofTestPassed()*100)/arr[i].getNoofTestConducted();
                if (rating >= 80) arr[i].setGrade("A1");
                else arr[i].setGrade("B2");
                return arr[i];
            }
        }
        return null;

    }
}

/*carld – int
brand – String noOfTestsConducted – int
noOfTestsPassed- int
environment – String
grade – String*/
class AutonomousCar
{
    private int carid;
    private String brand;
    private int noofTestConducted;
    private int noofTestPassed;
    private String environment;
    private String grade;

    public AutonomousCar(int carid, String brand, int noofTestConducted, int noofTestPassed, String environment) {
        this.carid = carid;
        this.brand = brand;
        this.noofTestConducted = noofTestConducted;
        this.noofTestPassed = noofTestPassed;
        this.environment = environment;
       //no need to create for grade as we will set vlue of grade 
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNoofTestConducted() {
        return noofTestConducted;
    }

    public void setNoofTestConducted(int noofTestConducted) {
        this.noofTestConducted = noofTestConducted;
    }

    public int getNoofTestPassed() {
        return noofTestPassed;
    }

    public void setNoofTestPassed(int noofTestPassed) {
        this.noofTestPassed = noofTestPassed;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

//==============================================================================================================================================
//==============================================================================================================================================
/*
Input==>

100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez

Output==>

1900
Mercedez::B2
*/