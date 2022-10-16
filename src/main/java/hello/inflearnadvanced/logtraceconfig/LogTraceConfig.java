package hello.inflearnadvanced.logtraceconfig;

import hello.inflearnadvanced.trace.logtrace.LogTrace;
import hello.inflearnadvanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
