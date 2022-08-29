package com.example.demo.Service;


import com.example.demo.Data.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DataRespository extends CrudRepository<CustomerInfo,Integer> {

}
