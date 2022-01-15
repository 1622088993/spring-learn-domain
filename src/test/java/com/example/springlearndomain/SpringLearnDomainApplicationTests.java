package com.example.springlearndomain;

import com.example.springlearndomain.type.Service;
import com.example.springlearndomain.type.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringLearnDomainApplicationTests {
    private Service<Double, Float> service;
    private List<List<String>> list;
    private Map<String, Map<String, Integer>> map;
    private List<String>[] array;

    @Test
    void contextLoads() {
        ResolvableType resolvableType = ResolvableType.forClass(SpringLearnDomainApplicationTests.class);
        Type type = resolvableType.getType();
        System.out.println(type);
    }

}
