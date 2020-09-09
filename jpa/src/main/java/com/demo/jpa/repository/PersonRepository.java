package com.demo.jpa.repository;

import com.demo.jpa.dto.UserDto;
import com.demo.jpa.po.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);
    List<Person> findByAgeGreaterThan(int age);
    @Query("select p from Person p where p.name=:name")
    Optional<Person> findByNameCustomQuery(@Param("name") String name);
    @Query("select p.name from Person p where p.id=:id")
    String findPersonNameBy(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update Person p set p.name = ?1 where p.id = ?2")
    void updatePersonNameById(String name, Long id);

    @Query(value="select new com.demo.jpa.dto.UserDto(p.name, p.age,c.companyName,s.name) " + "from Person p left " +
            "join Company c on p.companyId = c.id" + " left join School s on p.schoolId=s.id where p.id=:personId" )
    Optional<UserDto> getUserInfomation(@Param("personId") Long personId);

    @Query(value="select new com.demo.jpa.dto.UserDto(p.name, p.age,c.companyName,s.name) from Person p left join " +
            "Company c on p.companyId=c.id left join School s on p.schoolId=s.id", countQuery="select count(p.id) " +
            "from Person p left join Company c on p.companyId=c.id left join School s on p.schoolId=s.id ")
    Page<UserDto> getUserInfomationList(Pageable pageable);

    @Query(value="select new com.demo.jpa.dto.UserDto(p.name, p.age,c.companyName,s.name) from Person p left join " +
            "Company c on p.companyId=c.id left join School s on p.schoolId=s.id where p.name IN :peopleList")
    List<UserDto> filterUserInfo(List<?> peopleList);

    @Query(value="select new com.demo.jpa.dto.UserDto(p.name, p.age,c.companyName,s.name) from Person p left join " +
            "Company c on p.companyId=c.id left join School s on p.schoolId=s.id where p.age between :small and :big")
    List<UserDto> filterUserInfoByAge(int small, int big);
}
