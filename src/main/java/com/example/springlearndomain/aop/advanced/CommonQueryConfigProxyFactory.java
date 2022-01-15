package com.example.springlearndomain.aop.advanced;

import com.example.springlearndomain.aop.query.CommonQuery;
import com.example.springlearndomain.dto.PersonDTO;
import com.example.springlearndomain.evrnt.MailEvent;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AdvisorChainFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/12 15:15
 * @Version: 1.0
 * @Description:
 */
@AllArgsConstructor(staticName = "of")
@Component
public class CommonQueryConfigProxyFactory {



    private ApplicationEventPublisher applicationEventPublisher;

    private ApplicationContext applicationContext;  //容器事件由容器触发


    public Object createProxy(Object targetClass){
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(targetClass);
        proxyFactory.addAdvice(new CommonQueryAdvisor(targetClass));
        return proxyFactory.getProxy();
    }

    private class CommonQueryAdvisor implements MethodInterceptor {

        private final Object targetClass;

        public CommonQueryAdvisor(Object targetClass) {
            this.targetClass=targetClass;
        }

        @Nullable
        @Override
        public Object invoke(@Nonnull MethodInvocation methodInvocation) throws Throwable {
            Method method = methodInvocation.getMethod();

            if (!method.getName().matches("queryPersonByIdAnsSave")){
                return methodInvocation.proceed();
            }
            Object proceed = methodInvocation.proceed();
            if (proceed instanceof PersonDTO){
                applicationContext.getBean(CommonQuery.class).savePersonDTO((PersonDTO) proceed);
            }
            MailEvent ylj = new MailEvent(applicationContext, "ylj");

            applicationEventPublisher.publishEvent(ylj);
            return proceed;
        }
    }
}
