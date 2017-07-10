package com.internetshop.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.internetshop.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedNativeQuery;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByName(String name);

    User findByEmail(String email);

    @Query("select u from User u where u.uuid =:uuid")
    User findByUuid(@Param("uuid") String uuid);


    @Query("select u from User u left join fetch u.commodities where u.id =:id")
    User userWithCommputerCommodities(@Param("id") int id);

//    @Query("select u from User u left join fetch u.HouseholdAppliances where u.id =:id " )
//    User userWithHouseholdAppliances(@Param("id") int id);

    @Query("select b from User b inner join fetch b.commodities where b.id=:id")
    User userWithCommodyties (@Param("id") int id);



}
