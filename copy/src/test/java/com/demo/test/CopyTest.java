package com.demo.test;

import com.demo.dto.PersonDest;
import com.demo.dto.PersonSource;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class CopyTest {
    @Test
    public void TestApacheBeanUtils() throws InvocationTargetException, IllegalAccessException {
        PersonSource personSource = new PersonSource(1, "maple", "12345", 21);
        PersonDest   personDest   = new PersonDest();
        BeanUtils.copyProperties(personDest,personSource);
        System.out.println("personDest:"+personDest);

    }
    @Test
    public void TestSpringBeanUtils() {
        PersonSource personSource = new PersonSource(1, "pjmike", "12345", 21);
        PersonDest personDest = new PersonDest();
        org.springframework.beans.BeanUtils.copyProperties(personSource,personDest);
        System.out.println("personDest:"+personDest);
    }
}
