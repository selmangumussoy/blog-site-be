package com.example.blogsitebe.library.aop;

import com.example.blogsitebe.library.security.CustomUserDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //bu sınıfın oap için kullanacağını belirtmek için kullanıldı
@Component
public class LoggingAspect {

    private final HttpServletRequest request;
    private final LogEntryRepository repository;

    public LoggingAspect(HttpServletRequest request, LogEntryRepository repository) {
        this.request = request;
        this.repository = repository;
    }

    @Before("within(@org.springframework.web.bind.annotation.RestController *)")
    //RestController içindeki metotlar başlamadan önce bu metot çalışacak
    public void logRequest(JoinPoint joinPoint) {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String userInfo = getCurrentUserId();
        String arguments =Arrays.toString(joinPoint.getArgs());
        String ipaddress=request.getRemoteAddr();

        LogEntry entry= LogEntry.builder()
                .httpMethod(method)
                .uri(uri)
                .arguments(arguments)
                .userId(userInfo)
                .ipAddress(ipaddress)
                .build();
        repository.save(entry);

    }

    public String getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof CustomUserDetails userDetails) {
            return String.valueOf(userDetails.getId());
        }
        return "Anonymous";
    }
}