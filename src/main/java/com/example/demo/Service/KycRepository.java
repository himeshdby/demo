package com.example.demo.Service;

import com.example.demo.Data.CustomerInfo;
import com.example.demo.Data.Kyc;
import org.springframework.data.repository.CrudRepository;

public interface KycRepository extends CrudRepository<Kyc,Integer> {
}
