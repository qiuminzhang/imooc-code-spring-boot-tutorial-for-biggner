package com.programwitherik.restservice.RestApp.Controller;

import com.programwitherik.restservice.RestApp.Domain.Baby;
import com.programwitherik.restservice.RestApp.BabyRepository;
import com.programwitherik.restservice.RestApp.Domain.Result;
import com.programwitherik.restservice.RestApp.Service.BabyService;
import com.programwitherik.restservice.RestApp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BabyController {
    @Autowired // Help with initialization, so just need to declare, no need to new type();
    private BabyRepository babyRepository;

    @Autowired
    private BabyService babyService;

    /**
     * Think about adding a baby or updating a baby, in the real case, the backend should
     * validate if the user has logged in. But adding loggin validation in each method would
     * cause redundant work, so here's an idea that write the loggin validation in the constructor.
     * This is a good a idea but it doesn't work, because once the app runs, the class would be
     * initialized, but when http requests come later, the class cannot be initialized again.
     * That's why we introduce AOP to deal with the validations together.
     */
    public BabyController() {
    }

    /**
     * Select baby table
     * @return A json file contains all records in baby table,
     * can be reached by http://127.0.0.1:8081/babies
     */
    @GetMapping(value = "/babies")
    public List<Baby> babyList() {
        return babyRepository.findAll();
    }

    /**
     * Add a new baby into baby table
     * @param age
     * @param weight
     * @return
     */
    @PostMapping(value = "/baby／add") // alternative to test post request??
    public Baby addBaby(@RequestParam("age") int age,
                          @RequestParam("weight") int weight){
        Baby baby = new Baby();
        baby.setAge(age);
        baby.setWeight(weight);
        return babyRepository.save(baby);
    }

    /**
     * Validation workflow: set a min value for an attribute
     *                      Add @Valid annotation before Baby
     *                      pass a bindingResult to receive the error
     *                      create Result object,
     *                      set error code based on error type
     *                      return the result
     * Alternative / elegant way of add a new baby
     * 包含表单验证 contains validation
     * @Valid Validate the following object(baby) that if the baby is over 5
     * @Param: BindingResult: get the message defined in the Baby class -> age attribute
     * @Return: return a uniform format for all results(error or correct), the return value would be shouwn at postman.
     */
    @PostMapping(value = "/babies/addababy") // alternative to test post request??
    public Result<Baby> addABaby(@Valid Baby baby, BindingResult bindingResult){ // Validate baby that if the baby is over 5 years old
        if(bindingResult.hasErrors()) {
            Result result = new Result();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setData(null);
            return null;
//            return result;
//            return (bindingResult.getFieldError().getDefaultMessage()); // print pre-defined error messag -> underage
        }

        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        baby.setAge(baby.getAge());
        baby.setWeight(baby.getWeight());
        result.setData(babyRepository.save(baby));
        return result;
    }

    /**
     * Optimized method of addABaby, remove redundant codes.
     * @param baby
     * @param bindingResult
     * @return
     */
    @PostMapping(value="/baby/2ndadd")
    public Result<Baby> addABaby2(@Valid Baby baby, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
        }
        // TODO: why the set value can get from baby.get methods?
        baby.setAge(baby.getAge());
        baby.setWeight(baby.getWeight());
        return ResultUtil.success(babyRepository.save(baby));
    }

    /**
     *  Select a baby by *ID*. which is primary key.
     */
    @GetMapping(value = "/baby/{id}")
    public Baby searchBaby(@PathVariable("id") int id){
        return babyRepository.findOne(id);
    }

    /**
     * Update a data(baby). PutMapping is actually a post request
     * @param id
     */
    @PutMapping(value = "/baby/{id}")
    public Baby updateBaby(@PathVariable("id") int id,
                           @RequestParam("age") int age,
                           @RequestParam("weight") int weight){
        Baby baby = new Baby();
        baby.setId(id);
        baby.setWeight(weight);
        baby.setAge(age);

        return babyRepository.save(baby);
    }

    /**
     * Delete a baby .  This is a delete request if you want to test on postman APP.
     * @param id baby id
     */
    @DeleteMapping(value = "/baby/{id}")
    public void dropBaby(@PathVariable("id") int id){
        babyRepository.delete(id);
    }

    /**
     * Search baby by age.
     */
    @GetMapping(value="/baby/age/{age}")
    public List<Baby> babyListByAge(@PathVariable("age") int age) {
        return babyRepository.findByAge(age);
    }

    /**
     * Add two babies to database
     */
    @PostMapping(value="/baby/two")
    public void addTwoBabies() {
        babyService.insertTwoBaby();
    }

    @GetMapping(value="/baby/getAge/{id}")
    public void getAge(@PathVariable("id") int id) throws Exception{
        babyService.getAge(id);
    }
}
