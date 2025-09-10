public class Main{
    public static void main(String[] args){
        Person person = new PersonBuilderImpl().setFirstName("Aldiar").setAge(18).setIq(100).build();
        person.print();

    }
}

class Person {
    String firstname;
    String lastname;
    String gender;
    int age;
    int height;
    int weight;
    int iq;
    int salary;
    boolean job;
    public void print(){
        System.out.println(firstname + " " + lastname + " " + gender + " " + age + " " + height + " " + weight + " " + iq + " " + salary + " " + job);

    }

}

interface PersonBuilder{
    PersonBuilder setFirstName(String firstname);
    PersonBuilder setLastName(String lastname);
    PersonBuilder setGender(String gender);
    PersonBuilder setAge(int age);
    PersonBuilder setHeight(int height);
    PersonBuilder setWeight(int weight);
    PersonBuilder setIq(int iq);
    PersonBuilder setSalary(int salary);
    PersonBuilder setJob(boolean job);
    Person build();
}

class PersonBuilderImpl implements PersonBuilder {
    Person person =  new Person();
    @Override
    public PersonBuilder setFirstName(String firstname) {
        person.firstname = firstname;
        return this;
    }

    @Override
    public PersonBuilder setLastName(String lastname) {
        person.lastname = lastname;
        return this;
    }

    @Override
    public PersonBuilder setGender(String gender) {
        person.gender = gender;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        person.age = age;
        return this;
    }

    @Override
    public PersonBuilder setHeight(int height) {
        person.height = height;
        return this;
    }

    @Override
    public PersonBuilder setWeight(int weight) {
        person.weight = weight;
        return this;
    }

    @Override
    public PersonBuilder setIq(int iq) {
        person.iq = iq;
        return this;
    }

    @Override
    public PersonBuilder setSalary(int salary) {
        person.salary = salary;
        return this;
    }

    @Override
    public PersonBuilder setJob(boolean job) {
        person.job = job;
        return this;
    }

    @Override
    public Person build() {
        return person;
    }

}