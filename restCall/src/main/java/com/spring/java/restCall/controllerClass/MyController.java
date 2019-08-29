package com.spring.java.restCall.controllerClass;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.java.restCall.utility.Employee;

import org.json.simple.parser.JSONParser;
import com.spring.java.restCall.utility.Person;
import org.json.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class MyController {

    List<Person> personList= new ArrayList<Person>();
    @RequestMapping("/Employees")
    @ResponseBody
    public  List<Employee> getAllEmployees() {
        Employee employee = new Employee();
        List<Employee> all_emp_List = new ArrayList<Employee>();
        all_emp_List= this.populateData();
        return all_emp_List;
    }


    @RequestMapping(value="/Employees/{id}", method = GET)
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") int id) throws Exception {
        Employee employee = new Employee();
        List<Employee> all_emp_List = new ArrayList<Employee>();
        all_emp_List= populateData();
        for(Employee empSearch: all_emp_List){
            if(empSearch.getEmp_id()==id){
                return empSearch;
            }
        }
        employee.setError("unable to find employee DATA");

        return employee;
    }

    @RequestMapping(value="/Persons/{id}", method = GET)
    @ResponseBody
    public Person  getPerson(@PathVariable("id") String id) throws Exception {
       /* Employee employee = new Employee();

        JSONObject jsonObject = (JSONObject) readJsonSimpleDemo("/resources/sample.json");
        Person ben = new Person(
                (String)jsonObject.get("id"),
                        (String) jsonObject.get("employee_name"),
                        (String) jsonObject.get("employee_salary"),
                        (String) jsonObject.get("employee_age"),
                        (String) jsonObject.get("profile_image"));

        System.out.println(ben);
        return ben;*/
        ObjectMapper mapper = new ObjectMapper();
        File file = null;
        Person user= new Person();
       // List<Person> personList= new ArrayList<Person>();
        Person[] userList=null;
        try {

            ClassLoader classLoader= new MyController().getClass().getClassLoader();
           // System.out.println("Class Loader value-->"+classLoader.getResource("sample.json").getFile().toString());
            //user = mapper.readValue(new File(classLoader.getResource("sample.json").getFile()), Person.class);

            JSONParser jsonParser = new JSONParser();

             FileReader reader = new FileReader(classLoader.getResource("sample.json").getFile());

                //Read JSON file
                Object obj = jsonParser.parse(reader);
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) obj;
            org.json.simple.JSONArray employeeList = (org.json.simple.JSONArray) jsonObject.get("Person");
                System.out.println(employeeList);


                    employeeList.forEach( emp -> parseTestData( (org.json.simple.JSONObject) emp ) );
                    for(Person personOject:personList){
                        if(personOject.getId().equalsIgnoreCase(id)){
                            return personOject;
                        }
                    }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value="/Persons", method = GET)
    @ResponseBody
    public List<Person>  getPersonList() throws Exception {
       /* Employee employee = new Employee();

        JSONObject jsonObject = (JSONObject) readJsonSimpleDemo("/resources/sample.json");
        Person ben = new Person(
                (String)jsonObject.get("id"),
                        (String) jsonObject.get("employee_name"),
                        (String) jsonObject.get("employee_salary"),
                        (String) jsonObject.get("employee_age"),
                        (String) jsonObject.get("profile_image"));

        System.out.println(ben);
        return ben;*/
        ObjectMapper mapper = new ObjectMapper();
        File file = null;
        Person user= new Person();
        // List<Person> personList= new ArrayList<Person>();
        Person[] userList=null;
        try {

            ClassLoader classLoader= new MyController().getClass().getClassLoader();
            // System.out.println("Class Loader value-->"+classLoader.getResource("sample.json").getFile().toString());
            //user = mapper.readValue(new File(classLoader.getResource("sample.json").getFile()), Person.class);

            JSONParser jsonParser = new JSONParser();

            FileReader reader = new FileReader(classLoader.getResource("sample.json").getFile());

            //Read JSON file
            Object obj = jsonParser.parse(reader);
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) obj;
            org.json.simple.JSONArray employeeList = (org.json.simple.JSONArray) jsonObject.get("Person");
            System.out.println(employeeList);

            personList.clear();
            employeeList.forEach( emp -> parseTestData( (org.json.simple.JSONObject) emp ) );

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return personList;
    }



    private  void parseTestData(org.json.simple.JSONObject employee)
    {
        //Get employee object within list
        Person person= new Person();


        //this.personList= new ArrayList<Person>();
        org.json.simple.JSONObject personJSONObject = (org.json.simple.JSONObject) employee;

        person.setEmployee_age(personJSONObject.get("employee_age").toString());
        person.setEmployee_name(personJSONObject.get("employee_name").toString());
        person.setEmployee_salary(personJSONObject.get("employee_salary").toString());
        person.setId(personJSONObject.get("id").toString());
        person.setProfile_image(personJSONObject.get("profile_image").toString());
        this.personList.add(person);
    }



   public List<Employee> populateData(){
       List<Employee> all_emp = new ArrayList<Employee>();
       Employee employee_0 = new Employee(101,"ramit", "mathur", "ramit.mathur@gmail.com", "21054");
       all_emp.add(employee_0);
       Employee employee_1 = new Employee(102,"saurav", "ghimire", "saurav.ghimire@gmail.com", "21228");
       all_emp.add(employee_1);
       Employee employee_2 = new Employee(103,"prasad", "sakala", "prasad.sakala@gmail.com", "21114");
       all_emp.add(employee_2);
       return all_emp;
    }

    public static Object readJsonSimpleDemo(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        //File file= ResourceUtils.getFile(filename);
        //JSONParser jsonParser = new JSONParser();
        return null;//jsonParser.parse(reader);
    }

}