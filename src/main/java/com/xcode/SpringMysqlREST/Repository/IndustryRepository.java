package com.xcode.SpringMysqlREST.Repository;

import com.xcode.SpringMysqlREST.model.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IndustryRepository extends JpaRepository<Industry,Long> {
}
