package com.dmy.codedesign.JdkMethod;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 *
 * 用来处理对象中
 * @Author: dongmengyang
 */
@Data
@Getter
@Service
public class School {
    private Class myClass;

    public Class getMyClass() {
        return myClass;
    }

    public void setMyClass(Class myClass) {
        this.myClass = myClass;
    }

    @Data
    @Getter
    static class Class {
        private People people;

        public People getPeople() {
            return people;
        }

        public void setPeople(People people) {
            this.people = people;
        }
    }
    @Data
    @Getter
    static class People {
        private Integer teacher;
        private Man man;

        public Integer getTeacher() {
            return teacher;
        }

        public void setTeacher(Integer teacher) {
            this.teacher = teacher;
        }

        public Man getMan() {
            return man;
        }

        public void setMan(Man man) {
            this.man = man;
        }
    }
    @Data
    @Getter
    static class Man {
        private Integer boy;
        private Integer girl;

        public Integer getBoy() {
            return boy;
        }

        public void setBoy(Integer boy) {
            this.boy = boy;
        }

        public Integer getGirl() {
            return girl;
        }

        public void setGirl(Integer girl) {
            this.girl = girl;
        }
    }
    @PostConstruct
    public void init() {
        Man man = new Man();
        man.setBoy(10);
        People people = new People();
        people.setMan(man);
        people.setTeacher(2);
        Class myClass = new Class();
        myClass.setPeople(people);
        School mySchool =new School();
        mySchool.setMyClass(myClass);

        Optional<School> opt = Optional.of(mySchool);
        opt.map(School::getMyClass).map(Class::getPeople).map(People::getMan).map(Man::getBoy).ifPresent(System.out::println);



    }

    public static void main(String[] args) {

    }


}
