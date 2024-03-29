import java.sql.Time;
import java.util.*;
import java.lang.*;
import java.util.List;
import java.util.Scanner;
import MyPackage.login;

class Demo{
    public static void main(String args[]){

        drug drug0=new drug(14,"ultraset","for headache",20,30);
        drug0.generate_bill();
        drug0.add_drug();  
        stock.printDrugTypes("type1");
        login user3 = new login("ankur","ankur@","admin");
        System.out.println(user3.getPassword());
       
        customer cust1 = new customer(16,"Divya","1234567890",12);
        cust1.order_drug(drug0.d_id);

        Branches b = new Branches();
        System.out.println("This is about simple inheritance: ");
        b.generate_sales();
       
//         drug drug1 = new drug(1, "Paracetamol", "Antibody drug.", 10);
//         drug1.generate_bill();
//         drug drug2 = new drug(2, "Sinerest", "Antibody drug(fever).", 20, 90);
//         drug2.generate_bill();
        
        //multiple inheritance demonstration
         Branches b2 = new Branches(1,"KORMANGALA",1995,2,150.34,200.56);
         System.out.println("Your report is generated:");
        drug2.generate_report();
        
      // abstration demonstration
         Order o = new customer();
         System.out.println("Your drug ordered is:");
         o.order_drug(1);
         o.show();
        
        //  interface demonstration.
        // Company comp1 = new Company(2);
         Company comp = new Company("Pradeep Co.","Jayanagar");
         comp.generate_alert();
        //  nested interface
        report r = new report();
        r.most_sold();
//      //shallow copy
//         drug drug3 = drug2;
//         System.out.println("\nShallow copy: drug2 - " + drug2 + " and drug3 - "+ drug3);
//         //deep copy and constructor chaining
//         drug drug4 = new drug(drug2);
//         System.out.println("Deep copy: drug2 - " + drug2 + " and drug4 - "+ drug4+"\n");

//         //function overloading
//         customer customer1 = new customer(1, "Ranu", "9900160224", 6969);
//         customer1.search_drug(2);
//         customer1.search_drug("dolo");
//         customer1.search_drug(2, "dolo");
//         customer1.search_drug(3, "dolo");

//         //static variables
//         System.out.println("\nStatic variables");
//         System.out.println("Drug type 1: " + drug.drug_type1);
//         System.out.println("Drug type 2: " + drug.drug_type2);
//         System.out.println("Drug type 3: " + drug.drug_type3);

//         //nested static class
//         System.out.println("\nNested Static class");
//         drug.DrugCountry drug5 = new drug.DrugCountry();
//         drug5.IndiaDrug();
    }
}


class drug extends Branches implements stock
{
    public int d_id;
    public String name;
    public String description;
    public int quantity;
    public float cost;
    public int drug_rating;

    static String drug_type1;
    static String drug_type2;
    static String drug_type3;

    static{
        drug_type1 = "minors";
        drug_type2 = "adults";
        drug_type3 = "seniors";
    }

    //constructor overloading and chaining
    public drug(int d_id, String name,String description,int quantity)
    {
        super();
        this.d_id=d_id;
        this.name=name;
        this.description=description;
        this.quantity=quantity;
    }
    public drug(int d_id, String name,String description,int quantity, float cost)
    {
        this(d_id, name, description, quantity);
        this.cost = cost;
    }
    public drug(drug obj)
    {
        this(obj.d_id, obj.name, obj.description, obj.quantity, obj.cost);
    }

    public static void printDrugTypes()
    {
        System.out.println("Drug Type 1: "+drug_type1);
        System.out.println("Drug Type 2: "+drug_type2);
        System.out.println("Drug Type 3: "+drug_type3);
    }
    

    static class DrugCountry
    {
        void IndiaDrug()
        {
            System.out.println("Drug manufactured from India.");
        }
    }

    public void update_cost(){
        float new_price;
        Scanner sc=new Scanner(System.in);
        new_price = sc.nextFloat();
        this.cost=new_price;
        sc.close();
    }

    private float calculate_cost(int d_id){
        float total_cost;
        total_cost = this.cost * this.quantity;
        System.out.println("Amount paid: "+ this.cost);
        return total_cost;
    }

    public int update_quantity(int purchased){
        int new_quantity = this.quantity;
        new_quantity -= purchased;
        return new_quantity;
    }

    public void generate_bill(){
        float amount = this.calculate_cost(this.d_id);
        System.out.println("\n");
        System.out.println("Drug id: "+this.d_id);
        System.out.println("Drug name: "+this.name);
        System.out.println("Quantity purchased: "+this.quantity);
        System.out.println("Amount paid: "+ amount);
    }

    public void add_drug(){
        super.add_drug();
        System.out.println("enter drug id:");
        Scanner sc = new Scanner(System.in);
        int d_id = sc.nextInt();
        if( this.d_id == d_id && this.quantity < 5){
            System.out.println("This drug needs to be added" +d_id);
        
        }
    }

}

class customer extends Order{
    public int cust_id;
    public String cust_name;
    public String phone_no;
    public int presc_id;

    customer (){}

    public customer(int cust_id, String cust_name, String phone_no, int presc_id)
    {
        this.cust_id = cust_id;
        this.cust_name= cust_name;
        this.phone_no = phone_no;
        this.presc_id = presc_id;
    }

    //function overloading
        public void search_drug(String c){
        //String Class
        String d = new String("Dolo"); 

        if(c == d){
            System.out.println("You searched for Dolo");
        }
        else{
            System.out.println("You searched for " + c);
        }

        d.concat(" ,its for pain");
        System.out.println("Your drug is still " + c);

      

        d = d.concat(" -500mg");
        System.out.println("Your drug is " + d);

        long startTime = System.currentTimeMillis();  

        //StringBuffer Class
        StringBuffer c2 = new StringBuffer("Citrazine");
        StringBuffer sb_c = new StringBuffer("Citrazine"); 

        if(c2 == sb_c){
            System.out.println("You searched for Citrazine");
        }
        else{
            System.out.println("You searched for " + c);
        }

        sb_c.append(" - it is StringBuffer  ");
        System.out.println("Your drug is now " + sb_c);

    

        sb_c = sb_c.append(" - General");
        System.out.println("Your drug is " + sb_c);

        for (int i=0; i<100000; i++){  
            sb_c.append("buffer");  
        }  
        System.out.println("Time by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");  

        //StringBuilder Class
        startTime = System.currentTimeMillis();  
       
        StringBuilder category3 = new StringBuilder("Paracetamol");
        StringBuilder sbc_category = new StringBuilder("Paracetamol"); 

        if(category3 == sbc_category){
            System.out.println("You searched for Paracetamol");
        }
        else{
            System.out.println("You searched for " + c);
        }

        sbc_category.append(" - StringBuilder Will Update");
        System.out.println("Your drug is still " + sbc_category);


        sbc_category = sbc_category.append(" - General");
        System.out.println("Your drug is " + sbc_category);

        for (int i=0; i<100000; i++){  
            sbc_category.append("builder");  
        }  
        System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");  
    }

//datatype overloading
    public void search_drug(int drug_id)
    {
        drug d = new drug(2,"dolo","painkiller",2,90);
        if(d.d_id == drug_id){
            System.out.println("You searched for drug id: "+drug_id+". dose  = "+d.cost);
        }
        else{
            System.out.println("no drug with that name");
        }
    }

//number of arguments
    public void search_drug(int drug_id, String drug_name)
    {
        drug d = new drug(2,"dolo","painkiller",2,90);
        if(d.name == drug_name && d.d_id == drug_id){
            System.out.println("You searched for drug id: "+drug_id+" and drug name: "+drug_name+". dose  = "+d.cost);
        }
        else{
            System.out.println("no drug with that name");
        }
    }

    public void order_drug(int drug_id){
        drug d = new drug(2,"dolo","painkiller",2,90);
        d.generate_bill();
    }

    public void rate_drug(int d_id, int rating){
        drug drug1 = new drug(2,"dolo","painkiller",2,90);
        if(drug1.d_id == d_id){
            drug1.drug_rating = rating;
        }
        else{
            System.out.println("Drug id NOT FOUND");
        }
    }

    //public void emergengy(){
        //don't know how to implement this
    //}
}

class Branches extends Company  {
    public int b_id;
    public String name ;
    public String address;
    public int year = 10;
    public int times_visited;
    public double total_revenue;
    public double total_expense;


     public Branches(){}
    
    public Branches(int b_id, String name,int year,int times_visited, double  total_revenue, double total_expense)
    {
        this.b_id= b_id;
        this.name = name;
        this.year = year;

        this.times_visited = times_visited;
        this.total_revenue = total_revenue;
        this.total_expense = total_expense;
    }
   

    public void visited(int min)
    {
        if(this.times_visited > min)
        {
            System.out.println("The Branch is visited by Enough: "+name);
        }
        else
        {
            System.out.println("The Branch is not Visited much: "+name);
        }
    }

    private double yearly_profit(int b_id){
        double profit;
        profit = (total_revenue-total_expense);
        return profit;
    }

    public void generate_report(){
        double yearly_profit = this.yearly_profit(this.b_id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter branch-id");
        this.b_id = sc.nextInt();
        System.out.println("Branch id: "+this.b_id);
        System.out.println("Enter branch-name");
        this.name = sc.next();
        System.out.println("Branch name: "+this.name);
        System.out.println("Enter year");
        this.year = sc.nextInt();
        System.out.println("Year: "+this.year);
        //super variable demonstration
         System.out.println("Company Year: "+super.years);
        System.out.println("The Yearly profit is: "+ yearly_profit);
       
    } 
    // final keyword demonstration
//    public void checking(){
//        System.out.println("go");
//    }
}

interface stock{
   
   public void generate_alert();
   default void add_drug(){
       System.out.println("add to stock"); 
   }
   public static void printDrugTypes(String drug_type)
    {
        if(drug_type == "type1")
        {
            System.out.println("Drug Type 1: minor");
        }
        else if(drug_type == "type2")
        {
            System.out.println("Drug Type 2: senior");
        }
        else if(drug_type == "type3")
        {
            System.out.println("Drug Type 3: others");
        }
        else
        {
            System.out.println("Drug type not found");
        }
    }


}
 class Company implements stock{
    public int comp_id;
    public String name;
    public String address;
    public int years = 5;
    public int sales;
    public double profit;
    

    

    public Company(){
        Scanner sc= new Scanner(System.in);
        this.comp_id = sc.nextInt();
    }

    public Company(String name,String address){
        this.name = name;
        this.address = address;
         System.out.println("Enter your sales:");
         this.sales = sales;
         Scanner sc = new Scanner(System.in);
        this.sales = sc.nextInt();
      
    }

   public void  generate_sales(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the company name");
       this.name = sc.next();
       System.out.println("Enter the address:");
      this.address = sc.next();
      System.out.println("company name: "+this.name);
       System.out.println("address: "+this.address);
        // System.out.println("CHECKING"); 
   }

        public void generate_alert(){
           System.out.println("The company id:"+this.comp_id);
            if(this.sales > 0 && this.sales < 30 ){
                // System.out.println("Enter your sales:");
                profit = ((this.sales/30.0)* 100);
                System.out.println("Profit monthly:"+profit);
               
            }
            
        } 

        final void checking(){
            System.out.println("hello there");
        }
 }

 abstract class Order{
     int o_id;
    int quantity;
    String status;

     abstract public void order_drug(int drug_id);

    public void show(){
        System.out.println("Abstraction can have method with definition");
    }

 }


class report implements A.user{
 public void most_sold(){
     System.out.println("NESTED INTERFACE");
    Scanner sc = new Scanner(System.in);
    String name = sc.next();
    int sales = sc.nextInt();
    if(sales > 10){
        System.out.println("Name:"+name);
    }

}
}

 class A{
    interface user{
        public void most_sold();
    }}
