package com.test.cuentas.repository;

import com.test.cuentas.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {

}
