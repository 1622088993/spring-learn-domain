package com.example.springlearndomain.aop.query;

import com.example.springlearndomain.dto.PersonDTO;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/12 13:16
 * @Version: 1.0
 * @Description:
 */

@Service
@Slf4j
public class CommonQuery {

    public static Map<String,PersonDTO> personDTOMap= Maps.newHashMap();



    public PersonDTO queryPersonByIdAnsSave(Integer age,String name){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setAge(age);
        personDTO.setName(name);
        return personDTO;
    }

    public void savePersonDTO(PersonDTO personDTO ){
        personDTOMap.put(personDTO.getName(),personDTO);
        log.info("save {} ",personDTO);
    }



}
