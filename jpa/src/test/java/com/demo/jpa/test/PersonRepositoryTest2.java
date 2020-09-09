package com.demo.jpa.test;

import com.demo.jpa.po.Person;
import com.demo.jpa.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonRepositoryTest2 {
    @Autowired
    private PersonRepository personRepository;
    @Sql(scripts = {"classpath:/init.sql"})
    @Test
    public void find_person_age_older_than_18() {
        List<Person> personList = personRepository.findByAgeGreaterThan(18);
        assertEquals(1,personList.size());
    }
}
