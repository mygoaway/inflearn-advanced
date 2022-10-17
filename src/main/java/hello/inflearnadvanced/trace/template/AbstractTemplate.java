package hello.inflearnadvanced.trace.template;

import hello.inflearnadvanced.trace.TraceStatus;
import hello.inflearnadvanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate <T>{

    private final LogTrace trace;
    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            // 로직 시작
            T result = call();
            // 로직 종료
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }
    }

    protected abstract T call();
}
