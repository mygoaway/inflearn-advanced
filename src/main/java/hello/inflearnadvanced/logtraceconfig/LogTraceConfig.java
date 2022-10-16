package hello.inflearnadvanced.logtraceconfig;

import hello.inflearnadvanced.trace.logtrace.FieldLogTrace;
import hello.inflearnadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
