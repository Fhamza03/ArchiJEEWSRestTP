package fr.ubo.hello.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public class LogInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {
        String className = invocation.getMethod().getDeclaringClass().getSimpleName();
        String methodName = invocation.getMethod().getName();
        Object[] args = invocation.getArguments();

        logger.debug("{} - IN - Params: {}", className + "." + methodName, Arrays.toString(args));

        try {
            Object result = invocation.proceed();
            logger.debug("{} - OUT", className + "." + methodName);

            return result;
        } catch (Throwable ex) {
            logger.error("{} - ERROR - {}", className + "." + methodName, ex.getMessage(), ex);
            throw ex;
        }
    }
}
