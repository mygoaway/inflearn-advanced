package hello.inflearnadvanced.trace.logtrace;

import hello.inflearnadvanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
