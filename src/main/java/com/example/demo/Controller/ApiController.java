package com.example.demo.Controller;

import com.example.demo.Data.*;
import com.example.demo.Service.DataRespository;
import com.example.demo.Service.LogicBuilder;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/convert")
@CrossOrigin
public class ApiController {


    @Autowired
    LogicBuilder logicBuilder;

    @Autowired
    DataRespository dataRespository;

    @Autowired
    ApiResult apiResult;

    private static Logger logger = LoggerFactory.getLogger(ApiController.class);



    @PostMapping(path = "/updateUser")
    public ApiResult setCustomerInfo(@RequestBody CustomerInfo customerInfo) {

        try {
            CustomerInfo customerInf = dataRespository.save(customerInfo);
            apiResult.setCustomerInfo(customerInf);
            apiResult.setMessage("Customer information successfully inserted ");

        } catch (DataIntegrityViolationException e) {

            if (((ConstraintViolationException) e.getCause()).getSQLException().getSQLState().equals("23000")) {
               apiResult.setMessage(((ConstraintViolationException) e.getCause()).getSQLException().getMessage());
               apiResult.setCustomerInfo(null);
            }
        }

        return apiResult;
    }

    @PostMapping(path = "/validateUser")
    public ApiResult isValideUser(@RequestBody Kyc kyc){
        try {
            if(kyc != null && StringUtils.isNotBlank(kyc.getId().toString())) {
                if (logicBuilder.validateKyc(kyc))
                    apiResult.setMessage("user" + kyc.getName() + " is vaid ");
                else
                    apiResult.setMessage("user" + kyc.getName() + " is not vaid ");
            }

        }catch (Exception e){
            logger.error("error at validate user ",e.getMessage());
        }
        return apiResult;
    }


}
