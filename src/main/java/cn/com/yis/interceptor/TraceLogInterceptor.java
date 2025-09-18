package cn.com.yis.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

public class TraceLogInterceptor implements HandlerInterceptor {
    // 追踪ID在MDC中的键名
    private static final String TRACE_ID = "TRACE_ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 生成追踪ID，如果客户端传入了追踪ID，则使用客户端传入的追踪ID，否则使用默认的ULID生成
        String tid = "TID-" + System.currentTimeMillis();
        if (StringUtils.hasLength(request.getHeader(TRACE_ID))) {
            tid = request.getHeader(TRACE_ID);
        }

        String uid = request.getHeader("Authorization_UID");
        String authorizationUname = request.getHeader("Authorization_UNAME");
        // 将追踪ID放入MDC中
        MDC.put(TRACE_ID, tid);
        MDC.put("Authorization_UID", uid);
        MDC.put("Authorization_UNAME", authorizationUname);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) {
        // 请求处理完成后，从MDC中移除追踪ID
        MDC.remove(TRACE_ID);
    }
}
