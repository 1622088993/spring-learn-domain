package com.example.springlearndomain.bean.post.process;

import com.example.springlearndomain.bean.post.process.anno.RoutingSwitch;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/6 0:30
 * @Version: 1.0
 * @Description:
 */

public class RoutingBeanProxyFactory {

    public static Object createProxy(Class targetClass, Map<String, Object> beans) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(targetClass);
        proxyFactory.addAdvice(new VersionRoutingMethodInterceptor(targetClass, beans));
        return proxyFactory.getProxy();
    }
    static class VersionRoutingMethodInterceptor implements MethodInterceptor {
        private String classSwitch;
        private Object beanOfSwitchOn;
        private Object beanOfSwitchOff;

        public VersionRoutingMethodInterceptor(Class targetClass, Map<String, Object> beans) {
            String interfaceName = StringUtils.uncapitalize(targetClass.getSimpleName());
            if(targetClass.isAnnotationPresent(RoutingSwitch.class)){
                this.classSwitch =((RoutingSwitch)targetClass.getAnnotation(RoutingSwitch.class)).value();
            }
            this.beanOfSwitchOn = beans.get(this.buildBeanName(interfaceName, true));
            this.beanOfSwitchOff = beans.get(this.buildBeanName(interfaceName, false));
        }

        private String buildBeanName(String interfaceName, boolean isSwitchOn) {
            return interfaceName + "Impl" + (isSwitchOn ? "V2" : "V1");
        }

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            Method method = invocation.getMethod();
            String switchName = this.classSwitch;
            if (method.isAnnotationPresent(RoutingSwitch.class)) {
                switchName = method.getAnnotation(RoutingSwitch.class).value();
            }
            if (StringUtils.isEmpty(switchName)) {
                throw new IllegalStateException("RoutingSwitch's value is blank, method:" + method.getName());
            }
            return invocation.getMethod().invoke(getTargetBean(switchName), invocation.getArguments());
        }

        public Object getTargetBean(String switchName) {
            boolean switchOn=false;

            return switchOn ? beanOfSwitchOn : beanOfSwitchOff;
        }
    }
}

