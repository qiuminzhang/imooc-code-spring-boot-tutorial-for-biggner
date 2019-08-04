package com.programwitherik.restservice.RestApp.Service;

import com.programwitherik.restservice.RestApp.Domain.Baby;
import com.programwitherik.restservice.RestApp.BabyRepository;
import com.programwitherik.restservice.RestApp.enums.ResultEnum;
import com.programwitherik.restservice.RestApp.exception.BabyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Service annotation is for transaction
 */
@Service
public class BabyService {
    @Autowired
    private BabyRepository babyRepository;

    @Transactional // Make a transaction, if B fails to insert, A fails neither.
    public void insertTwoBaby(){
        Baby A = new Baby();
        A.setAge(4);
        A.setWeight(2020);
        babyRepository.save(A);

        Baby B = new Baby();
        B.setAge(5);
        B.setWeight(60);
        babyRepository.save(B);
    }

    /**
     * Code and messages are customized here, but as we have more and more code and msg,
     * it's gonna be a trouble to manage so many codes and message;
     * So the better way is to use enum to manage these code and message.
     * @param id
     * @throws Exception
     */
    public void getAge(int id) throws Exception{
        Baby baby = babyRepository.findOne(id);
        int age = baby.getAge();
        if(age < 10){
            throw new BabyException(ResultEnum.PRIMARY_SCHOOL);
//            throw new BabyException(100, "Elementary school");  // code = 100
        }else if(age > 10 && age < 16) {
            throw new BabyException((ResultEnum.MIDDLE_SCHOOL));
//            throw new BabyException(101, "Middle school");  // code = 101
        }
    }

    /**
     * Find a baby by id
     * @param id
     * @return
     */
    public Baby findOne(int id){
        return babyRepository.findOne(id);
    }
}
