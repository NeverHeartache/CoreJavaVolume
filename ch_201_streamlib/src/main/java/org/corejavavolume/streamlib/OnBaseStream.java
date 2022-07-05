package org.corejavavolume.streamlib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OnBaseStream {


    private List<Person> persons = new ArrayList<>();

    private void generateObjects() {
        Person david = new Person();
        david.setName("David Staff");
        david.setAge(10);
        persons.add(david);

        Person tom = new Person();
        tom.setName("tom Staff");
        tom.setAge(10);
        persons.add(tom);

        Person jerry = new Person();
        jerry.setName("jerry Staff");
        jerry.setAge(11);
        persons.add(jerry);

        Person dog = new Person();
        dog.setName("dog Staff");
        dog.setAge(12);
        persons.add(dog);

        Person cat = new Person();
        cat.setName("cat Staff");
        cat.setAge(10);
        persons.add(cat);

        Person lion = new Person();
        lion.setName("lion Staff");
        lion.setAge(11);
        persons.add(lion);

        Person tiger = new Person();
        tiger.setName("tiger Staff");
        tiger.setAge(12);
        persons.add(tiger);
    }

    public static void main(String[] args) {
        OnBaseStream onBaseStream = new OnBaseStream();
        onBaseStream.generateObjects();
        Map<Integer, List<Person>> map = onBaseStream.persons.stream().collect(Collectors.groupingBy(Person::getAge));

        map.keySet().stream().forEach(integer -> {
            List<Person> list = map.get(integer);
            for (Person p: list) {
                System.out.println(p.getName());

            }
            System.out.println();
            System.out.println();System.out.println();
        });
    }

    class Person {
        private String name;

        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
