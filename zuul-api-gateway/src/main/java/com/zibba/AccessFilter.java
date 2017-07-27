package com.zibba;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liuhui on 2017/7/26.
 * 请求过滤器
 */
public class AccessFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器类型,定义过滤器在什么时候执行,
     * pre:路由前执行, route:路由时执行,post:route和error后执行,error:过滤器异常后执行,static
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     * We also support a "static" type for static responses see  StaticResponseFilter.
     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
     *
     * @return A String representing that type
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序,越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        LOGGER.info("method:{}, requestUrl:{}, param:{}",
                request.getMethod(),
                request.getRequestURL().toString(),
                request.getParameterMap().toString());

        //鉴权失败
        String accessToken = request.getParameter("accessToken");
        if (accessToken == null){
            //忽略请求,不路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            HttpServletResponse response = ctx.getResponse();
            try {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("鉴权失败");
            } catch (IOException e) {
                //输出异常
                ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                ctx.set("error.exception", e);
                ctx.set("error.message", "错误信息");
                e.printStackTrace();
            }
            finally {
                try {
                    response.getWriter().flush();
                    response.getWriter().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        LOGGER.info("access token ok");
        return null;
    }
}
