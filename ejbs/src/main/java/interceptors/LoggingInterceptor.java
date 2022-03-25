package interceptors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

import java.util.Date;

public class LoggingInterceptor {

    @AroundInvoke
    public Object log(InvocationContext context)
            throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            return context.proceed();
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            String logString = new Date()
                    + " - Invoked method: " + context.getMethod().getName()
                    + " - Execution duration: " + duration + "ms";
            System.out.println(logString);
        }
    }

}